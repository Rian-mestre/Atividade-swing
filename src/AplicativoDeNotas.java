import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AplicativoDeNotas {
    private JPanel panelMain;
    private JTextField txtNotas;
    private JButton btnAdicionar;
    private JTextArea txtLista;
    private JLabel lblResultado;
    private JButton btnMedia;
    private ArrayList<Double> notas;

    public AplicativoDeNotas() {
        notas = new ArrayList<>();


        txtNotas = new JTextField(10);
        btnAdicionar = new JButton("Adicionar Nota");
        btnMedia = new JButton("Calcular Média");
        txtLista = new JTextArea(10, 30);
        lblResultado = new JLabel("Média: 0.0");
        panelMain = new JPanel();

        // Tornando a área de texto somente leitura
        txtLista.setEditable(false);
        txtLista.setLineWrap(true);
        txtLista.setWrapStyleWord(true);

        // Adicionando componentes ao painel principal
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(new JLabel("Insira a nota:"));
        panelMain.add(txtNotas);
        panelMain.add(btnAdicionar);
        panelMain.add(btnMedia);
        panelMain.add(new JScrollPane(txtLista));
        panelMain.add(lblResultado);

        // Adicionando ação ao botão "Adicionar Nota"
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double nota = Double.parseDouble(txtNotas.getText()); // Tenta converter para double
                    notas.add(nota); // Adiciona a nota à lista
                    txtNotas.setText(""); // Limpa o campo de texto
                    atualizarListaNotas(); // Atualiza a lista de notas
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para a nota.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Adicionando ação ao botão "Calcular Média"
        btnMedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularMedia();
            }
        });
    }

    private void atualizarListaNotas() {
        StringBuilder sb = new StringBuilder();
        for (Double nota : notas) {
            sb.append(nota).append("\n"); // Adiciona cada nota em uma nova linha
        }
        txtLista.setText(sb.toString()); // Atualiza a área de texto com a lista de notas
    }

    private void calcularMedia() {
        if (notas.size() > 0) {
            double soma = 0;
            for (Double nota : notas) {
                soma += nota; // Soma todas as notas
            }
            double media = soma / notas.size(); // Calcula a média
            String status = media >= 7.0 ? "Aprovado" : "Reprovado"; // Verifica o status de aprovação
            lblResultado.setText("Média: " + String.format("%.2f", media) + " - " + status);

            JOptionPane.showMessageDialog(null, status + " com média " + String.format("%.2f", media), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            lblResultado.setText("Média: 0.0"); // Caso não haja notas, exibe média 0.0
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicativo de Notas");
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new AplicativoDeNotas().panelMain);
        frame.setVisible(true);
}
}

