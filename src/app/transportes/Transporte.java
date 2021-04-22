package app.transportes;

public abstract class Transporte {
    
    // ATRIBUTOS

    private String nombre;
    private String descripcion;

    // GETTERS Y SETTERS
    
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
}
