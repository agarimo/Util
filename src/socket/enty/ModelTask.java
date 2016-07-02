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

/**
 *
 * @author Agárimo
 */
public class ModelTask implements Serializable {

    private int id;
    private String fechaInicio;
    private String propietario;
    private String tipoTarea;
    private String titulo;
    private String porcentaje;
    private String progreso;
    private String parametros;
    private ServerTask tipo;
    
    public ModelTask(ModeloTarea model){
        this.id=model.id.getValue();
        this.fechaInicio=model.fechaInicio.getValue();
        this.propietario=model.propietario.getValue();
        this.tipoTarea=model.tipoTarea.getValue();
        this.titulo=model.titulo.getValue();
        this.porcentaje=model.porcentaje.getValue();
        this.progreso=model.progreso.getValue();
        this.parametros=model.getParametros();
        this.tipo=model.getTipo();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getTipoTarea() {
        return tipoTarea;
    }

    public void setTipoTarea(String tipoTarea) {
        this.tipoTarea = tipoTarea;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getProgreso() {
        return progreso;
    }

    public void setProgreso(String progreso) {
        this.progreso = progreso;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

    public ServerTask getTipo() {
        return tipo;
    }

    public void setTipo(ServerTask tipo) {
        this.tipo = tipo;
    }
    
    public ModeloTarea toModeloTarea(){
        ModeloTarea model = new ModeloTarea();
        model.id.setValue(this.id);
        model.fechaInicio.setValue(this.fechaInicio);
        model.propietario.setValue(this.propietario);
        model.tipoTarea.setValue(this.tipoTarea);
        model.titulo.setValue(this.titulo);
        model.porcentaje.setValue(this.porcentaje);
        model.progreso.setValue(this.progreso);
        model.setParametros(this.parametros);
        model.setTipoTarea(this.tipo);
        
        return model;
        
    }
}
