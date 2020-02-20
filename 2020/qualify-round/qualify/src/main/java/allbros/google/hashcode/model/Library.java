package allbros.google.hashcode.model;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Library {
    private int id;
    private Set<Book> bookSet;
    private int signDays;
    private int numberBookScannedPerDay;

    public Library() {
        this.bookSet = new TreeSet<>();
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
