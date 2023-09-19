import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EcuacionCuadratica {
    private double coeficienteA;
    private double coeficienteB;
    private double coeficienteC;

    public EcuacionCuadratica(double coeficienteA, double coeficienteB, double coeficienteC) {
        this.coeficienteA = coeficienteA;
        this.coeficienteB = coeficienteB;
        this.coeficienteC = coeficienteC;
    }

    public String calcularSoluciones() {
        double discriminante = coeficienteB * coeficienteB - 4 * coeficienteA * coeficienteC;
        if (discriminante > 0) {
            double x1 = (-coeficienteB + Math.sqrt(discriminante)) / (2 * coeficienteA);
            double x2 = (-coeficienteB - Math.sqrt(discriminante)) / (2 * coeficienteA);
            return "Dos soluciones reales: x1 = " + x1 + ", x2 = " + x2;
        } else if (discriminante == 0) {
            double x = -coeficienteB / (2 * coeficienteA);
            return "Una solución real: x = " + x;
        } else {
            return "No hay soluciones reales";
        }
    }
}

public class Ecuacion extends JFrame {
    private JTextField coeficienteAField;
    private JTextField coeficienteBField;
    private JTextField coeficienteCField;
    private JTextArea resultadoArea;

    public Ecuacion() {
        setTitle("Calculadora de Ecuación Cuadrática");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Coeficiente A:"));
        coeficienteAField = new JTextField();
        panel.add(coeficienteAField);

        panel.add(new JLabel("Coeficiente B:"));
        coeficienteBField = new JTextField();
        panel.add(coeficienteBField);

        panel.add(new JLabel("Coeficiente C:"));
        coeficienteCField = new JTextField();
        panel.add(coeficienteCField);

        JButton calcularButton = new JButton("Calcular Soluciones");
        panel.add(calcularButton);

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularSoluciones();
            }
        });

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        panel.add(resultadoArea);

        add(panel);
        setVisible(true);
    }

    private void calcularSoluciones() {
        double coeficienteA = Double.parseDouble(coeficienteAField.getText());
        double coeficienteB = Double.parseDouble(coeficienteBField.getText());
        double coeficienteC = Double.parseDouble(coeficienteCField.getText());

        EcuacionCuadratica ecuacion = new EcuacionCuadratica(coeficienteA, coeficienteB, coeficienteC);
        String soluciones = ecuacion.calcularSoluciones();

        resultadoArea.setText(soluciones);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Ecuacion();
            }
        });
    }
}
