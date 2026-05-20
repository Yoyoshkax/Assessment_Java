package shawarma;

public class Ingredient {

    IngredientType type;
    String name;
    double price;

    public Ingredient(IngredientType type, String name, double price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public IngredientType getType() {
        return type;
    }
}
