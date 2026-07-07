package api.categories;

import data.DataGenerator;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CreateCategoryTest {

    CategoriesClient categoriesClient;

    @BeforeEach
    public void setUp() {
        categoriesClient = new CategoriesClient();
    }

    @Test
    @DisplayName("Проверка наличия правильных аттрибутов в новой созданной категории")
    public void checkCorrectCategoryAttributes() {
        Map<String, String> newCategoryMap = DataGenerator.createUniqueCategory();
        Response response = categoriesClient.createCategory(newCategoryMap);
        String expectedCategoryName = response.jsonPath().get("name");
        String imageUrl = response.jsonPath().get("image");

        String urlRegex = "^https?://.*";

        assertTrue(imageUrl.matches(urlRegex));
        assertEquals(expectedCategoryName, newCategoryMap.get("name"));
        assertEquals(imageUrl, newCategoryMap.get("image"));
    }
}
