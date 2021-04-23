package app.personajes;

import app.interfaces.IEsMagico;

public abstract class Criatura extends Personaje implements IEsMagico {

    // CONSTRUCTOR

    public Criatura(String nombre, int edad) {
        super(nombre, edad);
    }

}

