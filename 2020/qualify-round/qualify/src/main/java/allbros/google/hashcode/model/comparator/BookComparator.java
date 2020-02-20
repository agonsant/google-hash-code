package allbros.google.hashcode.model.comparator;

import java.util.Comparator;

import allbros.google.hashcode.model.Book;

public class BookComparator implements Comparator<Book> {
	@Override
	public int compare(Book b1, Book b2) {
		return (b1.getScore() > b2.getScore() ? 1 : (b1.getScore() < b2.getScore() ? -1 : 0)) *-1;
	}
}
