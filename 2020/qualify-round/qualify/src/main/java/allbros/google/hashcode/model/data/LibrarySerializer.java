package allbros.google.hashcode.model.data;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import allbros.google.hashcode.file.contract.StringSerializer;
import allbros.google.hashcode.model.Book;
import allbros.google.hashcode.model.Library;
import allbros.google.hashcode.model.OutputData;

public class LibrarySerializer implements StringSerializer<OutputData> {

    @Override
    public String serialize(OutputData objectToSerialize) {
        StringBuilder deliveryString = new StringBuilder();
        List<Library> l = objectToSerialize.getLibraryList();
        deliveryString.append(l.size());
        deliveryString.append(System.getProperty("line.separator"));
        Iterator<Library> itLib = l.iterator();
        while(itLib.hasNext()) {
        	Library lib = itLib.next();
        	deliveryString.append(lib.getId());
        	deliveryString.append(" ");
        	List<Book> b = lib.getBookSet();
        	deliveryString.append(b.size());
        	Iterator<Book> itBook = b.iterator();
            deliveryString.append(System.getProperty("line.separator"));
        	while(itBook.hasNext()) {
                deliveryString.append(itBook.next().getId());
                deliveryString.append(" ");
        	}
        	deliveryString.append(System.getProperty("line.separator"));
        }
        return deliveryString.toString();
    }
}
