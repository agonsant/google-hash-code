package allbros.google.hashcode.file;

import allbros.google.hashcode.file.contract.StringSerializer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class OutputWriter<TOutput> {

    private final StringSerializer<TOutput> serializer;

    public OutputWriter(StringSerializer<TOutput> serializer) {
        this.serializer = serializer;
    }

    public  void writeFile(TOutput objectToWrite, String pathFile) {
        String dataToWrite = serializer.serialize(objectToWrite);
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(pathFile).getPath());
            Files.write(file.toPath(), dataToWrite.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
