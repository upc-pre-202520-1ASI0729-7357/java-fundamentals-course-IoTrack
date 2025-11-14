// Lección 7: Proyecto Final - Sistema de Registro de Estudiantes
// Objetivo: Crear una aplicación completa usando conceptos de POO
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
                    // TODO: Implementar registrar nuevo estudiante
                    // Pedir nombre, edad, y nota
                    // Crear objeto Estudiante y agregarlo a listaEstudiantes

                    break;

                case 2:
                    // TODO: Implementar mostrar todos los estudiantes
                    // Recorrer listaEstudiantes y mostrar info de cada uno

                    break;

                case 3:
                    // TODO: Implementar buscar estudiante por nombre

                    break;

                case 4:
                    // TODO: Implementar calcular promedio general

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
}

// TODO: Completa la clase Estudiante
class Estudiante {
    // Atributos privados
    private String nombre;
    private int edad;
    private double nota;

    // TODO: Constructor


    // TODO: Getters


    // TODO: Setters


    // TODO: Método para mostrar información


    // TODO: Método para verificar si aprobó (nota >= 13)

}