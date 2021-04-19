package app.personajes;

import java.util.*;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import app.artefactos.*;
import app.artefactos.varitas.*;
import app.interfaces.*;
import app.poderes.*;
import app.poderes.hechizos.*;
import app.poderes.hechizos.ataques.*;
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

    public Poder getPoderInicial() {
        return this.poderInicial;
    }

    public void setPoderInicial(Poder poderInicial) {
        this.poderInicial = poderInicial;
    }

    public Artefacto getArtefacto() {
        return this.artefacto;
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

    // METODOS DE LAS INTERFACES

    @Override
    public void setPoder(Poder poder) {
        this.poderInicial = poder;
    }

    @Override
    public void aprender(Hechizo hechizo) {
        this.setPoder(hechizo);
        // ¿Así de una que aprenda el hechizo? Más adelante se le podría añadir alguna
        // dificultad.
    }

    public void aprender(Poder poder) {
        this.setPoder(poder);
        // ¿Así de una que aprenda el hechizo? Más adelante se le podría añadir alguna
        // dificultad.
    }

    public List<Poder> utilizarPoderesAprendidos() {
        this.
    }

    @Override
    public void atacar(Personaje personaje, Hechizo h) {
        for (Hechizo hechizo : this.hechizos) {
            if (h.equals(hechizo)) {
                if (this.getArtefacto() instanceof Varita) {
                    if (this.getArtefacto() instanceof VaritaComun) {
                        
                    } else if (this.getArtefacto() instanceof VaritaSauco) {
                        
                    }
                }
                else {
                    System.out.println("Hechizo no conjurado. El personaje no tiene varita.");
                }
            } 
            else {
                System.out.println("El mago no ha aprendido aún a conjurar este hechizo.");
            }
        } 
    }

    public void atacar(Personaje personaje, Poder p) {
        //Desps del catalogo: cartelito
    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {
        // Esto podría hacer... ¿Qué cosa? Alfonsina nos tiró la idea de que el método
        // conjure.
        // El tema es qué interpretamos por conjurar.
    }

    // Creé esta función para saber si el hechizo elegido ya lo tiene aprendido el personaje.
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hechizo) {
            Hechizo hechizo = (Hechizo) obj;
            return hechizo.getNombre().equals(this.getNombre()); // Este equals no es el mismo que el método en sí.
        } else if (obj instanceof Poder) {
            Poder poder = (Poder) obj;
            return poder.getNombre().equals(this.getNombre());// Es uno propio de cadenas, más bien.
        } else {
            return false;
        }
    }

}
