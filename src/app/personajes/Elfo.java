package app.personajes;

import java.util.*;
import app.artefactos.*;
import app.interfaces.*;
import app.poderes.Poder;
import app.poderes.hechizos.*;

public class Elfo extends Criatura implements IHaceMagia {
    
    // CONSTRUCTOR

    public Elfo(String nombre, Artefacto artefacto) {
        super(nombre);
        setEnergiaMagica(150);
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
        if (this.getEnergiaMagica() > 0){
    
            Artefacto artefactoElegido = this.getArtefacto();
            if (artefactoElegido instanceof CapaInvisibilidad) {
                int nivelDanio = (int) (hechizo.getNivelDanio() + artefactoElegido.getAmplificadorDeDanio());
                int nivelCuracion = (int) (hechizo.getNivelCuracion() + artefactoElegido.getAmplificadorDeCuracion());
                hechizo.setNivelDanio(nivelDanio);
                hechizo.setNivelCuracion(nivelCuracion);
            } else if (artefactoElegido instanceof EspadaGryffindor) {
                int nivelDanio = (int) (hechizo.getNivelDanio() + artefactoElegido.getAmplificadorDeDanio());
                int nivelCuracion = (int) (hechizo.getNivelCuracion() + artefactoElegido.getAmplificadorDeCuracion());
                hechizo.setNivelDanio(nivelDanio);
                hechizo.setNivelCuracion(nivelCuracion);
            } else if (artefactoElegido instanceof Horrocrux) {
                int nivelDanio = (int) (hechizo.getNivelDanio() + artefactoElegido.getAmplificadorDeDanio());
                int nivelCuracion = (int) (hechizo.getNivelCuracion() + artefactoElegido.getAmplificadorDeCuracion());
                hechizo.setNivelDanio(nivelDanio);
                hechizo.setNivelCuracion(nivelCuracion);
            } else if (artefactoElegido instanceof PiedraResurreccion) {
                int nivelDanio = (int) (hechizo.getNivelDanio() + artefactoElegido.getAmplificadorDeDanio());
                int nivelCuracion = (int) (hechizo.getNivelCuracion() + artefactoElegido.getAmplificadorDeCuracion());
                hechizo.setNivelDanio(nivelDanio);
                hechizo.setNivelCuracion(nivelCuracion);
            }

            saludOponente = personaje.getSalud() - hechizo.getNivelDanio();

            energiaMagicaAtacante = this.getEnergiaMagica() - hechizo.getEnergiaMagica();
            this.setEnergiaMagica(energiaMagicaAtacante);
            saludAtacante = this.getEnergiaMagica() + hechizo.getNivelCuracion();

            this.setSalud(saludAtacante);
            personaje.setSalud(saludOponente);

            System.out.println("La salud de " + this.getNombre() + " es " + this.getSalud() + 
            " y la salud de su oponente " + personaje.getNombre() + " es " + personaje.getSalud());
        } else {
            System.out.println("¡No tienes suficiente energia magica para atacar!");
        }
    }

}

