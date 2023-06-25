



package ejercicio3;
import java.util.Arrays;
public class HashingEmpleadosTest {
    public static void main(String[] args) {
        // Crear una tabla hash de tamaño 4 para el ejemplo
        HashingEmpleados.Empleado[] tablaHash = new HashingEmpleados.Empleado[4];
        // Crear algunos empleados de prueba
        HashingEmpleados.Empleado empleado1 = new HashingEmpleados.Empleado(1001, "Juan", "Calle A");
        HashingEmpleados.Empleado empleado2 = new HashingEmpleados.Empleado(2002, "Maria", "Calle B");
        HashingEmpleados.Empleado empleado3 = new HashingEmpleados.Empleado(3003, "Pedro", "Calle C");
        HashingEmpleados.Empleado empleado4 = new HashingEmpleados.Empleado(4004, "Ana", "Calle D");
        HashingEmpleados.Empleado empleado5 = new HashingEmpleados.Empleado(5005, "Luisa", "Calle E");
        // Calcular la dirección hash y insertar empleados en la tabla hash
        int direccionHash1 = HashingEmpleados.calcularDireccionHash(empleado1.getCodigo(), tablaHash.length);
        HashingEmpleados.insertarEmpleado(tablaHash, direccionHash1, empleado1);
        int direccionHash2 = HashingEmpleados.calcularDireccionHash(empleado2.getCodigo(), tablaHash.length);
        HashingEmpleados.insertarEmpleado(tablaHash, direccionHash2, empleado2);
        int direccionHash3 = HashingEmpleados.calcularDireccionHash(empleado3.getCodigo(), tablaHash.length);
        HashingEmpleados.insertarEmpleado(tablaHash, direccionHash3, empleado3);
        int direccionHash4 = HashingEmpleados.calcularDireccionHash(empleado4.getCodigo(), tablaHash.length);
        HashingEmpleados.insertarEmpleado(tablaHash, direccionHash4, empleado4);
        int direccionHash5 = HashingEmpleados.calcularDireccionHash(empleado5.getCodigo(), tablaHash.length);
        HashingEmpleados.insertarEmpleado(tablaHash, direccionHash5, empleado5);
        // Mostrar la tabla hash resultante
        mostrarTablaHash(tablaHash);
    }
    private static void mostrarTablaHash(HashingEmpleados.Empleado[] tablaHash) {
        System.out.println("Tabla Hash:");
        for (int i = 0; i < tablaHash.length; i++) {
            System.out.println("Dirección Hash: " + i);
            if (tablaHash[i] != null) {
                HashingEmpleados.EmpleadoLista lista = (HashingEmpleados.EmpleadoLista) tablaHash[i];
                lista.mostrarLista();
            } else {
                System.out.println("Lista vacía");
            }
            System.out.println();
        }
    }
}
