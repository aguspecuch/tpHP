package app;

public class App {
    public static void main(String[] args) throws Exception {
        JuegoHP nombreJuego = new JuegoHP("Tiene este nombre");

        nombreJuego.iniciarJuego();
        nombreJuego.darBienvenida();
        nombreJuego.inicializarJugadores();
        
      
    }
}
