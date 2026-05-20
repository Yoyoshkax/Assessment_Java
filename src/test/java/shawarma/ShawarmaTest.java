package shawarma;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class ShawarmaTest {

    private Shawarma shawarma;

    @Mock
    private Lavash mockLavash;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @Before
    public void setUp() {
        shawarma = new Shawarma();
    }

    @Test
    public void setLavashTest() {
        shawarma.setLavash(mockLavash);
        assertEquals("Неправильно установлен лаваш", mockLavash, shawarma.lavash);
    }

    @Test
    public void setIngridientTest() {
        shawarma.addIngridient(mockIngredient1);
        assertEquals("Ингредиент не добавлен", true, shawarma.ingredients.contains(mockIngredient1));
    }

    @Test
    public void removeIngridientTest() {
        shawarma.addIngridient(mockIngredient1);
        shawarma.addIngridient(mockIngredient2);
        shawarma.removeIngridient(mockIngredient2);
        assertEquals("Некорректный состав, ингредиент не удален", false, shawarma.ingredients.contains(mockIngredient2));
    }

    @Test
    public void getPriceTest() {
        shawarma.setLavash(mockLavash);
        Mockito.when(mockLavash.getPrice()).thenReturn(10.0);
        shawarma.addIngridient(mockIngredient1);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(10.0);
        shawarma.addIngridient(mockIngredient2);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(10.0);
        assertEquals("Неправильно посчитанная цена", 30.0, shawarma.getPrice(), 0.0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(mockLavash.getName()).thenReturn("Пшеничный лаваш");
        Mockito.when(mockLavash.getPrice()).thenReturn(10.0);
        Mockito.when(mockIngredient1.getName()).thenReturn("Грибы");
        Mockito.when(mockIngredient1.getPrice()).thenReturn(10.0);

        shawarma.setLavash(mockLavash);
        shawarma.addIngridient(mockIngredient1);

        String expectedReceipt = String.format("=== Финальный состав шаурмы и её рецепт ===%n%s%n%s%nЦена = %f",
                "Пшеничный лаваш", "Грибы", 20.0);

        assertEquals("Неверный рецепт шаурмы", expectedReceipt, shawarma.getReceipt());
    }
}
