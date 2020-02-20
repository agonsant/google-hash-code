package allbros.google.hashcode;

import allbros.google.hashcode.file.FilePathUtil;
import allbros.google.hashcode.launcher.Launcher;
import allbros.google.hashcode.launcher.LauncherBuilder;
import allbros.google.hashcode.model.Delivery;
import allbros.google.hashcode.model.Pizzeria;
import allbros.google.hashcode.model.process.DeliverySerializer;
import allbros.google.hashcode.model.process.PizzeriaDeserializer;

public class Main {

	private static final String[] files = { "a_example", "b_small", "c_medium", "d_quite_big", "e_also_big" };
	private static final String inputFilePath = "./resources/problem-statement/%s";
	private static final String outputFilePath = "./output/%s";
	private static final String inputFileNamePattern = "%s.in";
	private static final String outFileNamePattern = "%s.txt";

	public static void main(String[] args) {
		Launcher<Pizzeria, Delivery> launcher = new LauncherBuilder<Pizzeria, Delivery>()
				.withSolver(new BookScanningSolver())
				.withDeserialize(new PizzeriaDeserializer())
				.withSerialize(new DeliverySerializer())
				.withDataSetFilePath(FilePathUtil.buildFilePathSet(files,inputFilePath,inputFileNamePattern))
				.withSolutionSetFilePath(FilePathUtil.buildFilePathSet(files,outputFilePath,outFileNamePattern))
				.build();

		launcher.launchDataSet(0);
	}

}
