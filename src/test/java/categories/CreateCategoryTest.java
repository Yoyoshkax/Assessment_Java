package categories;

import data.DataGenerator;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CreateCategoryTest {

    CategoriesClient categoriesClient;

    @BeforeEach
    public void setUp() {
        categoriesClient = new CategoriesClient();
    }

    @Test
    @DisplayName("Создание новой категории c уникальным айди")
    public void createNewUniqueCategory() {
        Response categoryListResponse = categoriesClient.getAllCategory();
        List<Integer> uniqueId = categoryListResponse.jsonPath().getList("id");

        Response newCategoryResponse = categoriesClient.createCategory(DataGenerator.createUniqueCategory());
        int newCategoryId = newCategoryResponse.jsonPath().get("id");

        assertFalse(uniqueId.contains(newCategoryId),"Создалась категория с существующим айди");

    }

    @Test
    @DisplayName("Проверка наличия правильных аттрибутов в новой созданной категории")
    public void checkCorrectCategoryAttributes() {
        Response response = categoriesClient.createCategory(DataGenerator.createUniqueCategory());
        String expectedCategoryName = response.jsonPath().get("name");
        String imageUrl = response.jsonPath().get("image");

    }
}
