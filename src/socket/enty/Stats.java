/*
 * The MIT License
 *
 * Copyright 2016 agari.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package socket.enty;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import sql.Conexion;
import sql.Sql;
import tools.Util;

/**
 *
 * @author Agárimo
 */
public class Stats {

    private int id;
    private ServerTask tarea;
    private String propietario;
    private LocalDate fecha;
    private LocalTime horaInit;
    private LocalTime horaFin;

    public Stats(ServerTask tarea, String propietario) {
        this.tarea = tarea;
        this.propietario = propietario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ServerTask getTarea() {
        return tarea;
    }

    public void setTarea(ServerTask tarea) {
        this.tarea = tarea;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInit() {
        return horaInit;
    }

    public void setHoraInit(LocalTime horaInit) {
        this.horaInit = horaInit;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    private String initQuery() {
        return "INSERT into server.stats (tarea,propietario,fecha,hora_inicio) values("
                + Util.comillas(this.tarea.toString()) + ","
                + Util.comillas(this.propietario) + ","
                + Util.comillas(this.fecha.format(DateTimeFormatter.ISO_LOCAL_DATE)) + ","
                + Util.comillas(this.horaInit.format(DateTimeFormatter.ISO_TIME))
                + ");";
    }

    private String endQuery() {
        return "UPDATE server.stats SET "
                + "hora_fin=" + Util.comillas(this.horaFin.format(DateTimeFormatter.ISO_TIME)) + " "
                + "WHERE id=" + this.id;
    }

    public boolean init(Sql bd) {
        try {
            this.fecha = LocalDate.now();
            this.horaInit = LocalTime.now();
            bd.ejecutar(initQuery());
            this.id = bd.ultimoRegistro();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Stats.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean end(Sql bd) {
        try {
            this.horaFin = LocalTime.now();
            bd.ejecutar(endQuery());
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Stats.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
}
