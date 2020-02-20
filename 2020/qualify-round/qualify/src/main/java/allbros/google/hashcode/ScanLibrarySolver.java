package allbros.google.hashcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import allbros.google.hashcode.algorithm.Solver;
import allbros.google.hashcode.model.Book;
import allbros.google.hashcode.model.InputData;
import allbros.google.hashcode.model.Library;
import allbros.google.hashcode.model.OutputData;
import allbros.google.hashcode.model.comparator.BookComparator;
import allbros.google.hashcode.model.comparator.LibraryComparator;

public class ScanLibrarySolver implements Solver<InputData, OutputData> {

	public ScanLibrarySolver() {
	}

	public OutputData solve(InputData input) {
		OutputData out = new OutputData();
		List<Library> libs = new LinkedList<Library>();
		input.getLibrarySet().sort(new LibraryComparator());
		int totalDays = input.getDayToShip();
		Iterator<Library> itLib = input.getLibrarySet().iterator();
		while (itLib.hasNext() && totalDays > 0) {
			Library lib = itLib.next();
			lib.getBookSet().sort(new BookComparator());
			totalDays -= lib.getSignDays();
			libs.add(lib);
		}
		
		out.setLibraryList(libs);
		return out;
	}

	public Set<Book> getBooks(Library lib, int totalDays) {
		int books = Math.min(lib.getBookSet().size(), totalDays * lib.getNumberOfBooksScannedPerDay());
		Set<Book> l = new HashSet<>();
		Iterator<Book> it = lib.getBookSet().iterator();
		for (int i = 0; i < books; i++) {
			l.add(it.next());
		}
		return l;
	}

}
