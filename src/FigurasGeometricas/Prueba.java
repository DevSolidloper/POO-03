package FigurasGeometricas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prueba extends JFrame {
    private JTextField radioField, baseField, alturaField, ladoField1, ladoField2;
    private JButton calcularAreaButton, calcularPerimetroButton;
    private JTextArea resultadoArea;

    public Prueba() {
        setTitle("Calculadora de Figuras Geométricas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        panel.add(new JLabel("Radio (para círculo):"));
        radioField = new JTextField();
        panel.add(radioField);

        panel.add(new JLabel("Base (para rectángulo y triángulo):"));
        baseField = new JTextField();
        panel.add(baseField);

        panel.add(new JLabel("Altura (para rectángulo, triángulo y trapecio):"));
        alturaField = new JTextField();
        panel.add(alturaField);

        panel.add(new JLabel("Lado 1 (para cuadrado y rombo):"));
        ladoField1 = new JTextField();
        panel.add(ladoField1);

        panel.add(new JLabel("Lado 2 (para triángulo rectángulo y trapecio):"));
        ladoField2 = new JTextField();
        panel.add(ladoField2);

        calcularAreaButton = new JButton("Calcular Área");
        panel.add(calcularAreaButton);

        calcularPerimetroButton = new JButton("Calcular Perímetro");
        panel.add(calcularPerimetroButton);

        calcularAreaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularArea();
            }
        });

        calcularPerimetroButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularPerimetro();
            }
        });

        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        panel.add(resultadoArea);

        add(panel);
        setVisible(true);
    }

    private void calcularArea() {

        resultadoArea.getText();
    	
    }

    private void calcularPerimetro() {
    	
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Prueba();
            }
        });
    }
}
