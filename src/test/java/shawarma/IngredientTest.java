package shawarma;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class IngredientTest {

    private Ingredient ingredient;
    private final IngredientType expectedType = IngredientType.SAUCE;
    private final String expectedName = "Протеиновый соус";
    private final double expectedPrice = 5.0;

    @BeforeEach
    public void setUp() {
        ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
    }

    @Test
    public void getNameTest() {
        assertEquals(expectedName, ingredient.getName(), "Неправильное имя ингредиента");
    }

    @Test
    public void getPriceTest() {
        assertEquals(expectedPrice, ingredient.getPrice(), "Неправильная цена ингредиента");
    }

    @Test
    public void getTypeTest() {
        assertEquals(expectedType, ingredient.getType(), "Неправильный тип ингредиента");
    }
}
