package files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agarimo
 */
public class LoadFile {

    private final File file;
    private final List<String> lineas;
    private int count;
    private final boolean isCorrecto;
    
    public LoadFile(File file){
        this.file=file;
        count=0;
        isCorrecto=true;
        lineas=new ArrayList<>();
        loadLines();
    }
    
    private void loadLines() {
        try (FileReader fr = new FileReader(this.file); BufferedReader br = new BufferedReader(fr)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
                count++;
            }
        } catch (IOException ex) {
            Logger.getLogger(LoadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminaCabecera(){
        lineas.remove(0);
    }
    
    public int getCount(){
        return this.count;
    }
    
    public List<String> getLineas(){
        return this.lineas;
    }
}