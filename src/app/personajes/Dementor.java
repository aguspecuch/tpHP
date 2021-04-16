package app.personajes;

import app.interfaces.*;

public class Dementor extends Criatura {

    @Override
    public boolean esInvisibleAMuggles() {
        return true;
    }

    @Override
    public boolean esInvisible() {
        return false;
    }

    
}
