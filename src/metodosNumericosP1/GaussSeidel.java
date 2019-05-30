package metodosNumericosP1;

import javax.swing.*;

public class GaussSeidel {

    public void metodoGaussSeidel (JTextArea jTextArea, double[][] m, double e) throws Exception {
        int n = m.length;
        double b[][] = new double[n][1];
        double S[][] = new double[n][n];
        double T[][] = new double[n][n];
        double x[][] = new double[n][1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= j) {
                    S[i][j] = m[i][j];
                    T[i][j] = 0;
                } else {
                    S[i][j] = 0;
                    T[i][j] = -(m[i][j]);
                }
            }
            x[i][0] = 0;
            b[i][0] = m[i][n];
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
                x = sumar (multiplicar(M, x), multiplicar(inversa(S), b));
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

    public double normaI(double[][] m) {
        int j = 0;
        double sumaF = 0;
        double max = m[0][0];
        for (int i = 0; i < m.length; i++) {
            j = 0;
            while ((j < m[i].length)) {
                sumaF = sumaF + Math.abs(m[i][j]);
                j++;
            }
            if (max < sumaF) {
                max = sumaF;
            }
            sumaF = 0;
        }
        return max;
    }

    public double normaII(double[][] m) {
        double sumaC;
        double maxc = m[0][0];
        for(int i = 0; i < m.length; i++){
            sumaC = 0;
            for(int j = 0; j < m[i].length; j++){
                sumaC = sumaC + Math.abs (m[j][i]);
            }
            if(maxc < sumaC) {
                maxc = sumaC;
            }
        }
        return maxc;
    }

    public double normaIII(double[][] m) {
        double acu=0,a;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                acu = acu+ Math.abs(m[i][j]*m[i][j]);
            }
        }
        a=Math.sqrt(acu);
        return a;
    }

    public double[][] inversa(double a[][]) {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i = 0; i < n; ++i) {
            b[i][i] = 1;
        }
        gauss(a, index);
        for (int i=0; i<n-1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    b[index[j]][k] -= a[index[j]][i] * b[index[i]][k];
                }
            }
        }
        for (int i=0; i<n; ++i) {
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k) {
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

    public static void gauss(double a[][], int index[])  {
        int n = index.length;
        double c[] = new double[n];
        for (int i=0; i<n; ++i) {
            index[i] = i;
        }
        for (int i=0; i<n; ++i) {
            double c1 = 0;
            for (int j=0; j<n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }
        int k = 0;
        for (int j=0; j<n-1; ++j) {
            double pi1 = 0;
            for (int i=j; i<n; ++i)  {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i) {
                double pj = a[index[i]][j]/a[index[j]][j];
                a[index[i]][j] = pj;
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }

}
