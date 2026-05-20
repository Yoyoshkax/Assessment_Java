package shawarma;

import java.util.HashMap;
import java.util.Map;

public class DatabasePrice {

    private final Map<String, Lavash> lavash = new HashMap<>();
    private final Map<String, Ingredient> ingridients = new HashMap<>();

    public DatabasePrice() {

        ingridients.put("Капуста", new Ingredient(IngredientType.CABBAGE, "Капуста", 5.0));
        ingridients.put("Сыр", new Ingredient(IngredientType.CHEESE, "Сыр", 10.0));
        ingridients.put("Мясо", new Ingredient(IngredientType.MEAT, "Мясо", 25.0));
        ingridients.put("Огурец", new Ingredient(IngredientType.CUCUMBER, "Огурец", 6.0));
        ingridients.put("Маринованный огурец", new Ingredient(IngredientType.CUCUMBER, "Маринованный огурец", 7.0));
        ingridients.put("Лук", new Ingredient(IngredientType.ONION, "Лук", 6.0));
        ingridients.put("Маринованный лук", new Ingredient(IngredientType.ONION, "Маринованный лук", 6.0));
        ingridients.put("Карамелизованный лук", new Ingredient(IngredientType.ONION, "Карамелизованный лук", 7.0));
        ingridients.put("Картофель фри", new Ingredient(IngredientType.POTATO, "Картофель фри", 5.0));
        ingridients.put("Картофель по-деревенски", new Ingredient(IngredientType.POTATO, "Картофель по-деревенски", 7.0));
        ingridients.put("Протеиновый соус", new Ingredient(IngredientType.SAUCE, "Протеиновый соус", 5.0));
        ingridients.put("Чесночный соус", new Ingredient(IngredientType.SAUCE, "Чесночный соус", 5.0));
        ingridients.put("Сырный соус", new Ingredient(IngredientType.SAUCE, "Сырный соус", 5.0));
        ingridients.put("Барбекю соус", new Ingredient(IngredientType.SAUCE, "Барбекю соус", 5.0));
        ingridients.put("Грибы", new Ingredient(IngredientType.MUSHROOMS, "Грибы", 7.0));
        ingridients.put("Морковь по-корейски", new Ingredient(IngredientType.CARROT, "Морковь по-корейски", 7.0));
        ingridients.put("Помидор", new Ingredient(IngredientType.TOMATO, "Помидор", 6.0));

        lavash.put("Сырный", new Lavash(LavashType.CHEESE_LAVASH, "Сырный лаваш", 70.0));
        lavash.put("Обычный", new Lavash(LavashType.WHEAT_LAVASH, "Пшеничный лаваш", 50.0));
    }


    public Map<String, Lavash> availableLavashMap() {
        return lavash;
    }

    public Map<String, Ingredient> availableIngridients() {
        return ingridients;
    }
}
