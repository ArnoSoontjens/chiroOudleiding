
package be.chiro.chiro_namen_en_adressen.services;

import java.io.IOException;

/**
 *
 * @author Arno
 */
public interface CSVManagerInterface {
    public void writeDataToCSVFile(String[] data) throws IOException;
    public boolean deleteFile();
    public int getNumberOfEntries();
    public String getLastEntry();
    public boolean deleteLastEntryFromFile();
}
