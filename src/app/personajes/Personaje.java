package app.personajes;

import app.poderes.*;
import app.artefactos.*;

import java.util.ArrayList;
import java.util.List;
 public abstract class Personaje {

    private String nombre;
    private int salud;
    private int edad;
        
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }   

    public int getSalud() {
        return this.salud;
    }
    
    public void setSalud(int salud) {
        this.salud = salud; 
    } 

    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad; 
    }   

    public List<Poder> poderes = new ArrayList<>();

    public List<Artefacto> artefactos = new ArrayList<>();
    
}
