package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Usuario;
import model.Educacao;
import model.Lista;
import model.Pessoal;
import model.Tarefa;
import model.Trabalho;

/**
 * 
 * @author Esther Sena Martins
 * @author Mariiana Siqueira Neris
 * 
 * @since 2023
 * @version 1.1
 *
 */

public class TelaTarefa extends JFrame {

	DefaultListModel model = new DefaultListModel();

	private JTextField Nome = new JTextField("", 15);
	private JTextField Data = new JTextField("", 15);

	public TelaTarefa(Usuario usuario, Lista lista, String tipoLista) {
		super("Tarefa");

		Font fonte = new Font("Serif", Font.PLAIN, 20);
		String listaNome = "Lista " + lista.getNome();
		JLabel label = new JLabel(listaNome);
		label.setFont(fonte);
		label.setForeground(Color.WHITE);
		label.setBounds(550, 0, 355, 40);

		Container c = getContentPane();
		c.setLayout(null);
		Font fonte2 = new Font("Serif", Font.PLAIN, 18);

		JLabel AdicionarNome = new JLabel("Adicionar Nome:");
		AdicionarNome.setForeground(Color.WHITE);
		AdicionarNome.setFont(fonte2);
		AdicionarNome.setBounds(200, 50, 220, 34);

		Nome.setBounds(200, 80, 347, 34);

		JLabel AdicionarData = new JLabel("Data:");
		AdicionarData.setForeground(Color.WHITE);
		AdicionarData.setFont(fonte2);
		AdicionarData.setBounds(650, 50, 220, 34);

		Data.setBounds(650, 80, 347, 34);

		c.add(label);
		c.add(AdicionarNome);
		c.add(Nome);
		c.add(AdicionarData);
		c.add(Data);

		String[] Listas = {};
		JList jlista = new JList<>(Listas);
		jlista.setBounds(250, 250, 670, 300);
		jlista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		c.add(jlista);

		jlista.addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = e.getFirstIndex();
				Tarefa tarefaSelecionada = lista.getTarefas().get(index);
				new EdicaoTarefa(usuario, lista, tarefaSelecionada, tipoLista);
				dispose();
			}
		});

		JButton botaoAdicionar = new JButton("ADICIONAR");
		botaoAdicionar.setBounds(520, 200, 150, 23);
		botaoAdicionar.setBackground(new Color(128, 128, 255));
		botaoAdicionar.setForeground(new Color(255, 255, 255));
		botaoAdicionar.setOpaque(true);
		botaoAdicionar.setBorderPainted(false);
		botaoAdicionar.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.addElement(Nome.getText() + " - " + Data.getText());
				jlista.setModel(model);
				lista.cadastrarTarefa(Nome.getText(), Data.getText());
				JOptionPane.showMessageDialog(null, "Tarefa cadastrada com sucesso!");
			}
		});

		JButton botaoVoltar = new JButton("VOLTAR");
		botaoVoltar.setBounds(300, 600, 150, 23);
		botaoVoltar.setBackground(new Color(128, 128, 255));
		botaoVoltar.setForeground(new Color(255, 255, 255));
		botaoVoltar.setOpaque(true);
		botaoVoltar.setBorderPainted(false);
		botaoVoltar.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tipoLista.equals("pessoal")) {
					new TelaPessoal(usuario);
				} else if (tipoLista.equals("educacao")) {
					new TelaEducacao(usuario);
				} else {
					new TelaTrabalho(usuario);
				}

				dispose();
			}
		});

		JButton botaoEditar = new JButton("EDITAR LISTA");
		botaoEditar.setBounds(500, 600, 150, 23);
		botaoEditar.setBackground(new Color(128, 128, 255));
		botaoEditar.setForeground(new Color(255, 255, 255));
		botaoEditar.setOpaque(true);
		botaoEditar.setBorderPainted(false);
		botaoEditar.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.clear();

				if (tipoLista.equals("pessoal")) {
					new EdicaoPessoal(usuario, (Pessoal) lista);
				} else if (tipoLista.equals("educacao")) {
					new EdicaoEducacao(usuario, (Educacao) lista);
				} else {
					new EdicaoTrabalho(usuario, (Trabalho) lista);
				}

				dispose();
			}
		});

		JButton botaoExcluir = new JButton("EXCLUIR LISTA");
		botaoExcluir.setBounds(700, 600, 150, 23);
		botaoExcluir.setBackground(new Color(128, 128, 255));
		botaoExcluir.setForeground(new Color(255, 255, 255));
		botaoExcluir.setOpaque(true);
		botaoExcluir.setBorderPainted(false);
		botaoExcluir.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeDaLista = lista.getNome();
				usuario.apagarListaPeloNome(nomeDaLista, tipoLista);
				JOptionPane.showMessageDialog(null, "Lista " + nomeDaLista + " apagada!", "Sucesso!",
						JOptionPane.DEFAULT_OPTION);
				if (tipoLista.equals("pessoal")) {
					new TelaPessoal(usuario);
				} else if (tipoLista.equals("educacao")) {
					new TelaEducacao(usuario);
				} else {
					new TelaTrabalho(usuario);
				}

			}
		});

		c.add(botaoAdicionar);
		c.add(botaoVoltar);
		c.add(botaoEditar);
		c.add(botaoExcluir);

		// Listar previamente as tarefas
		ArrayList<Tarefa> listaDeTarefas = lista.getTarefas();
		for (Tarefa tarefa : listaDeTarefas) {
			model.addElement(tarefa.getTitulo() + " - " + tarefa.getData());
		}
		jlista.setModel(model);
		setVisible(true);

		c.setBackground(new Color(0, 0, 121));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 700);
		setVisible(true);

	}

}