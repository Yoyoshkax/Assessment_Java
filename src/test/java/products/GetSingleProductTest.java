package products;

import data.DataGenerator;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class GetSingleProductTest {

    ProductDto productDto;
    ProductClient productClient;

    @BeforeEach
    @Order(1)
    public void setUp() {
        productClient = new ProductClient();
        productDto = DataGenerator.createNewProduct();
    }

    @BeforeEach
    @Order(2)
    public void createUser() {
        productClient.createProduct(productDto);
    }


    @Test
    @DisplayName("Проверяем у продукта наличие всех атрибутов")
    public void getProductById() {
        Response response = productClient.getSingleProduct("id", 2);

    }
}
