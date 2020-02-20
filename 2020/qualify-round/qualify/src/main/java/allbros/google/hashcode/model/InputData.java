package allbros.google.hashcode.model;

import java.util.*;

public class InputData {
    public Set<Library> librarySet;
    public int dayToShip;
    public int numberOfBooks;
    public int numberOfLibraries;

    public InputData() {
        this.librarySet = new TreeSet<>() ;
    }

    public Set<Library> getLibrarySet() {
        return librarySet;
    }

    public void setLibrarySet(Set<Library> librarySet) {
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
}
