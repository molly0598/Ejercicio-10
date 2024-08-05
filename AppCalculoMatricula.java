import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppCalculoMatricula extends JFrame {
    private JTextField campoInscripcion;
    private JTextField campoNombre;
    private JTextField campoPatrimonio;
    private JTextField campoEstrato;
    private JLabel etiquetaResultado;

    public AppCalculoMatricula() {
        setTitle("Cálculo de Matrícula Universitaria");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(5, 2, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel etiquetaInscripcion = new JLabel("ID de inscripción:");
        campoInscripcion = new JTextField();
        JLabel etiquetaNombre = new JLabel("Nombre completo:");
        campoNombre = new JTextField();
        JLabel etiquetaPatrimonio = new JLabel("Valor del patrimonio:");
        campoPatrimonio = new JTextField();
        JLabel etiquetaEstrato = new JLabel("Nivel de estrato:");
        campoEstrato = new JTextField();
        JButton botonCalcular = new JButton("Calcular");
        etiquetaResultado = new JLabel("", SwingConstants.CENTER);

        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                try {
                    int inscripcion = Integer.parseInt(campoInscripcion.getText());
                    String nombre = campoNombre.getText();
                    double patrimonio = Double.parseDouble(campoPatrimonio.getText());
                    int estrato = Integer.parseInt(campoEstrato.getText());

                    RegistroUniversidad registro = new RegistroUniversidad(inscripcion, nombre, patrimonio, estrato);
                    double valorMatricula = registro.calcularValorMatricula();
                    etiquetaResultado.setText("Valor de la matrícula: $" + valorMatricula);
                } catch (NumberFormatException excepcion) {
                    etiquetaResultado.setText("Por favor, ingresa valores numéricos válidos.");
                }
            }
        });

        botonCalcular.setPreferredSize(new Dimension(150, 50));
        botonCalcular.setBackground(Color.GREEN);
        botonCalcular.setForeground(Color.BLACK);

        panelPrincipal.add(etiquetaInscripcion);
        panelPrincipal.add(campoInscripcion);
        panelPrincipal.add(etiquetaNombre);
        panelPrincipal.add(campoNombre);
        panelPrincipal.add(etiquetaPatrimonio);
        panelPrincipal.add(campoPatrimonio);
        panelPrincipal.add(etiquetaEstrato);
        panelPrincipal.add(campoEstrato);
        panelPrincipal.add(botonCalcular);
        panelPrincipal.add(etiquetaResultado);

        add(panelPrincipal);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception e) {
                e.printStackTrace();
            }
            new AppCalculoMatricula();
        });
    }
}
