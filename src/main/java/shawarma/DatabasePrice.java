package shawarma;

import java.util.HashMap;
import java.util.Map;

public class DatabasePrice {

    private final Map<String, Lavash> lavash = new HashMap<>();
    private final Map<String, Ingridient> ingridients = new HashMap<>();

    public DatabasePrice() {

        ingridients.put("Капуста", new Ingridient(IngridientType.CABBAGE, "Капуста", 5.0));
        ingridients.put("Сыр", new Ingridient(IngridientType.CHEESE, "Сыр", 10.0));
        ingridients.put("Мясо", new Ingridient(IngridientType.MEAT, "Мясо", 25.0));
        ingridients.put("Огурец", new Ingridient(IngridientType.CUCUMBER, "Огурец", 6.0));
        ingridients.put("Маринованный огурец", new Ingridient(IngridientType.CUCUMBER, "Маринованный огурец", 7.0));
        ingridients.put("Лук", new Ingridient(IngridientType.ONION, "Лук", 6.0));
        ingridients.put("Маринованный лук", new Ingridient(IngridientType.ONION, "Маринованный лук", 6.0));
        ingridients.put("Карамелизованный лук", new Ingridient(IngridientType.ONION, "Карамелизованный лук", 7.0));
        ingridients.put("Картофель фри", new Ingridient(IngridientType.POTATO, "Картофель фри", 5.0));
        ingridients.put("Картофель по-деревенски", new Ingridient(IngridientType.POTATO, "Картофель по-деревенски", 7.0));
        ingridients.put("Протеиновый соус", new Ingridient(IngridientType.SAUCE, "Протеиновый соус", 5.0));
        ingridients.put("Чесночный соус", new Ingridient(IngridientType.SAUCE, "Чесночный соус", 5.0));
        ingridients.put("Сырный соус", new Ingridient(IngridientType.SAUCE, "Сырный соус", 5.0));
        ingridients.put("Барбекю соус", new Ingridient(IngridientType.SAUCE, "Барбекю соус", 5.0));
        ingridients.put("Грибы", new Ingridient(IngridientType.MUSHROOMS, "Грибы", 7.0));
        ingridients.put("Морковь по-корейски", new Ingridient(IngridientType.CARROT, "Морковь по-корейски", 7.0));
        ingridients.put("Помидор", new Ingridient(IngridientType.TOMATO, "Помидор", 6.0));

        lavash.put("Сырный", new Lavash(LavashType.CHEESE_LAVASH, "Сырный лаваш", 70.0));
        lavash.put("Обычный", new Lavash(LavashType.WHEAT_LAVASH, "Пшеничный лаваш", 50.0));
    }


    public Map<String, Lavash> availableLavashMap() {
        return lavash;
    }

    public Map<String, Ingridient> availableIngridients() {
        return ingridients;
    }
}
