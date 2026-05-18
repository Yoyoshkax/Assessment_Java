package shawarma;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class IngridientTest {

    private Ingridient ingridient;
    private final IngridientType expectedType = IngridientType.SAUCE;
    private final String expectedName = "Протеиновый соус";
    private final double expectedPrice = 5.0;

    @Before
    public void setUp() {
        ingridient = new Ingridient(expectedType, expectedName, expectedPrice);
    }

    @Test
    public void getNameTest() {
        assertEquals("Неправильное имя ингридиента", expectedName, ingridient.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals("Неправильная цена ингридиента", expectedPrice, ingridient.getPrice(), 0.0);
    }

    @Test
    public void getTypeTest() {
        assertEquals("Неправильный тип ингридиента", expectedType, ingridient.getType());
    }
}
