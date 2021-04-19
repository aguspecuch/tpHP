package app;

import java.util.*;

import app.artefactos.*;
import app.artefactos.varitas.*;
import app.personajes.*;
import app.poderes.*;
import app.poderes.hechizos.*;
import app.poderes.hechizos.ataques.*;
import app.poderes.hechizos.defensas.*;
import app.poderes.hechizos.curaciones.*;
import app.poderes.hechizos.ocio.*;
import app.transportes.*;

public class JuegoHP {

    public static Scanner Teclado = new Scanner(System.in);

    // CONSTRUCTOR

    public JuegoHP(String nombreJuego) {
        this.nombreJuego = nombreJuego;
    }

    // ATRIBUTOS

    private String nombreJuego;
    private List<Personaje> personajes = new ArrayList<>();
    private List<Poder> poderes = new ArrayList<>();
    private List<Hechizo> hechizos = new ArrayList<>();
    private List<Artefacto> artefactos = new ArrayList<>();
    private List<Transporte> transportes = new ArrayList<>();
    private List<Jugador> jugadores = new ArrayList<>();

    // GETTERS Y SETTERS

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
        this.jugar();
    }

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
        } else if (personajeElegido instanceof Dementor) {
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.println("¡Eligió un dementor!");
            System.out.println("");
            System.out.println("-------------------------------");
        } else if (personajeElegido == null) {
            System.out.println("EL NÚMERO INGRESADO NO CORRESPONDE A NINGÚN PERSONAJE.");
        }
        return personajeElegido;
    }

    public Artefacto elegirArtefacto() {

        System.out.println("");
        System.out.println("♡ Seleccione el número de artefacto:");
        System.out.println("");
        int contador = 1;
        for (Artefacto artefacto : this.artefactos) {
            System.out.println(contador + ") " + artefacto.getNombre());
            contador++;
        }
        int nroArtefacto = Teclado.nextInt();
        Teclado.nextLine();
        nroArtefacto--;
        Artefacto artefactoElegido = this.artefactos.get(nroArtefacto);

        if (artefactoElegido instanceof Varita) {
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.println("¡Eligió una varita!");
            System.out.println("");
            System.out.println("-------------------------------");
        } else if (artefactoElegido instanceof CapaInvisibilidad) {
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.println("¡Eligió una capa de invisibilidad!");
            System.out.println("");
            System.out.println("-------------------------------");
        } else if (artefactoElegido instanceof EspadaGryffindor) {
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.println("¡Eligió una espada!");
            System.out.println("");
            System.out.println("-------------------------------");
        } else if (artefactoElegido instanceof Horrocrux) {
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.println("¡Eligió un horrocrux!");
            System.out.println("");
            System.out.println("-------------------------------");
        } else if (artefactoElegido instanceof PiedraResurreccion) {
            System.out.println("-------------------------------");
            System.out.println("");
            System.out.println("¡Eligió una piedra de la resurrección!");
            System.out.println("");
            System.out.println("-------------------------------");
        } else if (artefactoElegido == null) {
            System.out.println("EL NÚMERO INGRESADO NO CORRESPONDE A NINGÚN ARTEFACTO.");
        }
        return artefactoElegido;
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

        EspadaGryffindor espadaGryffindor = new EspadaGryffindor("Espada de Godric Gryffindor", 0.8, 0.5);
        this.artefactos.add(espadaGryffindor);

        VaritaComun varitaComun = new VaritaComun("Varita Magica", 0.2, 0.2);
        this.artefactos.add(varitaComun);

    }

    // Metodo individual para instanciar PODERES
    public void inicializarPoderes() {

        Invisibilidad invisibilidad = new Invisibilidad("Invisibilidad", "Poder que te hace invisible");
        this.poderes.add(invisibilidad);

        ParselTongue parselTongue = new ParselTongue("Parsel Tongue",
                "Poder que te permite hablar la lengua de serpientes y basiliscos");
        this.poderes.add(parselTongue);

        Metamorfosis metamorfosis = new Metamorfosis("Metamorfosis",
                "Poder que te permite cambiar tu apariencia fisica a voluntad");
        this.poderes.add(metamorfosis);

        BesoDementor besoDementor = new BesoDementor("Beso del Dementor",
                "Poder del dementor que permite quitarle el alma a las personas");
        this.poderes.add(besoDementor);
    }

    // Metodo individual para instanciar HECHIZOS
    public void inicializarHechizos() {

        SectumSempra sectumSempra = new SectumSempra("Sectum Sempra", false, 30, 0, 20); // 30 seria el daño, 0 la
                                                                                         // curacion y 20 el gasto de
                                                                                         // energiaMagica
        this.hechizos.add(sectumSempra);

        AvadaKedavra avadaKedavra = new AvadaKedavra("Avada Kedavra", true, 50, 0, 30);
        this.hechizos.add(avadaKedavra);

        Cruciatus cruciatus = new Cruciatus("Cruciatus", true, 40, 0, 25);
        this.hechizos.add(cruciatus);

        Expelliarmus expelliarmus = new Expelliarmus("Expelliarmus", false, 20, 0, 15);
        this.hechizos.add(expelliarmus);

        CaveInimicum caveInimicum = new CaveInimicum("Cave Inimicum", false, 0, 0, 10);
        this.hechizos.add(caveInimicum);

        ExpectoPatronum expectoPatronum = new ExpectoPatronum("Expecto Patronum", false, 0, 0, 20);
        this.hechizos.add(expectoPatronum);

        VulneraSanentur vulneraSanentur = new VulneraSanentur("Vulnera Sanentur", false, 0, 0, 10);
        this.hechizos.add(vulneraSanentur);
    }

    // Metodo individual para instanciar TRANSPORTES
    public void inicializarTransportes() {

        TrenExpresoHowards trenExpresoHowards = new TrenExpresoHowards("Tren Expreso de Howards",
                "ren magico que transporta a los estudiantes a Howarts");
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

        Wizard lordVoldemort = new Wizard("Lord Voldemort", this.poderes.get(0), true);
        this.personajes.add(lordVoldemort);

        Wizard bellatrixLestrange = new Wizard("Bellatrix Lestrange", this.poderes.get(0), true);
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

        Elfo dobby = new Elfo("Dobby", 100, 150, this.artefactos.get(0));
        this.personajes.add(dobby);

        Elfo kreacher = new Elfo("Kreacher", 100, 150, this.artefactos.get(0));
        this.personajes.add(kreacher);

        Elfo winky = new Elfo("Winky", 100, 150, this.artefactos.get(0));
        this.personajes.add(winky);

        Elfo hokey = new Elfo("Hokey", 100, 150, this.artefactos.get(0));
        this.personajes.add(hokey);

        Dementor dementor = new Dementor("Dementor", 100, 150, this.poderes.get(0));
        this.personajes.add(dementor);
    }

    /*
     * Abril aca te tiro esta otra forma de hacer el juego por turnos basandome en
     * el juego de MK que habia hecho el profe una vez, vos fijate si te copa o te
     * sirve de algo sino borra todo a la mierda jajajajaj.
     */
    /*
     * ¡Gracias!  
     * Fue muy preciso. 
     */

    public void jugar() {
        Personaje p1 = this.getJugadores().get(0).getPersonajeElegido();
        Personaje p2 = this.getJugadores().get(1).getPersonajeElegido();

        boolean turnoP1 = true;
        int numeroTurno = 1; // Puede no usarse
        while (p1.estaVivo() == true && p2.estaVivo() && numeroTurno < 20) {    // Esto es para que el bucle dure solo
                                                                                // mientras alguno de los jugadores
                                                                                // tenga vida.
            
            //Catálogo de artefactos para elegir
            //Elegir si atacar o aprender
            //Elegir poder
            //Elegir cambiar de artefacto
                                     
            if (turnoP1) {/*TODO ESTO EN UN METODO*/
                Artefacto artefactoElegido = this.elegirArtefacto();
                //Elegir si atacar o aprender por turno
                if (p1 instanceof Wizard) {
                    ((Wizard) p1).atacar(p2, ((Wizard) p1).getPoderInicial());
                } else if (p1 instanceof Elfo) {
                    ((Elfo) p1).atacar(p2, ((Elfo) p1).getPoderInicial());
                } else if (p1 instanceof Muggle) {
                    ((Muggle) p1).atacar(p2, ((Muggle) p1).getPoderInicial());
                } else if (p1 instanceof Dementor) {
                    ((Dementor) p1).atacar(p2, ((Dementor) p1).getPoderInicial()); 
                }
            } else {
                Artefacto artefactoElegido = this.elegirArtefacto();
                if (p2 instanceof Wizard) {
                    ((Wizard) p2).atacar(p1, ((Wizard) p2).getPoderInicial());
                } else if (p2 instanceof Elfo) {
                    ((Elfo) p2).atacar(p1, ((Elfo) p2).getPoderInicial());
                } else if (p2 instanceof Muggle) {
                    ((Muggle) p2).atacar(p1, ((Muggle) p2).getPoderInicial());
                } else if (p2 instanceof Dementor) {
                    ((Dementor) p2).atacar(p1, ((Dementor) p2).getPoderInicial()); 
                }
            }
            numeroTurno = numeroTurno + 1;
            turnoP1 = !turnoP1; // Acá cambiaría el turno de P1 a P2
        }
    }
}