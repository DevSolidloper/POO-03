import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Estudiante {
    private int numeroInscripcion;
    private String nombres;
    private double patrimonio;
    private int estrato;

    public Estudiante(int numeroInscripcion, String nombres, double patrimonio, int estrato) {
        this.numeroInscripcion = numeroInscripcion;
        this.nombres = nombres;
        this.patrimonio = patrimonio;
        this.estrato = estrato;
    }

    public double calcularPagoMatricula() {
        double costoMatricula = 50000;

        if (patrimonio > 2000000 && estrato > 3) {
            costoMatricula += 0.03 * patrimonio;
        }

        return costoMatricula;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public String getNombres() {
        return nombres;
    }
}

public class Codigo extends JFrame {
    private JTextField inscripcionField;
    private JTextField nombresField;
    private JTextField patrimonioField;
    private JTextField estratoField;
    private JTextArea resultadoArea;

    public Codigo() {
        setTitle("Calculadora de Matrícula Estudiantil");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        panel.add(new JLabel("Número de inscripción:"));
        inscripcionField = new JTextField();
        panel.add(inscripcionField);

        panel.add(new JLabel("Nombres del estudiante:"));
        nombresField = new JTextField();
        panel.add(nombresField);

        panel.add(new JLabel("Patrimonio:"));
        patrimonioField = new JTextField();
        panel.add(patrimonioField);

        panel.add(new JLabel("Estrato social:"));
        estratoField = new JTextField();
        panel.add(estratoField);

        JButton calcularButton = new JButton("Calcular Matrícula");
        panel.add(calcularButton);

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularMatricula();
            }
        });

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        panel.add(resultadoArea);

        add(panel);
        setVisible(true);
    }

    private void calcularMatricula() {
        int numeroInscripcion = Integer.parseInt(inscripcionField.getText());
        String nombres = nombresField.getText();
        double patrimonio = Double.parseDouble(patrimonioField.getText());
        int estrato = Integer.parseInt(estratoField.getText());

        Estudiante estudiante = new Estudiante(numeroInscripcion, nombres, patrimonio, estrato);
        double costoMatricula = estudiante.calcularPagoMatricula();

        resultadoArea.setText("Número de inscripción: " + estudiante.getNumeroInscripcion() + "\n" +
                              "Nombres: " + estudiante.getNombres() + "\n" +
                              "Pago de matrícula: $" + costoMatricula);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Codigo();
            }
        });
    }
}
