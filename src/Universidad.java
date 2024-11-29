import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Universidad implements Imprimible{
    private HashMap<String, Estudiante> estudiantes;
    private HashMap<String, Materia> materias;

    public Universidad() {
        this.estudiantes = new HashMap<>();
        this.materias = new HashMap<>();
    }

    public HashMap<String, Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void agregarEstudiante(Estudiante estudiante){
        estudiantes.put(estudiante.getNombre(), estudiante);
    }

    public Estudiante buscarEstudiante(String nombre){
        return estudiantes.get(nombre);
    }

    public void mostrarEstudiante(){
        if (estudiantes.isEmpty()){
            System.out.println("No hay");
        } else{
            for(Estudiante estudiante : estudiantes.values()){
                estudiante.mostrarInformacion();
                System.out.println();
            }
        }
    }

    public boolean checarEstudiante(String nombre){
        for(Estudiante estudiante : estudiantes.values()){
            if (estudiante.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }

    public void leerArchivo(String ruta) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String nombre = datos[0];
                Integer edad = Integer.parseInt(datos[1]);
                Estudiante estudiante = new Estudiante(nombre, edad);
                for (int i = 2; i < datos.length; i++) { // Procesar materias y calificaciones
                    String[] materiaData = datos[i].split(":");
                    String nomMat = materiaData[0];
                    Double calificacion = Double.parseDouble(materiaData[1]);
                    estudiante.agregarCalificacion(nomMat, calificacion);
                }
                agregarEstudiante(estudiante);
            }
        } catch (CalificacionInvalidaExceptiom e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarArchivo(String rutaArchivo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Estudiante estudiante : estudiantes.values()) {
                bw.write(estudiante.getNombre() + "," + estudiante.getEdad());
                for (Materia materia : estudiante.getCalificaciones()) {
                    bw.write("," + materia.getnomMat() + ":" + materia.getCalificacion());
                }
                bw.write("\n");
            }
        }
    }

    @Override
    public void imprimir() {
        for(Estudiante estudiante : estudiantes.values()){
            estudiante.mostrarInformacion();
        }
    }
}
