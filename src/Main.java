import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer opcion;
        String nombre;
        Integer edad;
        String nomMat;
        Double calificacion;
        try{
          do{
              System.out.println("Menú");
              System.out.println("1. Agregar un estudiante \n2. Buscar un alumno \n3. Mostrar estudiantes \n4. Leer archivo \n5. Leer archivo");
              opcion = scanner.nextInt();

              switch (opcion){
                  case 1:
                      System.out.print("Ingresa nombre: ");
                      nombre = scanner.next();
                      System.out.print("Ingresa edad: ");
                      edad = scanner.nextInt();
                      Contacto contacto = new Contacto(nombre, telefono);
                      agenda.agregarContacto(contacto);
                      System.out.println("Contacto agregado");
                      break;
                  case 2:
                      System.out.print("Ingresa nombre que quiere buscar: ");
                      nombre = scanner.next();
                      Contacto contEnc = agenda.buscarContacto(nombre);
                      if(contEnc != null){
                          System.out.println("Contacto encontrado: " + contEnc);
                      }else {
                          System.out.println("No se encontró");
                      }
                      break;
                  case 3:
                      agenda.mostrarContacto();
                      break;
                  case 4:
                      agenda.mostrarContacto();
                      break;
                  case 5:
                      agenda.mostrarContacto();
                      break;
                  default:
                      System.out.println("Saliendo...");
                      break;
              }

          } while (opcion = 5);




        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}