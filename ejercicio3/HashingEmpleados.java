


package ejercicio3;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class HashingEmpleados {
    public static void main(String[] args) {
        String archivoEmpleados = "EMPLEADO.TXT";
        int cantidadEmpleados = obtenerCantidadEmpleados(archivoEmpleados);
        Empleado[] tablaHash = new Empleado[cantidadEmpleados];
        dispersarEmpleados(archivoEmpleados, tablaHash);
        mostrarTablaHash(tablaHash);
    }
    private static int obtenerCantidadEmpleados(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String primeraLinea = br.readLine();
            return Integer.parseInt(primeraLinea);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
    private static void dispersarEmpleados(String archivo, Empleado[] tablaHash) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            br.readLine(); // Leer y descartar la primera línea (cantidad de empleados)
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int codigo = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String direccion = datos[2];
                Empleado empleado = new Empleado(codigo, nombre, direccion);
                int direccionHash = calcularDireccionHash(codigo, tablaHash.length);
                insertarEmpleado(tablaHash, direccionHash, empleado);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }   
    static int calcularDireccionHash(int codigo, int tablaSize) {
        return codigo % tablaSize;
    }
    static void insertarEmpleado(Empleado[] tablaHash, int direccionHash, Empleado empleado) {
        if (tablaHash[direccionHash] == null) {
            tablaHash[direccionHash] = new EmpleadoLista(empleado);
        } else {
            EmpleadoLista lista = (EmpleadoLista) tablaHash[direccionHash];
            lista.insertar(empleado);
        }
    }
    private static void mostrarTablaHash(Empleado[] tablaHash) {
        System.out.println("Tabla Hash:");
        for (int i = 0; i < tablaHash.length; i++) {
            System.out.println("Dirección Hash: " + i);
            if (tablaHash[i] != null) {
                EmpleadoLista lista = (EmpleadoLista) tablaHash[i];
                lista.mostrarLista();
            } else {
                System.out.println("Lista vacía");
            }
            System.out.println();
        }
    }
    static class Empleado {
        private int codigo;
        private String nombre;
        private String direccion;

        public Empleado(int codigo, String nombre, String direccion) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.direccion = direccion;
        }
        public int getCodigo() {
            return codigo;
        }   
        public String getNombre() {
            return nombre;
        }
        public String getDireccion() {
            return direccion;
        }
        @Override
        public String toString() {
            return nombre + ", " + direccion;
        }
    }
    static class EmpleadoLista extends Empleado {
        private EmpleadoLista siguiente;
        public EmpleadoLista(Empleado empleado) {
            super(empleado.getCodigo(), empleado.getNombre(), empleado.getDireccion());
            this.siguiente = null;
        }
        public void insertar(Empleado empleado) {
            if (siguiente == null) {
                siguiente = new EmpleadoLista(empleado);
            } else {
                siguiente.insertar(empleado);
            }
        }
        public void mostrarLista() {
            System.out.println(this.toString());
            if (siguiente != null) {
                siguiente.mostrarLista();
            }
        }
    }
}
