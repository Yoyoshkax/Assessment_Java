package shawarma;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LavashTest {

    @Test
    public void getNameTest() {
        Lavash lavash = new Lavash(LavashType.WHEAT_LAVASH,"Пшеничный лаваш", 1.0);
        assertEquals("Название лаваша не корректное","Пшеничный лаваш", lavash.getName());
    }

    @Test
    public void getPriceTest() {
        Lavash lavash = new Lavash(LavashType.WHEAT_LAVASH,"Пшеничный лаваш", 1.0);
        assertEquals("Некорректная цена лаваша",1.0, lavash.getPrice(), 0.0);
    }

}
