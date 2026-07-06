package categories;

import data.DataGenerator;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UpdateCategoryTest {

    CategoriesClient categoriesClient;

    @BeforeEach
    public void setUp() {
        categoriesClient = new CategoriesClient();
    }

    @Test
    @DisplayName("Обновление информации по категории")
    public void updateCategory() {
        Response createdCategoryResponse = categoriesClient.createCategory(DataGenerator.createUniqueCategory());
        int createdCategoryId = createdCategoryResponse.jsonPath().get("id");
        assertEquals(201, createdCategoryResponse.getStatusCode());

        Map<String, String> updatedCategoryMap = DataGenerator.createUniqueCategory();

        Response updatedCategoryResponse = categoriesClient.updateSingleCategory(updatedCategoryMap, "id", createdCategoryId);
        int updatedCategoryId = updatedCategoryResponse.jsonPath().get("id");
        String updatedCategoryName = updatedCategoryResponse.jsonPath().get("name");
        String updatedCategoryImage = updatedCategoryResponse.jsonPath().get("image");

        String urlRegex = "^https?://.*";

        assertAll("Проверяем аттрибуты обновленной категории",
                () -> assertEquals(createdCategoryId, updatedCategoryId, "После обновления присовился неправильный id"),
                () -> assertTrue(updatedCategoryImage.matches(urlRegex)),
                () -> assertEquals(updatedCategoryMap.get("name"), updatedCategoryName),
                () -> assertEquals(updatedCategoryMap.get("image"), updatedCategoryImage)
        );
    }
}
