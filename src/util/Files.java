package util;


import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agárimo
 */
public class Files {

    private static int totalLineas = 0;

    public static void abrirArchivo(File archivo) {
        if (archivo.exists()) {
            try {
                Desktop.getDesktop().open(archivo);
            } catch (IOException ex) {
                Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static boolean copiaArchivo(File origen, File destino) {
        try {
            InputStream in = new FileInputStream(origen);
            OutputStream out = new FileOutputStream(destino);

            byte[] buffer = new byte[1024];
            int lenght;

            while ((lenght = in.read(buffer)) > 0) {
                out.write(buffer, 0, lenght);
            }

            in.close();
            out.close();

            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static void escribeArchivo(File archivo, String datos) {
        FileWriter fw = null;
        PrintWriter pw;

        try {
            fw = new FileWriter(archivo);
            pw = new PrintWriter(fw);

            pw.print(datos);
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (null != fw) {
                    fw.close();
                }
            } catch (Exception ex) {
                Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void anexaArchivo(File archivo, String datos) {
        BufferedWriter out;

        try {
            out = new BufferedWriter(new FileWriter(archivo, true));
            out.append(datos);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String leeArchivo(File archivo) {
        String datos = "";
        FileReader fr = null;
        BufferedReader br;
        try {
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {
                datos = datos + linea + System.getProperty("line.separator");
            }
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception ex) {
                Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return datos;
    }

    public static int cuentaLineasArchivo(File archivo) {
        FileReader fr = null;
        int total = 0;
        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                total++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return total;
    }

    public static void creaDirectorio(File directorio) {
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
    }

    private static void copiaDirectorio(File origen, File destino) {
        if (origen.isDirectory()) {
            if (!destino.exists()) {
                destino.mkdir();
            }
            String[] archivos = origen.list();
            for (int i = 0; i < archivos.length; i++) {
                copiaDirectorio(new File(origen, archivos[i]), new File(destino, archivos[i]));
            }
        } else {
            copiaArchivo(origen, destino);
        }
    }

    public static void borraDirectorio(File directorio) {
        if (directorio.isDirectory()) {
            String[] archivos = directorio.list();
            for (int i = 0; i < archivos.length; i++) {
                borraDirectorio(new File(directorio, archivos[i]));
            }
            directorio.delete();
        } else {
            directorio.delete();
        }
    }

    public static void borraDirectorioVacio(File directorio) {
        File[] archivos = directorio.listFiles();
        File aux;

        for (int i = 0; i < archivos.length; i++) {
            aux = archivos[i];

            if (aux.isDirectory()) {
                aux.delete();
            }
        }
    }

    public static void moverDirectorio(File origen, File destino) {
        copiaDirectorio(origen, destino);
        borraDirectorio(origen);
    }

    public static int contarLineasDirectorio(File aux) {
        totalLineas = 0;
        contar(aux);
        return totalLineas;
    }

    private static void contar(File aux) {
        File[] ficheros = aux.listFiles();

        for (int i = 0; i < ficheros.length; i++) {
            if (ficheros[i].isDirectory()) {
                contarLineasDirectorio(ficheros[i]);
            } else {
                totalLineas += cuentaLineasArchivo(ficheros[i]);
            }
        }
    }
}
