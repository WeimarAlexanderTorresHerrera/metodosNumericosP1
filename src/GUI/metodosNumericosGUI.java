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

    private JButton generarTablaButton;
    private JButton encontrarFXYButton;
    private JTable table4;
    private JTextField np1;
    private JTextField x;
    private JTextField resfx;
    private JTextField resPol;
    private JButton nuevaInterpolacionButton;
    private JTable table5;
    private JTextField ng;
    private JTextField L;
    private JTextField Lp;
    private JTable table6;
    private JButton generarFuncionButton;
    private JButton obtenerRaicesButton;
    private JButton nuevaFuncionButton;
    private JTextField np3;
    private JTextField x1;
    private JButton generarTablaButton1;
    private JButton encontrarFXYButton1;
    private JTable table7;
    private JTextField resfx1;
    private JTextField resPol1;
    private JButton nuevaInterpolacionButton1;
    private JButton generarTablaButton2;
    private JButton encontrarFXYButton2;
    private JButton nuevaInterpolacionButton2;
    private JTextField np4;
    private JTextField x2;
    private JTable table8;
    private JTextField resfx2;
    private JTextField resPol2;
    private JTextField f;
    private JTextField x0;
    private JTextField yx0;
    private JTextField h;
    private JTextField xf;
    private JButton resolverButton;
    private JTextArea textArea4;
    private JButton nuevaEcuacionButton;
    private JTextField f1;
    private JTextField x01;
    private JTextField yx01;
    private JTextField h1;
    private JTextField xf1;
    private JButton resolverButton1;
    private JTextArea textArea5;
    private JButton nuevaEcuacionButton1;
    private JTextField f2;
    private JTextField x02;
    private JTextField yx02;
    private JTextField h2;
    private JTextField xf2;
    private JButton resolverButton2;
    private JButton nuevaEcuacionButton2;
    private JTextArea textArea6;
    private JTextField f3;
    private JTextField x03;
    private JTextField yx03;
    private JTextField h3;
    private JTextField xf3;
    private JButton resolverButton3;
    private JTextArea textArea7;
    private JButton nuevaEcuacionButton3;
    private JTextField f4;
    private JTextField x04;
    private JTextField yx04;
    private JTextField h4;
    private JTextField xf4;
    private JButton resolverButton4;
    private JButton nuevaEcuacionButton4;
    private JTextArea textArea8;
    private JTextArea textArea9;

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
        generarTablaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    n = Integer.parseInt(np1.getText());
                    if (n < 2) {
                        throw new Exception();
                    }
                    Object columna[] = {"x", "y"};
                    tableModel = new DefaultTableModel(columna, n);
                    table4.setModel(tableModel);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, "Datos Erroneos");
                }
            }
        });
        encontrarFXYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    resfx.setText("");
                    resPol.setText("");
                    double xy[][] = new double[n][2];
                    for (int i = 0; i < n; i++) {
                        xy[i][0] = Double.parseDouble(String.valueOf(table4.getValueAt(i, 0)));
                        xy[i][1] = Double.parseDouble(String.valueOf(table4.getValueAt(i, 1)));
                    }
                    if (Double.valueOf(x.getText())>xy[0][0] && Double.valueOf(x.getText())<xy[1][0]) {
                        NewtonAscendente newtonAscendente = new NewtonAscendente();
                        newtonAscendente.metodoNewtonAscendente(Double.valueOf(x.getText()), xy, resfx, resPol);
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, "Datos erroneos");
                }
            }
        });
        nuevaInterpolacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                resfx.setText("");
                resPol.setText("");
                x.setText("");
                np1.setText("");
                tableModel = new DefaultTableModel();
                table4.setModel(tableModel);
            }
        });
        generarFuncionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    n = Integer.parseInt(ng.getText());
                    if (n < 1) {
                        throw new Exception();
                    }
                    Object columna[] = new Object[n+1];
                    for (int i = 0; i < n+1; i++) {
                        columna[i] = "x^" + (n - i);
                    }
                    tableModel = new DefaultTableModel(columna, 1);
                    table5.setModel(tableModel);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, "Datos Erroneos");
                }
            }
        });
        obtenerRaicesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (Double.parseDouble(L.getText())-Double.parseDouble(Lp.getText())<=0) {
                        throw new Exception();
                    }
                    tableModel = new DefaultTableModel();
                    table6.setModel(tableModel);
                    double f[] = new double[n+1];
                    for (int i = 0; i < n+1; i++) {
                        f[i] = Double.parseDouble(String.valueOf(table5.getValueAt(0, i)));
                    }
                    NewtonRaphson newtonRaphson = new NewtonRaphson();
                    double[] sol = newtonRaphson.metodoNewtonRaphson(textArea9 ,f, Double.parseDouble(L.getText()), Double.parseDouble(Lp.getText()));
                    Object columna[] = new Object[sol.length];
                    for (int i = 0; i < sol.length; i++) {
                        columna[i] = "x" + (i+1);
                    }
                    tableModel = new DefaultTableModel(columna, 1);
                    table6.setModel(tableModel);
                    for (int i=0; i<sol.length; i++) {
                        table6.setValueAt(sol[i], 0, i);
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, "Datos erroneos");
                }
            }
        });
        nuevaFuncionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ng.setText("");
                tableModel = new DefaultTableModel();
                table5.setModel(tableModel);
                table6.setModel(tableModel);
                L.setText("");
                Lp.setText("");
            }
        });
        generarTablaButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    n = Integer.parseInt(np3.getText());
                    if (n < 2) {
                        throw new Exception();
                    }
                    Object columna[] = {"x", "y"};
                    tableModel = new DefaultTableModel(columna, n);
                    table7.setModel(tableModel);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, "Datos Erroneos");
                }
            }
        });
        encontrarFXYButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    resfx1.setText("");
                    resPol1.setText("");
                    double xy[][] = new double[n][2];
                    for (int i = 0; i < n; i++) {
                        xy[i][0] = Double.parseDouble(String.valueOf(table7.getValueAt(i, 0)));
                        xy[i][1] = Double.parseDouble(String.valueOf(table7.getValueAt(i, 1)));
                    }
                    if (Double.valueOf(x1.getText())>xy[xy.length-2][0] && Double.valueOf(x1.getText())<xy[xy.length-1][0]) {
                        NewtonDescendente newtonDescendente = new NewtonDescendente();
                        newtonDescendente.metodoNewtonDescendente(Double.valueOf(x1.getText()), xy, resfx1, resPol1);
                    } else {
                        throw new Exception();
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, "Datos erroneos");
                }
            }
        });
        generarTablaButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    n = Integer.parseInt(np4.getText());
                    if (n < 2) {
                        throw new Exception();
                    }
                    Object columna[] = {"x", "y"};
                    tableModel = new DefaultTableModel(columna, n);
                    table8.setModel(tableModel);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, "Datos Erroneos");
                }
            }
        });
        encontrarFXYButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    resfx2.setText("");
                    resPol2.setText("");
                    double xy[][] = new double[n][2];
                    for (int i = 0; i < n; i++) {
                        xy[i][0] = Double.parseDouble(String.valueOf(table8.getValueAt(i, 0)));
                        xy[i][1] = Double.parseDouble(String.valueOf(table8.getValueAt(i, 1)));
                    }
                    Lagrange lagrange = new Lagrange();
                    lagrange.metodoLagrange(Double.valueOf(x2.getText()), xy, resfx2, resPol2);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, "Datos erroneos");
                }
            }
        });
        nuevaInterpolacionButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                resfx2.setText("");
                resPol2.setText("");
                x2.setText("");
                np4.setText("");
                tableModel = new DefaultTableModel();
                table8.setModel(tableModel);
            }
        });
        nuevaInterpolacionButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                resfx1.setText("");
                resPol1.setText("");
                x1.setText("");
                np3.setText("");
                tableModel = new DefaultTableModel();
                table7.setModel(tableModel);
            }
        });
        resolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    textArea4.setText("");
                    Euler euler = new Euler();
                    euler.metodoEuler(textArea4, f.getText(), Double.parseDouble(x0.getText()), Double.parseDouble(yx0.getText()), Double.parseDouble(h.getText()), Double.parseDouble(xf.getText()));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, "Datos Erroneos");
                }
            }
        });
        nuevaEcuacionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea4.setText("");
                f.setText("");
                x0.setText("");
                yx0.setText("");
                h.setText("");
                xf.setText("");
            }
        });
        resolverButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    textArea5.setText("");
                    PuntoMedio puntoMedio = new PuntoMedio();
                    puntoMedio.metodoPuntoMedio(textArea5, f1.getText(), Double.parseDouble(x01.getText()), Double.parseDouble(yx01.getText()), Double.parseDouble(h1.getText()), Double.parseDouble(xf1.getText()));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, "Datos Erroneos");
                }
            }
        });
        nuevaEcuacionButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea5.setText("");
                f1.setText("");
                x01.setText("");
                yx01.setText("");
                h1.setText("");
                xf1.setText("");
            }
        });
        resolverButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    textArea6.setText("");
                    EulerModificado eulerModificado = new EulerModificado();
                    eulerModificado.metodoEulerModificado(textArea6, f2.getText(), Double.parseDouble(x02.getText()), Double.parseDouble(yx02.getText()), Double.parseDouble(h2.getText()), Double.parseDouble(xf2.getText()));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, "Datos Erroneos");
                }
            }
        });
        nuevaEcuacionButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea6.setText("");
                f2.setText("");
                x02.setText("");
                yx02.setText("");
                h2.setText("");
                xf2.setText("");
            }
        });
        resolverButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    textArea7.setText("");
                    Heun heun = new Heun();
                    heun.metodoHeun(textArea7, f3.getText(), Double.parseDouble(x03.getText()), Double.parseDouble(yx03.getText()), Double.parseDouble(h3.getText()), Double.parseDouble(xf3.getText()));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, "Datos Erroneos");
                }
            }
        });
        nuevaEcuacionButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea7.setText("");
                f3.setText("");
                x03.setText("");
                yx03.setText("");
                h3.setText("");
                xf3.setText("");
            }
        });
        resolverButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    textArea8.setText("");
                    RungeKutta rungeKutta = new RungeKutta();
                    rungeKutta.metodoRungeKutta(textArea8, f4.getText(), Double.parseDouble(x04.getText()), Double.parseDouble(yx04.getText()), Double.parseDouble(h4.getText()), Double.parseDouble(xf4.getText()));
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(tabbedPane1, "Datos Erroneos");
                }
            }
        });
        nuevaEcuacionButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea8.setText("");
                f4.setText("");
                x04.setText("");
                yx04.setText("");
                h4.setText("");
                xf4.setText("");
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
