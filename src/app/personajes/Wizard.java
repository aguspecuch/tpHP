package app.personajes;

import java.util.*;
import app.artefactos.*;
import app.interfaces.*;
import app.poderes.*;
import app.poderes.hechizos.*;
import app.poderes.hechizos.ataques.HechizoAtaque;
import app.transportes.*;

public class Wizard extends Persona implements IHaceMagia {

    // CONSTRUCTOR

    public Wizard(String nombre, Poder poderInicial, boolean magoOscuro) {
        this.setNombre(nombre);
        this.setSalud(100);
        this.energiaMagica = 150; // Le asigno directamente el máximo.
        this.poderInicial = poderInicial;
        this.magoOscuro = magoOscuro;
    }

    // ATRIBUTOS

    private int energiaMagica;
    private List<Hechizo> hechizos = new ArrayList<>();
    private Escoba escoba;
    private Poder poderInicial;
    private Artefacto artefacto;
    private boolean magoOscuro;
    private List<Poder> poderes = new ArrayList<>();

    // GETTERS Y SETTERS

    public int getEnergiaMagica() {
        return this.energiaMagica;
    }

    public void setEnergiaMagica(int energiaMagica) {
        this.energiaMagica = energiaMagica;
    }

    public List<Hechizo> getHechizos() {
        return this.hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    public Escoba getEscoba() {
        return this.escoba;
    }

    public void setEscoba(Escoba escoba) {
        this.escoba = escoba;
    }

    public void setArtefacto(Artefacto artefacto) {
        this.artefacto = artefacto;
    }

    public boolean getMagoOscuro() {
        return this.magoOscuro;
    }

    public void setMagoOscuro(boolean magoOscuro) {
        this.magoOscuro = magoOscuro;
    }

    public List<Poder> getPoderes() {
        return this.poderes;
    }

    public void setPoderes(List<Poder> poderes) {
        this.poderes = poderes;
    }

    // METODOS DE LAS INTERFACES

    @Override
    public void setPoder(Poder poder) {
        this.poderInicial = poder;
    }

    @Override
    public Poder getPoderInicial() {
        return poderInicial;
    }

    @Override
    public Artefacto getArtefacto() {
        return this.artefacto;
    }

    @Override
    public void aprender(Hechizo h) {
        for (Hechizo hechizo : hechizos) {
            if (!(h.equals(hechizo))) {
                this.hechizos.add(hechizo);
            }
        }
    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {
        System.out.println(this.getNombre() + " ataca a: " + personaje.getNombre());
    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) {
        int saludAtacante;
        int saludOponente;
        int energiaMagicaAtacante;
        if (this.estaVivo() == true && personaje.estaVivo() == true){
    
            if (hechizo instanceof HechizoAtaque && this.getMagoOscuro() == false && hechizo.getEsOscuro() == true) {
                this.setMagoOscuro(true);
                System.out.println("El mago ha utilizado un hechizo oscuro. Ahora es un mago oscuro.");
                int nivelDanio = hechizo.getNivelDanio()*2;
                hechizo.setNivelDanio(nivelDanio);
            }
        
            Artefacto artefactoElegido = this.getArtefacto();
            if (artefactoElegido instanceof CapaInvisibilidad) {
                int nivelDanio = hechizo.getNivelDanio() + 0;
                int nivelCuracion = hechizo.getNivelCuracion() + 50;
                hechizo.setNivelDanio(nivelDanio);
                hechizo.setNivelCuracion(nivelCuracion);
            } else if (artefactoElegido instanceof EspadaGryffindor) {
                int nivelDanio = hechizo.getNivelDanio() + 40;
                int nivelCuracion = hechizo.getNivelCuracion() + 0;
                hechizo.setNivelDanio(nivelDanio);
                hechizo.setNivelCuracion(nivelCuracion);
            } else if (artefactoElegido instanceof Horrocrux) {
                int nivelDanio = hechizo.getNivelDanio() + 80;
                int nivelCuracion = hechizo.getNivelCuracion() + 20;
                hechizo.setNivelDanio(nivelDanio);
                hechizo.setNivelCuracion(nivelCuracion);
            } else if (artefactoElegido instanceof PiedraResurreccion) {
                int nivelDanio = hechizo.getNivelDanio() + 0;
                int nivelCuracion = hechizo.getNivelCuracion() + 100;
                hechizo.setNivelDanio(nivelDanio);
                hechizo.setNivelCuracion(nivelCuracion);
            }

            saludOponente = personaje.getSalud() - hechizo.getNivelDanio();

            energiaMagicaAtacante = this.getEnergiaMagica() - hechizo.getEnergiaMagica();
            this.setEnergiaMagica(energiaMagicaAtacante);
            saludAtacante = this.getEnergiaMagica() + hechizo.getNivelCuracion();

            this.setSalud(saludAtacante);
            personaje.setSalud(saludOponente);
        } else {
            System.out.println("¡No tienes suficiente energia magica para atacar!");
        }
    }
}
