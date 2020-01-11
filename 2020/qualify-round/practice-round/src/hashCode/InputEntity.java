
package hashCode;

public class InputEntity {

    private int maxSlices;
    private int[] pizzaSlices;

    public InputEntity(int maxSlices, int maxPizzaTypes) {
        this.maxSlices = maxSlices;
        this.pizzaSlices = new int[maxPizzaTypes];
    }

    public void addPizza(int index, int slices) {
        this.pizzaSlices[index] = slices;
    }

    public int[] getPizzaSlices() {
        return this.pizzaSlices;
    }

    public int getMaximunSlices() {
        return this.maxSlices;
    }
}