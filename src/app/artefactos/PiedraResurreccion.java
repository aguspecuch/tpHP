package app.artefactos;

import app.interfaces.IReliquiaMuerte;

public class PiedraResurreccion extends Artefacto implements IReliquiaMuerte {

    public PiedraResurreccion(String nombre, double amplificadorDeDanio, double amplificadorDeCuracion, Poder poder) {
        super(nombre, amplificadorDeDanio, amplificadorDeCuracion, poder);
    }

    @Override
    public boolean esReliquiaMuerte() {
        return true;
    }

}
