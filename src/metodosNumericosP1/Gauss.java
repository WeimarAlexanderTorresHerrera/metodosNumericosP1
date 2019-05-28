package metodosNumericosP1;

import javax.swing.*;
import java.text.DecimalFormat;

public class Gauss {

    public void metodoGauss(JTextArea jTextArea, double[][] m) {
        int n = m.length;
        boolean sol = true;
        double soluciones[] = new double[n];
        for (int k = 0; k < n; k++) {
            if (m[k][k] != 0) {
                for (int j = k + 1; j < n + 1; j++) {
                    m[k][j] = m[k][j] / m[k][k];
                }
                for (int i = k + 1; i < n; i++) {
                    for (int j = k + 1; j < n + 1; j++) {
                        m[i][j] = m[i][j] - m[k][j] * m[i][k];
                    }
                }
                dibujarMatriz(jTextArea, m, k);
            } else {
                for (int j = k + 1; j < n; j++) {
                    if (m[j][k] != 0) {
                        double aux[] = new double[m[0].length];
                        aux = m[j];
                        m[j] = m[k];
                        m[k] = aux;
                    }
                }
                if (m[k][k] == 0) {
                    jTextArea.append("No existe una solucion");
                    k = n;
                    sol = false;
                }
                k--;
            }
        }
        if (sol) {
            for (int i = n - 1; i >= 0; i--) {
                double acc = 0;
                for (int j = i + 1; j < n; j++) {
                    acc += m[i][j] * soluciones[j];
                }
                soluciones[i] = m[i][n] - acc;
            }
            dibujarSoluciones(jTextArea, soluciones);
        }
    }

    public void dibujarMatriz (JTextArea jTextArea, double[][] m, int k) {
        for (int f = 0; f < m.length; f++) {
            for (int c = 0; c < m[0].length; c++) {
                if (c <= k && f >= c) {
                    if (c == f) {
                        jTextArea.append("1.00000000\t");
                    } else {
                        jTextArea.append("0.00000000\t");
                    }
                } else {
                    jTextArea.append(String.format("%.8f", m[f][c]) + "\t");
                }
            }
            jTextArea.append("\n");
        }
        jTextArea.append("\n");
    }

    public void dibujarSoluciones (JTextArea jTextArea, double[] s) {
        jTextArea.append("Soluciones:\n");
        for (int i = 0; i < s.length; i++) {
            jTextArea.append("x" + i + " : " + s[i] + "\n");
        }
    }

}
