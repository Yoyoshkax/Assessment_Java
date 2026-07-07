package api.categories;

import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetAllCategoriesTest {

    CategoriesClient categoriesClient;

    @BeforeEach
    public void setUp() {
        categoriesClient = new CategoriesClient();
    }

    @Test
    @DisplayName("Список всех категорий")
    public void getAllExistCategories() {
        Response response = categoriesClient.getAllCategory();
        int statusCode = response.getStatusCode();
        assertEquals(200, statusCode, "Список категорий не получен");
    }
}
