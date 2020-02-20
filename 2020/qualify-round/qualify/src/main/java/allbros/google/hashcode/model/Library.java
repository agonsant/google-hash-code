package allbros.google.hashcode.model;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import allbros.google.hashcode.model.comparator.BookComparator;

public class Library {
    private int id;
    private Set<Book> bookSet;
    private int numberOfBooks;
    private int signDays;
    private int numberOfBooksScannedPerDay;
    private int totalScoring;

    public Library() {
        this.bookSet = new TreeSet<>( new BookComparator());
    }

    public Library(String numberOfBooks, String signDays, String numberOfBooksScannedPerDay) {
        this.bookSet = new TreeSet<>( new BookComparator());
        this.numberOfBooks = Integer.parseInt(numberOfBooks);
        this.signDays = Integer.parseInt(signDays);
        this.numberOfBooksScannedPerDay = Integer.parseInt(numberOfBooksScannedPerDay);
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

    public int getNumberOfBooksScannedPerDay() {
        return numberOfBooksScannedPerDay;
    }

    public void setNumberOfBooksScannedPerDay(int numberOfBooksScannedPerDay) {
        this.numberOfBooksScannedPerDay = numberOfBooksScannedPerDay;
    }

    public int getTotalScoring() {
        return totalScoring;
    }

    public void setTotalScoring(int totalScoring) {
        this.totalScoring = totalScoring;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
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
