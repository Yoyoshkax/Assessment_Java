package products;

import categories.CategoriesClient;
import data.DataGenerator;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GetSingleProductTest {

    ProductDto productDto;
    ProductClient productClient;
    CategoriesClient categoriesClient;

    @BeforeEach
    public void setUp() {
        productClient = new ProductClient();
        categoriesClient = new CategoriesClient();
        productDto = DataGenerator.createNewProduct();
    }

    public int createProduct() {
        int categoryId = categoriesClient.createCategory(DataGenerator.createUniqueCategory()).jsonPath().get("id");
        productDto.setCategoryId(categoryId);
        int productId = productClient.createProduct(productDto).jsonPath().get("id");
        return productId;
    }


    @Test
    @DisplayName("Проверяем возможность создания продукта и его аттрибутов")
    public void getProductById() {
        Response response = productClient.getSingleProduct("id", createProduct());
        int statusCode = response.getStatusCode();

        assertAll("Проверка всего продукта",
                () -> assertEquals(200, statusCode, "Продукт не создан"),
                () -> assertNotNull(response.jsonPath().get("id"), "Продукт создался без айди"),
                () -> assertEquals(productDto.getTitle(), response.jsonPath().get("title"), "Сформировался некорректный Title продукта"),
                () -> assertNotNull(response.jsonPath().get("category.id"), "В продукте отсутствует категория"),
                () -> assertEquals(productDto.getCategoryId(), response.jsonPath().get("category.id"), "В продукте установилась неправильная категория"),
                () -> assertEquals(productDto.getPrice(), response.jsonPath().get("price"), "В продукте установилась неправильная цена"),
                () -> assertEquals(productDto.getDescription(), response.jsonPath().get("description"), "В продукте некорретный Description"),
                () -> assertFalse(response.jsonPath().getList("images").isEmpty(), "В продукте отсутствуют картинки")
        );

        List<String> images = response.jsonPath().getList("images");
        String urlRegex = "^https?://.*";

        images.forEach(
                s -> assertTrue(s.matches(urlRegex), "В массиве images, элемент не является ссылкой")
        );
    }
}
