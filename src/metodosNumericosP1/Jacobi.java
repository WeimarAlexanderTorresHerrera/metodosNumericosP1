package metodosNumericosP1;

import javax.swing.*;

public class Jacobi {

    public void metodoJacobi (JTextArea jTextArea, double[][] m, double e) throws Exception {
        int n = m.length;
        double b[][] = new double[n][1];
        double S[][] = new double[n][n];
        double T[][] = new double[n][n];
        double x[][] = new double[n][1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == j) {
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
        double M[][] = new double[n][n];
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
        }
    }

    public void dibujarTabla (JTextArea jTextArea, double[][] x, int k, int n, double e) {
        if (k == 0) {
            jTextArea.append("K\t");
            for (int i = 0; i < n; i++) {
                jTextArea.append("x" + i + "\t");
            }
            jTextArea.append("E\n");
            jTextArea.append(k + "\t");
            for (int i = 0; i < n; i++) {
                jTextArea.append(String.format("%.8f", x[i][0]) + "\t");
            }
            jTextArea.append("-\n");
        } else {
            jTextArea.append(k + "\t");
            for (int i = 0; i < n; i++) {
                jTextArea.append(String.format("%.8f", x[i][0]) + "\t");
            }
            jTextArea.append(e + "\n");
        }
    }

    public double[][] multiplicar (double[][] m1, double[][] m2) {
        double matrizc[][] = new double[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                double acu = 0;
                for (int r = 0; r < m2.length; r++) {

                    acu += m1[i][r] * m2[r][j];

                }
                matrizc[i][j] = acu;
            }
        }
        return matrizc;
    }

    public double[][] sumar (double[][] m1, double[][] m2) throws Exception {
        if (m1.length == m2.length && m1[0].length == m2[0].length) {
            double matrizc[][] = new double[m1.length][m2[0].length];
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m2[0].length; j++) {
                    matrizc[i][j] = m1[i][j] + m2[i][j];
                }
            }
            return matrizc;
        } else {
            throw new Exception("Datos Erroneos");
        }
    }

    public double[][] resta (double[][] m1, double[][] m2) throws Exception {
        if (m1.length == m2.length && m1[0].length == m2[0].length) {
            double matrizc[][] = new double[m1.length][m2[0].length];
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m2[0].length; j++) {
                    matrizc[i][j] = m1[i][j] - m2[i][j];
                }
            }
            return matrizc;
        } else {
            throw new Exception("Datos Erroneos");
        }
    }

    public double[][] inversa (double[][] m) {
        return null;
    }

    public double normaI (double[][] m) {
        return 0;
    }

    public double normaII (double[][] m) {
        return 0;
    }

    public double normaIII (double[][] m) {
        return 0;
    }

}
