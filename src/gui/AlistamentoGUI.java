package gui;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

import javax.swing.*;
import constants.CommonConstants;
import calculadora.calculaIdade;

public class AlistamentoGUI extends JFrame {
    public AlistamentoGUI() {
        super(CommonConstants.APP_NAME);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(CommonConstants.FRAME_SIZE[0], CommonConstants.FRAME_SIZE[1]);
        addGUIComponents();
    }

    public void addGUIComponents() {
        // SpringLayout springLayout = new SpringLayout();
        JPanel alistaPanel = new JPanel();
        calculaIdade calcular = new calculaIdade();
        alistaPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 40));
        
        // Criar o panel para os campos
        alistaPanel.setLayout(new GridLayout(7, 2)); // Alteração para colocar os campos um abaixo do outro
        
        // Criação das labels e campos de texto
        // nomeLabel
        JLabel nomeLabel = new JLabel("Nome");
        nomeLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // nomeField
        JTextField nomeField = new JTextField();
        nomeField.setFont(new Font("Dialog", Font.PLAIN, 18));

        // sexoLabel
        JLabel sexoLabel = new JLabel("Sexo");
        sexoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // sexoField
        JTextField sexoField = new JTextField();
        sexoField.setFont(new Font("Dialog", Font.PLAIN, 18));

        // diaLabel
        JLabel diaLabel = new JLabel("Dia");
        diaLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // diaField
        JTextField diaField = new JTextField(2);
        diaField.setFont(new Font("Dialog", Font.PLAIN, 18));

        // mesLabel
        JLabel mesLabel = new JLabel("Mes");
        mesLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // mesField
        JTextField mesField = new JTextField(2);
        mesField.setFont(new Font("Dialog", Font.PLAIN, 18));

        //anoLabel
        JLabel anoLabel = new JLabel("Ano");
        anoLabel.setFont(new Font("Dialog", Font.PLAIN, 18));

        // anoField
        JTextField anoField = new JTextField(4);
        anoField.setFont(new Font("Dialog", Font.PLAIN, 18));

        // buttons da beleza
        JButton okButton = new JButton("Verificar idade");
        okButton.setFont(new Font("Dialog", Font.BOLD, 18));

        JButton deveAlistar = new JButton("Alistar");
        deveAlistar.setFont(new Font("Dialog", Font.BOLD, 18));

        // Adicionar os campos ao JPanel
        alistaPanel.add(nomeLabel);
        alistaPanel.add(nomeField);

        alistaPanel.add(sexoLabel);
        alistaPanel.add(sexoField);

        alistaPanel.add(diaLabel);
        alistaPanel.add(diaField);

        alistaPanel.add(mesLabel);
        alistaPanel.add(mesField);

        alistaPanel.add(anoLabel);
        alistaPanel.add(anoField);

        // springLayout.putConstraint(SpringLayout.WEST, okButton, 300, SpringLayout.WEST, alistaPanel);
        // springLayout.putConstraint(SpringLayout.NORTH, okButton, 250, SpringLayout.NORTH, alistaPanel);

        // springLayout.putConstraint(SpringLayout.WEST, deveAlistar, 300, SpringLayout.WEST, alistaPanel);
        // springLayout.putConstraint(SpringLayout.NORTH, deveAlistar, 280, SpringLayout.NORTH, alistaPanel);

        // botão mostrar idade
        okButton.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e){
                int diaNascimento = Integer.parseInt(diaField.getText());
                int mesNascimento = Integer.parseInt(mesField.getText());
                int anoNascimento = Integer.parseInt(anoField.getText());

                if (diaNascimento >= 32 || mesNascimento >= 13 || (anoNascimento < 1923 || anoNascimento > 2023)){
                    Font fonte = new Font("Dialog", Font.BOLD, 18);
                    JLabel mensagem = new JLabel("Data inválida");
                    mensagem.setFont(fonte);
                    JOptionPane.showMessageDialog(alistaPanel, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
                } 
                else {
                    JOptionPane.showMessageDialog(alistaPanel, "Você tem " + calcular.calcularIdade(diaNascimento, mesNascimento, anoNascimento));
                }
            }
        });

        // botão de informações alistamento
        deveAlistar.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e){
                int diaNascimento = Integer.parseInt(diaField.getText());
                int mesNascimento = Integer.parseInt(mesField.getText());
                int anoNascimento = Integer.parseInt(anoField.getText());
                String nome = nomeField.getText();
                String sexo = sexoField.getText();

                int idade = calcular.calcularIdade(diaNascimento, mesNascimento, anoNascimento); 
                boolean alistar = calcular.deveAlistar(idade, sexo);
                String informaCategoria = calcular.informarCategoria(idade);

                 if (!alistar) {
                    JOptionPane.showMessageDialog(alistaPanel, "Não vai para o exercito não.");
                } else {
                    JOptionPane.showMessageDialog(alistaPanel, "Nome: " + nome + "\n" + "Idade: " + idade + "\n" + "Categoria: " + informaCategoria + "\n" + "Pode sofrer no exercíto");
                }
            }    
        });

        alistaPanel.add(okButton);
        alistaPanel.add(deveAlistar);
        
        this.getContentPane().add(alistaPanel);
    }
}
