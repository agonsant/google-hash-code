
package allbros.google.hashcode.model;

import java.util.Arrays;

public class Delivery {

    private int pizzaOrderedSize;
    private boolean[] pizzaOrdered;

    public Delivery(int maxPizzaTypes) {
        this.pizzaOrderedSize = 0;
        this.pizzaOrdered = new boolean[maxPizzaTypes];
        Arrays.fill(this.pizzaOrdered, false);
    }

    public void orderPizza(int index){
        this.pizzaOrdered[index] = true;
        this.pizzaOrderedSize++;
    }

    public int getOrderedPizzaTypes(){
        return this.pizzaOrderedSize;
    }

    public boolean[] getPizzaOrdered(){
        return this.pizzaOrdered;
    }
}