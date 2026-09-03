package central.pacientes.modelo;

public class Paciente {

    // atributos
    private int id;
    private String nombre;
    private int edad;
    private String clinica;

    // constructor
    public Paciente(int id, String nombre, int edad, String clinica) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.clinica = clinica;
    }

    // getters y setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    // toString
    public String toString() {
        return "ID: " + id
                + " | Nombre: " + nombre
                + " | Edad: " + edad
                + " | Clinica: " + clinica;
    }
}