package allbros.google.hashcode.model.comparator;

import java.util.Comparator;

import allbros.google.hashcode.model.Library;

public class LibraryComparator implements Comparator<Library> {

	@Override
	public int compare(Library o1, Library o2) {
		return o1.getSignDays() < o2.getSignDays() ? 1
				: o1.getSignDays() > o2.getSignDays() ? -1
						: o1.getNumberBookScannedPerDay() > o2.getNumberBookScannedPerDay() ? 1
								: o1.getNumberBookScannedPerDay() < o2.getNumberBookScannedPerDay() ? -1 : 0;

	}

}
