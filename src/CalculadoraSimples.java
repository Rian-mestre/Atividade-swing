import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculadoraSimples {
    private JPanel mainPanel;
    private JTextField txtValor;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btn0;
    private JButton btnDividir;
    private JButton btnMultiplicar;
    private JButton btnSubitrair;
    private JButton btnSomar;
    private JButton bntIgual;
    private JButton btnLimpar;

    private int primeiroValor;
    private int segundoValor;
    private String operacao;

    public CalculadoraSimples() {
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtValor.setText(txtValor.getText() + "1");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtValor.setText(txtValor.getText() + "2");
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtValor.setText(txtValor.getText() + "3");
            }
        });
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtValor.setText(txtValor.getText() + "4");
            }
        });
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtValor.setText(txtValor.getText() + "5");
            }
        });
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtValor.setText(txtValor.getText() + "6");
            }
        });
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtValor.setText(txtValor.getText() + "7");
            }
        });
        btn8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtValor.setText(txtValor.getText() + "8");
            }
        });
        btn9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtValor.setText(txtValor.getText() + "9");
            }
        });
        btn0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtValor.setText(txtValor.getText() + "0");
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtValor.setText("");
                primeiroValor = 0;
                segundoValor = 0;
                operacao = "";
            }
        });

        btnDividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primeiroValor = Integer.parseInt(txtValor.getText());
                operacao = "/";
                txtValor.setText("");
            }
        });

        btnMultiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primeiroValor = Integer.parseInt(txtValor.getText());
                operacao = "*";
                txtValor.setText("");
            }
        });

        btnSubitrair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primeiroValor = Integer.parseInt(txtValor.getText());
                operacao = "-";
                txtValor.setText("");
            }
        });

        btnSomar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                primeiroValor = Integer.parseInt(txtValor.getText());
                operacao = "+";
                txtValor.setText("");
            }
        });

        bntIgual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundoValor = Integer.parseInt(txtValor.getText());
                int resultado = 0;

                switch (operacao) {
                    case "+":
                        resultado = primeiroValor + segundoValor;
                        break;
                    case "-":
                        resultado = primeiroValor - segundoValor;
                        break;
                    case "*":
                        resultado = primeiroValor * segundoValor;
                        break;
                    case "/":
                        if (segundoValor != 0) {
                            resultado = primeiroValor / segundoValor;
                        } else {
                            JOptionPane.showMessageDialog(null, "Divisão por zero não é permitida.");
                            resultado = 0;
                        }
                        break;
                }

                txtValor.setText(String.valueOf(resultado));
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new CalculadoraSimples().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}