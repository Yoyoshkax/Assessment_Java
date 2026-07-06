package categories;

import data.DataGenerator;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteCategoryTest {

    CategoriesClient categoriesClient;

    @BeforeEach
    public void setUp() {
        categoriesClient = new CategoriesClient();
    }

    @Test
    @DisplayName("Создаем и удаляем категорию")
    public void deleteCategoryTest() {
        int newCategoryId = categoriesClient.createCategory(DataGenerator.createUniqueCategory()).jsonPath().get("id");
        Response response = categoriesClient.deleteSingleCategory("id", newCategoryId);
        assertEquals("true", response.getBody().asString());
    }
}
