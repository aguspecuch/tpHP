package app.personajes;

public class Dementor extends Criatura {

    private int energiaMagica;
    
    public Dementor (String nombre) {
        this.setNombre(nombre);
        this.setSalud(100); // Le asigno directamente el máximo.
        this.energiaMagica = 150; // Le asigno directamente el máximo.
    }

    @Override
    public boolean esInvisibleAMuggles() {
        return true;
    }

    @Override
    public boolean esInvisible() {
        return false;
    }

   
}
