package br.edu.unis;

import javax.swing.*;

public class CalculadoraIMC extends JFrame{

	private JLabel labelPeso, labelAltura, labelResultado;
    private JTextField campoPeso, campoAltura;
    private JButton botaoCalcular;

    public CalculadoraIMC() {
        setTitle("Calculadora de IMC");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        labelPeso = new JLabel("Peso (kg):");
        campoPeso = new JTextField(10);
        labelAltura = new JLabel("Altura (cm):");
        campoAltura = new JTextField(10);
        botaoCalcular = new JButton("Calcular");
        labelResultado = new JLabel();

        botaoCalcular.addActionListener(e -> calcularIMC());

        JPanel painel = new JPanel();
        painel.add(labelPeso);
        painel.add(campoPeso);
        painel.add(labelAltura);
        painel.add(campoAltura);
        painel.add(botaoCalcular);
        painel.add(labelResultado);

        add(painel);
        setVisible(true);
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(campoPeso.getText());
            double altura = Double.parseDouble(campoAltura.getText()) / 100; // Convertendo cm para metros
            double imc = peso / (altura * altura);
            String classificacao;

            if (imc < 18.5) {
                classificacao = "Abaixo do peso";
            } else if (imc < 25) {
                classificacao = "Peso normal";
            } else if (imc < 30) {
                classificacao = "Sobrepeso";
            } else if (imc < 35) {
                classificacao = "Obesidade Grau I";
            } else if (imc < 40) {
                classificacao = "Obesidade Grau II";
            } else {
                classificacao = "Obesidade Grau III (Obesidade Mórbida)";
            }

            labelResultado.setText("Seu IMC é " + String.format("%.2f", imc) + ". Classificação: " + classificacao);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para peso e altura.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new CalculadoraIMC();
    }	
}
