package presentacion;
import dominio.*;
import java.io.*;
import java.util.*;

public class Interfaz {
    private ArrayList<Contacto> contactos = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    Libreta libreta = new Libreta("Mi libreta personal");

    public boolean procesarPeticion(String peticion) {
        String[] p = peticion.split(" ");

        if (p.length == 1) {
            if (p[0].equals("addContacto")) {
                aniadirContacto();
            } else if (p[0].equals("read")) {
                leer();
            } else if (p[0].equals("list")) {
                mostrar();
            } else if (p[0].equals("actualizar")) {
                actualizar();
            } else if (p[0].equals("borrar")) {
                System.out.println("Introduzca el nombre del contacto a borrar:");
                String nombre = sc.nextLine();
                borrar(nombre);
            } else if (p[0].equals("help")) {
                System.out.println("introduzca una de las siguientes peticiones: \n addContacto: añadir contacto\n list: listar el contenido\n read: lectura inicial\n borrar: borrar contacto\n actualizar: actualizar contacto\n exit: salir\n");
            } else if (p[0].equals("exit")) {
                grabar();
                return false;
            } else {
                System.out.println("petición errónea");
                procesarPeticion("help");
            }
        } else {
            System.out.println("petición errónea");
            procesarPeticion("help");
        }

        return true;
    }

    public void aniadirContacto() {
        System.out.println("Introduzca el nombre del contacto:");
        String nombre = sc.nextLine();
        System.out.println("Introduzca el teléfono del contacto:");
        int telefono = sc.nextInt();
        sc.nextLine(); 
        Contacto contacto = new Contacto(nombre, telefono);
        contactos.add(contacto);
    }

    public void leer() {
        try {
            FileInputStream fis = new FileInputStream("contactos.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            contactos = (ArrayList<Contacto>) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo");
        }
    }

    public void mostrar() {
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    public void grabar() {
        try {
            FileOutputStream fos = new FileOutputStream("contactos.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contactos);
            oos.close();
        } catch (IOException e) {
            System.out.println("Error al grabar el archivo");
        }
    }

    public void borrar(String nombre) {
        Contacto contacto = buscarContacto(nombre);
        if (contacto != null) {
            contactos.remove(contacto);
            libreta.borrar(contacto);
            System.out.println("Contacto eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un contacto con ese nombre.");
        }
    }
    

    public void actualizar() {
        System.out.println("Introduzca el nombre del contacto a actualizar:");
        String nombre = sc.nextLine();
        Contacto contacto = buscarContacto(nombre);
        if (contacto != null) {
            System.out.println("Introduzca el nuevo nombre del contacto:");
            String nuevoNombre = sc.nextLine();
            System.out.println("Introduzca el nuevo teléfono del contacto:");
            int nuevoTelefono = sc.nextInt();
            sc.nextLine(); 
            contacto.setNombre(nuevoNombre);
            contacto.setNumTelefono(nuevoTelefono);
            System.out.println("Contacto actualizado exitosamente.");
        } else {
            System.out.println("No se encontró un contacto con ese nombre.");
        }
    }

    private Contacto buscarContacto(String nombre) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    public String leerPeticion() {
        System.out.print("?>");
        String cadena = sc.nextLine();
        return cadena;
    }
}
