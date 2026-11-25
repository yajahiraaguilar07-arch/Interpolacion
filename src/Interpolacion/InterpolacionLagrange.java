package interpolacion;

public class InterpolacionLagrange {

    private static void validarDatos(double[] x, double[] y) {
        if (x == null || y == null || x.length == 0 || y.length == 0) {
            throw new IllegalArgumentException("Los arreglos x e y no pueden ser nulos o vacíos.");
        }
        if (x.length != y.length) {
            throw new IllegalArgumentException("Los arreglos x e y deben tener el mismo tamaño.");
        }
        for (int i = 0; i < x.length; i++) {
            for (int j = i + 1; j < x.length; j++) {
                if (Double.compare(x[i], x[j]) == 0) {
                    throw new IllegalArgumentException("Todos los valores de x deben ser distintos.");
                }
            }
        }
    }

    public static double interpolacionLagrange(double[] x, double[] y, double xEval) {
        validarDatos(x, y);
        double resultado = 0.0;
        int n = x.length;

        for (int i = 0; i < n; i++) {
            double termino = y[i];
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    termino *= (xEval - x[j]) / (x[i] - x[j]);
                }
            }
            resultado += termino;
        }

        return resultado;
    }
}
