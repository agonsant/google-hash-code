package hashCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solver {

	private InputEntity input;
	private OutputEntity output;

	private final String[] files = { "a_example", "b_small", "c_medium", "d_quite_big", "e_also_big" };
	private final int file = 4;

	public Solver() {
	}

	public void loadData() {
		BufferedReader br = null;
		FileReader fr = null;
		String fileName = "./problem-statement/" + this.files[file] + ".in";
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String currentLine = br.readLine();
			String[] split = currentLine.split(" ");
			int maxSlices = Integer.parseInt(split[0]);
			int pizzaTypes = Integer.parseInt(split[1]);
			this.input = new InputEntity(maxSlices, pizzaTypes);
			this.output = new OutputEntity(pizzaTypes);

			currentLine = br.readLine();
			split = currentLine.split(" ");
			for (int i = 0; i < pizzaTypes; i++) {
				this.input.addPizza(i, Integer.parseInt(split[i]));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void writeData() {
		BufferedWriter bw = null;
		FileWriter fw = null;
		String fileName = "./output/output_" + this.files[file] + ".txt";
		try {
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			bw.write(Integer.toString(this.output.getOrderedPizzaTypes()));
			bw.newLine();
			boolean[] pizzas = this.output.getPizzaOrdered();
			for (int i = 0; i < pizzas.length; i++) {
				if (pizzas[i]) {
					bw.write(Integer.toString(i) + " ");
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void solve() {
		int[] pizzas = this.input.getPizzaSlices();
		int acc = 0, i = pizzas.length - 1, max = this.input.getMaximunSlices();
		while (i >= 0 && acc < max) {
			if (pizzas[i] + acc <= max) {
				this.output.orderPizza(i);
				acc += pizzas[i];
			}
			i--;
		}
	}

}
