package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Trabalho;
import model.Usuario;

/**
 * 
 * @author Esther Sena Martins
 * @author Mariiana Siqueira Neris
 * 
 * @since 2023
 * @version 1.1
 *
 */

public class EdicaoTrabalho extends JFrame {

	public EdicaoTrabalho(Usuario usuario, Trabalho lista) {
		super("Edição Traabalho");

		Container c = getContentPane();
		c.setLayout(null);

		Font fonte = new Font("Serif", Font.PLAIN, 20);
		JLabel label = new JLabel("Editar");
		label.setFont(fonte);
		label.setForeground(Color.WHITE);
		label.setBounds(250, 0, 125, 40);
		c.add(label);

		Font fonte2 = new Font("Serif", Font.PLAIN, 18);

		JLabel EditarNome = new JLabel("Editar Nome:");
		EditarNome.setForeground(Color.WHITE);
		EditarNome.setFont(fonte2);
		EditarNome.setBounds(50, 50, 230, 34);
		c.add(EditarNome);

		JTextField Nome = new JTextField(lista.getNome());
		Nome.setBounds(50, 80, 230, 34);
		c.add(Nome);

		JLabel EditarDestinatario = new JLabel("Editar Destinatário:");
		EditarDestinatario.setForeground(Color.WHITE);
		EditarDestinatario.setFont(fonte2);
		EditarDestinatario.setBounds(300, 50, 230, 34);
		c.add(EditarDestinatario);

		JTextField Destinatario = new JTextField(lista.getDestinatario());
		Destinatario.setBounds(300, 80, 230, 34);
		c.add(Destinatario);

		JButton jbtSalvar = new JButton("Salvar");
		jbtSalvar.setForeground(new Color(255, 255, 255));
		jbtSalvar.setBackground(new Color(0, 0, 121));
		jbtSalvar.setBounds(215, 195, 130, 40);
		jbtSalvar.setOpaque(true);
		jbtSalvar.setBorderPainted(false);
		c.add(jbtSalvar);

		jbtSalvar.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nomeP = Nome.getText();
				String DestinatarioP = Destinatario.getText();

				lista.setNome(nomeP);
				lista.setDestinatario(DestinatarioP);

				JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");

				new TelaTrabalho(usuario);
				dispose();
			}
		});

		c.setBackground(new Color(128, 128, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);
		setVisible(true);
		setResizable(false);

	}

}