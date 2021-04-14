package app.personajes;

import app.artefactos.Artefacto;
import app.interfaces.*;

public class Elfo extends Criatura implements IHaceMagia {
    
    private int energiaMagica;
    private Artefacto artefacto;

        
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

    
}

