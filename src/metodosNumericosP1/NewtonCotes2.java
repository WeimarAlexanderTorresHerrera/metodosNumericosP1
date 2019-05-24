package metodosNumericosP1;

import org.nfunk.jep.JEP;

public class NewtonCotes2 {

    private double[][] a = {{(double) 1/3, (double) 4/3, (double) 1/3}, {(double) 1/4, (double) 3/4, (double) 3/4, (double) 1/4}, {(double) 14/90, (double) 32/45, (double) 4/15, (double) 32/45, (double) 14/90}, {(double) 19/144, (double) 25/48, (double) 25/72, (double) 25/72, (double) 25/48, (double) 19/144}, {(double) 41/420, (double) 18/35, (double) 9/140, (double) 68/105, (double) 9/140, (double) 18/35, (double) 41/420}};
    private double[][] xy = {{(double) -1, (double) 0, (double) 1}, {(double) -1, (double) -1/3, (double) 1/3, (double) 1}, {(double) -1, (double) -1/2, (double) 0, (double) 1/2, (double) 1}, {(double) -1, (double) -3/5, (double) -1/5, (double) 1/5, (double) 3/5, (double) 1}, {(double) -1, (double) -2/3, (double) -1/3, (double) 0, (double) 1/3, (double) 2/3, (double) 1}};

    public String metodoNewtonCotes2 (double a, double b, String fx , String gx, String funcion, int n) {
        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.setImplicitMul(true);
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            double x = ((b+a)/2)+(((b-a)*xy[n-2][i])/2);
            double fx1 = jep.addVariable("x", x);
            jep.parseExpression(fx);
            fx1 = jep.getValue();
            double gx1 = jep.addVariable("x", x);
            jep.parseExpression(gx);
            gx1 = jep.getValue();
            double sum2 = 0;
            for (int j = 0; j <= n; j++) {
                double y = ((fx1+gx1)/2)+(((fx1-gx1)*xy[n-2][j])/2);
                double f = jep.addVariable("x", x);
                f = jep.addVariable("y", y);
                jep.parseExpression(funcion);
                f = jep.getValue();
                sum2 += (this.a[n - 2][j] * f);
            }
            sum += (this.a[n - 2][i] * ((fx1-gx1)/2) * sum2);
        }
        return Double.toString(((b-a)/2)*sum);
    }

}
