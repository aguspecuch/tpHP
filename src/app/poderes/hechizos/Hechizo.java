package app.poderes.hechizos;

import app.poderes.*;

public abstract class Hechizo extends Poder {
    
    private boolean esOscuro;
    private int nivelDanio;
    private int nivelCuracion;
    private int energiaMagica;

    public void setEsOscuro(boolean esOscuro){
        this.esOscuro = esOscuro;
    }

    public boolean getEsOscuro(){
        return this.esOscuro;
    }

    public void nivelDanio(int nivelDanio){
        this.nivelDanio = nivelDanio;
    }

    public int getNivelDanio(){
        return this.nivelDanio;
    }

    public void setNivelCuracion(int nivelCuracion){
        this.nivelCuracion = nivelCuracion;
    }

    public int getNivelDuracion(){
        return this.nivelCuracion;
    }
}
