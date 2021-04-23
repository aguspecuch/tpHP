package app.personajes;

public abstract class Personaje {

    // CONSTRUCTOR

    public Personaje(String nombre, int edad) {
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setSalud(100);
        this.setEdad(edad);
    }

    // ATRIBUTOS

    private String nombre;
    private int salud;
    private int edad;

    // GETTERS Y SETTERS

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

    // METODOS

    public boolean estaVivo() {
        if (this.salud > 0) {
            return true;
        }
        return false;
    }

}
