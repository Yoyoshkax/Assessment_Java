package api.categories;

import data.DataGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class CheckForCategoryIdUniquenessTest {

    CategoriesClient categoriesClient;

    @BeforeEach
    public void setUp() {
        categoriesClient = new CategoriesClient();
    }

    @Test
    @DisplayName("Проверка создания уникального/несуществующего айди для новой категории")
    public void checkUniqueCategoryId() {
        List<Integer> uniqueIds = categoriesClient.getAllCategory().jsonPath().getList("id");

        int newId = categoriesClient.createCategory(DataGenerator.createUniqueCategory()).jsonPath().get("id");

        assertFalse(uniqueIds.stream().anyMatch(id -> id.equals(newId)), "Такой айди уже существует в списке категорий");
    }
}
