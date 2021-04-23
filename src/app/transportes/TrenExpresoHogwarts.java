package app.transportes;

import app.interfaces.IEsMagico;

public class TrenExpresoHogwarts extends Transporte implements IEsMagico {

    // CONSTRUCTOR
    
    public TrenExpresoHogwarts(String nombre, String descripcion) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
    }

    // METODOS

    @Override
    public boolean esInvisibleAMuggles() {
        return true;
    }

    @Override
    public boolean esInvisible() {
        return false;
    }
    
}