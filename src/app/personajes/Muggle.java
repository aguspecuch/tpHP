package app.personajes;

public class Muggle extends Persona {

    // CONSTRUCTOR

    public Muggle(String nombre){
        this.setNombre(nombre);
        this.setSalud(100); // Le fijo el maximo.
    }
}
