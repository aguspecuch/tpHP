package app.personajes;

<<<<<<< HEAD
import app.artefactos.Artefacto;

public class Elfo extends Criatura {
=======
import app.interfaces.IHaceMagia;

public class Elfo extends Criatura implements IHaceMagia {
>>>>>>> 95dcf147839d5b2008309b7fe2016884fdd563b3
    
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

