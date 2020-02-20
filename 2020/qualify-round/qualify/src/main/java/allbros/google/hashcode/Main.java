package allbros.google.hashcode;

import allbros.google.hashcode.file.FilePathUtil;
import allbros.google.hashcode.launcher.Launcher;
import allbros.google.hashcode.launcher.LauncherBuilder;
import allbros.google.hashcode.model.InputData;
import allbros.google.hashcode.model.OutputData;
import allbros.google.hashcode.model.data.LibraryDeserializer;
import allbros.google.hashcode.model.data.LibrarySerializer;

public class Main {

	private static final String[] files = { "a_example", "b_small", "c_medium", "d_quite_big", "e_also_big" };
	private static final String inputFilePath = "./problem-statement/%s";
	private static final String outputFilePath = "./output/%s";
	private static final String inputFileNamePattern = "%s.in";
	private static final String outFileNamePattern = "%s.txt";

	public static void main(String[] args) {
		Launcher<InputData, OutputData> launcher = new LauncherBuilder<InputData, OutputData>()
				.withSolver(new ScanLibrarySolver())
				.withDeserialize(new LibraryDeserializer())
				.withSerialize(new LibrarySerializer())
				.withDataSetFilePath(FilePathUtil.buildFilePathSet(files,inputFilePath,inputFileNamePattern))
				.withSolutionSetFilePath(FilePathUtil.buildFilePathSet(files,outputFilePath,outFileNamePattern))
				.build();

		launcher.launchDataSet(0);
	}

}
