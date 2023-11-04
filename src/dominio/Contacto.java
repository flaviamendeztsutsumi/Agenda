
package dominio;
import java.io.Serializable;
public class Contacto implements Serializable{
    private String nombre;
    private int numTelefono;

    public Contacto(String nombre_,int numTelefono_) {
        nombre = nombre_;
        numTelefono = numTelefono_;
    }
    public String toString(){
        return "Contacto: "+ nombre+" numero de Telefono: "+numTelefono+" Agenda\n";
    }

    public int getNumagentatotal() {
        return numTelefono;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }
    public boolean equals(Object obj){
        Contacto c = (Contacto)obj;
        return nombre.equals(c.nombre);

    }

    public Contacto(String nombre_) {
        nombre = nombre_;
    }

} 

