package categories;

import org.junit.jupiter.api.BeforeEach;

public class CreateCategoryTest {

    CategoriesClient categoriesClient;

    @BeforeEach
    public void setUp() {
        categoriesClient = new CategoriesClient();
    }
}
