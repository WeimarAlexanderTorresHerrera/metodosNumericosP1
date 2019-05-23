package metodosNumericosP1;

import org.nfunk.jep.JEP;

public class NewtonCotes {

    private double[][] a = {{0.3333333333, 1.3333333333, 0.3333333333}, {0.25, 0.75, 0.75, 0.25}, {0.1555555556, 0.7111111111, 0.2666666667, 0.7111111111, 0.1555555556}, {0.1319444444, 0.5208333333, 0.3472222222, 0.3472222222, 0.5208333333, 0.1319444444}, {0.0976190476, 0.5142857143, 0.0642857142, 0.6476190476, 0.0642857142, 0.5142857143, 0.0976190476}};
    private double[][] x = {{-1, 0, 1}, {-1, -0.3333333333, 0.3333333333, 1}, {-1, -0.5, 0, 0.5, 1}, {-1, -0.6, -0.2, 0.2, 0.6, 1}, {-1, -0.6666666667, -0.3333333333, 0, 0.3333333333, 0.6666666667, 1}};

    public String metodoNewtonCotes (double a, double b, String funcion, int n) {
        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.setImplicitMul(true);
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            double v = ((b + a) / 2) + (((b - a) * x[n - 2][i]) / 2);
            double f = jep.addVariable("x", v);
            jep.parseExpression(funcion);
            f = jep.getValue();
            sum += this.a[n - 2][i] * f;
        }
        return Double.toString(((b-a)/2)*sum);
    }

}
