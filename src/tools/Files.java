package tools;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Agárimo
 */
public class Files {
    
    public static boolean openFile(File file){
        try {
            Desktop.getDesktop().open(file);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    private static void copyDir(File origen, File destino) {
        if (origen.isDirectory()) {
            if (!destino.exists()) {
                destino.mkdir();
            }
            String[] archivos = origen.list();
            for (String archivo : archivos) {
                copyDir(new File(origen, archivo), new File(destino, archivo));
            }
        } else {
            copyFile(origen, destino);
        }
    }

    public static boolean copyFile(File origen, File destino) {
        try {
            OutputStream out;
            try (InputStream in = new FileInputStream(origen)) {
                out = new FileOutputStream(destino);
                byte[] buffer = new byte[1024];
                int lenght;
                while ((lenght = in.read(buffer)) > 0) {
                    out.write(buffer, 0, lenght);
                }
            }
            out.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void moveDir(File origen, File destino) {
        copyDir(origen, destino);
        deleteDir(origen);
    }

    public static void deleteDir(File directorio) {
        if (directorio.isDirectory()) {
            String[] archivos = directorio.list();
            for (String archivo : archivos) {
                deleteDir(new File(directorio, archivo));
            }
            directorio.delete();
        } else {
            directorio.delete();
        }
    }

    public static void deleteDirContent(File directorio) {
        File[] archivos = directorio.listFiles();
        File aux;

        for (File archivo : archivos) {
            aux = archivo;
            if (aux.isDirectory()) {
                aux.delete();
            }
        }
    }

    public static boolean moveFile(File origen, File destino) {
        try {
            OutputStream out;
            try (InputStream in = new FileInputStream(origen)) {
                out = new FileOutputStream(destino);
                byte[] buffer = new byte[1024];
                int lenght;
                while ((lenght = in.read(buffer)) > 0) {
                    out.write(buffer, 0, lenght);
                }
            }
            out.close();
            origen.delete();

            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
