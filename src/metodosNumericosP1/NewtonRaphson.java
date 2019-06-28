package metodosNumericosP1;

import org.nfunk.jep.JEP;

import javax.swing.*;

public class NewtonRaphson {

    public double[] metodoNewtonRaphson (JTextArea jTextArea, double[] funcion, double L, double Lp) throws Exception {
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
        int h=1001;
        double u = (L-Lp)/(h-1);
        boolean mSignos[][] = new boolean[p.length][h];
        int mCambios[] = new int[h];
        for (int j=0; j<mSignos[0].length; j++) {
            double v = Lp+j*u;
            jTextArea.append(String.format("%.8f", v)+"\t");
            for (int i=0; i<mSignos.length; i++) {
                double f = jep.addVariable("x", v);
                jep.parseExpression(p[i]);
                f = jep.getValue();
                if(f<0) {
                    mSignos[i][j]=false;
                } else if (f>0) {
                    mSignos[i][j]=true;
                } else {
                    if (i==0) {
                        double f1 = jep.addVariable("x", v);
                        jep.parseExpression(p[i+1]);
                        f1 = jep.getValue();
                        if (f1!=0) {
                            mCambios[j] = -1;
                        } else {
                            throw new Exception();
                        }
                    } else {
                        v+=v/1000;
                        i=-1;
                    }
                }
            }
        }
        jTextArea.append("\n");
        for (int i=0; i<mSignos[0].length; i++) {
            if (mCambios[i]!=-1) {
                int count=0;
                for (int j=1; j<mSignos.length; j++) {
                    if ((mSignos[j-1][i]&&!mSignos[j][i])||(!mSignos[j-1][i]&&mSignos[j][i])) {
                        count++;
                    }
                }
                mCambios[i]=count;
                jTextArea.append(mCambios[i]+"\t");
            } else {
                jTextArea.append(mCambios[i]+"\t");
            }
        }
        acc=0;
        for (int i=1; i<mCambios.length; i++) {
            if (mCambios[i]!=-1) {
                if (mCambios[i - 1] - mCambios[i] > 0) {
                    sol[acc] = encontrarRaiz(Lp + (i - 1) * u, Lp + i * u, funcion);
                    acc++;
                }
            } else {
                sol[acc] = Lp + i * u;
                acc++;
            }
        }
        for (int i=0; i<sol.length; i++) {
            double f = jep.addVariable("x", sol[i]);
            jep.parseExpression(p[0]);
            f = jep.getValue();
            double f1 = jep.addVariable("x", sol[i]);
            jep.parseExpression(p[1]);
            f1 = jep.getValue();
            if (f>-0.000001 && f<0.000001 && f1>-0.000001 && f1<0.000001) {
                throw new Exception();
            }
        }
        if (acc < funcion.length-1) {
            double s[] = new double[acc];
            for (int i=0; i<s.length; i++) {
                s[i] = sol[i];
            }
            return s;
        } else {
            return sol;
        }
    }

    public double[] restoHorner (double[] num, double[] den) {
        int l;
        if (num.length-den.length+1>=den.length-1) {
            l = num.length-den.length+3;
        } else {
            l = den.length+1;
        }
        double m[][] = new double[l][num.length+1];
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
        if (p.length==1) {
            double[] res = {0};
            return res;
        } else {
            double res[] = new double[p.length - 1];
            for (int i = 0; i < res.length; i++) {
                res[i] = p[i] * (p.length - 1 - i);
            }
            return res;
        }
    }

    public String obtenerFuncion (double[] p) {
        String funcion = "";
        funcion += p[0]+"*(x^"+(p.length-1)+")";
        for (int i=1; i<p.length; i++) {
            funcion += "+"+p[i]+"*(x^"+(p.length-i-1)+")";
        }
        return funcion;
    }

    public double encontrarRaiz (double a, double b, double[] fun) {
        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.setImplicitMul(true);
        String funcion = obtenerFuncion(fun);
        String funcion2d = obtenerFuncion(derivarPolinomios(derivarPolinomios(fun)));
        double fa = jep.addVariable("x", a);
        jep.parseExpression(funcion);
        fa = jep.getValue();
        double fa2 = jep.addVariable("x", a);
        jep.parseExpression(funcion2d);
        fa2 = jep.getValue();
        double fb = jep.addVariable("x", b);
        jep.parseExpression(funcion);
        fb = jep.getValue();
        double fb2 = jep.addVariable("x", b);
        jep.parseExpression(funcion2d);
        fb2 = jep.getValue();
        if ((fa>0 && fa2>0) || (fa<0 && fa2<0)) {
            return newtonRaphsonBasico(a, fun);
        } else if ((fb>0 && fb2>0) || (fb<0 && fb2<0)) {
            return newtonRaphsonBasico(b, fun);
        } else {
            if (b-a>0) {
                return encontrarRaiz(a+(a/1000), b-(b/1000), fun);
            } else {
                return encontrarRaiz((a+b)/2, (a+b)/2, fun);
            }
        }
    }

    public double newtonRaphsonBasico (double x, double[] f) {
        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.setImplicitMul(true);
        String funcion = obtenerFuncion(f);
        String funciond = obtenerFuncion(derivarPolinomios(f));
        double fn = jep.addVariable("x", x);
        jep.parseExpression(funcion);
        fn = jep.getValue();
        double fd = jep.addVariable("x", x);
        jep.parseExpression(funciond);
        fd = jep.getValue();
        double xs = x-(fn/fd);
        if (Math.abs(xs-x)>0.000000000000001) {
            return newtonRaphsonBasico(xs, f);
        } else {
            return xs;
        }
    }

}
