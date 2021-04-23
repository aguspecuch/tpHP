package app.personajes;

import app.poderes.Poder;

public class Dementor extends Criatura {

    // CONSTUCTOR

    public Dementor(String nombre, int edad, Poder poderInicial) {
        super(nombre, edad);
        this.setEnergiaMagica(150);
        this.poderInicial = poderInicial;
    }

    // ATRIBUTOS

    private int energiaMagica;
    private Poder poderInicial;

    // GETTERS Y SETTERS

    public int getEnergiaMagica() {
        return this.energiaMagica;
    }

    public void setEnergiaMagica(int energiaMagica) {
        this.energiaMagica = energiaMagica;
    }

    public Poder getPoderInicial() {
        return this.poderInicial;
    }

    public void setPoderInicial(Poder poderInicial) {
        this.poderInicial = poderInicial;
    }

    // METODO

    @Override
    public boolean esInvisibleAMuggles() {
        return true;
    }

    @Override
    public boolean esInvisible() {
        return false;
    }

}
