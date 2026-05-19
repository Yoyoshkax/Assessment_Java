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
    private Ingridient mockIngridient1;

    @Mock
    private Ingridient mockIngridient2;

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
        shawarma.addIngridient(mockIngridient1);
        assertEquals("Ингридиент не добавлен", true, shawarma.ingridients.contains(mockIngridient1));
    }

    @Test
    public void removeIngridientTest() {
        shawarma.addIngridient(mockIngridient1);
        shawarma.addIngridient(mockIngridient2);
        shawarma.removeIngridient(mockIngridient2);
        assertEquals("Некорректный состав, ингридиент не удален", false, shawarma.ingridients.contains(mockIngridient2));
    }

    @Test
    public void getPriceTest() {
        shawarma.setLavash(mockLavash);
        Mockito.when(mockLavash.getPrice()).thenReturn(10.0);
        shawarma.addIngridient(mockIngridient1);
        Mockito.when(mockIngridient1.getPrice()).thenReturn(10.0);
        shawarma.addIngridient(mockIngridient2);
        Mockito.when(mockIngridient2.getPrice()).thenReturn(10.0);
        assertEquals("Неправильно посчитанная цена", 30.0, shawarma.getPrice(), 0.0);
    }

    @Test
    public void getReceiptTest() {
        Mockito.when(mockLavash.getName()).thenReturn("Пшеничный лаваш");
        Mockito.when(mockLavash.getPrice()).thenReturn(10.0);
        Mockito.when(mockIngridient1.getName()).thenReturn("Грибы");
        Mockito.when(mockIngridient1.getPrice()).thenReturn(10.0);

        shawarma.setLavash(mockLavash);
        shawarma.addIngridient(mockIngridient1);

        String expectedReceipt = String.format("=== Финальный состав шаурмы и её рецепт ===%n%s%n%s%nЦена = %f",
                "Пшеничный лаваш", "Грибы", 20.0);

        assertEquals("Неверный рецепт шаурмы", expectedReceipt, shawarma.getReceipt());
    }
}
