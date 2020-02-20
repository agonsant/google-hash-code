package allbros.google.hashcode;

public class Main {

	public static void main(String[] args) {
		Solver solver = new Solver();
		solver.loadData();
		System.out.println("DATOS CARGADOS");
		solver.solve();
		System.out.println("RESUELTO");
		solver.writeData();
		System.out.println("TERMINADO");
	}

}
