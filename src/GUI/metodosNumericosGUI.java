package GUI;

import metodosNumericosP1.NewtonCotes;
import metodosNumericosP1.Simpson;
import metodosNumericosP1.Trapecios;
import org.nfunk.jep.JEP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class metodosNumericosGUI {

    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel resNewtonCotes;
    private JLabel resSimpson;
    private JLabel resTrapecios;
    private JButton integrarRespectoAXButton;
    private JButton nuevaIntegracionButton;
    private JTextField b;
    private JTextField funcion;
    private JTextField a;
    private JTextField ni;
    private JTextField np;
    private JLabel mensajeTrapecios;
    private JLabel mensajeSimpson;
    private JLabel mensajeNewtonCotes;

    public metodosNumericosGUI() {
        nuevaIntegracionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b.setText("");
                a.setText("");
                funcion.setText("");
                ni.setText("");
                np.setText("");
                resTrapecios.setText("");
                resSimpson.setText("");
                resNewtonCotes.setText("");
                mensajeTrapecios.setText("");
                mensajeSimpson.setText("");
                mensajeNewtonCotes.setText("");
            }
        });
        integrarRespectoAXButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JEP jep = new JEP();
                jep.addStandardFunctions();
                jep.addStandardConstants();
                jep.setImplicitMul(true);
                try {
                    String f = funcion.getText();
                    jep.parseExpression(a.getText());
                    double a1 = jep.getValue();
                    jep.parseExpression(b.getText());
                    double b1 = jep.getValue();
                    if (!ni.getText().equals("")) {
                        int ni1 = Integer.parseInt(ni.getText());
                        Trapecios trapecios = new Trapecios();
                        resTrapecios.setText(trapecios.metodoTrapecios(a1, b1, f, ni1));
                        if (ni1 % 2 == 0) {
                            Simpson simpson = new Simpson();
                            resSimpson.setText(simpson.metodoSimpson(a1, b1, f, ni1));
                            mensajeSimpson.setText("Error: " + simpson.errorSimpson(a1, b1, f, ni1));
                        } else {
                            mensajeSimpson.setText("Numero de sub-intervalos impar");
                        }
                    }
                    if (!np.getText().equals("")) {
                        int np1 = Integer.parseInt(np.getText());
                        NewtonCotes newtonCotes = new NewtonCotes();
                        resNewtonCotes.setText(newtonCotes.metodoNewtonCotes(a1, b1, f, np1));
                    }
                } catch (Exception e1) {
                    mensajeTrapecios.setText("Datos erroneos");
                    mensajeSimpson.setText("Datos erroneos");
                    mensajeNewtonCotes.setText("Datos erroneos");
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

}
