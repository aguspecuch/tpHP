package app.artefactos;

public class EspadaGryffindor extends Artefacto {

    // CONSTRUCTOR

    public EspadaGryffindor(String nombre, double amplificadorDeDanio, double amplificadorDeCuracion) {
        this.setNombre(nombre);
        this.setAmplificadorDeDanio(amplificadorDeDanio);
        this.setAmplificadorDeCuracion(amplificadorDeCuracion);
    }

    // METODOS DE LAS INTERFACES

    @Override
    public boolean esInvisibleAMuggles() {
        return false;
    }

    @Override
    public boolean esInvisible() {
        return false;
    }

}