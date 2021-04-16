package app.poderes.hechizos.curaciones;

public class VulneraSanentur extends HechizoCuracion {
    
    public VulneraSanentur(String nombre, boolean esOscuro, int nivelDanio, int nivelCuracion, int energiaMagica){
        this.setNombre(nombre);
        this.setEsOscuro(esOscuro);
        this.setNivelDanio(nivelDanio);
        this.setNivelCuracion(nivelCuracion);
        this.setEnergiaMagica(energiaMagica);
    }
    
}
