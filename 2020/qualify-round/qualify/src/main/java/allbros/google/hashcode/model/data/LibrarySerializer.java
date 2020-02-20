package allbros.google.hashcode.model.data;

import allbros.google.hashcode.file.contract.StringSerializer;

import allbros.google.hashcode.model.OutputData;

public class LibrarySerializer implements StringSerializer<OutputData> {

    @Override
    public String serialize(OutputData objectToSerialize) {
        StringBuilder deliveryString = new StringBuilder();

        return deliveryString.toString();
    }
}
