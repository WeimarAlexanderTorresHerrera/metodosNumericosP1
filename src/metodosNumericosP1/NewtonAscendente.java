package metodosNumericosP1;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

import javax.swing.*;

public class NewtonAscendente {

    public void metodoNewtonAscendente (double x, double[][] xy, JTextField resfx, JTextField resPol) throws ParseException {
        JEP jep = new JEP();
        DJep dJep = new DJep();
        dJep.addStandardConstants();
        dJep.addStandardFunctions();
        dJep.addComplex();
        dJep.setAllowUndeclared(true);
        dJep.setAllowAssignment(true);
        dJep.setImplicitMul(true);
        dJep.addStandardDiffRules();
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
                funcion += y[i]+"+"+v+"*(x-"+xy[i][0]+")";
            } else {
                funcion += "+"+v;
                for (int j=0; j<i+1; j++) {
                    funcion += "*(x-"+xy[j][0]+")";
                }
            }
        }
        double fx = jep.addVariable("x", x);
        jep.parseExpression(funcion);
        fx = jep.getValue();
        resfx.setText(Double.toString(fx));
        Node node = dJep.parse(funcion);
        node = dJep.simplify(node);
        resPol.setText(dJep.toString(node));
    }

    public double[] diferenciasFinitas (double[] m) {
        double matriza[][] = new double[m.length][m.length];
        for(int i=0; i<m.length; i++) {
            matriza[i][0]=m[i];
        }
        for(int c=1; c<matriza[0].length;c++) {
            for(int f=0; f<matriza.length - 1;f++) {
                if(f<=matriza.length-(c+1)) {
                    matriza[f][c]= (matriza[f+1][c-1]-matriza[f][c-1]);
                }
                else
                    matriza[f][c]=0;
            }

        }
        double res[] = new double[m.length-1];
        for(int i=0; i<res.length; i++) {
            res[i]=matriza[0][i+1];
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
