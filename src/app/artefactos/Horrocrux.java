package app.artefactos;

import app.interfaces.*;

public class Horrocrux extends Artefacto implements IReliquiaMuerte {

    // CONSTRUCTOR
    
    public Horrocrux(String nombre, int amplificadorDeDanio, int amplificadorDeCuracion) {
        this.setNombre(nombre);
        this.setAmplificadorDeDanio(amplificadorDeDanio);
        this.setAmplificadorDeCuracion(amplificadorDeCuracion);
    }

    // METODOS DE LAS INTERFACES

    @Override
    public boolean esReliquiaMuerte() {
        return false;
    }

    @Override
    public boolean esInvisibleAMuggles() {
        return false;
    }

    @Override
    public boolean esInvisible() {
        return false;
    }

}
