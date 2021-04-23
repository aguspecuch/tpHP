package app.personajes;

import java.util.*;
import app.artefactos.*;
import app.interfaces.*;
import app.poderes.*;
import app.poderes.hechizos.*;
import app.transportes.*;

public class Wizard extends Persona implements IHaceMagia {

    // CONSTRUCTOR

    public Wizard(String nombre, int edad, Poder poderInicial, boolean magoOscuro) {
        super(nombre, edad);
        this.setEnergiaMagica(150);
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

    // METODOS

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
        System.out.println("");
        System.out.println(
                "→ " + this.getNombre() + " ataca a: " + personaje.getNombre() + " con el hechizo: " + hechizo);
        System.out.println("");
    }

    @Override
    public void atacar(Personaje personaje, Hechizo hechizo) {
        int saludAtacante;
        int saludOponente;
        int energiaMagicaAtacante;

        if (this.getEnergiaMagica() > 0) {

            if (this.getMagoOscuro() == false && hechizo.getEsOscuro() == true) {
                this.setMagoOscuro(true);
                System.out.println("☠  El mago ha utilizado un hechizo oscuro. Ahora es un mago oscuro  ☠ ");
                int nivelDanio = (hechizo.getNivelDanio() * 2);
                hechizo.setNivelDanio(nivelDanio);
            }

            Artefacto artefactoElegido = this.getArtefacto();

            if (artefactoElegido != null) {
                int nivelDanio = (int) (hechizo.getNivelDanio() + artefactoElegido.getAmplificadorDeDanio());
                int nivelCuracion = (int) (hechizo.getNivelCuracion() + artefactoElegido.getAmplificadorDeCuracion());
                hechizo.setNivelDanio(nivelDanio);
                hechizo.setNivelCuracion(nivelCuracion);
            }

            saludOponente = personaje.getSalud() - hechizo.getNivelDanio();
            energiaMagicaAtacante = this.getEnergiaMagica() - hechizo.getEnergiaMagica();
            saludAtacante = this.getSalud() + hechizo.getNivelCuracion();

            this.setEnergiaMagica(energiaMagicaAtacante);
            this.setSalud(saludAtacante);
            personaje.setSalud(saludOponente);

            System.out.println("");
            System.out.println("☆ La salud de " + this.getNombre() + " es " + this.getSalud()
                    + " y la salud de su oponente " + personaje.getNombre() + " es " + personaje.getSalud() + " ☆");
            System.out.println("");

        } else {
            System.out.println("");
            System.out.println("¡No tienes suficiente energia magica para atacar!");
            System.out.println("");
        }
    }
}
