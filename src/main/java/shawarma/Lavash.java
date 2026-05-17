package shawarma;

public class Lavash {

    LavashType type;
    public String name;
    public double price;

    public Lavash(LavashType type, String name, double price) {
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

    public LavashType getType() {
        return type;
    }

}
