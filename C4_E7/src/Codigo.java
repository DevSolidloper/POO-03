import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Comparador {
    public static String comparar(int a, int b) {
        if (a > b) {
            return "A es mayor que B";
        } else if (a < b) {
            return "A es menor que B";
        } else {
            return "A es igual a B";
        }
    }
}

public class Codigo extends JFrame {
    private JTextField valorAField;
    private JTextField valorBField;
    private JTextArea resultadoArea;

    public Codigo() {
        setTitle("Comparador de Valores");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Valor A:"));
        valorAField = new JTextField();
        panel.add(valorAField);

        panel.add(new JLabel("Valor B:"));
        valorBField = new JTextField();
        panel.add(valorBField);

        JButton compararButton = new JButton("Comparar");
        panel.add(compararButton);

        compararButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                compararValores();
            }
        });

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        panel.add(resultadoArea);

        add(panel);
        setVisible(true);
    }

    private void compararValores() {
        int valorA = Integer.parseInt(valorAField.getText());
        int valorB = Integer.parseInt(valorBField.getText());

        String mensaje = Comparador.comparar(valorA, valorB);

        resultadoArea.setText(mensaje);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Codigo();
            }
        });
    }
}
