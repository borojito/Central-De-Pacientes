# Central de Pacientes

Aplicación de consola en Java para administrar el registro de pacientes de una
central clínica. Permite registrar, consultar, modificar y eliminar pacientes,
almacenándolos en una lista enlazada simple).

- **Autora:** Stefania Borja
- **Universidad:** Universidad EAN
- **Asignatura:** Desarrollo de Software

## Descripción

El programa muestra un menú por consola con las operaciones básicas de un CRUD.
Cada paciente tiene un identificador único (`id`); si se intenta registrar un
`id` que ya existe, la operación se rechaza.

La estructura de datos es una lista enlazada propia, formada por nodos
(`Nodo`) que apuntan al siguiente elemento. Esto permite practicar el manejo
manual de referencias, recorridos y eliminación de nodos.

## Estructura del proyecto

```
CentralDePacientes/
├── README.md
└── src/
    ├── Main.java                 -> paquete central.pacientes (menú e interacción)
    ├── ListaPacientes.java       -> paquete central.pacientes.estructura (lista enlazada)
    └── model/
        ├── Paciente.java         -> paquete central.pacientes.modelo (entidad Paciente)
        └── Nodo.java             -> paquete central.pacientes.modelo (nodo de la lista)
```

### Clases

| Clase            | Responsabilidad                                                                 |
|------------------|--------------------------------------------------------------------------------|
| `Paciente`       | Modelo con los datos del paciente: `id`, `nombre`, `edad`, `clinica`.          |
| `Nodo`           | Contenedor de un `Paciente` y referencia al siguiente nodo.                    |
| `ListaPacientes` | Lista enlazada: `agregar`, `buscarPorId`, `eliminar`, `mostrarTodos`, `estaVacia`. |
| `Main`           | Punto de entrada. Dibuja el menú, lee la entrada del usuario y llama a la lista. |