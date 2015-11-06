package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Agárimo
 */
public class Regex {

    private Pattern pt;
    private Matcher mt;

    private String[] patrones;

    public Regex() {
    }

    public boolean isBuscar(String patron, String str) {
        pt = Pattern.compile(patron);
        mt = pt.matcher(str);

        return mt.find();
    }

    public String buscar(String patron, String str) {
        String aux;
        pt = Pattern.compile(patron);
        mt = pt.matcher(str);

        if (mt.find()) {
            aux = mt.group();
        } else {
            aux = null;
        }
        return aux;
    }

    public String buscar(String str, String[] patrones) {
        this.patrones = patrones;
        String found = null;

        for (String aux : patrones) {
            pt = Pattern.compile(aux);
            mt = pt.matcher(str);

            if (mt.find()) {
                aux = mt.group().trim();
            }
        }
        return found;
    }
}
