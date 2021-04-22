package app.personajes;

import java.util.*;
import app.artefactos.*;
import app.interfaces.*;
import app.poderes.*;
import app.poderes.hechizos.*;
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
    public void aprender(Hechizo hechizo) {
        this.hechizos.add(hechizo);
    }

    public void aprender(Poder poder) {
        this.poderes.add(getPoderInicial());
        this.poderes.add(poder);
    }

    @Override
    public void atacar(Personaje personaje, Hechizo h) {
        for (Hechizo hechizo : this.hechizos) {
            if (h.equals(hechizo)) {
                if (this.getMagoOscuro() == true || (this.getMagoOscuro() == false && h.getEsOscuro() == false) {
                    //Entonces no se va a duplicar daño ni curación
                    if (h instanceof HechizoAtaque) {
                        
                    } else if (h instanceof HechizoDefensa) {

                    }

                } else if (this.getMagoOscuro() == false && h.getEsOscuro() == true) {
                    //Doble daño y curación
                }
            } else {
                System.out.println("El mago no ha aprendido aún a conjurar este hechizo.");
            } 
        }
    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {
        //A esto después lo utilizo en JuegoHP.
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Hechizo) {
            Hechizo hechizo = (Hechizo) obj;
            return hechizo.getNombre().equals(this.getNombre());
        } else if (obj instanceof Poder) {
            Poder poder = (Poder) obj;
            return poder.getNombre().equals(this.getNombre());
        } else {
            return false;
        }
    }

    public int devolverNroHechizo(Hechizo hechizo) {
        int nroHechizo = this.hechizos.indexOf(hechizo);
        return nroHechizo;
    }

    public int devolverNroPoder(Poder poder) {
        int nroPoder = this.poderes.indexOf(poder);
        return nroPoder;
    }

    //Version Agus

    public void atacarVAgus(Personaje personaje, Hechizo h) {

        int saludOponente;
        int energiaMagicaAtacante;
        if (this.getEnergiaMagica() > 0){
            saludOponente = personaje.getSalud() - h.getNivelDanio();
            energiaMagicaAtacante = this.getEnergiaMagica() - h.getEnergiaMagica();

            this.setEnergiaMagica(energiaMagicaAtacante);
            personaje.setSalud(saludOponente);
        } else {
            System.out.println("¡No tienes suficiente energia magica para atacar!");
        }
    }
}
