package view;

import model.Trabalho;
import model.Usuario;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 
 * @author Esther Sena Martins
 * @author Mariiana Siqueira Neris
 * 
 * @since 2023
 * @version 1.1
 *
 */

public class TelaTrabalho extends JFrame implements ActionListener, ListSelectionListener {

	DefaultListModel model = new DefaultListModel();

	private JTextField Nome;
	private JTextField Destinatario;
	JComboBox<String> Tipo2 = new JComboBox<>();

	private JList<String> listasTrabalho;

	public TelaTrabalho(Usuario usuario) {
		super("Trabalho");

		Container c = getContentPane();
		c.setLayout(null);

		Font fonte2 = new Font("Serif", Font.PLAIN, 18);
		Font fonte = new Font("Serif", Font.PLAIN, 20);

		JLabel label = new JLabel("Trabalho");
		label.setFont(fonte);
		label.setForeground(Color.WHITE);
		label.setBounds(550, 0, 125, 40);
		c.add(label);

		JLabel AdicionarNome = new JLabel("Adicionar Nome:");
		AdicionarNome.setForeground(Color.WHITE);
		AdicionarNome.setFont(fonte2);
		AdicionarNome.setBounds(200, 50, 220, 34);
		c.add(AdicionarNome);

		JTextField Nome = new JTextField("", 15);
		Nome.setBounds(200, 80, 347, 34);
		c.add(Nome);

		JLabel AdicionarDestinatario = new JLabel("Adicionar Destinatário:");
		AdicionarDestinatario.setForeground(Color.WHITE);
		AdicionarDestinatario.setFont(fonte2);
		AdicionarDestinatario.setBounds(650, 50, 220, 34);
		c.add(AdicionarDestinatario);

		JTextField Destinatario = new JTextField("", 15);
		Destinatario.setBounds(650, 80, 347, 34);
		c.add(Destinatario);

		JLabel JLTipo = new JLabel("Tipo:");
		JLTipo.setForeground(Color.WHITE);
		JLTipo.setFont(fonte2);
		JLTipo.setBounds(480, 120, 220, 34);
		c.add(JLTipo);

		JComboBox<String> Tipo2 = new JComboBox();
		Tipo2.setBounds(480, 150, 220, 34);
		Tipo2.addItem("À Distância");
		Tipo2.addItem("Presencial");
		c.add(Tipo2);

		String[] Lista = {};
		JList<String> listasTrabalho = new JList<>(Lista);
		listasTrabalho.setBounds(200, 250, 800, 300);
		listasTrabalho.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.add(listasTrabalho);
		listasTrabalho.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = e.getFirstIndex();
				Trabalho listaSelecionada = usuario.getTrabalho().get(index);
				new TelaTarefa(usuario, listaSelecionada, "trabalho");
				dispose();
				setVisible(false);
			}
		});

		// Listar previamente as listas
		ArrayList<Trabalho> listaTarefaTrabalho = usuario.getTrabalho();
		for (Trabalho trabalho : listaTarefaTrabalho) {

			String tipo = "Presencial";

			if (trabalho.getTipo2() == false) {
				tipo = "À Distância";
			}

			model.addElement(trabalho.getNome() + " - " + trabalho.getDestinatario() + " - " + tipo);
		}
		listasTrabalho.setModel(model);
		setVisible(true);

		JButton botaoAdicionar = new JButton("ADICIONAR");
		botaoAdicionar.setLocation(50, 50);
		botaoAdicionar.setBounds(630, 200, 150, 23);
		botaoAdicionar.setBackground(new Color(128, 128, 255));
		botaoAdicionar.setForeground(new Color(255, 255, 255));
		botaoAdicionar.setOpaque(true);
		botaoAdicionar.setBorderPainted(false);

		c.add(botaoAdicionar);
		botaoAdicionar.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Nome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Coloque um nome para a lista", "Atenção!",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Lista criada!", "Parabéns!", JOptionPane.DEFAULT_OPTION);

					String nm = Nome.getText();
					String dest = Destinatario.getText();
					String tip2 = Tipo2.getSelectedItem().toString();

					model.addElement(nm + " - " + dest + " - " + tip2);
					listasTrabalho.setModel(model);

					Boolean tipo2;

					if (tip2 == "Presencial") {
						tipo2 = true;
					} else {
						tipo2 = false;
					}

					usuario.cadastrarTrabalho(nm, dest, tipo2);

					setVisible(true);
				}
			}

		});

		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.setBounds(450, 200, 150, 23);
		botaoVoltar.setBackground(new Color(128, 128, 255));
		botaoVoltar.setForeground(new Color(255, 255, 255));
		botaoVoltar.setOpaque(true);
		botaoVoltar.setBorderPainted(false);
		c.add(botaoVoltar);
		botaoVoltar.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuario.irParaTelaOpcao();
				dispose();
			}
		});

		c.setBackground(new Color(0, 0, 121));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 700);
		setVisible(true);
		setResizable(false);

		listasTrabalho.setModel(model);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
	}

}