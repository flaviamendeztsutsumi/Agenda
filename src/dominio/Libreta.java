package dominio;
import java.util.ArrayList;
import java.io.Serializable;
public class Libreta implements Serializable{
    private String nombre;
    private ArrayList<Contacto> contactos;
 
    public Libreta(String nombre_) {
        nombre=nombre_;
        contactos=new ArrayList<Contacto>();
    }
    public Libreta add(Contacto contacto){
        contactos.add(contacto);
        return this;
    }
    public int getNumagentatotal(){
        int Numagentatotal=0;
        for(Contacto contacto:contactos){
            Numagentatotal+=contacto.getNumagentatotal();
        }
        return Numagentatotal;
    }
    public int getContactos(){
        return contactos.size();
    }
    public Contacto getContacto(int i){
        return contactos.get(i);
    }
    public String toString(){
        return "Libreta: "+nombre+" Numagentatotal: "+getNumagentatotal() +" agenda\n"+contactos.toString()+"\n";
    }
 
    public String getNombre() {
        return nombre;
    }
    public Libreta borrar (Contacto c){
        contactos.remove (c);
        return this;
    }
   
}