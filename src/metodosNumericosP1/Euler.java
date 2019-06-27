package metodosNumericosP1;

import org.nfunk.jep.JEP;

import javax.swing.*;

public class Euler {

    public void metodoEuler (JTextArea jTextArea, String funcion, double x0, double yx0, double h, double xf) {
        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.setImplicitMul(true);
        boolean esPrimero = true;
        double y = yx0;
        dibujarTabla(jTextArea, esPrimero, h, x0, y);
        esPrimero=false;
        for (double x = x0; x <= xf-h+(h/50);) {
            double xp = x;
            double k1 = jep.addVariable("x", xp);
            k1 = jep.addVariable("y", y);
            jep.parseExpression(funcion);
            k1 = jep.getValue();
            y += h * k1;
            x += h;
            dibujarTabla(jTextArea, esPrimero, h, x, y);
        }
    }

    public void dibujarTabla (JTextArea jTextArea, boolean esPrimero, double h, double x, double y) {
        if (esPrimero) {
            jTextArea.append("h = "+h+"\n");
            jTextArea.append("xi\t\tyi\n");
            jTextArea.append(String.format("%.16f", x)+"\t"+y+"\n");
        } else {
            jTextArea.append(String.format("%.16f", x)+"\t"+y+"\n");
        }
    }

}
