package shawarma;

import java.util.ArrayList;
import java.util.List;

public class Shawarma {

    Lavash lavash;
    List<Ingridient> ingridients = new ArrayList<>();

    public void setLavash(Lavash lavash) {
        this.lavash = lavash;
    }

    public void addIngridient(Ingridient ingridient) {
        ingridients.add(ingridient);
    }

    public void removeIngridient(Ingridient ingridient) {
        ingridients.remove(ingridient);
    }

    public double getPrice() {
        double price = lavash.getPrice();

        for (Ingridient ingridient : ingridients) {
            price += ingridient.getPrice();
        }

        return price;
    }

    public String getReceipt() {
        StringBuilder str = new StringBuilder(String.format("=== Финальный состав шаурмы и её рецепт ==="));

        str.append(String.format("%n%s ", lavash.getName()));

        for (Ingridient ingridient : ingridients) {
            str.append(String.format("%n%s", ingridient.getName()));
        }

        str.append(String.format("%nЦена = %f", getPrice()));

        return str.toString();
    }

}
