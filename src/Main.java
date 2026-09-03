package central.pacientes;

import central.pacientes.estructura.ListaPacientes;
import central.pacientes.modelo.Paciente;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListaPacientes pacientes = new ListaPacientes();

        int opcion = 0;

        // el menu se repite hasta que el usuario elija salir (opcion 6)
        while (opcion != 6) {
            System.out.println();
            System.out.println("******** CENTRAL DE PACIENTES ********");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Buscar paciente por ID");
            System.out.println("3. Modificar paciente");
            System.out.println("4. Eliminar paciente");
            System.out.println("5. Mostrar todos los pacientes");
            System.out.println("6. Salir");
            System.out.print("Elija una opcion: ");

            opcion = leerEntero(sc);

            if (opcion == 1) {
                registrarPaciente(sc, pacientes);
            } else if (opcion == 2) {
                buscarPaciente(sc, pacientes);
            } else if (opcion == 3) {
                modificarPaciente(sc, pacientes);
            } else if (opcion == 4) {
                eliminarPaciente(sc, pacientes);
            } else if (opcion == 5) {
                pacientes.mostrarTodos();
            } else if (opcion == 6) {
                System.out.println("Saliendo del sistema. Hasta luego.");
            } else {
                System.out.println("Opcion no valida. Digite una de las mencionadas anteriormente.");
            }
        }

        sc.close();
    }

    /*
     * Opcion 1: pide los datos y agrega el paciente a la lista.
     */
    private static void registrarPaciente(Scanner sc, ListaPacientes pacientes) {
        System.out.println("--- Registrar paciente ---");

        System.out.print("ID (numero unico): ");
        int id = leerEntero(sc);

        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();

        System.out.print("Edad: ");
        int edad = leerEntero(sc);

        System.out.print("Clinica: ");
        String clinica = sc.nextLine().trim();

        Paciente nuevo = new Paciente(id, nombre, edad, clinica);
        boolean agregado = pacientes.agregar(nuevo);

        if (agregado) {
            System.out.println("Paciente registrado correctamente.");
        } else {
            System.out.println("Ya existe un paciente con el ID " + id + ".");
        }
    }

    /*
     * Opcion 2: busca un paciente por su ID y muestra sus datos.
     */
    private static void buscarPaciente(Scanner sc, ListaPacientes pacientes) {
        System.out.println("--- Buscar paciente ---");
        System.out.print("ID a buscar: ");
        int id = leerEntero(sc);

        Paciente encontrado = pacientes.buscarPorId(id);

        if (encontrado != null) {
            System.out.println("Paciente encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("No existe un paciente con el ID " + id + ".");
        }
    }

    /*
     * Opcion 3: modifica el nombre, la edad o la clinica de un paciente.
     */
    private static void modificarPaciente(Scanner sc, ListaPacientes pacientes) {
        System.out.println("--- Modificar paciente ---");
        System.out.print("ID del paciente a modificar: ");
        int id = leerEntero(sc);

        Paciente paciente = pacientes.buscarPorId(id);

        if (paciente == null) {
            System.out.println("No existe un paciente con el ID " + id + ".");
            return;
        }

        System.out.println("Datos actuales: " + paciente);
        System.out.print("Nuevo nombre (Enter para dejar igual): ");
        String nombre = sc.nextLine().trim();
        if (!nombre.isEmpty()) {
            paciente.setNombre(nombre);
        }

        System.out.print("Nueva edad (0 para dejar igual): ");
        int edad = leerEntero(sc);
        if (edad > 0) {
            paciente.setEdad(edad);
        }

        System.out.print("Nueva clinica (Enter para dejar igual): ");
        String clinica = sc.nextLine().trim();
        if (!clinica.isEmpty()) {
            paciente.setClinica(clinica);
        }

        System.out.println("Paciente actualizado: " + paciente);
    }

    /*
     * Opcion 4: elimina un paciente de la lista por su ID.
     */
    private static void eliminarPaciente(Scanner sc, ListaPacientes pacientes) {
        System.out.println("--- Eliminar paciente ---");
        System.out.print("ID del paciente a eliminar: ");
        int id = leerEntero(sc);

        boolean eliminado = pacientes.eliminar(id);

        if (eliminado) {
            System.out.println("Paciente eliminado correctamente.");
        } else {
            System.out.println("No existe un paciente con el ID " + id + ".");
        }
    }

    /*
     * Lee un numero entero desde el teclado.
     * Si el usuario escribe algo que no es un numero, devuelve -1
     * y limpia la linea para no bloquear el programa.
     */
    private static int leerEntero(Scanner sc) {
        if (!sc.hasNextLine()) {
            return 6; // no hay mas entrada: se interpreta como "Salir"
        }
        String texto = sc.nextLine().trim();

        if (texto.matches("-?\\d+")) {
            return Integer.parseInt(texto);
        } else {
            return -1;
        }
    }
}
