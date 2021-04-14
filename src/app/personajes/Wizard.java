package app.personajes;

import app.artefactos.Artefacto;
import app.interfaces.*;
import app.poderes.Poder;
import app.poderes.hechizos.Hechizo;
import app.transportes.Escoba;

import java.util.ArrayList;
import java.util.List;

abstract class Wizard extends Persona implements IHaceMagia {

    private int energiaMagica;
    private Artefacto artefacto;
    private Escoba escoba;
    private Poder poderInicial;
    private boolean magoOscuro;
    private List<Hechizo> hechizos = new ArrayList<>();
            
    public int getEnergiaMagica() {
        return this.energiaMagica;
    }
        
    public void setEnergiaMagica(int energiaMagica) {
        this.energiaMagica = energiaMagica; 
    }   
    
    public Artefacto getArtefacto() {
        return this.artefacto;
    }
        
    public void setArtefacto(Artefacto artefacto) {
        this.artefacto = artefacto; 
    } 
   
    public Escoba getEscoba() {
        return this.escoba;
    }
        
    public void setEscoba(Escoba escoba) {
        this.escoba = escoba;
    } 

    public Poder getPoderInicial() {
        return this.poderInicial;
    }
        
    public void setPoderInicial(Poder poderInicial) {
        this.poderInicial = poderInicial;
    } 

    public boolean getMagoOscuro() {
        return this.magoOscuro;
    }

    public void setMagoOscuro(boolean magoOscuro) {
        this.magoOscuro = magoOscuro;
    }

    public List<Hechizo> getHechizos() {
        return this.hechizos;
    }
    
    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }
}   

