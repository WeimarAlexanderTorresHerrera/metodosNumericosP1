package metodosNumericosP1;

import org.nfunk.jep.JEP;

public class NewtonRaphson {

    public double[] metodoNewtonRaphson (double[] funcion, double L, double Lp) {
        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.setImplicitMul(true);
        double sol[] = new double[funcion.length-1];
        int acc = 2;
        double aux[] = funcion;
        double aux1[] = derivarPolinomios(funcion);
        for (; aux1.length > 1; acc++) {
            double aux2[] = aux1;
            aux1 = restoHorner(aux, aux1);
            aux = aux2;
        }
        String p[] = new String[acc];
        aux = funcion;
        aux1 = derivarPolinomios(funcion);
        p[0]=obtenerFuncion(funcion);
        p[1]=obtenerFuncion(derivarPolinomios(funcion));
        for (int i=2; i<p.length; i++) {
            double aux2[] = aux1;
            aux1 = restoHorner(aux, aux1);
            aux = aux2;
            p[i]=obtenerFuncion(aux1);
        }
        int h;
        if (L-Lp < 100) {
            h=100;
        } else {
            h=1000;
        }
        acc = 0;
        double u = (L-Lp)/h;
        boolean mSignos[][] = new boolean[p.length][h+1];
        int mStotal[] = new int[funcion.length-1];
        for (int i=0; i<mSignos.length; i++) {
            for (int j=0; j<mSignos[0].length; j++) {
                double v = Lp+j*u;
                double f = jep.addVariable("x", v);
                jep.parseExpression(p[i]);
                f = jep.getValue();
                if(f<0) {
                    mSignos[i][j]=false;
                } else if (f>0) {
                    mSignos[i][j]=true;
                } else {
                    //if con caso 0
                    sol[acc] = f;
                }
            }
        }
        return null;
    }

    public double[] restoHorner (double[] num, double[] den) {
        double m[][] = new double[num.length-den.length+3][num.length+1];
        for (int i=0; i<num.length; i++) {
            if (i==0) {
                m[i][0] = den[i];
            } else if (i<den.length) {
                m[i][0] = -den[i];
            }
            m[0][i+1] = num[i];
        }
        for (int i=0; i<num.length-den.length+1; i++) {
            double sum = 0;
            int j = 0;
            while (j<i+1) {
                sum += m[j][i+1];
                j++;
            }
            m[m.length-1][i+1] = sum/m[0][0];
            for (j=1; j<den.length; j++) {
                m[i+1][i+j+1] = m[m.length-1][i+1]*m[j][0];
            }
        }
        for (int i=num.length-den.length+2; i<m[0].length; i++) {
            double sum = 0;
            int j = 0;
            while (j<m.length-1) {
                sum += m[j][i];
                j++;
            }
            m[m.length-1][i] = sum;
        }
        boolean esCero = false;
        int n = 0;
        for (int i=num.length-den.length+2; i<m[0].length && m[m.length-1][i]==0; i++) {
            if (i==m[0].length-1) {
                esCero = true;
            }
            n++;
        }
        if (esCero) {
            double res[] = {0};
            return res;
        } else {
            double res[] = new double[den.length-1-n];
            for (int i=num.length-den.length+2+n, j=0; i<m[0].length; i++, j++) {
                res[j] = -m[m.length-1][i];
            }
            return res;
        }
    }

    public double[] derivarPolinomios (double[] p) {
        double res[] = new double[p.length-1];
        for (int i=0; i<res.length; i++) {
            res[i] = p[i]*(p.length-1-i);
        }
        return res;
    }

    public String obtenerFuncion (double[] p) {
        String funcion = "";
        funcion += p[0]+"*(x^"+(p.length-1)+")";
        for (int i=1; i<p.length; i++) {
            funcion += "+"+p[i]+"*(x^"+(p.length-i-1)+")";
        }
        return funcion;
    }

}
