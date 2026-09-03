package central.pacientes.estructura;

import central.pacientes.modelo.Nodo;
import central.pacientes.modelo.Paciente;

public class ListaPacientes {

    // atributos
    private Nodo cabeza;

    // constructor
    public ListaPacientes() {
        this.cabeza = null;
    }

    // metodos
    public boolean estaVacia() {
        if (cabeza == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean agregar(Paciente paciente) {
        if (buscarPorId(paciente.getId()) != null) {
            return false;
        }

        Nodo nuevo = new Nodo(paciente);

        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        return true;
    }

    public Paciente buscarPorId(int id) {
        Nodo actual = cabeza;

        while (actual != null) {
            if (actual.getPaciente().getId() == id) {
                return actual.getPaciente();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    public boolean eliminar(int id) {
        if (cabeza == null) {
            return false;
        }

        if (cabeza.getPaciente().getId() == id) {
            cabeza = cabeza.getSiguiente();
            return true;
        }

        Nodo anterior = cabeza;
        Nodo actual = cabeza.getSiguiente();

        while (actual != null) {
            if (actual.getPaciente().getId() == id) {
                anterior.setSiguiente(actual.getSiguiente());
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void mostrarTodos() {
        if (cabeza == null) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        Nodo actual = cabeza;
        int posicion = 1;

        while (actual != null) {
            System.out.println(posicion + ") " + actual.getPaciente());
            actual = actual.getSiguiente();
            posicion++;
        }
    }
}
