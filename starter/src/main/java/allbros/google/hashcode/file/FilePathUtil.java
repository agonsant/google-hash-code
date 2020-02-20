package allbros.google.hashcode.file;

import java.util.ArrayList;
import java.util.List;

public class FilePathUtil {

    public static String[] buildFilePathSet(String[] fileNameSet, String filePathPattern, String fileNamePattern) {
        List<String> filePathSetBuilt = new ArrayList<>();
        String[] filePathSetBuiltArray = new String[fileNameSet.length];

        for (String fileName : fileNameSet) {
            String completeFileName = String.format(fileNamePattern, fileName);
            filePathSetBuilt.add(String.format(filePathPattern, completeFileName));
        }
        return filePathSetBuilt.toArray(filePathSetBuiltArray);
    }

}
