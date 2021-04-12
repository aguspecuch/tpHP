package app.artefactos;

import app.interfaces.IReliquiaMuerte;

public class VaritaSauco extends Varita implements IReliquiaMuerte {

    public VaritaSauco(String nombre, double amplificadorDeDanio, double amplificadorDeCuracion, Poder poder){
        super(nombre, amplificadorDeDanio, amplificadorDeCuracion, poder);
    }

    @Override
    public boolean esReliquiaMuerte() {
        return true;
    }
    
}
