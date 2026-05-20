package shawarma;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ShawarmaTest {

    private Shawarma shawarma;

    @Mock
    private Lavash mockLavash;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    @BeforeEach
    public void setUp() {
        shawarma = new Shawarma();
    }

    @Test
    public void setLavashTest() {
        shawarma.setLavash(mockLavash);
        assertEquals(mockLavash, shawarma.lavash, "Неправильно установлен лаваш");
    }

    @Test
    public void setIngridientTest() {
        shawarma.addIngridient(mockIngredient1);
        assertEquals(true, shawarma.ingredients.contains(mockIngredient1), "Ингредиент не добавлен");
    }

    @Test
    public void removeIngridientTest() {
        shawarma.addIngridient(mockIngredient1);
        shawarma.addIngridient(mockIngredient2);
        shawarma.removeIngridient(mockIngredient2);
        assertEquals(false, shawarma.ingredients.contains(mockIngredient2), "Некорректный состав, ингредиент не удален");
    }

    @Test
    public void getPriceTest() {
        shawarma.setLavash(mockLavash);
        Mockito.when(mockLavash.getPrice()).thenReturn(10.0);
        shawarma.addIngridient(mockIngredient1);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(10.0);
        shawarma.addIngridient(mockIngredient2);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(10.0);
        assertEquals(30.0, shawarma.getPrice(), "Неправильно посчитанная цена");
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

        assertEquals(expectedReceipt, shawarma.getReceipt(), "Неверный рецепт шаурмы");
    }
}
