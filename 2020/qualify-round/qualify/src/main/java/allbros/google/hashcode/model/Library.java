package allbros.google.hashcode.model;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import allbros.google.hashcode.model.comparator.BookComparator;

public class Library {
    private int id;
    private Set<Book> bookSet;
    private int signDays;
    private int numberBookScannedPerDay;
    private int totalScoring;

    public Library() {
        this.bookSet = new TreeSet<Book>( new BookComparator());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    public int getSignDays() {
        return signDays;
    }

    public void setSignDays(int signDays) {
        this.signDays = signDays;
    }

    public int getNumberBookScannedPerDay() {
        return numberBookScannedPerDay;
    }

    public void setNumberBookScannedPerDay(int numberBookScannedPerDay) {
        this.numberBookScannedPerDay = numberBookScannedPerDay;
    }

    public int getTotalScoring() {
        return totalScoring;
    }

    public void setTotalScoring(int totalScoring) {
        this.totalScoring = totalScoring;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return id == library.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
