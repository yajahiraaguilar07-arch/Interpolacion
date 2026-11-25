package interpolacion;

public class DiferenciasDivididasNewton {

    public static double[][] construirTablaDiferenciasDivididas(double[] x, double[] y) {
        int n = x.length;
        double[][] tabla = new double[n][n];

        for (int i = 0; i < n; i++) {
            tabla[i][0] = y[i];
        }

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                tabla[i][j] = (tabla[i + 1][j - 1] - tabla[i][j - 1]) / (x[i + j] - x[i]);
            }
        }

        return tabla;
    }

    public static double evaluarNewton(double[] x, double[][] tabla, double xEval) {
        int n = x.length;
        double resultado = tabla[0][n - 1];

        for (int k = n - 2; k >= 0; k--) {
            resultado = resultado * (xEval - x[k]) + tabla[0][k];
        }

        return resultado;
    }

    public static void imprimirTablaDiferenciasDivididas(double[] x, double[][] tabla) {
        int n = x.length;
        System.out.println("=== MATRIZ DE DIFERENCIAS DIVIDIDAS DE NEWTON ===");
        for (int i = 0; i < n; i++) {
            System.out.printf("x[%d]=%6.2f | ", i, x[i]);
            for (int j = 0; j < n - i; j++) {
                System.out.printf("%10.4f ", tabla[i][j]);
            }
            System.out.println();
        }
    }
}
