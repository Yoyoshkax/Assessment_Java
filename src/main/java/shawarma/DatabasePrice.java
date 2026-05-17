package shawarma;

import java.util.ArrayList;
import java.util.List;

public class DatabasePrice {

    List<Lavash> lavash = new ArrayList<>();
    List<Ingridient> ingridients = new ArrayList<>();

    public DatabasePrice() {
        lavash.add(new Lavash(LavashType.CHEESE_LAVASH, "Сырный лаваш", 70.0));
        lavash.add(new Lavash(LavashType.WHEAT_LAVASH, "Пшеничный лаваш", 50.0));

        ingridients.add(new Ingridient(IngridientType.CABBAGE, "Капуста", 5.0));
        ingridients.add(new Ingridient(IngridientType.CHEESE, "Сыр", 10.0));
        ingridients.add(new Ingridient(IngridientType.MEAT, "Мясо", 25.0));
        ingridients.add(new Ingridient(IngridientType.CUCUMBER, "Огурец", 6.0));
        ingridients.add(new Ingridient(IngridientType.CUCUMBER, "Маринованный огурец", 7.0));
        ingridients.add(new Ingridient(IngridientType.ONION, "Лук", 6.0));
        ingridients.add(new Ingridient(IngridientType.ONION, "Маринованный лук", 6.0));
        ingridients.add(new Ingridient(IngridientType.ONION, "Карамелизованный лук", 7.0));
        ingridients.add(new Ingridient(IngridientType.POTATO, "Картофель фри", 5.0));
        ingridients.add(new Ingridient(IngridientType.POTATO, "Картофель по-деревенски", 7.0));
        ingridients.add(new Ingridient(IngridientType.SAUCE, "Протеиновый соус", 5.0));
        ingridients.add(new Ingridient(IngridientType.SAUCE, "Чесночный соус", 5.0));
        ingridients.add(new Ingridient(IngridientType.SAUCE, "Сырный соус", 5.0));
        ingridients.add(new Ingridient(IngridientType.SAUCE, "Барбекю соус", 5.0));
        ingridients.add(new Ingridient(IngridientType.MUSHROOMS, "Грибы", 7.0));
        ingridients.add(new Ingridient(IngridientType.CARROT, "Морковь по-корейски", 7.0));
        ingridients.add(new Ingridient(IngridientType.TOMATO, "Помидор", 6.0));
    }

    public List<Lavash> availableLavash() {
        return lavash;
    }

    public List<Ingridient> availableIngridients() {
        return ingridients;
    }
}
