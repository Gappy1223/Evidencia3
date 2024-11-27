import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Universidad universidad = new Universidad();
        Scanner scanner = new Scanner(System.in);
        Integer opcion;
        String nombre;
        Integer edad;
        Integer numMat;
        String nomMat;
        Double calificacion;
        String ruta;
        try{
          do{
              System.out.println("Menú");
              System.out.println("1. Agregar un estudiante \n2. Buscar un alumno \n3. Mostrar estudiantes \n4. Leer archivo \n5. Guardar progreso \n6. Salir");
              opcion = scanner.nextInt();

              switch (opcion){
                  case 1:
                      do {
                          try {
                              System.out.print("Ingresa nombre del estudiante: ");
                              nombre = scanner.next();
                              System.out.print("Ingresa edad del alumno: ");
                              edad = scanner.nextInt();
                              Estudiante estudiante = new Estudiante(nombre, edad);
                              System.out.print("Ingresa el numero de materias: ");
                              numMat = scanner.nextInt();
                              for(int i = 0; i < numMat; i++){
                                  System.out.print("Ingresa el nombre de la materia: ");
                                  nomMat = scanner.next();
                                  System.out.print("Ingresa la calificacion: ");
                                  calificacion = scanner.nextDouble();
                                  try{
                                      estudiante.agregarCalificacion(nomMat,calificacion);
                                  } catch (CalificacionInvalidaExceptiom e) {
                                      System.out.println("Error: " + e.getMessage());
                                  }
                              }
                              universidad.agregarEstudiante(estudiante);
                              break;
                          } catch (InputMismatchException e) {
                              System.out.println("La excepción es: " + e + " Solo puede utilizar números.");
                              scanner.next();
                          }
                      } while (true);
                      break;
                  case 2:
                      System.out.print("Ingresa nombre que quiere buscar: ");
                      nombre = scanner.next();
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
                  default:
                      System.out.println("Saliendo...");
                      break;
              }

          } while (opcion == 1||opcion == 2||opcion ==3||opcion == 4||opcion == 5);




        } catch (IllegalArgumentException e) {
            System.out.println("La excepción es: " + e);
        } catch (FileNotFoundException e) {
            System.out.println("No se puede utilizar/ubicar el archivo: " + e);
        } catch (InputMismatchException e) {
            System.out.println("La excepción es: " + e + " Solo puede utilizar números.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("----------------------------------");
            scanner.close();
        }

    }
}