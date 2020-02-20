package allbros.google.hashcode.launcher;

import allbros.google.hashcode.algorithm.Solver;
import allbros.google.hashcode.file.contract.StringDeserializer;
import allbros.google.hashcode.file.contract.StringSerializer;

public class LauncherBuilder<TInput, TOutput> {
    private Solver<TInput, TOutput> solver;
    private String[] dataSetFilePath;
    private String[] solutionSetFilePath;
    private StringDeserializer<TInput> deserializer;
    private StringSerializer<TOutput> serializer;

    public LauncherBuilder withSolver(Solver<TInput, TOutput> solver) {
        this.solver = solver;
        return this;
    }

    public LauncherBuilder withDataSetFilePath(String[] dataSetFilePath) {
        this.dataSetFilePath = dataSetFilePath;
        return this;
    }

    public LauncherBuilder withSolutionSetFilePath(String[] solutionSetFilePath) {
        this.solutionSetFilePath = solutionSetFilePath;
        return this;
    }

    public LauncherBuilder withSerialize(StringSerializer<TOutput> serializer) {
        this.serializer = serializer;
        return this;
    }

    public LauncherBuilder withDeserialize(StringDeserializer<TInput> deserializer) {
        this.deserializer = deserializer;
        return this;
    }

    public Launcher<TInput, TOutput> build() {
        return new Launcher<TInput, TOutput>(solver, dataSetFilePath, solutionSetFilePath, serializer, deserializer);
    }
}
