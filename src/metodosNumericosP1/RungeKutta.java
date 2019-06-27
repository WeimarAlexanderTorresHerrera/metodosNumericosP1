package metodosNumericosP1;

import org.nfunk.jep.JEP;

import javax.swing.*;

public class RungeKutta {

    public void metodoRungeKutta (JTextArea jTextArea, String funcion, double x0, double yx0, double h, double xf) {
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
            k1= jep.getValue();
            k1 *= h;
            double k2 = jep.addVariable("x", x+h/2);
            k2 = jep.addVariable("y", y+(k1 / 2));
            jep.parseExpression(funcion);
            k2= jep.getValue();
            k2 *= h;
            double k3 = jep.addVariable("x", x+h/2);
            k3 = jep.addVariable("y", y+(k2/2));
            jep.parseExpression(funcion);
            k3= jep.getValue();
            k3 *= h;
            double k4 = jep.addVariable("x", x+h);
            k4 = jep.addVariable("y", y+k3);
            jep.parseExpression(funcion);
            k4= jep.getValue();
            k4 *= h;
            double i=(double) 1/6;
            y += i *(k1 + 2 * k2 + 2 * k3 + k4);
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
