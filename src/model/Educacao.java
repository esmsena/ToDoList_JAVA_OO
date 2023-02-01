package model;

import java.util.ArrayList;

/**
 * Classe Educacao responsável por cadastrar os dados da lista educacao e herda
 * da classe Lista.
 * 
 * @author Esther Sena Martins, Mariiana Siqueira Neris
 *
 */

public class Educacao extends Lista {

	protected String campus;
	protected boolean Tipo1;
	private boolean Participantes;
	private boolean tipo1;

	/**
	 * Construtor responsavel por cadastrar o nome, campus, tipo e participantes os
	 * dados necessarios para criar uma lista do tipo Educacao.
	 * 
	 * @param nome   String recebera o nome da lista que o usuario colocar.
	 * @param campus String recebera o campus da lista.
	 * @param tip1   boolean recebe o tipo de estudo escolhido.
	 * @param part   boolean recebe o tipo de participante escolhido.
	 */

	public Educacao(String nome, String campus, boolean tip1, boolean part) {
		this.nome = nome;
		this.campus = campus;
		this.Tipo1 = tip1;
		this.Participantes = part;
		this.tarefas = new ArrayList<>();
	}

	// gets sets

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	public boolean getTipo1() {
		return tipo1;
	}

	public void setTipo1(boolean tipo1) {
		this.Tipo1 = tipo1;
	}

	// outros metodos

	public String atualizaDados(boolean dados) {
		if (toString() == "Prova") {
			tipo1 = true;
		} else {
			tipo1 = false;
		}
		return toString();
	}

	public boolean getParticipantes() {
		return Participantes;
	}

	public void setParticipantes(boolean participantes) {
		this.Participantes = participantes;
	}

	@Override
	public String toString() {
		String part;
		if (Participantes == true) {
			part = "Solo";
		} else {
			part = "Grupo";
		}
		return part;
	}

}