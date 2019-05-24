package GUI;

import metodosNumericosP1.*;
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
    private JTextField a2;
    private JTextField np2;
    private JTextField b2;
    private JTextField fx;
    private JTextField gx;
    private JTextField funcion2;
    private JLabel resNewtonCotes2;
    private JLabel resCuadraturaGauss2;
    private JButton IntegrarrespectoaYyX;
    private JButton NuevaIntegracion2;
    private JLabel mensajeCuadraturaGauss2;
    private JLabel mensajeNewtonCotes2;

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
                jep.parseExpression(a.getText());
                double a1 = jep.getValue();
                jep.parseExpression(b.getText());
                double b1 = jep.getValue();
                if (!ni.getText().equals("")) {
                    try {
                        int ni1 = Integer.parseInt(ni.getText());
                        Trapecios trapecios = new Trapecios();
                        resTrapecios.setText(trapecios.metodoTrapecios(a1, b1, funcion.getText(), ni1));
                        if (ni1 % 2 == 0) {
                            Simpson simpson = new Simpson();
                            resSimpson.setText(simpson.metodoSimpson(a1, b1, funcion.getText(), ni1));
                            mensajeSimpson.setText("Error: " + simpson.errorSimpson(a1, b1, funcion.getText(), ni1));
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
                        resNewtonCotes.setText(newtonCotes.metodoNewtonCotes(a1, b1, funcion.getText(), np1));
                        CuadraturaGauss cuadraturaGauss = new CuadraturaGauss();
                        resCuadraturaGauss.setText(cuadraturaGauss.metodoCuadraturaGauss(a1, b1, funcion.getText(), np1));
                    } catch (Exception e2) {
                        mensajeNewtonCotes.setText("Datos erroneos");
                        mensajeCuadraturaGauss.setText("Datos erroneos");
                    }
                }
            }
        });
        IntegrarrespectoaYyX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resNewtonCotes2.setText("");
                resCuadraturaGauss2.setText("");
                mensajeNewtonCotes2.setText("");
                mensajeCuadraturaGauss2.setText("");
                JEP jep = new JEP();
                jep.addStandardFunctions();
                jep.addStandardConstants();
                jep.setImplicitMul(true);
                jep.parseExpression(a2.getText());
                double a1 = jep.getValue();
                jep.parseExpression(b2  .getText());
                double b1 = jep.getValue();
                if (!np2.getText().equals("")) {
                    try {
                        int np1 = Integer.parseInt(np2.getText());
                        NewtonCotes2 newtonCotes2 = new NewtonCotes2();
                        resNewtonCotes2.setText(newtonCotes2.metodoNewtonCotes2(a1, b1, fx.getText(), gx.getText(), funcion2.getText(), np1));
                        CuadraturaGauss2 cuadraturaGauss2 = new CuadraturaGauss2();
                        resCuadraturaGauss2.setText(cuadraturaGauss2.metodoCuadraturaGauss2(a1, b1, fx.getText(), gx.getText(), funcion2.getText(), np1));
                    } catch (Exception e2) {
                        mensajeNewtonCotes2.setText("Datos erroneos");
                        mensajeCuadraturaGauss2.setText("Datos erroneos");
                    }
                }
            }
        });
        NuevaIntegracion2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b2.setText("");
                a2.setText("");
                funcion2.setText("");
                fx.setText("");
                gx.setText("");
                np2.setText("");
                resNewtonCotes2.setText("");
                resCuadraturaGauss2.setText("");
                mensajeNewtonCotes2.setText("");
                mensajeCuadraturaGauss2.setText("");
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

}
