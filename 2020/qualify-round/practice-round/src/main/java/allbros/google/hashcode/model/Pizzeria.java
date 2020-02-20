
package allbros.google.hashcode.model;

public class Pizzeria {

    private int maxSlices;
    private int[] pizzaSlices;

    public Pizzeria(int maxSlices, int maxPizzaTypes) {
        this.maxSlices = maxSlices;
        this.pizzaSlices = new int[maxPizzaTypes];
    }

    public void addPizza(int index, int slices) {
        this.pizzaSlices[index] = slices;
    }

    public int[] getPizzaSlices() {
        return this.pizzaSlices;
    }

    public int getMaximumSlices() {
        return this.maxSlices;
    }
}