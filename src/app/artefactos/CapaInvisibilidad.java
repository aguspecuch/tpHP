package app.artefactos;

import app.interfaces.*;

public class CapaInvisibilidad extends Artefacto implements IReliquiaMuerte {

    // CONSTRUCTOR
    
    public CapaInvisibilidad(String nombre, double amplificadorDeDanio, double amplificadorDeCuracion) {
        this.setNombre(nombre);
        this.setAmplificadorDeDanio(amplificadorDeDanio);
        this.setAmplificadorDeCuracion(amplificadorDeCuracion);
    }

    // METODOS

    @Override
    public boolean esReliquiaMuerte() {
        return true;
    }

    @Override
    public boolean esInvisibleAMuggles() {
        return true;
    }

    @Override
    public boolean esInvisible() {
        return true;
    }

}
