package metodosNumericosP1;

public class NewtonRaphson {

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
                res[j] = m[m.length-1][i];
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

}
