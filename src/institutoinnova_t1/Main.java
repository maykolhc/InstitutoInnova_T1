/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package institutoinnova_t1;
import java.util.Scanner;
/**
 *
 * @author USUARIO
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ControladorAlumno controlador = new ControladorAlumno();

        controlador.iniciarMenu(scanner);
        scanner.close();
    }
}
