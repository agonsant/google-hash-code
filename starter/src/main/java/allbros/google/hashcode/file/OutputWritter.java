package allbros.google.hashcode.file;

import allbros.google.hashcode.file.contract.StringSerializer;

public class OutputWritter {
    private final StringSerializer serializer;

    public OutputWritter(StringSerializer serializer) {
        this.serializer = serializer;
    }

    public <TOutput> void writeFile(TOutput objectToWrite, String pathFile){
        String dataToWrite  = serializer.serialize(objectToWrite);
    }
}
