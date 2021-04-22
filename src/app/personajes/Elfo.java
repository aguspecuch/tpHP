package app.personajes;

import java.util.*;
import app.artefactos.*;
import app.interfaces.*;
import app.poderes.Poder;
import app.poderes.hechizos.*;

public class Elfo extends Criatura implements IHaceMagia {
    
    // CONSTRUCTOR

    public Elfo(String nombre, int salud, int energiaMagica, Artefacto artefacto) {
        this.setNombre(nombre);
        this.setSalud(salud); // Le asigno directamente el máximo.
        this.energiaMagica = energiaMagica; // Le asigno directamente el máximo.
        this.artefacto = artefacto;
    }
    
    //ATRIBUTOS

    private int energiaMagica;
    private Artefacto artefacto;
    private List<Hechizo> hechizos = new ArrayList<>();

    //GETTERS Y SETTERS
        
    public int getEnergiaMagica() {
        return this.energiaMagica;
    }
    
    public void setEnergiaMagica(int energiaMagica) {
        this.energiaMagica = energiaMagica; 
    }   

    public Artefacto getArtefacto() {
        return this.artefacto;
    }
    
    public void setArtefacto(Artefacto artefacto) {
        this.artefacto = artefacto; 
    } 

    public List<Hechizo> getHechizos() {
        return this.hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    // METODOS DE LAS INTERFACES

    @Override
    public boolean esInvisibleAMuggles() {
        return true;
    }

    @Override
    public boolean esInvisible() {
        return false;
    }

    @Override
    public void setPoder(Poder poder) {
       
    }

    @Override
    public Poder getPoderInicial() {
        return null;
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

    /*public void atacarVAgus(Personaje personaje, Hechizo hechizo) {
        int saludOponente;
        int energiaMagicaAtacante;
        if (this.getEnergiaMagica() > 0){
            saludOponente = personaje.getSalud() - hechizo.getNivelDanio();
            energiaMagicaAtacante = this.getEnergiaMagica() - hechizo.getEnergiaMagica();

            this.setEnergiaMagica(energiaMagicaAtacante);
            personaje.setSalud(saludOponente);
        } else {
            System.out.println("¡No tienes suficiente energia magica para atacar!");
        }
    }*/

    //Versión de Agus modificada:
    //Capa Agus.
    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) {
        int saludAtacante;
        int saludOponente;
        int energiaMagicaAtacante;
        if (this.estaVivo() == true && personaje.estaVivo() == true){
    
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

