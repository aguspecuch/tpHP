package app.interfaces;

import app.poderes.*;
import app.poderes.hechizos.*;
import app.artefactos.*;
import app.personajes.*;

public interface IHaceMagia {

    void setEnergiaMagica(int energiaMagica);

    int getEnergiaMagica();

    void setPoder(Poder poder);

    Poder getPoderInicial();

    Artefacto getArtefacto();

    void aprender(Hechizo hechizo);

    void atacar(Personaje personaje, Hechizo hechizo);

    void atacar(Personaje personaje, String hechizo);

}