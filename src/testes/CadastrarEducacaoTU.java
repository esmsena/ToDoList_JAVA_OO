package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.CadastroUsuarioController;

/**
 * Classe responsavel por testar o metodo usado para cadastrar uma lista
 * Educacao.
 * 
 * @author Esther Sena Martins
 * @author Mariiana Siqueira Neris
 */

class CadastrarEducacaoTU {

	@Test
	void test() {

		CadastroUsuarioController controle = new CadastroUsuarioController();

		/**
		 * Metodo responsavel por cadastrar um usuario
		 */
		controle.cadastrarUsuario("julia@gmail.com", "Julia");

		/**
		 * Metodo responsavel por cadastrar uma lista do tipo Educacao.
		 */

		controle.usuario.cadastrarEducacao("Faculdade", "FGA", true, true);

		/**
		 * Metodo para verificar se a lista de educacao do usuario esta vazia e o
		 * resultado e comparado com o valor esperado (false).
		 */

		boolean resultadoFinal = controle.usuario.getEducacao().isEmpty();

		assertFalse(resultadoFinal);
	}

}