package shawarma;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private Ingredient ingredient;
    private final IngredientType expectedType = IngredientType.SAUCE;
    private final String expectedName = "Протеиновый соус";
    private final double expectedPrice = 5.0;

    @Before
    public void setUp() {
        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
    }

    @Test
    public void getNameTest() {
        assertEquals("Неправильное имя ингредиента", expectedName, ingredient.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals("Неправильная цена ингредиента", expectedPrice, ingredient.getPrice(), 0.0);
    }

    @Test
    public void getTypeTest() {
        assertEquals("Неправильный тип ингредиента", expectedType, ingredient.getType());
    }
}
