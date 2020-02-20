package allbros.google.hashcode.file;

import allbros.google.hashcode.file.contract.StringDeserializer;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputReader<TInput>  {

    private final StringDeserializer<TInput> deserializer;

    public InputReader(StringDeserializer<TInput> deserializer) {
        this.deserializer = deserializer;
    }

    public TInput readFile(String pathFile) {
        return deserializer.deserialize(readCompleteFile(pathFile));
    }

    private String readCompleteFile(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(filePath).getPath());
        try (Stream<String> stream = Files.lines(file.toPath(), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

}
