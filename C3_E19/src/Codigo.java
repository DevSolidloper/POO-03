import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Codigo extends JFrame {
    private JTextField ladoField;
    private JTextArea resultadoArea;

    public Codigo() {
        setTitle("Calculadora de Triángulo Equilátero");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        panel.add(new JLabel("Lado del triángulo:"));
        ladoField = new JTextField();
        panel.add(ladoField);

        JButton calcularButton = new JButton("Calcular");
        panel.add(calcularButton);

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularTriangulo();
            }
        });

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        panel.add(resultadoArea);

        add(panel);
        setVisible(true);
    }

    private void calcularTriangulo() {
        double lado = Double.parseDouble(ladoField.getText());

        double perimetro = 3 * lado;
        double altura = (Math.sqrt(3) / 2) * lado;
        double area = (lado * lado * Math.sqrt(3)) / 4;

        resultadoArea.setText("Perímetro: " + perimetro + "\n" +
                              "Altura: " + altura + "\n" +
                              "Área: " + area);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Codigo();
            }
        });
    }
}
