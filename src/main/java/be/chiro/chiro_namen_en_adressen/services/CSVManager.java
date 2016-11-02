
package be.chiro.chiro_namen_en_adressen.services;

import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Arno
 */
public class CSVManager implements CSVManagerInterface {
    
    private String fileLocation;
    private final CSVWriter writer;
    
    public CSVManager(String fileLocation) throws IOException {
        this.fileLocation = fileLocation;
        writer = new CSVWriter(new FileWriter(fileLocation),';');
        prepareCSVFile();
    }

    @Override
    public void writeDataToCSVFile(String[] data) throws IOException {
        writer.writeNext(data);
    }
    
    @Override
    public boolean deleteFile() {
        File fileToDelete = new File(fileLocation);
        return fileToDelete.delete(); 
    }
    
    private void prepareCSVFile() {
        String[] columnNames = {"Naam","Geboortedatum","Adres","Stad/Dorp","E-mail adres"};
        writer.writeNext(columnNames);
    }
    
    public void closeWriter() throws IOException{
        writer.close();
    }

    @Override
    public int getNumberOfEntries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getLastEntry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteLastEntryFromFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
