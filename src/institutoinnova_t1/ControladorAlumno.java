/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package institutoinnova_t1;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author USUARIO
 */
public class ControladorAlumno {
     // Lista 
    private ArrayList<Alumno> alumnos;

    // Constructor
    public ControladorAlumno() {
        alumnos = new ArrayList<>();
    }

    // 
    public void agregarAlumno(Scanner scanner) {

        try {
            System.out.println("\nREGISTRAR ALUMNO");

            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Tipo de documento (DNI/RESIDENCIA): ");
            String tipoDocumento = scanner.nextLine();

            System.out.print("Número de documento: ");
            String numeroDocumento = scanner.nextLine();

            // Verificar si ya existe el documento
            if (existeDocumento(numeroDocumento)) {

                throw new IllegalArgumentException(
                        "Ya existe un alumno con ese numero de documento.");
            }

            System.out.print("Nivel socioeconómico (A/B/C): ");
            String nivelTexto = scanner.nextLine();

            if (nivelTexto.length() != 1) {

                throw new IllegalArgumentException(
                        "Debe ingresar solamente A, B o C.");
            }

            char nivel =
                    Character.toUpperCase(nivelTexto.charAt(0));

            System.out.print(
                    "Tipo de beca (NINGUNA/PARCIAL/TOTAL): ");

            String tipoBeca = scanner.nextLine();

            // Crear objeto Alumno
            Alumno alumno = new Alumno(
                    nombre,
                    tipoDocumento,
                    numeroDocumento,
                    nivel,
                    tipoBeca
            );

            // Agregar a la lista
            alumnos.add(alumno);

            System.out.println(
                    "\nAlumno registrado correctamente.");

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "\nError: " + e.getMessage());

        } catch (Exception e) {

            System.out.println(
                    "\nOcurrió un error inesperado.");
        }
    }

    //verificar documentos repetidos
    private boolean existeDocumento(String numeroDocumento) {
        for (Alumno alumno : alumnos) {

            if (alumno.getNumeroDocumento()
                    .equals(numeroDocumento)) {

                return true;
            }
        }
        return false;
    }

    //listar todos los alumnos
    public void listarAlumnos() {
        System.out.println("LISTA DE ALUMNOS");
        if (alumnos.isEmpty()) {
            System.out.println(
                    "No existen alumnos registrados.");
            return;
        }

        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    // Menu
    public void iniciarMenu(Scanner scanner) {
        int opcion = 0;
        do {
            System.out.println("1. Agregar alumno");
            System.out.println("2. Listar alumnos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(
                        scanner.nextLine());
                switch (opcion) {
                    case 1:
                        agregarAlumno(scanner);
                        break;
                    case 2:
                        listarAlumnos();
                        break;
                    case 3:
                        System.out.println(
                                "\nPrograma finalizado.");
                        break;
                    default:
                        System.out.println(
                                "\nOpción no válida.");
                }
            } catch (NumberFormatException e) {
                System.out.println(
                        "\nDebe ingresar un número.");
            }
        } while (opcion != 3);
    }
}
