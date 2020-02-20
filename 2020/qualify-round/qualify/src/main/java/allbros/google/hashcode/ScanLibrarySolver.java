package allbros.google.hashcode;

import allbros.google.hashcode.algorithm.Solver;
import allbros.google.hashcode.model.InputData;
import allbros.google.hashcode.model.OutputData;

public class ScanLibrarySolver implements Solver<InputData, OutputData> {


	public ScanLibrarySolver() {
	}

	public OutputData solve(InputData pizzeria) {
//		int[] pizzas = pizzeria.getPizzaSlices();
//		int acc = 0, i = pizzas.length - 1, max =pizzeria.getMaximumSlices();
//		Delivery deliveryData = new Delivery(pizzeria.getMaximumSlices());
//		while (i >= 0 && acc < max) {
//			if (pizzas[i] + acc <= max) {
//				deliveryData.orderPizza(i);
//				acc += pizzas[i];
//			}
//			i--;
//		}
//		return deliveryData;
		return null;
	}

}
