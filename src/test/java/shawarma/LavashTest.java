package shawarma;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class LavashTest {

    Lavash lavash;

    @Before
    public void setUp() {
        lavash = new Lavash(LavashType.WHEAT_LAVASH,"Пшеничный лаваш", 1.0);
    }

    @Test
    public void getNameTest() {
        assertEquals("Название лаваша не корректное","Пшеничный лаваш", lavash.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals("Некорректная цена лаваша",1.0, lavash.getPrice(), 0.0);
    }

    @Test
    public void getTypeTest() {
        assertEquals("Неправильный тип лаваша",LavashType.WHEAT_LAVASH, lavash.getType());
    }
}
