package app;

import java.util.*;
import app.personajes.*;
import app.poderes.*;
import app.poderes.hechizos.ataques.SectumSempra;
import app.artefactos.*;
import app.transportes.*;
import app.interfaces.*;

public class App {
    public static void main(String[] args) throws Exception {
        JuegoHP nombreJuego = new JuegoHP("Tiene este nombre");

        nombreJuego.inicializarCatalogo();

        nombreJuego.getPersonajes();
        nombreJuego.getHechizos();

        harryPotter.aprender(SectumSempra); //Tenemos problema de scope o algún método no tiene cuerpo.
        
        harryPotter.atacar(hermioneGranger, SectumSempra); //Lo mismo.
    
    }
}
