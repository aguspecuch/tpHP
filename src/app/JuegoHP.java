package app;

public class JuegoHP {
    
    public JuegoHP(String nombreJuego){
        this.setNombreJuego(nombreJuego);
    }

    private String nombreJuego;

    public String getNombreJuego(){
        return this.nombreJuego;
    }

    public void setNombreJuego(String nombreJuego){
        this.nombreJuego = nombreJuego;
    }
}
