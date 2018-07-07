import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 * File: NameSurferDataBase.java
 * -----------------------------
 * This class keeps track of the complete database of names.
 * The constructor reads in the database from a file, and
 * the only public method makes it possible to look up a
 * name and get back the corresponding NameSurferEntry.
 * Names are matched independent of case, so that "Eric"
 * and "ERIC" are the same names.
 */

public class NameSurferDataBase implements NameSurferConstants {

    // Instance variables
    private HashMap<String, String> namesAndRanksMap = new HashMap<String, String>();

    /* Constructor: NameSurferDataBase(filename) */

    /**
     * Creates a new NameSurferDataBase and initializes it using the data in the
     * specified file. The constructor throws an error exception if the
     * requested file does not exist or if an error occurs as the file is being
     * read.
     */
    public NameSurferDataBase(String filename) {
        try {

            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            while (true) {
                String line = br.readLine();
                if (null == line) {
                    break;
                }
                addEntryToDatabase(line);
                System.out.println(line);
            }

            System.out.println(namesAndRanksMap.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void addEntryToDatabase(String line) {
        StringTokenizer st = new StringTokenizer(line, " ");
        String name = st.nextToken();
        String rankList = line.substring(name.length());

        System.out.println("addEntryToDatabase name = " + name);
        System.out.println("addEntryToDatabase rankList = " + rankList);
        namesAndRanksMap.put(name.toUpperCase(), rankList);
    }

    /* Method: findEntry(name) */

    /**
     * Returns the NameSurferEntry associated with this name, if one exists. If
     * the name does not appear in the database, this method returns null.
     */
    public NameSurferEntry findEntry(String name) {

        System.out.println("findEntry name = " + name);
        if (namesAndRanksMap.containsKey(name.toUpperCase())) {
            String line = name + namesAndRanksMap.get(name.toUpperCase());
            System.out.println("findEntry line = " + line);
            return new NameSurferEntry(line);
        }
        return null;
    }
}
