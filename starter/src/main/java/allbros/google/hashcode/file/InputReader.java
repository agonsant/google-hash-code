package allbros.google.hashcode.file;

import allbros.google.hashcode.file.contract.StringDeserializer;

public class InputReader {

    private final StringDeserializer deserializer;

    public InputReader(StringDeserializer deserializer) {

        this.deserializer = deserializer;
    }
    public <TInput> TInput readFile(String pathFile){
        return deserializer.deserialize("");
    }
}
