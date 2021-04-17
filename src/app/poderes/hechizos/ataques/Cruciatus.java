package app.poderes.hechizos.ataques;

public class Cruciatus extends HechizoAtaque {
    
    // CONSTRUCTOR
    
    public Cruciatus(String nombre, boolean esOscuro, int nivelDanio, int nivelCuracion, int energiaMagica){
        super();
        this.setNombre(nombre);
        this.setEsOscuro(esOscuro);
        this.setNivelDanio(nivelDanio);
        this.setNivelCuracion(nivelCuracion);
        this.setEnergiaMagica(energiaMagica);
    }

}