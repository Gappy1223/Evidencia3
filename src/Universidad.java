import java.util.Map;

public class Universidad implements Imprimible{
    private Map<String, Estudiante> estudiantes;
    private Map<String, Materia> materias;

    public void agregarEstudiante(Estudiante estudiante){
        estudiantes.put(estudiante.getNombre(), estudiante.getEdad());
    }

    public void buscarEstudiante(){

    }

    public void mostrarEstudiante(){
    }

    public void leerArchivo(){

    }


    @Override
    public void imprimir() {

    }
}
