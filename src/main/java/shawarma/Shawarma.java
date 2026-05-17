package shawarma;

import java.util.ArrayList;
import java.util.List;

public class Shawarma {

    Lavash lavash;
    List<Ingridient> ingridients = new ArrayList<>();

    public void setLavash(Lavash lavash){
        this.lavash = lavash;
    }

    public void addIngridient(Ingridient ingridient){
        ingridients.add(ingridient);
    }

    public void removeIngridient(int index){
        ingridients.remove(index);
    }

    public double getPrice() {
        double price = lavash.getPrice();

        for(Ingridient ingridient : ingridients){
            price+= ingridient.getPrice();
        }

        return price;
    }

    public String getReceipt(){
        return String.format("%s",lavash.getType().name());
    }

}
