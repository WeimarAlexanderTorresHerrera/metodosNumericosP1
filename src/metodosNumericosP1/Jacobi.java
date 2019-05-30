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
            for (int j = 0; j < n; j++) {
                if (i == j) {
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
            double aux2[][] = new double[S.length][b[0].length];
            aux2 = multiplicar(inversa(S), b);
            x = sumar(multiplicar(M, acc), aux2);
            double er = (normaIII(M) * normaIII(resta(acc, x)) / (1 - normaIII(M)));
            k++;
            dibujarTabla(jTextArea, x, k, n, er);
            while (er >= e) {
                acc = x;
                x = sumar(multiplicar(M, acc), aux2);
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

    public double[][] inversa(double[][] matriz) {
        double det=1/determinante(matriz);
        double[][] nmatriz=matrizAdjunta(matriz);
        multiplicarMatriz(det,nmatriz);
        return nmatriz;
    }

    public void multiplicarMatriz(double n, double[][] matriz) {
        for(int i=0;i<matriz.length;i++)
            for(int j=0;j<matriz.length;j++)
                matriz[i][j]*=n;
    }

    public double[][] matrizAdjunta(double [][] matriz){
        return matrizTranspuesta(matrizCofactores(matriz));
    }

    public double[][] matrizCofactores(double[][] matriz){
        double[][] nm=new double[matriz.length][matriz.length];
        for(int i=0;i<matriz.length;i++) {
            for(int j=0;j<matriz.length;j++) {
                double[][] det=new double[matriz.length-1][matriz.length-1];
                double detValor;
                for(int k=0;k<matriz.length;k++) {
                    if(k!=i) {
                        for(int l=0;l<matriz.length;l++) {
                            if(l!=j){
                                int indice1=k<i ? k : k-1 ;
                                int indice2=l<j ? l : l-1 ;
                                det[indice1][indice2]=matriz[k][l];
                            }
                        }
                    }
                }
                detValor=determinante(det);
                nm[i][j]=detValor * (double)Math.pow(-1, i+j+2);
            }
        }
        return nm;
    }

    public double[][] matrizTranspuesta(double [][] matriz){
        double[][]nuevam=new double[matriz[0].length][matriz.length];
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz.length; j++)
                nuevam[i][j]=matriz[j][i];
        }
        return nuevam;
    }

    public double determinante(double[][] matriz){
        double det;
        if(matriz.length==2){
            det=(matriz[0][0]*matriz[1][1])-(matriz[1][0]*matriz[0][1]);
            return det;
        }
        double suma=0;
        for(int i=0; i<matriz.length; i++){
            double[][] nm=new double[matriz.length-1][matriz.length-1];
            for(int j=0; j<matriz.length; j++){
                if(j!=i){
                    for(int k=1; k<matriz.length; k++){
                        int indice=-1;
                        if(j<i)
                            indice=j;
                        else if(j>i)
                            indice=j-1;
                        nm[indice][k-1]=matriz[j][k];
                    }
                }
            }
            if(i%2==0)
                suma+=matriz[i][0] * determinante(nm);
            else
                suma-=matriz[i][0] * determinante(nm);
        }
        return suma;
    }

}
