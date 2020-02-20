package allbros.google.hashcode.model.data;

import allbros.google.hashcode.file.contract.StringDeserializer;
import allbros.google.hashcode.model.Book;
import allbros.google.hashcode.model.InputData;
import allbros.google.hashcode.model.Library;

import java.util.Set;


public class LibraryDeserializer implements StringDeserializer<InputData> {
    @Override
    public InputData deserialize(String stringToDeserialize) {
        String[] lines = stringToDeserialize.split(System.getProperty("line.separator"));
        InputData inputData = loadInitData(lines[0]);
        inputData.setBookArray(loadBookData(lines[1]));
        for(int i = 2; i<lines.length-1; i+=2){
            inputData.addLibrary(loadLibraryData(lines[i], lines[i+1]));
        }

        return inputData;
    }

    private Library loadLibraryData(String line, String line1) {
        return null;
    }


    private Book[] loadBookData(String line) {
        return null;
    }

    private InputData loadInitData(String line) {
        InputData newInputData = new InputData();
        return newInputData;
    }


}
