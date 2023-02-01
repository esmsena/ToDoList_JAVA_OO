package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.CadastroUsuarioController;

/**
 * Classe responsavel por testar o metodo usado para apagar a lista pelo nome.
 * 
 * @author Esther Sena Martins
 * @author Mariiana Siqueira Neris
 */

class ApagarListaPeloNomeTU {

	@Test
	void test() {

		CadastroUsuarioController controle = new CadastroUsuarioController();

		/**
		 * Metodo responsavel por cadastrar um usuario e uma lista de Educacao
		 */
		controle.cadastrarUsuario("julia@gmail.com", "Julia");
		controle.usuario.cadastrarEducacao("Faculdade", "FGA", true, true);

		/**
		 * Metodo responsavel por apagar a lista criada
		 */
		controle.usuario.apagarListaPeloNome("Faculdade", "educacao");

		/**
		 * Metodo para verificar se a lista de educacao do usuario esta vazia e o
		 * resultado e comparado com o valor esperado (true).
		 */

		boolean resultadoFinal = controle.usuario.getEducacao().isEmpty();

		assertTrue(resultadoFinal);
	}

}
