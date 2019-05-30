package GUI;

import metodosNumericosP1.*;
import org.nfunk.jep.JEP;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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

    private JTextField nx;
    private JButton generarMatrizButton;
    private JTable table1;
    private JTextArea textArea1;
    private JButton resolverSistemaButton;
    private JTextField nx1;
    private JButton generarMatrizButton1;
    private JTextField er;
    private JButton resolverSistemaButton1;
    private JTable table2;
    private JTextArea textArea2;
    private JButton nuevoSistemaButton;
    private JButton nuevoSistemaButton1;
    private JButton nuevoSistemaButton2;
    private JTextArea textArea3;
    private JTable table3;
    private JTextField nx2;
    private JTextField er1;
    private JButton generarMatrizButton2;
    private JButton resolverSistemaButton2;
    private DefaultTableModel tableModel = new DefaultTableModel();
    private int n;

    public metodosNumericosGUI() {

        table1.setModel(tableModel);

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
        generarMatrizButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    n = Integer.parseInt(nx.getText());
                    if (n < 2) {
                        throw new Exception("Datos Erroneos");
                    }
                    Object columna[] = new Object[n+1];
                    for (int i = 0; i < n + 1; i++) {
                        if (i < n) {
                            columna[i] = "x" + (i + 1);
                        } else {
                            columna[i] = "d";
                        }
                    }
                    tableModel = new DefaultTableModel(columna, n);
                    table1.setModel(tableModel);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, e1.getMessage());
                }
            }
        });
        resolverSistemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea1.setText("");
                    double m[][] = new double[n][n + 1];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n + 1; j++) {
                            m[i][j] = Double.parseDouble(String.valueOf(table1.getValueAt(i, j)));
                        }
                    }
                    Gauss gauss = new Gauss();
                    gauss.metodoGauss(textArea1, m);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, "Datos erroneos");
                }
            }
        });
        nuevoSistemaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel = new DefaultTableModel();
                table1.setModel(tableModel);
                textArea1.setText("");
                nx.setText("");
            }
        });
        nuevoSistemaButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel = new DefaultTableModel();
                table2.setModel(tableModel);
                textArea2.setText("");
                nx1.setText("");
                er.setText("");
            }
        });
        generarMatrizButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    n = Integer.parseInt(nx1.getText());
                    if (n < 2) {
                        throw new Exception("Datos Erroneos");
                    }
                    Object columna[] = new Object[n+1];
                    for (int i = 0; i < n + 1; i++) {
                        if (i < n) {
                            columna[i] = "x" + (i + 1);
                        } else {
                            columna[i] = "d";
                        }
                    }
                    tableModel = new DefaultTableModel(columna, n);
                    table2.setModel(tableModel);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, e1.getMessage());
                }
            }
        });
        resolverSistemaButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea2.setText("");
                    double m[][] = new double[n][n + 1];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n + 1; j++) {
                            m[i][j] = Double.parseDouble(String.valueOf(table2.getValueAt(i, j)));
                        }
                    }
                    Jacobi jacobi = new Jacobi();
                    jacobi.metodoJacobi(textArea2, m, Double.parseDouble(er.getText()));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, "Datos erroneos");
                }
            }
        });
        generarMatrizButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    n = Integer.parseInt(nx2.getText());
                    if (n < 2) {
                        throw new Exception("Datos Erroneos");
                    }
                    Object columna[] = new Object[n+1];
                    for (int i = 0; i < n + 1; i++) {
                        if (i < n) {
                            columna[i] = "x" + (i + 1);
                        } else {
                            columna[i] = "d";
                        }
                    }
                    tableModel = new DefaultTableModel(columna, n);
                    table3.setModel(tableModel);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, e1.getMessage());
                }
            }
        });
        nuevoSistemaButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel = new DefaultTableModel();
                table3.setModel(tableModel);
                textArea3.setText("");
                nx2.setText("");
                er1.setText("");
            }
        });
        resolverSistemaButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea3.setText("");
                    double m[][] = new double[n][n + 1];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n + 1; j++) {
                            m[i][j] = Double.parseDouble(String.valueOf(table3.getValueAt(i, j)));
                        }
                    }
                    GaussSeidel gaussSeidel = new GaussSeidel();
                    gaussSeidel.metodoGaussSeidel(textArea3, m, Double.parseDouble(er1.getText()));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, "Datos erroneos");
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
