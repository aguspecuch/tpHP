package app.transportes;

import app.interfaces.IEsMagico;

public class TrenExpresoHowards extends Transporte implements IEsMagico {

    // CONSTRUCTOR
    
    public TrenExpresoHowards(String nombre, String descripcion) {
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
    }

    // METODOS DE LAS INTERFACES

    @Override
    public boolean esInvisibleAMuggles() {
        return true;
    }

    @Override
    public boolean esInvisible() {
        return false;
    }
    
}