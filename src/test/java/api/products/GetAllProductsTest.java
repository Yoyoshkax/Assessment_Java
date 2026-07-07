package api.products;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GetAllProductsTest {

    ProductClient productClient;

    @BeforeEach
    public void setUp() {
        productClient = new ProductClient();
    }

    @Test
    @DisplayName("Проверяем что список не пустой и содержит хотя бы один продукт")
    public void checkListShouldBeNotEmpty() {
        Response response = productClient.getAllProducts();
        List<Object> productsList = response.jsonPath().get();
        assertFalse(productsList.isEmpty());
    }
}
