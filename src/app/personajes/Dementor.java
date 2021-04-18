package app.personajes;

public class Dementor extends Criatura {

    // CONSTUCTOR

    public Dementor (String nombre) {
        this.setNombre(nombre);
        this.setSalud(100); // Le asigno directamente el máximo.
        this.energiaMagica = 150; // Le asigno directamente el máximo.
    }

    // ATRIBUTOS

    private int energiaMagica;

    // GETTERS Y SETTERS

    public int getEnergiaMagica() {
        return this.energiaMagica;
    }

    public void setEnergiaMagica(int energiaMagica) {
        this.energiaMagica = energiaMagica;
    }

    // METODO DE LAS INTERFASES

    @Override
    public boolean esInvisibleAMuggles() {
        return true;
    }

    @Override
    public boolean esInvisible() {
        return false;
    }

   
}
