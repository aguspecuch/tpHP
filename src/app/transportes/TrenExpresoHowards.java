package app.transportes;

import app.interfaces.IEsMagico;

public class TrenExpresoHowards extends Transporte implements IEsMagico {

    @Override
    public boolean esInvisibleAMuggles() {
        return true;
    }

    @Override
    public boolean esInvisible() {
        return false;
    }
    
}