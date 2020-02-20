package allbros.google.hashcode.model;

import java.util.*;

import allbros.google.hashcode.model.comparator.BookComparator;

public class Library {
    private int id;
    private List<Book> bookSet;
    private int numberOfBooks;
    private int signDays;
    private int numberOfBooksScannedPerDay;
    private int totalScoring;

    public Library() {
        this.bookSet = new ArrayList<>();
    }

    public Library(int id,String numberOfBooks, String signDays, String numberOfBooksScannedPerDay) {
        this.id = id;
        this.bookSet =  new ArrayList<>();
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

    public List<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(List<Book> bookSet) {
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

    public void addBook(Book newBook) {
        getBookSet().add(newBook);
    }
}
