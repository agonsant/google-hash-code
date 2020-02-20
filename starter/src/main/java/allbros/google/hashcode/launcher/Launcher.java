package allbros.google.hashcode.launcher;

import allbros.google.hashcode.algorithm.Solver;
import allbros.google.hashcode.file.InputReader;
import allbros.google.hashcode.file.OutputWriter;
import allbros.google.hashcode.file.contract.StringDeserializer;
import allbros.google.hashcode.file.contract.StringSerializer;

public class Launcher<TInput,TOutput> {

    private final Solver<TInput,TOutput> solver;
    private final String[] dataSetFilePath;
    private final String[] solutionSetFilePath;
    private final InputReader<TInput> reader;
    private final OutputWriter<TOutput> writer;

    public Launcher(Solver<TInput, TOutput> solver, String[] dataSetFilePath, String[] solutionSetFilePath,StringSerializer<TOutput> serializer, StringDeserializer<TInput> deserializer) {
        this.solver = solver;
        this.dataSetFilePath = dataSetFilePath;
        this.solutionSetFilePath = solutionSetFilePath;
        reader = new InputReader<TInput>(deserializer);
        writer = new OutputWriter<TOutput>(serializer);
    }

    public void launchDataSet(int dataSetIndex)
    {
       TInput inputData = this.reader.readFile(dataSetFilePath[dataSetIndex]);
       TOutput outputData = solver.solve(inputData);
       this.writer.writeFile(outputData,solutionSetFilePath[dataSetIndex]);
    }
}
