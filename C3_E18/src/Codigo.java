import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Codigo extends JFrame {
    private JTextField codigoField;
    private JTextField nombreField;
    private JTextField horasTrabajadasField;
    private JTextField valorHoraField;
    private JTextField retencionField;
    private JTextArea resultadoArea;

    public Codigo() {
        setTitle("Calculadora de Salario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Código del empleado:"));
        codigoField = new JTextField();
        panel.add(codigoField);

        panel.add(new JLabel("Nombres del empleado:"));
        nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Horas trabajadas al mes:"));
        horasTrabajadasField = new JTextField();
        panel.add(horasTrabajadasField);

        panel.add(new JLabel("Valor hora trabajada:"));
        valorHoraField = new JTextField();
        panel.add(valorHoraField);

        panel.add(new JLabel("Porcentaje de retención en la fuente:"));
        retencionField = new JTextField();
        panel.add(retencionField);

        JButton calcularButton = new JButton("Calcular");
        panel.add(calcularButton);

        calcularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularSalario();
            }
        });

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        panel.add(resultadoArea);

        add(panel);
        setVisible(true);
    }

    private void calcularSalario() {
        String codigo = codigoField.getText();
        String nombre = nombreField.getText();
        double horasTrabajadas = Double.parseDouble(horasTrabajadasField.getText());
        double valorHora = Double.parseDouble(valorHoraField.getText());
        double retencion = Double.parseDouble(retencionField.getText());

        double salarioBruto = horasTrabajadas * valorHora;
        double salarioNeto = salarioBruto - (salarioBruto * (retencion / 100));

        resultadoArea.setText("Código: " + codigo + "\n" +
                              "Nombres: " + nombre + "\n" +
                              "Salario Bruto: " + salarioBruto + "\n" +
                              "Salario Neto: " + salarioNeto);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Codigo();
            }
        });
    }
}
