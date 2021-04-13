package app.interfaces;

public interface IHaceMagia {

    void setEnergiaMagica(int energiaMagica);

    int getEnergiaMagica();

    void setPoder(Poder poder);

    Poder getPoderInicial();

    Artefacto getArtefacto();

    void aprenderHechizo(Hechizo hechizo);

    void atacar(Personaje personaje, Hechizo hechizo);

    void atacar(Personaje personaje, String hechizo);

}