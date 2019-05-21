package metodosNumericosP1;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("metodosNumericos");
        frame.setContentPane(new GUI.metodosNumericosGUI().getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
