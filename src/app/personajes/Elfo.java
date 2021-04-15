package app.personajes;

import java.util.*;
import app.artefactos.Artefacto;
import app.interfaces.*;
import app.poderes.hechizos.Hechizo;

abstract class Elfo extends Criatura implements IHaceMagia {
    
    private int energiaMagica;
    private Artefacto artefacto;
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

    public List<Hechizo> getHechizos() {
        return this.hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }
}

