


package hashingempleados;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class HashingEmpleados {
    private static final double LOAD_FACTOR = 1.4;
    public static void main(String[] args) {
        String archivoEmpleados = "EMPLEADO.TXT";
        int cantidadEmpleados = obtenerCantidadEmpleados(archivoEmpleados);
        int m = obtenerTamanioTabla(cantidadEmpleados);
        Empleado[] tablaHash = new Empleado[m];
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
    private static int obtenerTamanioTabla(int cantidadElementos) {
        int m = (int) (cantidadElementos * LOAD_FACTOR);
        while (!esPrimo(m)) {
            m++;
        }
        return m;
    }
    private static boolean esPrimo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
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
                int posicion = buscarPosicionDisponible(tablaHash, direccionHash);
                tablaHash[posicion] = empleado;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static int calcularDireccionHash(int codigo, int tablaSize) {
        return codigo % tablaSize;
    }
    static int buscarPosicionDisponible(Empleado[] tablaHash, int direccionHash) {
        int i = 0;
        int posicion = direccionHash;
        while (tablaHash[posicion] != null) {
            i++;
            posicion = (direccionHash + (i * i)) % tablaHash.length;
        }
        return posicion;
    }
    private static void mostrarTablaHash(Empleado[] tablaHash) {
        System.out.println("Tabla Hash:");
        System.out.println("Direccion Hash\tDireccion Real\tEmpleado\tLongitud de Busqueda");
        for (int i = 0; i < tablaHash.length; i++) {
            Empleado empleado = tablaHash[i];
            if (empleado != null) {
                int direccionHash = calcularDireccionHash(empleado.getCodigo(), tablaHash.length);
                int longitudBusqueda = calcularLongitudBusqueda(tablaHash, direccionHash, i);
                System.out.println(direccionHash + "\t\t\t" + i + "\t\t\t" + empleado.toString() + "\t\t\t" + longitudBusqueda);
            }
        }
    }
    static int calcularLongitudBusqueda(Empleado[] tablaHash, int direccionHash, int posicion) {
        int i = 0;
        int actual = (direccionHash + (i * i)) % tablaHash.length;
        while (actual != posicion && tablaHash[actual] != null) {
            i++;
            actual = (direccionHash + (i * i)) % tablaHash.length;
        }
        return i;
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
}
