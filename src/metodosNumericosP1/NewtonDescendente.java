package metodosNumericosP1;

import org.nfunk.jep.JEP;

import javax.swing.*;

public class NewtonDescendente {

    public void metodoNewtonDescendente (double x, double[][] xy, JTextField resfx, JTextField resPol) {
        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.setImplicitMul(true);
        double h = xy[1][0]-xy[0][0];
        double y[] = new double[xy.length];
        for (int i=0; i<xy.length; i++) {
            y[i] = xy[i][1];
        }
        double df[] = diferenciasFinitas(y);
        String funcion = "";
        for (int i=0; i<df.length; i++) {
            double v = df[i]/(factorial(i+1)*Math.pow(h, i+1));
            if (i==0) {
                funcion += y[y.length-1]+"+"+v+"*(x-"+xy[xy.length-(1+i)][0]+")";
            } else {
                funcion += "+"+v;
                for (int j=0; j<i+1; j++) {
                    funcion += "*(x-"+xy[xy.length-(1+j)][0]+")";
                }
            }
        }
        resPol.setText(funcion);
        double fx = jep.addVariable("x", x);
        jep.parseExpression(funcion);
        fx = jep.getValue();
        resfx.setText(Double.toString(fx));
    }

    public double[] diferenciasFinitas (double[] m) {
        double matriza[][] = new double[m.length][m.length];
        for(int i=0; i<m.length; i++) {
            matriza[i][0]=m[i];
        }
        for(int c=1; c<matriza[0].length;c++) {
            for(int f=1; f<matriza.length;f++) {
                if(f>=c) {
                    matriza[f][c]= (matriza[f][c-1]-matriza[f-1][c-1]);
                }
                else
                    matriza[f][c]=0;
            }

        }
        double res[] = new double[m.length-1];
        for(int i=0; i<res.length; i++) {
            res[i]=matriza[matriza.length-1][i+1];
        }
        return res;
    }

    public double factorial(int n) {
        int factorial;
        factorial=1;
        while(n!=0) {
            factorial=factorial*n;
            n--;
        }
        return factorial;
    }

}
