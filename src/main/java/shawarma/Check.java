package shawarma;

import java.util.Map;

public class Check {
    public static void main(String[] args) {

        DatabasePrice databasePrice = new DatabasePrice();

        Shawarma shawarma = new Shawarma();

        Map<String, Ingredient> ingridients = databasePrice.availableIngridients();

        Map<String, Lavash> lavashes = databasePrice.availableLavashMap();

        shawarma.setLavash(lavashes.get("Сырный"));
        shawarma.addIngridient(ingridients.get("Грибы"));
        shawarma.addIngridient(ingridients.get("Морковь по-корейски"));
        shawarma.addIngridient(ingridients.get("Мясо"));
        shawarma.addIngridient(ingridients.get("Лук"));

        shawarma.removeIngridient(ingridients.get("Лук"));

        System.out.println(shawarma.getReceipt());

    }


}
