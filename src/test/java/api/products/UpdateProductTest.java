package api.products;

import api.categories.CategoriesClient;
import data.DataGenerator;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UpdateProductTest {

    CategoriesClient categoriesClient;
    ProductClient productClient;
    ProductDto productDto;

    @BeforeEach
    public void setUp() {
        productClient = new ProductClient();
        categoriesClient = new CategoriesClient();
        productDto = DataGenerator.createNewProduct();
    }

    public int createProduct() {
        int categoryId = categoriesClient.createCategory(DataGenerator.createUniqueCategory()).jsonPath().get("id");
        productDto.setCategoryId(categoryId);
        return productClient.createProduct(productDto).jsonPath().get("id");
    }

    @Test
    @DisplayName("Провека обновленной информации продукта")
    public void checkUpdatedProduct() {
        Map<String, Object> updatedProductMap = DataGenerator.updateProduct();
        String expectedTitle = updatedProductMap.get("title").toString();
        int expectedPrice = (int) updatedProductMap.get("price");

        Response updatedProductResponse = productClient.updateProduct("id", createProduct(), updatedProductMap);

        assertEquals(expectedTitle, updatedProductResponse.jsonPath().get("title"));
        assertEquals(expectedPrice, updatedProductResponse.jsonPath().getInt("price"));

        List<String> images = updatedProductResponse.jsonPath().getList("images");
        String urlRegex = "^https?://.*";

        images.forEach(
                s -> assertTrue(s.matches(urlRegex), "В массиве images, элемент не является ссылкой")
        );
    }
}
