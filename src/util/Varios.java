package util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agárimo
 */
public class Varios {

    /**
     * Método que abre la URI indicada en el navegador por defecto del sistema.
     *
     * @param uri URI a abrir
     */
    public static void abrirWeb(URI uri) {
        try {
            Desktop.getDesktop().browse(uri);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que entrecomilla con comillas simples el String pasado como
     * parámetro
     *
     * @param contenido String a entrecomillar
     * @return Devuelve un String con el contenido entrecomillado
     */
    public static String entrecomillar(String contenido) {
        return "'" + contenido + "'";
    }

    public static String comillas(String contenido) {
        if (contenido != null) {
            return "'" + contenido.replace("'", "\\'") + "'";
        } else {
            return "''";
        }
    }

    /**
     * Método que calcula el progreso, en tanto por ciento, de una tarea.
     *
     * @param pos Cantidad efectuada de la tarea
     * @param total Total de la cantidad de la tarea
     * @return Devuelve un int con el tanto por ciento del progreso
     */
    public static int calculaProgreso(int pos, int total) {
        int aux;
        aux = (pos * 100) / total;
        return aux;
    }

    /**
     * Método que calcula un porcentaje pasado como parámetro sobre una cantidad
     * pasada como parámetro y se lo suma
     *
     * @param cantidad Cantidad a calcular el porcentaje
     * @param porcentaje Porcentaje a calcular
     * @return Devuelve un double con el porcentaje sumado a la cantidad.
     */
    public static double calculaPorcentaje(double cantidad, int porcentaje) {
        double aux = (cantidad * porcentaje) / 100;
        aux = aux + cantidad;
        return aux;
    }

    /**
     * Método que descarga un archivo Web en la ruta indicada
     *
     * @param ruta Ruta web para la descarga del archivo
     * @param destino Ruta local dónde se descargará el archivo
     */
    public static void descargaArchivo(URL ruta, File destino) {
        try {
            URLConnection conn;
            conn = ruta.openConnection();
            conn.connect();
            try (InputStream in = conn.getInputStream(); OutputStream out = new FileOutputStream(destino)) {
                int b = 0;

                while (b != -1) {
                    b = in.read();

                    if (b != -1) {
                        out.write(b);
                    }
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(Varios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Varios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
