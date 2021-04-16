package app.poderes.hechizos.defensas;

public class CaveInimicum extends HechizoDefensa {
    
    public CaveInimicum(String nombre, boolean esOscuro, int nivelDanio, int nivelCuracion, int energiaMagica){
        this.setNombre(nombre);
        this.setEsOscuro(esOscuro);
        this.setNivelDanio(nivelDanio);
        this.setNivelCuracion(nivelCuracion);
        this.setEnergiaMagica(energiaMagica);
    }
    
}
