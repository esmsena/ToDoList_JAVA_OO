package model;

import java.util.ArrayList;

/**
 * Classe Trabalho responsavel por cadastrar os dados da lista trabalho e herda
 * da classe Lista.
 * 
 * @author Esther Sena Martins, Mariiana Siqueira Neris
 *
 */

public class Trabalho extends Lista {

	private String destinatario;
	protected boolean Tipo2;

	/**
	 * Construtor responsavel por cadastrar o nome, destinatario e tipo os dados
	 * necessarios para criar uma lista do tipo Trabalho.
	 * 
	 * @param nome         String recebera o nome da lista que o usuario colocar.
	 * @param destinatario String recebera o destinatario da lista.
	 * @param tip2         boolean recebe o tipo de trabalho escolhido.
	 */

	public Trabalho(String nome, String destinatario, boolean tip2) {
		this.nome = nome;
		this.destinatario = destinatario;
		this.Tipo2 = tip2;
		this.tarefas = new ArrayList<>();
	}

	// gets sets

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public boolean getTipo2() {
		return Tipo2;
	}

	public void setTipo2(boolean Tipo2) {
		this.Tipo2 = Tipo2;
	}

	// outros metodos

	public String atualizaDados(boolean dados) {
		if (toString() == "Presencial") {
			Tipo2 = true;
		} else {
			Tipo2 = false;
		}
		return toString();
	}

}
