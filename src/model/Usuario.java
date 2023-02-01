package model;

import java.util.ArrayList;
import view.TelaOpcao;

/**
 * 
 * @author Esther Sena Martins
 * @author Mariiana Siqueira Neris
 * 
 * @since 2023
 * @version 1.1
 *
 */

public class Usuario {

	// atributos

	private String email;
	private String nome;
	private ArrayList<Educacao> listaEducacao;
	private ArrayList<Pessoal> listaPessoal;
	private ArrayList<Trabalho> listaTrabalho;

	// construtor

	public Usuario(String email, String nome) {
		this.email = email;
		this.nome = nome;
		this.listaEducacao = new ArrayList<>();
		this.listaTrabalho = new ArrayList<>();
		this.listaPessoal = new ArrayList<>();
	}

	public void irParaTelaOpcao() {
		new TelaOpcao(this);
	}

	// gets e sets
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Educacao> getEducacao() {
		return listaEducacao;
	}

	public ArrayList<Pessoal> getPessoal() {
		return listaPessoal;
	}

	public ArrayList<Trabalho> getTrabalho() {
		return listaTrabalho;
	}

	public int pegarIndexListaPessoalPeloNome(String nome) {
		int index = -1;
		for (int i = 0; i < listaPessoal.size(); i++) {
			if (listaPessoal.get(i).nome.equals(nome)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public int pegarIndexListaEducacaoPeloNome(String nome) {
		int index = -1;
		for (int i = 0; i < listaEducacao.size(); i++) {
			if (listaEducacao.get(i).nome.equals(nome)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public int pegarIndexListaTrabalhoPeloNome(String nome) {
		int index = -1;
		for (int i = 0; i < listaTrabalho.size(); i++) {
			if (listaTrabalho.get(i).nome.equals(nome)) {
				index = i;
				break;
			}
		}
		return index;
	}

	public void apagarListaPeloNome(String nome, String tipo) {
		if (tipo.equals("pessoal")) {
			int index = this.pegarIndexListaPessoalPeloNome(nome);
			listaPessoal.remove(index);
		} else if (tipo.equals("educacao")) {
			int index = this.pegarIndexListaEducacaoPeloNome(nome);
			listaEducacao.remove(index);
		} else if (tipo.equals("trabalho")) {
			int index = this.pegarIndexListaTrabalhoPeloNome(nome);
			listaTrabalho.remove(index);
		}

		this.irParaTelaOpcao();
	}

	public void cadastrarEducacao(String nome, String campus, boolean tipo, boolean part) {
		Educacao listaCadastradaEducacao = new Educacao(nome, campus, tipo, part);
		listaEducacao.add(listaCadastradaEducacao);
	}

	public void cadastrarPessoal(String nome, String local, boolean tipo) {
		Pessoal listaCadastradaPessoal = new Pessoal(nome, local, tipo);
		listaPessoal.add(listaCadastradaPessoal);
	}

	public void cadastrarTrabalho(String nome, String destinatario, boolean tipo) {
		Trabalho listaCadastradaTrabalho = new Trabalho(nome, destinatario, tipo);
		listaTrabalho.add(listaCadastradaTrabalho);
	}

}
