package app.personajes;

 public abstract class Personaje {

    private String nombre;
    private int salud;
    private int edad;
        
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }   

    public int getSalud() {
        return this.salud;
    }
    
    public void setSalud(int salud) {
        this.salud = salud; 
    } 

    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad; 
    }   
 

}
