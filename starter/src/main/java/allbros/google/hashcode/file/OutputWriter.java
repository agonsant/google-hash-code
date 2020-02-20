package allbros.google.hashcode.file;

import allbros.google.hashcode.file.contract.StringSerializer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OutputWriter<TOutput> {

    private final StringSerializer<TOutput> serializer;

    public OutputWriter(StringSerializer<TOutput> serializer) {
        this.serializer = serializer;
    }

    public  void writeFile(TOutput objectToWrite, String pathFile) {
        String dataToWrite = serializer.serialize(objectToWrite);
        try {
            Files.write(Paths.get(pathFile), dataToWrite.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
