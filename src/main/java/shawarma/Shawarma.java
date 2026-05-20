package shawarma;

import java.util.ArrayList;
import java.util.List;

public class Shawarma {

    Lavash lavash;
    List<Ingredient> ingredients = new ArrayList<>();

    public void setLavash(Lavash lavash) {
        this.lavash = lavash;
    }

    public void addIngridient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void removeIngridient(Ingredient ingredient) {
        ingredients.remove(ingredient);
    }

    public double getPrice() {
        double price = lavash.getPrice();

        for (Ingredient ingredient : ingredients) {
            price += ingredient.getPrice();
        }

        return price;
    }

    public String getReceipt() {
        StringBuilder str = new StringBuilder(String.format("=== Финальный состав шаурмы и её рецепт ==="));

        str.append(String.format("%n%s", lavash.getName()));

        for (Ingredient ingredient : ingredients) {
            str.append(String.format("%n%s", ingredient.getName()));
        }

        str.append(String.format("%nЦена = %f", getPrice()));

        return str.toString();
    }

}
