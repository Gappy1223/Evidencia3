import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private Integer edad;
    private ArrayList<Materia> calificaciones = new ArrayList<>();

    public Estudiante(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public ArrayList<Materia> getCalificaciones() {
        return calificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void agregarCalificacion(String nomMat, Double calificacion) throws CalificacionInvalidaExceptiom{
        if(calificacion > 100 || calificacion < 0){
            throw new CalificacionInvalidaExceptiom("Solo se aceptan calificaciones del 0 al 100");
        }

        calificaciones.add(new Materia(nomMat, calificacion));
    }

    public double Promedio(){
        Double suma = 0d;
        for (Materia materia: calificaciones){
            suma += materia.getCalificacion();
        }
        return suma / calificaciones.size();
    }

    public void mostrarInformacion(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Calificaciones:");
        for (Materia materia : calificaciones) {
            System.out.println("  - " + materia);
        }
        System.out.print("Promedio: " + Promedio());
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre + " Edad: " + edad + " Promedio: " + Promedio();
    }
}