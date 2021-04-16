package app.artefactos;

import app.interfaces.*;

public class PiedraResurreccion extends Artefacto implements IReliquiaMuerte {

    // CONSTRUCTOR
    
    public PiedraResurreccion(String nombre, double amplificadorDeDanio, double amplificadorDeCuracion) {
        this.setNombre(nombre);
        this.setAmplificadorDeDanio(amplificadorDeDanio);
        this.setAmplificadorDeCuracion(amplificadorDeCuracion);
    }

    // METODOS DE LAS INTERFACES

    @Override
    public boolean esReliquiaMuerte() {
        return true;
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
