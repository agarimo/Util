package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

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
        Date fecha = formatFecha(imprimeFecha(cal.getTime()),"yyyy-MM-dd");
        
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
     * Devuelve la diferencia entre 2 fechas en milisegundos
     *
     * @param fechaMayor
     * @param fechaMenor
     * @return
     */
    public static long diferenciaFechas(Date fechaMayor, Date fechaMenor) {
        long diferencia = fechaMayor.getTime() - fechaMenor.getTime();
        return diferencia;
    }

    public static String imprimeTiempo(long milisegundos) {
        String h, m, s;
        long hora, minuto, segundo;
        long restohora, restominuto, restosegundo;

        hora = milisegundos / 3600000;
        restohora = milisegundos % 3600000;

        minuto = restohora / 60000;
        restominuto = restohora % 60000;

        segundo = restominuto / 1000;
        restosegundo = restominuto % 1000;

        if (hora < 10) {
            h = "0" + hora;
        } else {
            h = hora + "";
        }

        if (minuto < 10) {
            m = "0" + minuto;
        } else {
            m = minuto + "";
        }

        if (segundo < 10) {
            s = "0" + segundo;
        } else {
            s = segundo + "";
        }

        return h + " : " + m + " : " + s + "." + restosegundo;
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
        }
        return aux;
    }
    
    /**
     * Método que convierte una fecha a String con el formato pasado como variable
     *
     * @param cal Fecha a convertir
     * @param formato Formato a aplicar
     * @return Devuelve la fecha en String
     */
    public static String imprimeFecha(Date cal, String formato){
        if (cal == null) {
            return null;
        } else {
            String date;
            SimpleDateFormat format = new SimpleDateFormat(formato);
            date = format.format(cal);
            return date;
        }
    }

    /**
     * Método que convierte una fecha a String con el siguiente formato:
     * yyyy-MM-dd
     *
     * @param cal Fecha a convertir
     * @return Devuelve la fecha en String
     */
    public static String imprimeFecha(Date cal) {

        if (cal == null) {
            return null;
        } else {
            String date;
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            date = formato.format(cal);
            return date;
        }
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

    public static Date asDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static LocalDate asLocalDate(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalDateTime asLocalDateTime(Date date) {
        return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
