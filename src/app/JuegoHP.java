package app;

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

}
