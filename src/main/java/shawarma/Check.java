package shawarma;

import java.util.List;

public class Check {
    public static void main(String[] args) {

        DatabasePrice databasePrice = new DatabasePrice();

        Shawarma shawarma = new Shawarma();

        List<Lavash> lavash = databasePrice.availableLavash();

        List<Ingridient> ingridients = databasePrice.availableIngridients();

        shawarma.setLavash(lavash.add());
    }



}
