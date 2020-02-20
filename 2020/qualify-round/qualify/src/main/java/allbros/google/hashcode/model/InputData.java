package allbros.google.hashcode.model;

import java.util.*;

import allbros.google.hashcode.model.comparator.LibraryComparator;

public class InputData {
    public Set<Library> librarySet;
    public int dayToShip;

    public InputData() {
        this.librarySet = new TreeSet<Library>(new LibraryComparator()) ;
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
}
