package app;

import java.util.*;

import app.artefactos.*;
import app.artefactos.varitas.VaritaSauco;
import app.personajes.*;
import app.poderes.*;
import app.poderes.hechizos.*;
import app.poderes.hechizos.ataques.SectumSempra;
import app.transportes.*;

public class JuegoHP {

    // CONSTRUCTOR

    public JuegoHP(String nombreJuego){
        this.nombreJuego = nombreJuego;
    }

    private String nombreJuego;
    private List<Personaje> personajes = new ArrayList<>();
    private List<Poder> poderes = new ArrayList<>();
    private List<Hechizo> hechizos = new ArrayList<>();
    private List<Artefacto> artefactos = new ArrayList<>();
    private List<Transporte> transportes = new ArrayList<>();

    public String getNombreJuego() {
        return this.nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public List<Personaje> getPersonajes() {
        return this.personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    public List<Poder> getPoderes() {
        return this.poderes;
    }

    public void setPoderes(List<Poder> poderes) {
        this.poderes = poderes;
    }

    public List<Hechizo> getHechizos() {
        return this.hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    public List<Artefacto> getArtefactos() {
        return this.artefactos;
    }

    public void setArtefactos(List<Artefacto> artefactos) {
        this.artefactos = artefactos;
    }

    public List<Transporte> getTransportes() {
        return this.transportes;
    }

    public void setTransportes(List<Transporte> transportes) {
        this.transportes = transportes;
    }

    // Y acá se pueden instanciar los poderes y artefactos.

    // Este seria el metodo principal donde podemos poner todos los metodos individuales donde instanciamos las cosas.
    public void inicializarCatalogo(){
        this.inicializarArtefactos();
        this.inicializarPoderes();
        this.inicializarHechizos();
        this.inicializarTransportes();
        this.inicializarPersonajes();
    }
    // Metodo individual para instanciar ARTEFACTOS
    public void inicializarArtefactos(){

        CapaInvisibilidad capaInvisibilidad = new CapaInvisibilidad("Capa de Invisibilidad", 0.1, 0.2); // Instancio el objeto CapaInvisibilidad
        this.artefactos.add(capaInvisibilidad); // Lo agrego a la lista de artefactos de JuegoHP
        Horrocrux horrocrux = new Horrocrux("Horrocrux", 0.5, 0.5);
        this.artefactos.add(horrocrux);
        PiedraResurreccion piedraResurreccion = new PiedraResurreccion("Piedra Resurreccion", 0.2, 0.8);
        this.artefactos.add(piedraResurreccion);
        VaritaSauco varitaSauco = new VaritaSauco("Varita de Sauco", 0.8, 0.5);
        this.artefactos.add(varitaSauco);
    }
    // Metodo individual para instanciar PODERES
    public void inicializarPoderes(){

        Invisibilidad invisibilidad = new Invisibilidad("Invisibilidad", "Poder que te hace invisible");
        this.poderes.add(invisibilidad);
    }

    // Metodo individual para instanciar HECHIZOS
    public void inicializarHechizos(){

        SectumSempra sectumSempra = new SectumSempra("Sectum Sempra", true, 50, 20, 30); // 50 seria el daño, 20 la curacion y 30 el gasto de energiaMagica
        this.hechizos.add(sectumSempra);
    }

    // Metodo individual para instanciar TRANSPORTES
    public void inicializarTransportes(){

        TrenExpresoHowards trenExpresoHowards = new TrenExpresoHowards("Tren Expreso de Howards", "Un tren magico que transporta a los estudiantes a Howarts");
        this.transportes.add(trenExpresoHowards);
    }

    // Metodo individual para instanciar PERSONAJES
    public void inicializarPersonajes(){

        Wizard wizard = new Wizard("Harry Potter", this.poderes.get(0), false); // El "this.poderes.get(0)" hace referencia al 1er Poder de la lista PODERES de JuegoHP. En este caso es SectumSempra.
        this.personajes.add(wizard);
    }


}