package app.personajes;

import app.artefactos.Artefacto;

public class Elfo extends Criatura {
    
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

