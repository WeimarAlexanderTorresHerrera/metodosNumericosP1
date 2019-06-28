package metodosNumericosP1;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

import javax.swing.*;

public class Lagrange {

    public void metodoLagrange (double x, double[][] xy, JTextField resfx, JTextField resPol) throws ParseException {
        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.setImplicitMul(true);
        DJep dJep = new DJep();
        dJep.addStandardConstants();
        dJep.addStandardFunctions();
        dJep.addComplex();
        dJep.setAllowUndeclared(true);
        dJep.setAllowAssignment(true);
        dJep.setImplicitMul(true);
        dJep.addStandardDiffRules();
        String funcion = "";
        for (int i=0; i<xy.length; i++) {
            if (i!=0) {
                funcion += "+";
            }
            double v = xy[i][1];
            for (int j=0; j<xy.length; j++) {
                if (j!=i) {
                    v = v/(xy[i][0]-xy[j][0]);
                }
            }
            funcion += v;
            for (int j=0; j<xy.length; j++) {
                if (j!=i) {
                    funcion += "*(x-" + xy[j][0] + ")";
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

}
