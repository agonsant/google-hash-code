package allbros.google.hashcode.model.data;

import allbros.google.hashcode.file.contract.StringDeserializer;
import allbros.google.hashcode.model.Book;
import allbros.google.hashcode.model.InputData;
import allbros.google.hashcode.model.Library;

public class LibraryDeserializer implements StringDeserializer<InputData> {
    @Override
    public InputData deserialize(String stringToDeserialize) {
        String[] lines = stringToDeserialize.split("\n");
        InputData inputData = loadInitData(lines[0]);
        inputData.setBookArray(loadBookData(lines[1]));
        for(int i = 2; i<lines.length-1; i+=2){
            inputData.addLibrary(loadLibraryData((i/2-1), lines[i], lines[i+1],inputData.getBookArray()));
        }
        return inputData;
    }

    private Library loadLibraryData(int libraryId,String librarySetup, String libraryBooksSetData,Book[] googleBookSet) {
        System.out.println("Creating Library id:"+libraryId);
        String[] librarySetupSplit = librarySetup.split(" ");
        String[] libraryBooksSetDataSplit = libraryBooksSetData.split(" ");
        Library newLibrary = new Library(libraryId,librarySetupSplit[0],librarySetupSplit[1],librarySetupSplit[2]);

        for(String bookId:libraryBooksSetDataSplit) {
            newLibrary.addBook(googleBookSet[Integer.parseInt(bookId)]);
        }
        newLibrary.calculateTotalScoring();
        return newLibrary;
    }


    private Book[] loadBookData(String bookSetup) {
        String[] bookSetupSplit = bookSetup.split(" ");
        Book[] googleTotalBooks = new Book[bookSetupSplit.length];
        for(int i=0; i< googleTotalBooks.length;i++){
            googleTotalBooks[i]= new Book(i, bookSetupSplit[i]);
        }
        return googleTotalBooks;
    }

    private InputData loadInitData(String googleBookSetup) {
        InputData newInputData = new InputData();
        String[] googleBookSetupSplit = googleBookSetup.split(" ");
        newInputData.setNumberOfBooks(Integer.parseInt(googleBookSetupSplit[0]));
        newInputData.setNumberOfLibraries(Integer.parseInt(googleBookSetupSplit[1]));
        newInputData.setDayToShip(Integer.parseInt(googleBookSetupSplit[2]));
        return newInputData;
    }


}
