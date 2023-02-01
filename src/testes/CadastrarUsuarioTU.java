package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.CadastroUsuarioController;

/**
 * Classe responsavel por testar o metodo usado para cadastrar um usuario.
 * 
 * @author Esther Sena Martins
 * @author Mariiana Siqueira Neris
 */

class CadastrarUsuarioTU {

	@Test
	void test() {
		CadastroUsuarioController controle = new CadastroUsuarioController();

		/**
		 * Metodo responsavel por cadastrar um usuario
		 */

		controle.cadastrarUsuario("julia@gmail.com", "Julia");

		/**
		 * Metodo para recuperar e armazenar o nome.
		 */
		String resultadoFinal = controle.usuario.getNome();
		String valor = "Julia";

		/**
		 * Metodo para comparar os valores do nome e o nome armazenado.
		 */
		assertEquals(valor, resultadoFinal);
	}

}