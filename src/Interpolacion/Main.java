package interpolacion;

public class Main {

    public static void main(String[] args) {

        // Datos de prueba
        double[] x = {1, 2, 3, 4};
        double[] y = {1, 4, 9, 16};

        // Punto a evaluar
        double xEval = 2.5;

        System.out.println("===== INTERPOLACION NUMERICA =====");
        System.out.println("Punto a evaluar: " + xEval);
        System.out.println();

        // Metodo de Lagrange
        double resultadoLagrange =
                InterpolacionLagrange.interpolacionLagrange(x, y, xEval);

        System.out.println("--- Metodo de Lagrange ---");
        System.out.println("Resultado: " + resultadoLagrange);
        System.out.println();

        // Metodo de Newton
        double[][] tabla =
                DiferenciasDivididasNewton.construirTablaDiferenciasDivididas(x, y);

        System.out.println("--- Metodo de Newton ---");
        DiferenciasDivididasNewton.imprimirTablaDiferenciasDivididas(x, tabla);

        double resultadoNewton =
                DiferenciasDivididasNewton.evaluarNewton(x, tabla, xEval);

        System.out.println();
        System.out.println("Resultado: " + resultadoNewton);
        System.out.println();

        // Comparacion
        System.out.println("--- Comparacion ---");
        System.out.println("Lagrange: " + resultadoLagrange);
        System.out.println("Newton: " + resultadoNewton);
    }
}
