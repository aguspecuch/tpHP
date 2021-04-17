package app.personajes;

import java.util.*;
import app.artefactos.*;
import app.interfaces.*;
import app.poderes.*;
import app.poderes.hechizos.*;
import app.poderes.hechizos.ataques.*;
import app.poderes.hechizos.curaciones.HechizoCuracion;
import app.poderes.hechizos.defensas.HechizoDefensa;
import app.poderes.hechizos.ocio.HechizoOcio;
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

    private int energiaMagica;
    private List<Hechizo> hechizos = new ArrayList<>();
    private Escoba escoba;
    private Poder poderInicial;
    private Artefacto artefacto;
    private boolean magoOscuro;

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
        this.getHechizos().add(hechizo);
        //¿Así de una que aprenda el hechizo? Más adelante se le podría añadir alguna dificultad.
    }

    @Override
    public void atacar(Personaje personaje, Hechizo h) {
        if (personaje.estaVivo()) {
            for (Hechizo hechizo : this.hechizos) {
                if (h.equals(hechizo)) {
                    //Agregar qué hace.
                    //Debería usar un cast acá también creo o reutilizar algo para que según qué tipo de hechizo
                    //es que tenga X daño, Y defensa y demás, donde X e Y son enteros (int).
                }
            } 
        }
  
    }

    @Override
    public void atacar(Personaje personaje, String hechizo) {
        //Esto podría hacer... ¿Qué cosa? Alfonsina nos tiró la idea de que conjure pero no sabría bien...
    }

    //Creé esta función para saber si el hechizo elegido es de cierto tipo y utilizarla en el cuerpo 
    //del método atacar(Personaje personaje, Hechizo hechizo).
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof HechizoAtaque) {
            HechizoAtaque hechizoAtaque = (HechizoAtaque)obj;
            return hechizoAtaque.getNombre().equals(this.getNombre());
        } else if (obj instanceof HechizoDefensa) {
            HechizoDefensa hechizoDefensa = (HechizoDefensa)obj;
            return hechizoDefensa.getNombre().equals(this.getNombre());
        } else if (obj instanceof HechizoCuracion) {
            HechizoCuracion hechizoCuracion = (HechizoCuracion)obj;
            return hechizoCuracion.getNombre().equals(this.getNombre());
        } else if (obj instanceof HechizoOcio) {
            HechizoOcio hechizoOcio = (HechizoOcio)obj;
            return hechizoOcio.getNombre().equals(this.getNombre());
        } else {
            return false;
        }    
    }
    //Me gustaría que este método anterior se rehaga con un switch(key).
    


}
