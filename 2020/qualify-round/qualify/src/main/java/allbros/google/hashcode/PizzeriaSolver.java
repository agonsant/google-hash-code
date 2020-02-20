package allbros.google.hashcode;

import allbros.google.hashcode.algorithm.Solver;
import allbros.google.hashcode.file.InputReader;
import allbros.google.hashcode.file.OutputWriter;
import allbros.google.hashcode.model.Pizzeria;
import allbros.google.hashcode.model.Delivery;

public class PizzeriaSolver implements Solver<Pizzeria,Delivery> {

//	private final String[] files = { "a_example", "b_small", "c_medium", "d_quite_big", "e_also_big" };
//	private final InputReader<Pizzeria> inputReader;
//	private final OutputWriter<Delivery> outputWriter;
//	private String inputFilePath = "./problem-statement/%s";
//	private String outputFilePath = "./output/%s";
//	private String fileNamePattern = "%s.in";

	public PizzeriaSolver() {
	}

	public Delivery solve(Pizzeria pizzeria) {
		int[] pizzas = pizzeria.getPizzaSlices();
		int acc = 0, i = pizzas.length - 1, max =pizzeria.getMaximumSlices();
		Delivery deliveryData = new Delivery(pizzeria.getMaximumSlices());
		while (i >= 0 && acc < max) {
			if (pizzas[i] + acc <= max) {
				deliveryData.orderPizza(i);
				acc += pizzas[i];
			}
			i--;
		}
		return deliveryData;
	}

}
