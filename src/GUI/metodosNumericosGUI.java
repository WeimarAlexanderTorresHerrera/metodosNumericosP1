package GUI;

import metodosNumericosP1.CuadraturaGauss;
import metodosNumericosP1.NewtonCotes;
import metodosNumericosP1.Simpson;
import metodosNumericosP1.Trapecios;
import org.nfunk.jep.JEP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class    metodosNumericosGUI {

    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel resNewtonCotes;
    private JLabel resSimpson;
    private JLabel resTrapecios;
    private JLabel resCuadraturaGauss;
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
    private JLabel mensajeCuadraturaGauss;

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
                resCuadraturaGauss.setText("");
                mensajeTrapecios.setText("");
                mensajeSimpson.setText("");
                mensajeNewtonCotes.setText("");
                mensajeCuadraturaGauss.setText("");
            }
        });
        integrarRespectoAXButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resTrapecios.setText("");
                resSimpson.setText("");
                resNewtonCotes.setText("");
                resCuadraturaGauss.setText("");
                mensajeTrapecios.setText("");
                mensajeSimpson.setText("");
                mensajeNewtonCotes.setText("");
                mensajeCuadraturaGauss.setText("");
                JEP jep = new JEP();
                jep.addStandardFunctions();
                jep.addStandardConstants();
                jep.setImplicitMul(true);
                String f = funcion.getText();
                jep.parseExpression(a.getText());
                double a1 = jep.getValue();
                jep.parseExpression(b.getText());
                double b1 = jep.getValue();
                if (!ni.getText().equals("")) {
                    try {
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
                    } catch (Exception e1) {
                        mensajeSimpson.setText("Datos erroneos");
                        mensajeTrapecios.setText("Datos erroneos");
                    }
                }
                if (!np.getText().equals("")) {
                    try {
                        int np1 = Integer.parseInt(np.getText());
                        NewtonCotes newtonCotes = new NewtonCotes();
                        resNewtonCotes.setText(newtonCotes.metodoNewtonCotes(a1, b1, f, np1));
                        CuadraturaGauss cuadraturaGauss = new CuadraturaGauss();
                        resCuadraturaGauss.setText(cuadraturaGauss.metodoCuadraturaGauss(a1, b1, f, np1));
                    } catch (Exception e2) {
                        mensajeNewtonCotes.setText("Datos erroneos");
                        mensajeCuadraturaGauss.setText("Datos erroneos");
                    }
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

}
