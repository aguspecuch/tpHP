package app.artefactos;

import app.interfaces.IReliquiaMuerte;

public class Horrocrux extends Artefacto implements IReliquiaMuerte {

    public Horrocrux(String nombre, double amplificadorDeDanio, double amplificadorDeCuracion, Poder poder) {
        super(nombre, amplificadorDeDanio, amplificadorDeCuracion, poder);
    }

    @Override
    public boolean esReliquiaMuerte() {
        return false;
    }

}
