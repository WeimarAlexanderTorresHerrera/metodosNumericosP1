package metodosNumericosP1;

import org.nfunk.jep.JEP;

import javax.swing.*;

public class Heun {

    public void metodoHeun (JTextArea jTextArea, String funcion, double x0, double yx0, double h, double xf) {
        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.setImplicitMul(true);
        boolean esPrimero = true;
        double y = yx0;
        dibujarTabla(jTextArea, esPrimero, h, x0, y);
        esPrimero=false;
        for (double x = x0; x <= xf-h+(h/50);) {
            double k1 = jep.addVariable("x", x);
            k1 = jep.addVariable("y", y);
            jep.parseExpression(funcion);
            k1 = jep.getValue();
            double k2 = jep.addVariable("x", x + ((2 * h) / 3));
            k2 = jep.addVariable("y", y + ((2 * h) / 3)*k1);
            jep.parseExpression(funcion);
            k2 = jep.getValue();
            y += (h / 4)*(k1 + 3 * k2);
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
