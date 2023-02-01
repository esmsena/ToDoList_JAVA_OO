package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.*;

/**
 * Classe da primeira tela do projeto, onde ocorre o cadastro do usuário.
 *
 * @author Esther Sena Martins
 * @author Mariiana Siqueira Neris
 * 
 * @since 2023
 * @version 1.1
 *
 */

public class TelaCadastro extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JFrame f = new JFrame(" CADASTRO ");
	JLabel jlemail = new JLabel("Digite o email:");
	JTextField jtemail = new JTextField();
	JLabel jlnome = new JLabel("Digite o nome:");
	JTextField jtnome = new JTextField();
	JButton bntCadastrar = new JButton("Cadastrar");

	/**
	 * Método construtor que define os campos de preenchimento nome e email, e botão
	 * de cadastro.
	 */

	public TelaCadastro() {
		super("Tarefa Pessoal");

		jlemail.setForeground(new Color(255, 255, 255));
		jlemail.setBounds(475, 190, 100, 13);

		jtemail.setBackground(new Color(255, 255, 255));
		jtemail.setBounds(475, 210, 270, 34);

		jlnome.setForeground(new Color(255, 255, 255));
		jlnome.setBounds(475, 290, 100, 13);

		jtnome.setBackground(new Color(255, 255, 255));
		jtnome.setBounds(475, 310, 270, 34);

		bntCadastrar.setForeground(new Color(255, 255, 255));
		bntCadastrar.setBackground(new Color(128, 128, 255));
		bntCadastrar.setBounds(545, 390, 130, 25);
		bntCadastrar.addActionListener(this);
		bntCadastrar.setOpaque(true);
		bntCadastrar.setBorderPainted(false);

		f.add(jlemail);
		f.add(jtemail);
		f.add(jlnome);
		f.add(jtnome);
		f.add(bntCadastrar);
		f.setSize(1200, 700);
		f.setLayout(null);
		f.setVisible(true);
		f.getContentPane().setBackground(new Color(0, 0, 121));
		f.setResizable(false);
	}

	/**
	 * Método de uso do ActionListener que recebe os dados, cadastra o usuário e
	 * imprime na tela uma mensagem.
	 */

	public void actionPerformed(ActionEvent e) {

		if (jtemail.getText().isEmpty() && jtnome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha TODOS os dados para prosseguir!", "ATENÇÃO!",
					JOptionPane.ERROR_MESSAGE);
		} else if (jtemail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o email para prosseguir!", "ATENÇÃO!",
					JOptionPane.ERROR_MESSAGE);
		} else if (jtnome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome para prosseguir!", "ATENÇÃO!",
					JOptionPane.ERROR_MESSAGE);
		} else {

			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Parabéns!",
					JOptionPane.DEFAULT_OPTION);

			String email = jtemail.getText().toString();
			String nome = jtnome.getText().toString();

			CadastroUsuarioController cadastrarUsuario = new CadastroUsuarioController();
			cadastrarUsuario.cadastrarUsuario(email, nome);
			f.setVisible(false);
		}
	}

	/**
	 * Metodo responsavel pela inicializacao do programa.
	 * 
	 * @param args String padrao do java.
	 */

	public static void main(String[] args) {
		new TelaCadastro();
	}
}