package app.poderes.hechizos.defensas;

public class Expelliarmus extends HechizoDefensa {
    
    // CONSTRUCTOR
    
    public Expelliarmus(String nombre, boolean esOscuro, int nivelDanio, int nivelCuracion, int energiaMagica){
        this.setNombre(nombre);
        this.setEsOscuro(esOscuro);
        this.setNivelDanio(nivelDanio);
        this.setNivelCuracion(nivelCuracion);
        this.setEnergiaMagica(energiaMagica);
    }

}