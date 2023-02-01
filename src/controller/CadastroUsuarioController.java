package controller;

import listadetarefas.Educacao;
import listadetarefas.Pessoal;
import listadetarefas.Usuario;

import java.util.ArrayList;

import view.TelaOpcao;

/**
 * Classe para cadastrar um usuário, listas e tarefas e liga o package view e o
 * package model.
 * 
 * @author Esther Sena Martins
 * @author Mariiana Siqueira Neris
 *
 */

public class CadastroUsuarioController {

	public static Usuario usuario;

	// cadastrar usuario
	public void cadastrarUsuario(String email, String nome) {
		usuario = new Usuario(email, nome);
		cadastrarDadosIniciais(usuario);

		new TelaOpcao(usuario);
	}

	public void cadastrarDadosIniciais(Usuario usuario) {
		ArrayList<Pessoal> listaPessoal = usuario.getPessoal();
		ArrayList<Educacao> listaEducacao = usuario.getEducacao();

		// Lista Padrão
		Pessoal listaPessoalPadrao = new Pessoal("Tarefas de Casa", "Casa", false);
		listaPessoalPadrao.cadastrarTarefa("Limpar casa", "29/01");

		Educacao listaEducacaoPadrao = new Educacao("Tarefas de Estudo", "Faculdade", false, true);
		listaEducacaoPadrao.cadastrarTarefa("Estudar para Prova de OO", "31/01");

		// Tarefa Padrão
		listaPessoal.add(listaPessoalPadrao);
		listaEducacao.add(listaEducacaoPadrao);
	}

}