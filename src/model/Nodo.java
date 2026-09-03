package central.pacientes.modelo;

public class Nodo {

    // atributos
    private Paciente paciente;
    private Nodo siguiente;

    // constructor
    public Nodo(Paciente paciente) {
        this.paciente = paciente;
        this.siguiente = null;
    }

    // getters y setters
    public Paciente getPaciente() {
        return paciente;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
