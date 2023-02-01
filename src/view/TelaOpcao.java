package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Usuario;

/**
 * Classe contendo a tela que tera o menu de opcoes, que levara o usuario para
 * as listas.
 * 
 * @author Esther Sena Martins
 * @author Mariiana Siqueira Neris
 * 
 */

public class TelaOpcao {

	JLabel opcao = new JLabel("Escolha uma opção");
	Font fonte = new Font("Serif", Font.PLAIN, 20);
	JButton bPessoal = new JButton("Pessoal");
	JButton bEducacao = new JButton("Educacao");
	JButton bTrabalho = new JButton("Trabalho");

	/**
	 * Metodo construtor que instancia os botoes que levarao o usuario para as
	 * demais telas.
	 * 
	 */

	public TelaOpcao(Usuario usuario) {

		JFrame f = new JFrame("TIPO");

		opcao.setForeground(new Color(255, 255, 255));
		opcao.setBounds(535, 170, 450, 50);
		opcao.setFont(fonte);

		bPessoal.setForeground(new Color(255, 255, 255));
		bPessoal.setBackground(new Color(128, 128, 255));
		bPessoal.setOpaque(true);
		bPessoal.setBorderPainted(false);
		bPessoal.setBounds(475, 230, 270, 34);

		bPessoal.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaPessoal(usuario);

				f.setVisible(false);
			}
		});

		bEducacao.setForeground(new Color(255, 255, 255));
		bEducacao.setBackground(new Color(128, 128, 255));
		bEducacao.setOpaque(true);
		bEducacao.setBorderPainted(false);
		bEducacao.setBounds(475, 300, 270, 34);
		bEducacao.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaEducacao(usuario);
				f.setVisible(false);
			}
		});

		bTrabalho.setForeground(new Color(255, 255, 255));
		bTrabalho.setBackground(new Color(128, 128, 255));
		bTrabalho.setOpaque(true);
		bTrabalho.setBorderPainted(false);
		bTrabalho.setBounds(475, 370, 270, 34);
		bTrabalho.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaTrabalho(usuario);
				f.setVisible(false);
			}
		});

		f.add(opcao);
		f.add(bPessoal);
		f.add(bEducacao);
		f.add(bTrabalho);

		f.setSize(1200, 700);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(false);
		f.getContentPane().setBackground(new Color(0, 0, 121));
	}
}