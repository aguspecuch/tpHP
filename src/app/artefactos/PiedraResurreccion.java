package app.artefactos;

import app.interfaces.IReliquiaMuerte;

public class PiedraResurreccion extends Artefacto implements IReliquiaMuerte {

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
