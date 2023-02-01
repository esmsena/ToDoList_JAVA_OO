package view;

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

import model.Pessoal;
import model.Usuario;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Classe que define a tela em que e possível cadastrar uma lista do tipo
 * pessoal
 * 
 * @author Esther Sena Martins
 * @author Mariiana Siqueira Neris
 *
 */

public class TelaPessoal extends JFrame implements ActionListener, ListSelectionListener {

	DefaultListModel model = new DefaultListModel();

	private JTextField Nome;
	private JTextField Local;
	private JComboBox<String> Tipo = new JComboBox<>();

	private JList<String> jListaPessoal;

	/**
	 * Metodo que contem os campos nome, local e tipo necessarios para criar a
	 * lista, alem de cadastrar essa lista.
	 * 
	 * @param usuario utilizado para salvar a lista.
	 */

	public TelaPessoal(Usuario usuario) {
		super("Pessoal");

		Container c = getContentPane();
		c.setLayout(null);
		Font fonte2 = new Font("Serif", Font.PLAIN, 18);

		Font fonte = new Font("Serif", Font.PLAIN, 20);
		JLabel label = new JLabel("Pessoal");
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

		JLabel AdicionarLocal = new JLabel("Adicionar Local:");
		AdicionarLocal.setForeground(Color.WHITE);
		AdicionarLocal.setFont(fonte2);
		AdicionarLocal.setBounds(650, 50, 220, 34);
		c.add(AdicionarLocal);

		JTextField Local = new JTextField("", 15);
		Local.setBounds(650, 80, 347, 34);
		c.add(Local);

		JLabel JLTipo = new JLabel("Tipo:");
		JLTipo.setForeground(Color.WHITE);
		JLTipo.setFont(fonte2);
		JLTipo.setBounds(480, 120, 220, 34);
		c.add(JLTipo);

		JComboBox<String> Tipo = new JComboBox();
		Tipo.setBounds(480, 150, 220, 34);
		Tipo.addItem("Saúde");
		Tipo.addItem("Gerais");
		c.add(Tipo);

		String[] Lista = {};
		JList<String> jListaPessoal = new JList<>(Lista);
		jListaPessoal.setBounds(200, 250, 800, 300);
		jListaPessoal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.add(jListaPessoal);
		jListaPessoal.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = e.getFirstIndex();

				new TelaTarefa(usuario, usuario.getPessoal().get(index), "pessoal");
				dispose();
				setVisible(false);
			}
		});

		// Listar previamente as listas
		ArrayList<Pessoal> listaTarefaPessoal = usuario.getPessoal();
		for (Pessoal pessoal : listaTarefaPessoal) {
			String tipo = "Saúde";

			if (pessoal.getTipo() == false) {
				tipo = "Gerais";
			}

			model.addElement(pessoal.getNome() + " - " + pessoal.getLocal() + " - " + tipo);
		}
		jListaPessoal.setModel(model);
		setVisible(true);

		JButton botaoAdicionar = new JButton("ADICIONAR");
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

					String nome = Nome.getText();
					String local = Local.getText();
					String tip = Tipo.getSelectedItem().toString();

					model.addElement(nome + " - " + local + " - " + tip);
					jListaPessoal.setModel(model);

					Boolean Tipo;

					if (tip == "saude") {
						Tipo = true;
					} else {
						Tipo = false;
					}

					usuario.cadastrarPessoal(nome, local, Tipo);
					setVisible(true);

					JOptionPane.showMessageDialog(null, "Lista criada!", "Parabéns!", JOptionPane.DEFAULT_OPTION);
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
		setResizable(true);

		jListaPessoal.setModel(model);

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