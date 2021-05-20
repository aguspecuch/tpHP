package app.poderes.hechizos.ataques;

public class AvadaKedavra extends HechizoAtaque {
    
    // CONSTRUCTOR
    
    public AvadaKedavra(String nombre, boolean esOscuro, int nivelDanio, int nivelCuracion, int energiaMagica){
        super();
        this.setNombre(nombre);
        this.setEsOscuro(esOscuro);
        this.setNivelDanio(nivelDanio);
        this.setNivelCuracion(nivelCuracion);
        this.setEnergiaMagica(energiaMagica);
    }

}