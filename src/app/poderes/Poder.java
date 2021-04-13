package app.poderes;

import java.util.ArrayList;
import java.util.List;

public abstract class Poder {

    private String nombre;
    private String descripcion;
    private String tipoDeHabilidad;

    public List<Poder> Poderes = new ArrayList<>(); // Creo la clase poder no tendria que tener una lista de poderes
                                                    // sino mejor la clase Perosnaje.

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
