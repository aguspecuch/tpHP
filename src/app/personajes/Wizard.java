package app.personajes;

import app.artefactos.Artefacto;
import app.interfaces.*;
import app.poderes.Poder;
import app.poderes.hechizos.Hechizo;
import app.transportes.Escoba;

import java.util.ArrayList;
import java.util.List;

public class Wizard extends Persona implements IHaceMagia {

    private int energiaMagica;
    private Artefacto artefacto;
    private Escoba escoba;
    private Poder poderInicial;
    private boolean magoOscuro;
    private List<Hechizo> hechizos = new ArrayList<>();

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

    public boolean getMagoOscuro() {
        return this.magoOscuro;
    }

    public void setMagoOscuro(boolean magoOscuro) {
        this.magoOscuro = magoOscuro;
    }

    public List<Hechizo> getHechizos() {
        return this.hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    // Los constructores no pueden estar en las clases abstractas, pero sí en las concretas.
    // Y como puedo instanciar Wizard porque es concreta, entonces le puedo crear un constructor 
    // (y descartamos automáticamente el que es por defecto al crear uno):

    public Wizard(int energiaMagica, Artefacto artefacto, Escoba escoba, Poder poderInicial, boolean magoOscuro, List<Hechizo> hechizos) {
        
        this.energiaMagica = 150; /* Le asigno directamente el máximo, pero podría 
        complejizarse esta asignación de un int.*/
        
        if (artefacto != Null) {
            this.artefacto = artefacto; 
        } else {
            this.artefacto = new VaritaPorDefecto(); // Fijarse si se puede asignar una varita random.
        }

        if (artefacto != Null) {
            this.escoba = escoba; 
        } else {
            this.escoba = new Escoba();
        }

        this.poderInicial = 200; // Número arbitrario.
        /* Dependiendo del tipo de mago podemos crear un constructor para cada subclase 
        (aún no creada) de Wizard y les asignamos un número manual o aleatoriamente. */

        this.magoOscuro = false;

        this.hechizos = Null;

    }

    /* También podemos crear constructores en subclases de Wizard (aún no creadas) e inicializar valores
    distintos para cada una de ellas. Si hacemos eso, entonces deberíamos borrar este constructor y
    declarar abstracta a la clase Wizard e instanciar directamente objetos de sus subclases. */

}
