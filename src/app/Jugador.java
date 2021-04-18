package app;

import app.personajes.*;
import app.poderes.hechizos.Hechizo;

public class Jugador {
    
    // Cree esta clase nueva para que podamos tener una lista de jugadores en JuegoHP.java

    // CONSTRUCTOR

    public Jugador(int nroJugador, String nombreJugador, Personaje personajeElegido){
        this.setNroJugador(nroJugador);
        this.setNombreJugador(nombreJugador);
        this.setPersonajeElegido(personajeElegido);
    }

    private int nroJugador;
    private String nombreJugador;
    private Personaje personajeElegido;
    private Personaje personajeEnemigo;

    // GETTERS Y SETTERS

    public int getNroJugador(){
        return this.nroJugador;
    }

    public void setNroJugador(int nroJugador){
        this.nroJugador = nroJugador;
    }

    public String getNombreJugador(){
        return this.nombreJugador;
    }

    public void setNombreJugador(String nombreJugador){
        this.nombreJugador = nombreJugador;
    }

    public Personaje getPersonajeElegido() {
        return this.personajeElegido; 
    }

    public void setPersonajeElegido(Personaje personajeElegido){
        this.personajeElegido = personajeElegido;
    }

    public Personaje getPersonajeEnemigo() {
        return this.personajeEnemigo;
    }

    public void setPersonajeEnemigo(Personaje personajeEnemigo) {
        this.personajeEnemigo = personajeEnemigo;
    }
    
}
