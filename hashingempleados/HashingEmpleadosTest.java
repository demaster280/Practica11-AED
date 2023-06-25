

package hashingempleados;
import java.util.Arrays;
public class HashingEmpleadosTest {
    public static void main(String[] args) {
        // Crear una tabla hash de tamaño 13 para el ejemplo
        HashingEmpleados.Empleado[] tablaHash = new HashingEmpleados.Empleado[13];
        // Crear algunos empleados de prueba
        HashingEmpleados.Empleado empleado1 = new HashingEmpleados.Empleado(1001, "Juan", "Calle A");
        HashingEmpleados.Empleado empleado2 = new HashingEmpleados.Empleado(2002, "Maria", "Calle B");
        HashingEmpleados.Empleado empleado3 = new HashingEmpleados.Empleado(3003, "Pedro", "Calle C");
        HashingEmpleados.Empleado empleado4 = new HashingEmpleados.Empleado(4004, "Ana", "Calle D");
        // Calcular la dirección hash y buscar posición para cada empleado
        int direccionHash1 = HashingEmpleados.calcularDireccionHash(empleado1.getCodigo(), tablaHash.length);
        int posicion1 = HashingEmpleados.buscarPosicionDisponible(tablaHash, direccionHash1);
        int direccionHash2 = HashingEmpleados.calcularDireccionHash(empleado2.getCodigo(), tablaHash.length);
        int posicion2 = HashingEmpleados.buscarPosicionDisponible(tablaHash, direccionHash2);
        int direccionHash3 = HashingEmpleados.calcularDireccionHash(empleado3.getCodigo(), tablaHash.length);
        int posicion3 = HashingEmpleados.buscarPosicionDisponible(tablaHash, direccionHash3);
        int direccionHash4 = HashingEmpleados.calcularDireccionHash(empleado4.getCodigo(), tablaHash.length);
        int posicion4 = HashingEmpleados.buscarPosicionDisponible(tablaHash, direccionHash4);
        // Almacenar los empleados en la tabla hash
        tablaHash[posicion1] = empleado1;
        tablaHash[posicion2] = empleado2;
        tablaHash[posicion3] = empleado3;
        tablaHash[posicion4] = empleado4;
        // Mostrar la tabla hash resultante
        mostrarTablaHash(tablaHash);
    }
    
    
    
    private static void mostrarTablaHash(HashingEmpleados.Empleado[] tablaHash) {
        System.out.println("Tabla Hash:");
        System.out.println("Direccion Hash\tDireccion Real\tEmpleado\tLongitud de Busqueda");
        for (int i = 0; i < tablaHash.length; i++) {
            HashingEmpleados.Empleado empleado = tablaHash[i];
            if (empleado != null) {
                int direccionHash = HashingEmpleados.calcularDireccionHash(empleado.getCodigo(), tablaHash.length);
                int longitudBusqueda = HashingEmpleados.calcularLongitudBusqueda(tablaHash, direccionHash, i);
                System.out.println(direccionHash + "\t\t\t" + i + "\t\t\t" + empleado.toString() + "\t\t\t" + longitudBusqueda);
            }
        }
    }
}

