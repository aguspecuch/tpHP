package app;

import java.util.*;
import app.personajes.*;
import app.transportes.*;

public class JuegoHP {
    
    private String nombreJuego;

    public JuegoHP(String nombreJuego){ 
        this.setNombreJuego(nombreJuego);
    }

    public void setNombreJuego(String nombreJuego){
        this.nombreJuego = nombreJuego;
    }

    public String getNombreJuego(){
        return this.nombreJuego;
    }

    public List<Personaje> personajes = new ArrayList<>();
    public List<Escoba> escobas = new ArrayList<>();
    public List<Transporte> transportes = new ArrayList<>();

    //Y acá se pueden instanciar los poderes y artefactos.

}