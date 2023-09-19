import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Empleado {
    private String nombre;
    private double salarioPorHora;
    private int horasTrabajadas;

    public Empleado(String nombre, double salarioPorHora, int horasTrabajadas) {
        this.nombre = nombre;
        this.salarioPorHora = salarioPorHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    public double calcularSalarioMensual() {
        double salarioMensual = salarioPorHora * horasTrabajadas;
        return salarioMensual;
    }

    public String getNombre() {
        return nombre;
    }
}

public class Codigo extends JFrame {
    private JTextField nombreField;
    private JTextField salarioHoraField;
    private JTextField horasTrabajadasField;
    private JTextArea resultadoArea;

    public Codigo() {
        setTitle("Calculadora de Salario de Empleado");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Nombre del empleado:"));
        nombreField = new JTextField();
        panel.add(nombreField);

        panel.add(new JLabel("Salario por hora:"));
        salarioHoraField = new JTextField();
        panel.add(salarioHoraField);

        panel.add(new JLabel("Horas trabajadas en el mes:"));
        horasTrabajadasField = new JTextField();
        panel.add(horasTrabajadasField);

        JButton calcularButton = new JButton("Calcular Salario");
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
        String nombre = nombreField.getText();
        double salarioPorHora = Double.parseDouble(salarioHoraField.getText());
        int horasTrabajadas = Integer.parseInt(horasTrabajadasField.getText());

        Empleado empleado = new Empleado(nombre, salarioPorHora, horasTrabajadas);
        double salarioMensual = empleado.calcularSalarioMensual();

        if (salarioMensual > 450000) {
            resultadoArea.setText("Nombre del empleado: " + empleado.getNombre() + "\n" +
                                  "Salario mensual: $" + salarioMensual);
        } else {
            resultadoArea.setText("Nombre del empleado: " + empleado.getNombre());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Codigo();
            }
        });
    }
}
