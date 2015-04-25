package util;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.LineIterator;

/**
 *
 * @author Agárimo
 */
public class Files {

    private static int total = 0;

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

    public static boolean moverArchivo(File origen, File destino) {
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

    public static void splitArchivo(File archivo, File destino, int lineas, String stn) throws FileNotFoundException {
        File archivoDestino;
        int contador = 1;
        int contadorArchivos = 1;
        String nombre = archivo.getName().substring(0, archivo.getName().lastIndexOf("."));
        String ln;
        BufferedReader in;
        BufferedWriter out;

        File fl;
        fl = new File(destino, nombre);
        fl.mkdirs();
        archivoDestino = new File(fl, nombre + "-" + contadorArchivos + "." + stn);

        try {
            in = new BufferedReader(new FileReader(archivo));
            out = new BufferedWriter(new FileWriter(archivoDestino));

            while ((ln = in.readLine()) != null) {
                System.out.println("Contador "+contador +" de archivo "+contadorArchivos);
                System.out.println("Lee : "+ln);
                out.append(ln);
                out.newLine();
                contador++;

                if (contador > lineas) {
                    contadorArchivos++;
                    archivoDestino = new File(fl, nombre + "-" + contadorArchivos + "." + stn);
                    contador = 1;
                }
            }
            in.close();
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     /**
     * Split file.
     *
     * @param inputFile
     * @param outputFolder
     * @param linesPerFile
     * @param stn
     * @throws IOException
     */
    public static void splitFile(File inputFile, File outputFolder, int linesPerFile, String stn) throws IOException {
        String filename = inputFile.getName().substring(0, inputFile.getName().lastIndexOf("."));

        int fileCounter = 0;
        int counter = 1;
        List<String> newLines = new ArrayList<>();

        LineIterator it = FileUtils.lineIterator(inputFile);
        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                newLines.add(line);
                counter++;
                if (counter == linesPerFile
                        || (counter < linesPerFile && !it.hasNext())) {
                    outputFolder.mkdirs();

                    String newFileLocation = filename + "-" + (++fileCounter) + "." + stn;
                    File outputFile = new File(outputFolder,newFileLocation);
                    FileUtils.writeLines(outputFile, newLines);

                    newLines.clear();
                    counter = 1;
                }
            }
        } finally {
            LineIterator.closeQuietly(it);
        }
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
            for (String archivo : archivos) {
                copiaDirectorio(new File(origen, archivo), new File(destino, archivo));
            }
        } else {
            copiaArchivo(origen, destino);
        }
    }

    public static void borraDirectorio(File directorio) {
        if (directorio.isDirectory()) {
            String[] archivos = directorio.list();
            for (String archivo : archivos) {
                borraDirectorio(new File(directorio, archivo));
            }
            directorio.delete();
        } else {
            directorio.delete();
        }
    }

    public static void borraDirectorioVacio(File directorio) {
        File[] archivos = directorio.listFiles();
        File aux;

        for (File archivo : archivos) {
            aux = archivo;
            if (aux.isDirectory()) {
                aux.delete();
            }
        }
    }

    public static void moverDirectorio(File origen, File destino) {
        copiaDirectorio(origen, destino);
        borraDirectorio(origen);
    }

    public static int cuentaLineasArchivo(File archivo) {
        FileReader fr = null;
        int tt = 0;
        try {
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                tt++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Files.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tt;
    }

    public static int contarLineasDirectorio(File aux) {
        total = 0;
        contar(aux);
        return total;
    }

    private static void contar(File aux) {
        File[] ficheros = aux.listFiles();

        for (File fichero : ficheros) {
            if (fichero.isDirectory()) {
                contarLineasDirectorio(fichero);
            } else {
                total += cuentaLineasArchivo(fichero);
            }
        }
    }
}
