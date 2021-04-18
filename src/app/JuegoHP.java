package app;

import java.util.*;

import app.artefactos.*;
import app.artefactos.varitas.VaritaSauco;
import app.personajes.*;
import app.poderes.*;
import app.poderes.hechizos.*;
import app.poderes.hechizos.ataques.*;
import app.transportes.*;

public class JuegoHP {

    public static Scanner Teclado = new Scanner(System.in);

    // CONSTRUCTOR

    public JuegoHP(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    private String nombreJuego;
    private List<Personaje> personajes = new ArrayList<>();
    private List<Poder> poderes = new ArrayList<>();
    private List<Hechizo> hechizos = new ArrayList<>();
    private List<Artefacto> artefactos = new ArrayList<>();
    private List<Transporte> transportes = new ArrayList<>();
    private List<Jugador> jugadores = new ArrayList<>();

    public String getNombreJuego() {
        return this.nombreJuego;
    }

    public void setNombreJuego(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    public List<Personaje> getPersonajes() {
        return this.personajes;
    }

    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    public List<Poder> getPoderes() {
        return this.poderes;
    }

    public void setPoderes(List<Poder> poderes) {
        this.poderes = poderes;
    }

    public List<Hechizo> getHechizos() {
        return this.hechizos;
    }

    public void setHechizos(List<Hechizo> hechizos) {
        this.hechizos = hechizos;
    }

    public List<Artefacto> getArtefactos() {
        return this.artefactos;
    }

    public void setArtefactos(List<Artefacto> artefactos) {
        this.artefactos = artefactos;
    }

    public List<Transporte> getTransportes() {
        return this.transportes;
    }

    public void setTransportes(List<Transporte> transportes) {
        this.transportes = transportes;
    }

    public List<Jugador> getJugadores() {
        return this.jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    // Y acá se pueden instanciar los poderes y artefactos.

    // Esto seria lo primero que aparece cuando arranca el juego. Fijense si les
    // gusta o quieren poner otra cosa.
    // Le puse "Duelo Magico" para no ponerle tpHP lol
    public void darBienvenida() {
        System.out.println(" ______________________________");
        System.out.println("|                              |");
        System.out.println("| Bienvenidos a 'DUELO MAGICO' |");
        System.out.println("|______________________________|");
        System.out.println("");
    }

    // Esto seria un metodo para inicializar 2 jugadores (metodologia player vs
    // player). Se les pide que ingrese su nombre y
    // se llama a otro metodo elegirPersonaje() para que cada jugador pueda elegir
    // su personaje de la lista. A su vez, dependiendo
    // del personaje que elija le avisa que clase de personaje eligio (Mago, Elfo o
    // Muggle).

    public void inicializarJugadores() {

        System.out.println("→ PLAYER 1");
        System.out.println("");
        System.out.println("♡ Ingrese su nombre de jugador:");
        String nombreJugador = Teclado.nextLine();

        Personaje personajeElegido = this.elegirPersonaje();

        Jugador player1 = new Jugador(1, nombreJugador, personajeElegido);
        this.getJugadores().add(player1);

        System.out.println("");
        System.out.println("→ PLAYER 2");
        System.out.println("");
        System.out.println("♡ Ingrese su nombre de jugador:");
        nombreJugador = Teclado.nextLine();
        System.out.println("");

        personajeElegido = this.elegirPersonaje();

        Jugador player2 = new Jugador(2, nombreJugador, personajeElegido);
        this.getJugadores().add(player2);
    }

    // Este seria el metodo para que el jugador pueda elegir su personaje.
    public Personaje elegirPersonaje() {

        System.out.println("");
        System.out.println("♡ Seleccione su personaje:");
        System.out.println("");
        int contador = 1;
        for (Personaje personaje : this.personajes) {
            System.out.println(contador + ") " + personaje.getNombre());
            contador++;
        }
        int nroPersonaje = Teclado.nextInt();
        Teclado.nextLine();
        nroPersonaje--;
        Personaje personajeElegido = this.personajes.get(nroPersonaje);

        if (personajeElegido instanceof Wizard) {
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.println("¡Eligió un mago!");
            System.out.println("");
            System.out.println("-------------------------------");
        } else if (personajeElegido instanceof Elfo) {
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.println("¡Eligió un elfo!");
            System.out.println("");
            System.out.println("-------------------------------");
        } else if (personajeElegido instanceof Muggle) {
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.println("¡Eligió un muggle!");
            System.out.println("");
            System.out.println("-------------------------------");
        } else if (personajeElegido == null) {
            System.out.println("EL NÚMERO INGRESADO NO CORRESPONDE A NINGÚN PERSONAJE.");
        }

        return personajeElegido;
    }

    // Este seria el metodo principal donde podemos poner todos los metodos
    // individuales donde instanciamos las cosas.
    public void iniciarJuego() {
        this.inicializarArtefactos();
        this.inicializarPoderes();
        this.inicializarHechizos();
        this.inicializarTransportes();
        this.inicializarPersonajes();
        this.darBienvenida();
        this.inicializarJugadores();
        this.jugadores.get(0).setPersonajeEnemigo(jugadores.get(1).getPersonajeElegido());
        this.jugadores.get(1).setPersonajeEnemigo(jugadores.get(0).getPersonajeElegido());
        //this.jugar();
    }

    // Metodo individual para instanciar ARTEFACTOS
    public void inicializarArtefactos() {

        CapaInvisibilidad capaInvisibilidad = new CapaInvisibilidad("Capa de Invisibilidad", 0.1, 0.2); // Instancio el
                                                                                                        // objeto
                                                                                                        // CapaInvisibilidad
        this.artefactos.add(capaInvisibilidad); // Lo agrego a la lista de artefactos de JuegoHP
        Horrocrux horrocrux = new Horrocrux("Horrocrux", 0.5, 0.5);
        this.artefactos.add(horrocrux);
        PiedraResurreccion piedraResurreccion = new PiedraResurreccion("Piedra Resurreccion", 0.2, 0.8);
        this.artefactos.add(piedraResurreccion);
        VaritaSauco varitaSauco = new VaritaSauco("Varita de Sauco", 0.8, 0.5);
        this.artefactos.add(varitaSauco);

    }

    // Metodo individual para instanciar PODERES
    public void inicializarPoderes() {

        Invisibilidad invisibilidad = new Invisibilidad("Invisibilidad", "Poder que te hace invisible");
        this.poderes.add(invisibilidad);
    }

    // Metodo individual para instanciar HECHIZOS
    public void inicializarHechizos() {

        SectumSempra sectumSempra = new SectumSempra("Sectum Sempra", true, 50, 20, 30); // 50 seria el daño, 20 la
                                                                                         // curacion y 30 el gasto de
                                                                                         // energiaMagica
        this.hechizos.add(sectumSempra);
    }

    // Metodo individual para instanciar TRANSPORTES
    public void inicializarTransportes() {

        TrenExpresoHowards trenExpresoHowards = new TrenExpresoHowards("Tren Expreso de Howards",
                "Un tren magico que transporta a los estudiantes a Howarts");
        this.transportes.add(trenExpresoHowards);
    }

    // Metodo individual para instanciar PERSONAJES
    public void inicializarPersonajes() {

        Wizard harryPotter = new Wizard("Harry Potter", this.poderes.get(0), false); // El "this.poderes.get(0)" hace
                                                                                     // referencia al 1er Poder de la
                                                                                     // lista PODERES de JuegoHP. En
                                                                                     // este caso es SectumSempra.
        this.personajes.add(harryPotter);

        Wizard hermioneGranger = new Wizard("Hermione Granger", this.poderes.get(0), false);
        this.personajes.add(hermioneGranger);

        Wizard albusDumbledore = new Wizard("Albus Dumbledore", this.poderes.get(0), false);
        this.personajes.add(albusDumbledore);

        Wizard lordVoldemort = new Wizard("Lord Voldemort", this.poderes.get(0), false);
        this.personajes.add(lordVoldemort);

        Wizard bellatrixLestrange = new Wizard("Bellatrix Lestrange", this.poderes.get(0), false);
        this.personajes.add(bellatrixLestrange);

        Wizard ronWeasly = new Wizard("Ron Weasly", this.poderes.get(0), false);
        this.personajes.add(ronWeasly);

        Wizard severusSnape = new Wizard("Severus Snape", this.poderes.get(0), false);
        this.personajes.add(severusSnape);

        Wizard dracoMalfoy = new Wizard("Draco Malfoy", this.poderes.get(0), false);
        this.personajes.add(dracoMalfoy);

        Muggle dudleyDursley = new Muggle("Dudley Dursley");
        this.personajes.add(dudleyDursley);

        Muggle vernonDursley = new Muggle("Vernon Dursley");
        this.personajes.add(vernonDursley);

        Muggle petuniaDursley = new Muggle("Petunia Dursley");
        this.personajes.add(petuniaDursley);

        Elfo dobby = new Elfo("Dobby");
        this.personajes.add(dobby);

        Elfo kreacher = new Elfo("Kreacher");
        this.personajes.add(kreacher);

        Elfo winky = new Elfo("Winky");
        this.personajes.add(winky);

        Elfo hokey = new Elfo("Hokey");
        this.personajes.add(hokey);

        Dementor dementor = new Dementor("Dementor");
        this.personajes.add(dementor);
        
    }

    public void jugar() {
        int numeroRonda = 0;
        do {
            for (Jugador jugador : this.jugadores) {
                if (jugador.getPersonajeElegido() instanceof Wizard) {
                    ((Wizard) jugador.getPersonajeElegido()).atacar(jugador.getPersonajeEnemigo(), ((Wizard) jugador.getPersonajeElegido()).getPoderInicial());
                }
                
            }
        } 
        //while {
        //}
       
    }
}