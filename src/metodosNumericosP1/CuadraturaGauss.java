package metodosNumericosP1;

import org.nfunk.jep.JEP;

public class CuadraturaGauss {

    private double[][] a = {{1, 1}, {0.555555555555556, 0.888888888888889, 0.555555555555556}, {0.347854845137454, 0.652145154862546, 0.652145154862546, 0.347854845137454}, {0.236926885056189, 0.478628670499366, 0.568888888888889, 0.478628670499366, 0.236926885056189}, {0.171324492379170, 0.360761573048139, 0.467913934572691, 0.467913934572691, 0.360761573048139, 0.171324492379170}};
    private double[][] x = {{-0.577350269189626, 0.577350269189626}, {-0.774596669241483, 0, 0.774596669241483}, {-0.861136311594053, -0.339981043584856, 0.339981043584856, 0.861136311594053}, {-0.906179845938664, -0.538469310105683, 0 , 0.538469310105683, 0.906179845938664}, {-0.932469514203152, -0.661209386466265, -0.238619186083197, 0.238619186083197, 0.661209386466265, 0.932469514203152}};

    public String metodoCuadraturaGauss (double a, double b, String funcion, int n) {
        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.setImplicitMul(true);
        double sum = 0;
        for (int i = 0; i <= n - 1; i++) {
            double v = ((b + a) / 2) + (((b - a) * x[n - 2][i]) / 2);
            double f = jep.addVariable("x", v);
            jep.parseExpression(funcion);
            f = jep.getValue();
            sum += this.a[n - 2][i] * f;
        }
        return Double.toString(((b-a)/2)*sum);
    }

}
