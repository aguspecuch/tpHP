package app.poderes;

import java.util.ArrayList;
import java.util.List;

public abstract class Poder {

    private String nombre;
    private String descripcion;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }                   
                                    
    public String getNombre() {
        return this.nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }

}
