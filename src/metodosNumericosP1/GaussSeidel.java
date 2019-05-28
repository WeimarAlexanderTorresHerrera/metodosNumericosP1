package metodosNumericosP1;

import javax.swing.*;

public class GaussSeidel {

    public void metodoGaussSeidel (JTextArea jTextArea, double[][] m, double e) {
        int n = m.length;
        double b[][] = new double[n][1];
        double S[][] = new double[n][n];
        double T[][] = new double[n][n];
        double x[][] = new double[n][1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i >= j) {
                    S[i][j] = m[i][j];
                    T[i][j] = 0;
                } else {
                    S[i][j] = 0;
                    T[i][j] = -(m[i][j]);
                }
            }
            x[i][0] = 0;
            b[i][0] = m[i][n - 1];
        }
        /*double M[][] = new double[n][n];
        M = multiplicar(inversa(S), T);
        if (normaI(M) < 1 && normaII(M) < 1 && normaIII(M) < 1) {
            int k = 0;
            double acc[][] = new double[n][1];
            acc = x;
            dibujarTabla(jTextArea, acc, k, n, -1);
            x = sumar(multiplicar(M, x), multiplicar(inversa(S), b));
            double er = (normaIII(M) * normaIII(resta(acc, x)) / (1 - normaIII(M)));
            k++;
            dibujarTabla(jTextArea, x, k, n, er);
            while (er >= e) {
                acc = x;
                x = sumar(multiplicar(M, x), multiplicar(inversa(S), b));
                er = (normaIII(M) * normaIII(resta(acc, x)) / (1 - normaIII(M)));
                k++;
                dibujarTabla(jTextArea, x, k, n, er);
            }
        } else {
            jTextArea.append("No converge en la solucion");
        }*/
    }
}
