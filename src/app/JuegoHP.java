package app;

import java.util.*;

import app.artefactos.*;
import app.artefactos.varitas.*;
import app.personajes.*;
import app.poderes.*;
import app.poderes.hechizos.*;
import app.poderes.hechizos.ataques.*;
import app.poderes.hechizos.defensas.*;
import app.poderes.hechizos.ocio.WingardiumLeviosa;
import app.poderes.hechizos.curaciones.*;
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

    // METODO PRINCIPAL DEL JUEGO

    public void iniciarJuego() {
        this.inicializarArtefactos();
        this.inicializarPoderes();
        this.inicializarHechizos();
        this.inicializarTransportes();
        this.inicializarPersonajes();
        this.darBienvenida();
        this.inicializarJugadores();
        this.jugar();
        this.mostrarGanador();
    }

    public void darBienvenida() {
        System.out.println(" ______________________________");
        System.out.println("|                              |");
        System.out.println("| Bienvenidos a 'DUELO MAGICO' |");
        System.out.println("|______________________________|");
        System.out.println("");
    }

    public void inicializarJugadores() {

        System.out.println("→ PLAYER 1");
        System.out.println("");
        System.out.println("♡ Ingrese su nombre de jugador:");
        String nombreJugador = Teclado.nextLine();

        Personaje personajeElegido = this.elegirPersonaje();
        Artefacto artefactoElegido;

        if (personajeElegido instanceof Wizard) {
            artefactoElegido = this.elegirArtefacto();
            ((Wizard) personajeElegido).setArtefacto(artefactoElegido);
        } else if (personajeElegido instanceof Elfo) {
            artefactoElegido = this.elegirArtefacto();
            ((Elfo) personajeElegido).setArtefacto(artefactoElegido);
        }

        Jugador player1 = new Jugador(1, nombreJugador, personajeElegido);
        this.getJugadores().add(player1);

        System.out.println("");
        System.out.println("→ PLAYER 2");
        System.out.println("");
        System.out.println("♡ Ingrese su nombre de jugador:");
        nombreJugador = Teclado.nextLine();
        System.out.println("");

        personajeElegido = this.elegirPersonaje();

        if (personajeElegido instanceof Wizard) {
            artefactoElegido = this.elegirArtefacto();
            ((Wizard) personajeElegido).setArtefacto(artefactoElegido);
        } else if (personajeElegido instanceof Elfo) {
            artefactoElegido = this.elegirArtefacto();
            ((Elfo) personajeElegido).setArtefacto(artefactoElegido);
        }

        Jugador player2 = new Jugador(2, nombreJugador, personajeElegido);
        this.getJugadores().add(player2);
    }

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
            System.out.println("");
            System.out.println("----->  ¡Eligió un mago!");
            System.out.println("");
        } else if (personajeElegido instanceof Elfo) {
            System.out.println("");
            System.out.println("-----> ¡Eligió un elfo!");
            System.out.println("");
        } else if (personajeElegido instanceof Muggle) {
            System.out.println("");
            System.out.println("-----> ¡Eligió un muggle!");
            System.out.println("");
        } else if (personajeElegido == null) {
            System.out.println("EL NÚMERO INGRESADO NO CORRESPONDE A NINGÚN PERSONAJE.");
        }
        return personajeElegido;
    }

    public Artefacto elegirArtefacto() {
        System.out.println("");
        System.out.println("♡ Seleccione el número de artefacto que desea usar:");
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

        System.out.println("");
        System.out.println("-----> ¡Eligio " + artefactoElegido.getNombre() + "!");
        System.out.println("");

        return artefactoElegido;
    }

    public void inicializarArtefactos() {

        CapaInvisibilidad capaInvisibilidad = new CapaInvisibilidad("Capa de Invisibilidad", 0.1, 0.2);
        this.artefactos.add(capaInvisibilidad);

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

    public void inicializarPoderes() {

        Invisibilidad invisibilidad = new Invisibilidad("Invisibilidad", "Poder que te hace invisible");
        this.poderes.add(invisibilidad);

        ParselTongue parselTongue = new ParselTongue("Parsel Tongue",
                "Poder que te permite hablar la lengua de serpientes y basiliscos");
        this.poderes.add(parselTongue);

        Metamorfosis metamorfosis = new Metamorfosis("Metamorfosis",
                "Poder que te permite cambiar tu apariencia fisica a voluntad");
        this.poderes.add(metamorfosis);

    }

    public void inicializarHechizos() {

        SectumSempra sectumSempra = new SectumSempra("Sectum Sempra", false, 30, 0, 20);
        sectumSempra.setDescripcion("Maldición que produce cortes profundos generando hemorragias a la victima");
        this.hechizos.add(sectumSempra);

        AvadaKedavra avadaKedavra = new AvadaKedavra("Avada Kedavra", true, 50, 0, 30);
        avadaKedavra.setDescripcion("Maldicion imperdonable, produce la muerte instantanea a la victima");
        this.hechizos.add(avadaKedavra);

        Cruciatus cruciatus = new Cruciatus("Cruciatus", true, 40, 0, 25);
        cruciatus.setDescripcion("Maldición imperdonable, genera un dolor intenso y agonico en la victima");
        this.hechizos.add(cruciatus);

        Desmaius desmaius = new Desmaius("Desmaius", false, 25, 0, 15);
        desmaius.setDescripcion("Encantamiento estupefactor, deja inconsciente a las victimas");
        this.hechizos.add(desmaius);

        PetrificusTotalus petrificusTotalus = new PetrificusTotales("Petrificus Totalus", false, 30, 0, 20);
        petrificusTotalus.setDescripcion("Maldicion de paralisis que deja a la victima totalmente inmovil");
        this.hechizos.add(petrificusTotalus);

        Expelliarmus expelliarmus = new Expelliarmus("Expelliarmus", false, 20, 0, 15);
        expelliarmus.setDescripcion("Encantamiento defensivo que fuerza a la victima a soltar lo que este sujetando");
        this.hechizos.add(expelliarmus);

        CaveInimicum caveInimicum = new CaveInimicum("Cave Inimicum", false, 0, 10, 10);
        caveInimicum.setDescripcion("Hechizo de proteccion que mantiene a los enemigos alejados");
        this.hechizos.add(caveInimicum);

        ExpectoPatronum expectoPatronum = new ExpectoPatronum("Expecto Patronum", false, 0, 20, 20);
        expectoPatronum.setDescripcion("Encantamiento defensivo que genera una fuerza de energia positiva parcialmente tangible");
        this.hechizos.add(expectoPatronum);

        VulneraSanentur vulneraSanentur = new VulneraSanentur("Vulnera Sanentur", false, 0, 50, 10);
        vulneraSanentur.setDescripcion("Hechizo de curacion para sanar lesiones, desde cortes menores hasta heridas profundas");
        this.hechizos.add(vulneraSanentur);

        BrackiumEmendo brackiumEmendo = new BrackiumEmendo("Brackium Emendo", false, 0, 45, 15);
        brackiumEmendo.setDescripcion("Hechizo sanador que se utiliza para reparar huesos rotos");
        this.hechizos.add(brackiumEmendo);

        WingardiumLeviosa wingardiumLeviosa = new WingardiumLeviosa("Wingardium Leviosa", false, 0, 0, 0);
        wingardiumLeviosa.setDescripcion("Encantamiento usado para hacer que los objetos leviten");
        this.hechizos.add(wingardiumLeviosa);

    }

    public void inicializarTransportes() {

        TrenExpresoHogwarts trenExpresoHogwarts = new TrenExpresoHogwarts("Tren Expreso de Hogwarts",
                "Tren magico que transporta a los estudiantes a Hogwarts");
        this.transportes.add(trenExpresoHogwarts);
    }

    public void inicializarPersonajes() {

        Wizard harryPotter = new Wizard("Harry Potter", 17, this.poderes.get(0), false);
        this.personajes.add(harryPotter);

        Wizard hermioneGranger = new Wizard("Hermione Granger", 18, this.poderes.get(1), false);
        this.personajes.add(hermioneGranger);

        Wizard albusDumbledore = new Wizard("Albus Dumbledore", 116, this.poderes.get(2), false);
        this.personajes.add(albusDumbledore);

        Wizard lordVoldemort = new Wizard("Lord Voldemort", 71, this.poderes.get(2), true);
        this.personajes.add(lordVoldemort);

        Wizard bellatrixLestrange = new Wizard("Bellatrix Lestrange", 46, this.poderes.get(2), true);
        this.personajes.add(bellatrixLestrange);

        Wizard ronWeasly = new Wizard("Ron Weasly", 17,  this.poderes.get(0), false);
        this.personajes.add(ronWeasly);

        Wizard severusSnape = new Wizard("Severus Snape", 37, this.poderes.get(2), false);
        this.personajes.add(severusSnape);

        Wizard siriusBlack = new Wizard("Sirius Black", 38, this.poderes.get(1), false);
        this.personajes.add(siriusBlack);

        Wizard remusLupin = new Wizard("Remus Lupin", 37, this.poderes.get(2), false);
        this.personajes.add(remusLupin);

        Wizard dracoMalfoy = new Wizard("Draco Malfoy", 17,  this.poderes.get(0), false);
        this.personajes.add(dracoMalfoy);

        Muggle dudleyDursley = new Muggle("Dudley Dursley", 17);
        this.personajes.add(dudleyDursley);

        Muggle vernonDursley = new Muggle("Vernon Dursley", 42);
        this.personajes.add(vernonDursley);

        Muggle petuniaDursley = new Muggle("Petunia Dursley", 40);
        this.personajes.add(petuniaDursley);

        Elfo dobby = new Elfo("Dobby", 9);
        this.personajes.add(dobby);

        Elfo kreacher = new Elfo("Kreacher", 666);
        this.personajes.add(kreacher);

        Elfo winky = new Elfo("Winky", 60);
        this.personajes.add(winky);

        }

    public void jugar() {
        System.out.println("");
        System.out.println("Es hora de que ...");
        System.out.println("");
        System.out.println(" (ง︡'-'︠)ง ¡COMIENCE EL DUELO! ");
        System.out.println("");

        Personaje personajeAtacante;
        Personaje personajeOponente;

        boolean turnoP1 = true;

        while (this.getJugadores().get(0).getPersonajeElegido().estaVivo() == true
                && this.getJugadores().get(1).getPersonajeElegido().estaVivo() == true) {

            if (turnoP1) {
                personajeAtacante = this.getJugadores().get(0).getPersonajeElegido();
                personajeOponente = this.getJugadores().get(1).getPersonajeElegido();
            } else {
                personajeAtacante = this.getJugadores().get(1).getPersonajeElegido();
                personajeOponente = this.getJugadores().get(0).getPersonajeElegido();
            }

            if (personajeAtacante instanceof Muggle && personajeOponente instanceof Muggle){
                System.out.println("");
                System.out.println("¿Una pelea entre 2 Muggles? ¡ESO NO ES POSIBLE!");
                break;
            } else if (personajeAtacante instanceof Wizard) {
                Hechizo hechizoParaAtacar = this.seleccionarHechizoParaAtacar();
                ((Wizard) personajeAtacante).aprender(hechizoParaAtacar);
                ((Wizard) personajeAtacante).atacar(personajeOponente, hechizoParaAtacar.getNombre());
                ((Wizard) personajeAtacante).atacar(personajeOponente, hechizoParaAtacar);
            } else if (personajeAtacante instanceof Elfo) {
                Hechizo hechizoParaAtacar = this.seleccionarHechizoParaAtacar();
                ((Elfo) personajeAtacante).aprender(hechizoParaAtacar);
                ((Elfo) personajeAtacante).atacar(personajeOponente, hechizoParaAtacar.getNombre());
                ((Elfo) personajeAtacante).atacar(personajeOponente, hechizoParaAtacar);
            } else {
                System.out.println("");
                System.out.println(
                        "¡El personaje elegido no posee habilidades mágicas! Lo siento pero no puedes atacar.");
                System.out.println("");
            }

            turnoP1 = !turnoP1;
        }
    }

    public Hechizo seleccionarHechizoParaAtacar() {
        System.out.println("");
        System.out.println("♡ Seleccione el número de hechizo que desea aprender y utilizar:");
        System.out.println("");
        int contador = 1;
        for (Hechizo hechizo : this.hechizos) {
            System.out.println(contador + ") " + hechizo.getNombre());
            contador++;
        }
        int nroHechizo = Teclado.nextInt();
        Teclado.nextLine();
        nroHechizo--;
        Hechizo hechizoElegido = this.hechizos.get(nroHechizo);

        return hechizoElegido;
    }

    public void mostrarGanador() {
        System.out.println("");
        System.out.println(" |    ¡GAME OVER!      |");
        System.out.println("");

        if (this.getJugadores().get(0).getPersonajeElegido().getSalud() > 0) {
            System.out.println("");
            System.out.println("ʕ•́ᴥ•̀ʔっ  " + this.getJugadores().get(0).getNombreJugador() + " es el ganador!!!");
            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("ʕ•́ᴥ•̀ʔっ  " + this.getJugadores().get(1).getNombreJugador() + " es el ganador!!!");
            System.out.println("");
        }
    }

}