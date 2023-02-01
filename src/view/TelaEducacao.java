package view;

import model.Usuario;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.Educacao;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TelaEducacao extends JFrame implements ActionListener, ListSelectionListener {

	DefaultListModel model = new DefaultListModel();

	private JTextField Nome;
	private JTextField Campus;
	private JComboBox<String> Tipo1 = new JComboBox<>();
	private JComboBox<String> Participantes = new JComboBox<>();
	private JList<String> listasEducacao;

	public TelaEducacao(Usuario usuario) {
		super("Educacao");

		Container c = getContentPane();
		c.setLayout(null);

		Font fonte2 = new Font("Serif", Font.PLAIN, 18);
		Font fonte = new Font("Serif", Font.PLAIN, 20);

		JLabel label = new JLabel("Educacao");
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

		JLabel AdicionarCampus = new JLabel("Adicionar Campus:");
		AdicionarCampus.setForeground(Color.WHITE);
		AdicionarCampus.setFont(fonte2);
		AdicionarCampus.setBounds(650, 50, 220, 34);
		c.add(AdicionarCampus);

		JTextField Campus = new JTextField("", 15);
		Campus.setBounds(650, 80, 347, 34);
		c.add(Campus);

		JLabel JLTipo = new JLabel("Tipo:");
		JLTipo.setForeground(Color.WHITE);
		JLTipo.setFont(fonte2);
		JLTipo.setBounds(200, 120, 220, 34);
		c.add(JLTipo);

		JLabel Participantes1 = new JLabel("Participantes:");
		Participantes1.setForeground(Color.WHITE);
		Participantes1.setFont(fonte2);
		Participantes1.setBounds(650, 120, 220, 34);
		c.add(Participantes1);

		JComboBox<String> Tipo1 = new JComboBox();
		Tipo1.setBounds(200, 150, 220, 34);
		Tipo1.addItem("Prova");
		Tipo1.addItem("Trabalho");
		c.add(Tipo1);

		JComboBox<String> Participantes = new JComboBox();
		Participantes.setBounds(650, 150, 220, 34);
		Participantes.addItem("Solo");
		Participantes.addItem("Grupo");
		c.add(Participantes);

		String[] Lista = {};
		JList<String> listasEducacao = new JList<>(Lista);
		listasEducacao.setBounds(200, 250, 800, 300);
		listasEducacao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.add(listasEducacao);
		listasEducacao.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = e.getFirstIndex();
				new TelaTarefa(usuario, usuario.getEducacao().get(index), "educacao");
				dispose();
				setVisible(false);
			}
		});

		JButton botaoAdicionar = new JButton("ADICIONAR");
		botaoAdicionar.setBounds(630, 200, 150, 23);
		botaoAdicionar.setBackground(new Color(128, 128, 255));
		botaoAdicionar.setForeground(new Color(255, 255, 255));
		c.add(botaoAdicionar);

		// Listar previamente as tarefas

		ArrayList<Educacao> listaTarefaEducacao = usuario.getEducacao();
		for (Educacao educacao : listaTarefaEducacao) {

			String tipo = "Prova";
			String participantes = "Solo";

			if (educacao.getTipo1() == false) {
				tipo = "Trabalho";
			}

			if (educacao.getParticipantes() == false) {
				participantes = "Grupo";
			}

			model.addElement(educacao.getNome() + " - " + educacao.getCampus() + " - " + tipo + " - " + participantes);
		}
		listasEducacao.setModel(model);
		setVisible(true);

		botaoAdicionar.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Nome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Coloque um nome para a lista", "Atenção!",
							JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Lista criada!", "Parabéns!", JOptionPane.DEFAULT_OPTION);

					String nm = Nome.getText();
					String camp = Campus.getText();
					String tip1 = Tipo1.getSelectedItem().toString();
					String part = Participantes.getSelectedItem().toString();

					model.addElement(nm + " - " + camp + " - " + tip1 + " - " + part);
					listasEducacao.setModel(model);

					Boolean tipo1;

					if (tip1 == "Prova") {
						tipo1 = true;
					} else {
						tipo1 = false;
					}

					Boolean participantes;

					if (part == "Solo") {
						participantes = true;
					} else {
						participantes = false;
					}

					usuario.cadastrarEducacao(nm, camp, tipo1, participantes);

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

		listasEducacao.setModel(model);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

	}
}