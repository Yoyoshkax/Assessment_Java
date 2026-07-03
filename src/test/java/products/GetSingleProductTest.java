package products;

import categories.CategoriesClient;
import data.DataGenerator;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetSingleProductTest {

    ProductDto productDto;
    ProductClient productClient;
    CategoriesClient categoriesClient;

    @BeforeEach
    @Order(1)
    public void setUp() {
        productClient = new ProductClient();
        categoriesClient = new CategoriesClient();
        productDto = DataGenerator.createNewProduct();
    }

    @BeforeEach
    @Order(2)
    public void createProduct() {
        int categoryId = categoriesClient.createCategory(DataGenerator.createUniqueCategory()).jsonPath().get("id");
        productDto.setCategoryId(categoryId);
        productClient.createProduct(productDto);
    }


    @Test
    @DisplayName("Проверяем у продукта наличие всех атрибутов")
    public void getProductById() {
        Response response = productClient.getSingleProduct("id", productDto.getCategoryId());
        int statusCode = response.getStatusCode();
        System.out.println((response.jsonPath().get("title")).toString());
        assertEquals(200,statusCode,"Продукт не создан");
    }
}
