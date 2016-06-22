/*
 * The MIT License
 *
 * Copyright 2016 Agárimo.
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

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Agárimo
 */
public class ModeloTarea implements Serializable {

    SimpleIntegerProperty id = new SimpleIntegerProperty();
    SimpleStringProperty fechaInicio = new SimpleStringProperty();
    SimpleStringProperty propietario = new SimpleStringProperty();
    SimpleStringProperty tipoTarea = new SimpleStringProperty();
    SimpleStringProperty titulo = new SimpleStringProperty();
    SimpleStringProperty porcentaje = new SimpleStringProperty();
    SimpleStringProperty progreso = new SimpleStringProperty();
    
    private String parametros;
    private ServerTask tipo;

    public int getId() {
        return id.getValue();
    }

    public void setId(int id) {
        this.id.setValue(id);
    }

    public String getFechaInicio() {
        return fechaInicio.getValue();
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio.setValue(fechaInicio.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }

    public String getPropietario() {
        return propietario.getValue();
    }

    public void setPropietario(String propietario) {
        this.propietario.setValue(propietario);
    }

    public String getTipoTarea() {
        return tipoTarea.getValue();
    }

    public ServerTask getTipo() {
        return this.tipo;
    }

    public void setTipoTarea(ServerTask tipoTarea) {
        this.tipo = tipoTarea;
        this.tipoTarea.setValue(tipoTarea.toString());
    }

    public String getPorcentaje() {
        return porcentaje.getValue();
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje.setValue(porcentaje);
    }

    public String getProgreso() {
        return progreso.getValue();
    }

    public void setProgreso(String progreso) {
        this.progreso.setValue(progreso);
    }

    public String getTitulo() {
        return titulo.getValue();
    }

    public void setTitulo(String titulo) {
        this.titulo.setValue(titulo);
    }
    
    public String getParametros() {
        return this.parametros;
    }

    public void setParametros(String parametros) {
        this.parametros=parametros;
    }

    @Override
    public String toString() {
        return "ModeloTarea{" + "fechaInicio=" + fechaInicio + ", propietario=" + propietario + ", tipoTarea=" + tipoTarea + ", titulo=" + titulo + ", porcentaje=" + porcentaje + ", progreso=" + progreso + ", tipo=" + tipo + '}';
    }
}
