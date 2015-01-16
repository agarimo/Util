
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Agárimo
 */
public class Dates {

    /**
     * Método que devuelve la fecha actual del sistema
     *
     * @return Date con la fecha actual del sistema
     */
    public static Date curdate() {
        Calendar cal = Calendar.getInstance();
        Date fecha = cal.getTime();
        return fecha;
    }

    /**
     * Calcula la fecha que será al sumarle los días pasados como parámetros a
     * la fecha pasada como parámetro
     *
     * @param fecha Fecha a sumar
     * @param dias Dias a sumar
     * @return Date con la fecha calculada
     */
    public static Date sumaDiasFecha(Date fecha, int dias) {
        Calendar aux = Calendar.getInstance();
        aux.setTime(fecha);
        aux.add(Calendar.DATE, dias);

        return aux.getTime();
    }

    /**
     * Devuelve un Date a partir de un String y un formato
     *
     * @param fecha String con la fecha
     * @param formato Formato a aplicar a la fecha
     * @return Date con la fecha, devuelve null si da un error.
     */
    public static Date formatFecha(String fecha, String formato) {
        SimpleDateFormat sf = new SimpleDateFormat(formato);
        Date aux;
        try {
            aux = sf.parse(fecha);
        } catch (ParseException ex) {
            aux = null;
            Logger.getLogger(Dates.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }

    /**
     * Método que convierte una fecha a String con el siguiente formato:
     * yyyy-MM-dd
     *
     * @param cal Fecha a convertir
     * @return Devuelve la fecha en String
     */
    public static String imprimeFecha(Date cal) {
        String date;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        date = formato.format(cal);

        return date;
    }

    /**
     * Método que convierte una fecha a String con el siguiente formato:
     * yyyy-MM-dd HH:mm:ss
     *
     * @param cal Fecha a convertir
     * @return Devuelve la fecha en String
     */
    public static String imprimeFechaCompleta(Date cal) {
        String date;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = formato.format(cal);

        return date;
    }

    /**
     * Método que convierte una fecha a String con el siguiente formato:
     * yyyyMMdd
     *
     * @param cal Fecha a convertir
     * @return Devuelve la fecha en String
     */
    public static String imprimeFechaSinFormato(Date cal) {
        String date;
        SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
        date = formato.format(cal);

        return date;
    }

    /**
     * Método que convierte una fecha a String con el siguiente formato: dd.MM.
     *
     * @param cal Fecha a convertir
     * @return Devuelve la fecha en String
     */
    public static String imprimeFechaBoletin(Date cal) {
        String date;
        SimpleDateFormat formato = new SimpleDateFormat("dd.MM.");
        date = formato.format(cal);

        return date;
    }

    /**
     * Método que convierte una fecha a String con el siguiente formato:
     * HH:mm:ss
     *
     * @param cal Fecha a convertir
     * @return Devuelve la fecha en String
     */
    public static String imprimeHora(Date cal) {
        String date;
        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
        date = formato.format(cal);

        return date;
    }

    /**
     * Método que convierte una fecha a String con el siguiente formato: HHmmss
     *
     * @param cal Fecha a convertir
     * @return Devuelve la fecha en String
     */
    public static String imprimeHoraSinFormato(Date cal) {
        String date;
        SimpleDateFormat formato = new SimpleDateFormat("HHmmss");
        date = formato.format(cal);

        return date;
    }
}
