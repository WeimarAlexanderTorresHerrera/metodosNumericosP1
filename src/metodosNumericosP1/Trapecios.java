package metodosNumericosP1;

import org.nfunk.jep.JEP;

public class Trapecios {

    public String metodoTrapecios (double a, double b, String funcion, int n) {
        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.setImplicitMul(true);
        double h = (b - a) / n;
        double fa = jep.addVariable("x", a);
        jep.parseExpression(funcion);
        fa = jep.getValue();
        double fb = jep.addVariable("x", b);
        jep.parseExpression(funcion);
        fb = jep.getValue();
        double e = fa + fb;
        double i = 0;
        double p = 0;
        for(int j = 1; j < n; j++){
            double aux = jep.addVariable("x", a + (j * h));
            jep.parseExpression(funcion);
            aux = jep.getValue();
            if(j % 2 == 0){
                p += aux;
            } else {
                i += aux;
            }
        }

        return Double.toString(h * ( e + ( 2 * i ) + ( 2 * p ) ) / 2);
    }

}
