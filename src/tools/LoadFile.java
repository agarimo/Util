package tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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

    public LoadFile(File file) {
        this.file = file;
        count = 0;
        lineas = new ArrayList<>();
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

    public void eliminaCabecera() {
        lineas.remove(0);
    }

    public int getCount() {
        return this.count;
    }

    public List<String> getLineas() {
        return this.lineas;
    }

    public String getFileData() {
        StringBuilder sb = new StringBuilder();
        Iterator it = lineas.iterator();

        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    public static String readFile(File file) {
        try (FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            StringBuilder sb = new StringBuilder();
            String linea;
            while ((linea = br.readLine()) != null) {
                sb.append(linea);
                sb.append(System.lineSeparator());
            }

            return sb.toString();
        } catch (IOException ex) {
            Logger.getLogger(LoadFile.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void writeFile(File file, String datos) {
        try (FileWriter fw = new FileWriter(file); BufferedWriter out = new BufferedWriter(fw)) {
            out.write(datos);
        } catch (IOException ex) {
            Logger.getLogger(LoadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void writeFileAppend(File file, String datos) {
        try (FileWriter fw = new FileWriter(file); BufferedWriter out = new BufferedWriter(fw)) {
            out.append(datos);
        } catch (IOException ex) {
            Logger.getLogger(LoadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
