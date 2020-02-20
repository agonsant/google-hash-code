package allbros.google.hashcode.model;

import java.util.*;

import allbros.google.hashcode.model.comparator.LibraryComparator;

public class InputData {
    private List<Library> librarySet;
    private Book[] bookArray;
    private int dayToShip;
    private int numberOfBooks;
    private int numberOfLibraries;

    public InputData() {
        this.librarySet = new ArrayList<>() ;
    }

    public List<Library> getLibrarySet() {
        return librarySet;
    }

    public void setLibrarySet(List<Library> librarySet) {
        this.librarySet = librarySet;
    }

    public int getDayToShip() {
        return dayToShip;
    }

    public void setDayToShip(int dayToShip) {
        this.dayToShip = dayToShip;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public int getNumberOfLibraries() {
        return numberOfLibraries;
    }

    public void setNumberOfLibraries(int numberOfLibraries) {
        this.numberOfLibraries = numberOfLibraries;
    }

    public Book[] getBookArray() {
        return bookArray;
    }

    public void setBookArray(Book[] bookArray) {
        this.bookArray = bookArray;
    }

    public void addLibrary(Library newLibrary) {
        getLibrarySet().add(newLibrary);
    }
}
