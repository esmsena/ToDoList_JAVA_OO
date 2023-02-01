package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Lista;
import model.Tarefa;
import model.Usuario;
import view.TelaTarefa;

/**
 * 
 * @author Esther Sena Martins
 * @author Mariiana Siqueira Neris
 * 
 * @since 2023
 * @version 1.1
 *
 */

public class EdicaoTarefa extends JFrame {

	public EdicaoTarefa(Usuario usuario, Lista lista, Tarefa tarefa, String tipoLista) {
		super("Edição Tarefa");

		Container c = getContentPane();
		c.setLayout(null);

		Font fonte = new Font("Serif", Font.PLAIN, 20);
		JLabel label = new JLabel("Editar Tarefa: " + tarefa.getTitulo());
		label.setFont(fonte);
		label.setForeground(Color.WHITE);
		label.setBounds(210, 0, 225, 40);
		c.add(label);

		Font fonte2 = new Font("Serif", Font.PLAIN, 18);

		JLabel EditarNome = new JLabel("Editar Nome:");
		EditarNome.setForeground(Color.WHITE);
		EditarNome.setFont(fonte2);
		EditarNome.setBounds(50, 50, 230, 34);
		c.add(EditarNome);

		JTextField Nome = new JTextField(tarefa.getTitulo());
		Nome.setBounds(50, 80, 230, 34);
		c.add(Nome);

		JLabel EditarData = new JLabel("Editar Data:");
		EditarData.setForeground(Color.WHITE);
		EditarData.setFont(fonte2);
		EditarData.setBounds(300, 50, 230, 34);
		c.add(EditarData);

		JTextField Data = new JTextField(tarefa.getData());
		Data.setBounds(300, 80, 230, 34);
		c.add(Data);

		JButton jbtVoltar = new JButton("Voltar");
		jbtVoltar.setForeground(new Color(255, 255, 255));
		jbtVoltar.setBackground(new Color(0, 0, 121));
		jbtVoltar.setBounds(400, 195, 130, 40);
		jbtVoltar.setOpaque(true);
		jbtVoltar.setBorderPainted(false);
		c.add(jbtVoltar);
		jbtVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaTarefa(usuario, lista, tipoLista);
				dispose();
			}
		});

		JButton jbtSalvar = new JButton("Salvar");
		jbtSalvar.setForeground(new Color(255, 255, 255));
		jbtSalvar.setBackground(new Color(0, 0, 121));
		jbtSalvar.setBounds(250, 195, 130, 40);
		jbtSalvar.setOpaque(true);
		jbtSalvar.setBorderPainted(false);
		c.add(jbtSalvar);
		jbtSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tarefa.setTitulo(Nome.getText());
				tarefa.setData(Data.getText());
				new TelaTarefa(usuario, lista, tipoLista);
				dispose();
			}
		});

		JButton jbtApagar = new JButton("Apagar");
		jbtApagar.setForeground(new Color(255, 255, 255));
		jbtApagar.setBackground(new Color(0, 0, 121));
		jbtApagar.setBounds(80, 195, 130, 40);
		jbtApagar.setOpaque(true);
		jbtApagar.setBorderPainted(false);
		c.add(jbtApagar);
		jbtApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista.removerTarefa(tarefa.getTitulo());
				new TelaTarefa(usuario, lista, tipoLista);
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