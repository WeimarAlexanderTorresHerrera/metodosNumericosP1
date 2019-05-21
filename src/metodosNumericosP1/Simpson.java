package metodosNumericosP1;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

public class Simpson {

    public String metodoSimpson(double a, double b, String funcion, int n) {
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
        return Double.toString(h * (e + 4 * i + 2 * p) / 3);
    }

    public String errorSimpson (double a, double b, String funcion, int n) {
        double h = (b - a) / n;
        String funciond4 = derivar(derivar(derivar(derivar(funcion))));
        double max = maximo(a, b, funciond4);
        return Double.toString(h * h * h * h * max * (b - a) / 180);
    }

    public String derivar(String funcion) {
        String derivada = "";
        DJep derivar = new DJep();
        derivar.addStandardConstants();
        derivar.addStandardFunctions();
        derivar.addComplex();
        derivar.setAllowUndeclared(true);
        derivar.setAllowAssignment(true);
        derivar.setImplicitMul(true);
        derivar.addStandardDiffRules();

        try {
            Node node = derivar.parse(funcion);
            Node diff = derivar.differentiate(node, "x");
            Node simp = derivar.simplify(diff);
            derivada = derivar.toString(simp);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return derivada;
    }

    public double maximo (double a, double b, String funcion) {
        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.setImplicitMul(true);
        double d = (b - a) / 10000;
        double x = a;
        double fx = jep.addVariable("x", x);
        jep.parseExpression(funcion);
        fx = jep.getValue();
        for (int i = 1; i <= 10000; i++) {
            double fxaux = jep.addVariable("x", (a + d * i));
            jep.parseExpression(funcion);
            fxaux = jep.getValue();
            if (fx < fxaux) {
                fx = fxaux;
                x = (a + d * i);
            }
        }
        return fx;
    }

}
