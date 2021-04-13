package app.poderes;
public class Poder {

    private String nombre;
    private String descripcion;
    private String tipoDeHabilidad;
    
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion(){
        return this.descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getTipoDeHabilidad(){
        return this.tipoDeHabilidad;
    }

    public void setTipoDeHabilidad(String tipoDeHabilidad){
        this.tipoDeHabilidad = tipoDeHabilidad;
    }

}

