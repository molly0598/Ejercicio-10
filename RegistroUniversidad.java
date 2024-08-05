public class RegistroUniversidad {
    private int idInscripcion;
    private String nombreCompleto;
    private double valorPatrimonio;
    private int nivelEstrato;

    public RegistroUniversidad(int idInscripcion, String nombreCompleto, double valorPatrimonio, int nivelEstrato) {
        this.idInscripcion = idInscripcion;
        this.nombreCompleto = nombreCompleto;
        this.valorPatrimonio = valorPatrimonio;
        this.nivelEstrato = nivelEstrato;
    }

    public double calcularValorMatricula() {
        double baseMatricula = 50000;
        double valorMatricula = baseMatricula;

        if (valorPatrimonio > 2000000 && nivelEstrato > 3) {
            double incremento = 0.03 * valorPatrimonio;
            valorMatricula += incremento;
        }

        return valorMatricula;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
}