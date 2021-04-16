package app;

import java.util.*;
import app.personajes.Wizard;

public class App {
    public static void main(String[] args) throws Exception {
        
    //Acá se pueden instanciar los personajes y transportes.

        //Todo lo que sigue es sólo para mostrarles.

        Wizard wizard = new Wizard(true);

        System.out.println("¿El mago es oscuro? " + wizard.getMagoOscuro());


    }
}
