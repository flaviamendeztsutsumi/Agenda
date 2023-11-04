
package aplicacion;
import dominio.*;
import presentacion.Interfaz;
import java.util.ArrayList;
import java.io.*;
public class Principal {
    public static void main(String[] args) {
        Interfaz interfaz=new Interfaz();
        String peticion;
        interfaz.procesarPeticion("help");
        do {
            peticion=interfaz.leerPeticion();
        } while (interfaz.procesarPeticion(peticion));
    }
}

