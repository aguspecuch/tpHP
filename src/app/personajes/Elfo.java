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
    public void aprender(Hechizo hechizo) {
        this.hechizos.add(hechizo);
    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) {
    }
    

    @Override
    public void atacar(Personaje personaje, String hechizo) {
        
    }

    public void atacarVAgus(Personaje personaje, Hechizo hechizo) {
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
    }
}

