package shawarma;

public class Ingridient {

    IngridientType type;
    String name;
    double price;

    public Ingridient(IngridientType type, String name, double price) {
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

    public IngridientType getType() {
        return type;
    }
}
