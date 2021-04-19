package app.personajes;

import java.util.*;
import app.poderes.Poder;

public class Dementor extends Criatura {

    // CONSTUCTOR

    public Dementor (String nombre, int salud, int energiaMagica, Poder poderInicial) {
        this.setNombre(nombre);
        this.setSalud(salud); // Le asigno directamente el máximo.
        this.energiaMagica = energiaMagica; // Le asigno directamente el máximo.
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

    // METODO DE LAS INTERFASES

    @Override
    public boolean esInvisibleAMuggles() {
        return true;
    }

    @Override
    public boolean esInvisible() {
        return false;
    }

   
}
