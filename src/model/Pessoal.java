package model;

import java.util.ArrayList;

/**
 * Classe Pessoal responsavel por cadastrar os dados da lista pessoal e herda da
 * classe Lista.
 * 
 * @author Esther Sena Martins, Mariiana Siqueira Neris
 *
 */

public class Pessoal extends Lista {

	private String local;
	private boolean tipo;

	/**
	 * Construtor responsavel por cadastrar o nome, local e tipo os dados
	 * necessarios para criar uma lista do tipo Pessoal.
	 * 
	 * @param nome  String recebera o nome da lista que o usuario colocar.
	 * @param local String recebera o local da lista.
	 * @param tipo  boolean recebe o tipo escolhido.
	 */

	public Pessoal(String nome, String local, boolean tipo) {
		this.nome = nome;
		this.local = local;
		this.tipo = tipo;
		this.tarefas = new ArrayList<>();
	}

	// gets sets

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public boolean getTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public void add(Pessoal listaPessoal) {
		System.out.println(listaPessoal);
	}

	public Object getTitulo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

}