package app.poderes.hechizos.ataques;

public class SectumSempra extends HechizoAtaque {
    
    // CONSTRUCTOR
    
    public SectumSempra(String nombre, boolean esOscuro, int nivelDanio, int nivelCuracion, int energiaMagica){
        this.setNombre(nombre);
        this.setEsOscuro(esOscuro);
        this.setNivelDanio(nivelDanio);
        this.setNivelCuracion(nivelCuracion);
        this.setEnergiaMagica(energiaMagica);
    }

}