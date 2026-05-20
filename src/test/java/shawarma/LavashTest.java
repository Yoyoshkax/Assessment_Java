package shawarma;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LavashTest {

    Lavash lavash;

    @BeforeEach
    public void setUp() {
        lavash = new Lavash(LavashType.WHEAT_LAVASH, "Пшеничный лаваш", 1.0);
    }

    @Test
    public void getNameTest() {
        assertEquals("Пшеничный лаваш", lavash.getName(), "Название лаваша не корректное");
    }

    @Test
    public void getPriceTest() {
        assertEquals(1.0, lavash.getPrice(), "Некорректная цена лаваша");
    }

    @Test
    public void getTypeTest() {
        assertEquals(LavashType.WHEAT_LAVASH, lavash.getType(), "Неправильный тип лаваша");
    }

}
