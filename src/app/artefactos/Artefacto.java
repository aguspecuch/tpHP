package app.artefactos;

public abstract class Artefacto {
    
    private String nombre;
    private double amplificadorDeDanio;
    private double amplificadorDeCuracion;
    private Poder poder;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getAmplificadorDeDanio(){
        return this.amplificadorDeDanio;
    }

    public void setAmplificadorDeDanio(double amplificadorDeDanio){
        this.amplificadorDeDanio = amplificadorDeDanio;
    }

    public double getAmplificadorDeCuracion(){
        return this.amplificadorDeCuracion;
    }

    public void setAmplificadorDeCuracion(double amplificadorDeCuracion){
        this.amplificadorDeCuracion = amplificadorDeCuracion;
    }

    public Poder getPoder(){
        return this.poder;
    }

    public void setPoder(Poder poder){
        this.poder = poder;
    }


}
