package categories;

import data.DataGenerator;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetDeletedCategoryTest {

    CategoriesClient categoriesClient;

    @BeforeEach
    public void setUp() {
        categoriesClient = new CategoriesClient();
    }

    public int deletedCategoryId() {
        int newCategoryId = categoriesClient.createCategory(DataGenerator.createUniqueCategory()).jsonPath().get("id");
        categoriesClient.deleteSingleCategory("id", newCategoryId);
        return newCategoryId;
    }

    @Test
    @DisplayName("Получаем удаленную категорию")
    public void getDeletedCategory() {
        Response response = categoriesClient.getSingleCategory("id", deletedCategoryId());

        int statusCode = response.getStatusCode();
        String errorMessageName = response.jsonPath().get("name");
        assertEquals(400, statusCode, "Категория не удалена");
        assertEquals("EntityNotFoundError", errorMessageName);

    }
}
