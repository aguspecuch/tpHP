package app.artefactos;

import app.interfaces.IReliquiaMuerte;

public class Horrocrux extends Artefacto implements IReliquiaMuerte {

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
