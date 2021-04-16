<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
public class Poder {
    
private List<String> poderes = new ArrayList<>();
private String nombreDelPoder;
private String descripcionDelPoder;
    
public List<String> getPoderes(){
    return poderes;
}

public void setPoderes(List <String> poderes){
    this.poderes = poderes;
}
=======
package app.poderes;

public abstract class Poder {

    private String nombre;
    private String descripcion;
>>>>>>> 8b912e4df3eebb4f2c01b82501f7e37b8670f3fb

public String getnombreDelPoder() {
    return nombreDelPoder;
}
public void setnombreDelPoder(String nombreDelPoder) {
        this.nombreDelPoder = nombreDelPoder;
    }

public String getdescripcionDelPoder(){
    return descripcionDelPoder;
}
public void setdescripcionDelPoder(String descripcionDelPoder){
    this.descripcionDelPoder = descripcionDelPoder;
}

}

}
