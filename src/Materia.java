public class Materia {
    private String nomMat;
    private Double calificacion;

    public Materia(String nomMat, Double calificacion) {
        this.nomMat = nomMat;
        this.calificacion = calificacion;
    }

    public String getnomMat() {
        return nomMat;
    }

    public Double getCalificacion() {
        return calificacion;
    }

    @Override
    public String toString(){
        return "Materia: " + nomMat + " Calificación: " + calificacion;
    }

}
