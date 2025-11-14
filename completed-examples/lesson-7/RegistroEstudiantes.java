// Lección 7: Proyecto Final - Sistema de Registro de Estudiantes
// Aplicación completa usando Programación Orientada a Objetos
// Java 25 - Compatible con Replit, JDoodle, OnlineGDB

import java.util.ArrayList;
import java.util.Scanner;

public class RegistroEstudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

        System.out.println("========================================");
        System.out.println("   SISTEMA DE REGISTRO DE ESTUDIANTES   ");
        System.out.println("========================================\n");

        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            System.out.print("Selecciona una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarEstudiante(scanner, listaEstudiantes);
                    break;

                case 2:
                    mostrarTodosEstudiantes(listaEstudiantes);
                    break;

                case 3:
                    buscarEstudiante(scanner, listaEstudiantes);
                    break;

                case 4:
                    calcularPromedioGeneral(listaEstudiantes);
                    break;

                case 5:
                    System.out.println("\nGracias por usar el sistema. Adios!");
                    continuar = false;
                    break;

                default:
                    System.out.println("\nOpcion invalida. Intenta de nuevo.\n");
            }
        }

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Registrar nuevo estudiante");
        System.out.println("2. Mostrar todos los estudiantes");
        System.out.println("3. Buscar estudiante por nombre");
        System.out.println("4. Calcular promedio general");
        System.out.println("5. Salir");
        System.out.println("----------------------");
    }

    public static void registrarEstudiante(Scanner scanner, ArrayList<Estudiante> lista) {
        System.out.println("\n--- REGISTRAR NUEVO ESTUDIANTE ---");

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = scanner.nextInt();

        System.out.print("Nota (0-20): ");
        double nota = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer

        Estudiante nuevoEstudiante = new Estudiante(nombre, edad, nota);
        lista.add(nuevoEstudiante);

        System.out.println("\nEstudiante registrado exitosamente!");
    }

    public static void mostrarTodosEstudiantes(ArrayList<Estudiante> lista) {
        System.out.println("\n--- LISTA DE ESTUDIANTES ---");

        if (lista.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        System.out.println("Total de estudiantes: " + lista.size());
        System.out.println("----------------------------");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println("\nEstudiante #" + (i + 1));
            lista.get(i).mostrarInfo();
        }
    }

    public static void buscarEstudiante(Scanner scanner, ArrayList<Estudiante> lista) {
        System.out.println("\n--- BUSCAR ESTUDIANTE ---");

        if (lista.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        System.out.print("Ingresa el nombre a buscar: ");
        String nombreBuscar = scanner.nextLine();

        boolean encontrado = false;

        for (Estudiante est : lista) {
            if (est.getNombre().toLowerCase().contains(nombreBuscar.toLowerCase())) {
                System.out.println("\nEstudiante encontrado:");
                est.mostrarInfo();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("\nNo se encontro ningun estudiante con ese nombre.");
        }
    }

    public static void calcularPromedioGeneral(ArrayList<Estudiante> lista) {
        System.out.println("\n--- ESTADISTICAS GENERALES ---");

        if (lista.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        double sumaNotas = 0;
        int aprobados = 0;
        int desaprobados = 0;

        for (Estudiante est : lista) {
            sumaNotas += est.getNota();
            if (est.aprobo()) {
                aprobados++;
            } else {
                desaprobados++;
            }
        }

        double promedioGeneral = sumaNotas / lista.size();

        System.out.println("Total de estudiantes: " + lista.size());
        System.out.println("Promedio general: " + String.format("%.2f", promedioGeneral));
        System.out.println("Estudiantes aprobados: " + aprobados);
        System.out.println("Estudiantes desaprobados: " + desaprobados);
        System.out.println("Porcentaje de aprobacion: " +
            String.format("%.1f", (aprobados * 100.0 / lista.size())) + "%");
    }
}

/**
 * Clase Estudiante - Representa a un estudiante con sus datos básicos
 * Incluye encapsulación mediante atributos privados y métodos públicos
 */
class Estudiante {
    // Atributos privados (encapsulación)
    private String nombre;
    private int edad;
    private double nota;

    /**
     * Constructor - Inicializa un nuevo estudiante con sus datos
     * @param nombre Nombre completo del estudiante
     * @param edad Edad del estudiante
     * @param nota Nota del estudiante (0-20)
     */
    public Estudiante(String nombre, int edad, double nota) {
        this.nombre = nombre;
        this.edad = edad;
        setNota(nota); // Usar setter para validación
    }

    // Getters - Métodos para obtener los valores de los atributos

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getNota() {
        return nota;
    }

    // Setters - Métodos para modificar los valores con validación

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public void setEdad(int edad) {
        if (edad > 0 && edad < 100) {
            this.edad = edad;
        }
    }

    public void setNota(double nota) {
        if (nota >= 0 && nota <= 20) {
            this.nota = nota;
        } else {
            this.nota = 0; // Valor por defecto si la nota es inválida
        }
    }

    /**
     * Muestra la información completa del estudiante
     */
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " anos");
        System.out.println("Nota: " + nota);
        System.out.println("Estado: " + (aprobo() ? "APROBADO" : "DESAPROBADO"));
    }

    /**
     * Verifica si el estudiante aprobó
     * @return true si la nota es mayor o igual a 13, false en caso contrario
     */
    public boolean aprobo() {
        return nota >= 13.0;
    }

    /**
     * Retorna una representación en texto del estudiante
     * @return String con los datos del estudiante
     */
    @Override
    public String toString() {
        return "Estudiante{" +
               "nombre='" + nombre + '\'' +
               ", edad=" + edad +
               ", nota=" + nota +
               '}';
    }
}