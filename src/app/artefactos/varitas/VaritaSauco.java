package app.artefactos.varitas;

import app.interfaces.IReliquiaMuerte;

public class VaritaSauco extends Varita implements IReliquiaMuerte {

    @Override
    public boolean esReliquiaMuerte() {
        return true;
    }

}