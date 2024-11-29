import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws EntradaInvalida{
        Universidad universidad = new Universidad();
        Scanner scanner = new Scanner(System.in);
        Integer opcion = 0;
        String nombre;
        Integer edad;
        Integer numMat;
        String nomMat;
        Double calificacion;
        String ruta;
        try{
          do{
              try {
                  System.out.println("\nMenú");
                  System.out.println("1. Agregar un estudiante \n2. Buscar un alumno \n3. Mostrar estudiantes \n4. Leer archivo \n5. Guardar progreso \n6. Salir");
                  opcion = leerEntero(scanner, "Elige: ");

                  switch (opcion){
                      case 1:
                          nombre = leerCadena(scanner, "Ingresa nombre del estudiante: ");
                          if(universidad.checarEstudiante(nombre)){
                              System.out.println("Ya esta registrado un estudiante con ese nombre");
                              nombre = leerCadena(scanner, "Ingrese otro nombre del estudiante: ");
                          }
                          scanner.nextLine();
                          edad = leerEntero(scanner, "Ingresa edad del alumno: ");
                          if(edad<= 0){
                              throw new EntradaInvalida("Solo edades positivas");
                          }
                          Estudiante estudiante = new Estudiante(nombre, edad);
                          numMat = leerEntero(scanner, "Ingresa el numero de materias: ");
                          for(int i = 0; i < numMat; i++){
                              nomMat = leerCadena(scanner, "Ingresa nombre de la materia: ");

                              try {
                                  calificacion = leerDouble(scanner, "Ingresa la calificación (1-100): ");
                                  estudiante.agregarCalificacion(nomMat, calificacion);

                              } catch (InputMismatchException e) {
                                  System.out.println("Error: Solo se aceptan números para la calificación.");
                                  scanner.next();
                              } catch (CalificacionInvalidaExceptiom e) {
                                  throw new RuntimeException(e);
                              }

                          }
                          universidad.agregarEstudiante(estudiante);
                          break;
                      case 2:
                          nombre = leerCadena(scanner,"Ingresa nombre del estudiante: ");
                          Estudiante estudianteBuscar = universidad.buscarEstudiante(nombre);
                          if (estudianteBuscar != null) {
                              estudianteBuscar.mostrarInformacion();
                          } else {
                              System.out.println("Estudiante no encontrado.");
                          }
                          break;
                      case 3:
                          universidad.mostrarEstudiante();
                          break;
                      case 4:
                          System.out.print("Ingresa ruta del archivo: ");
                          ruta = scanner.next();
                          universidad.leerArchivo(ruta);
                          break;
                      case 5:
                          System.out.print("Ingresa ruta del archivo para guardar: ");
                          ruta = scanner.next();
                          universidad.guardarArchivo(ruta);
                          break;
                      case 6:
                          System.out.println("Saliendo...");
                          break;
                      default:
                          System.out.println("Intenta de nuevo: ");
                          break;
                  }
              } catch (InputMismatchException e) {
                  System.out.println("Solo se permiten números dentro del rango.");
                  scanner.next(); // Limpiar el buffer
              }


          } while (opcion != 6);


        } catch (FileNotFoundException e) {
            System.out.println("No se puede utilizar/ubicar el archivo: " + e);
        }  catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("----------------------------------");
            scanner.close();
        }

    }

    private static Integer leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Solo se permiten números enteros. Intenta de nuevo.");
                scanner.next(); // Limpiar el buffer
            }
        }
    }

    private static Double leerDouble(Scanner scanner, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Error: Solo se permiten números positivos. Intenta de nuevo.");
                scanner.next(); // Limpiar el buffer
            }
        }
    }

    private static String leerCadena(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.next();
            if (entrada.matches("[a-zA-Z ]+")) {
                return entrada;
            } else {
                System.out.println("Error: Solo se permiten letras. Intenta de nuevo.");
            }
        }
    }
    }