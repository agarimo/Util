package tools;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author Agárimo
 */
public class Util {

    public static void openWeb(String link) throws IOException, URISyntaxException {
        Desktop.getDesktop().browse(new URI(link));
    }

    public static void openFile(File file) throws IOException {
        Desktop.getDesktop().browse(file.toURI());
    }

    public static String comillas(String contenido) {
        if (contenido != null) {
            return "'" + contenido.replace("'", "\\'") + "'";
        } else {
            return "''";
        }
    }
}
