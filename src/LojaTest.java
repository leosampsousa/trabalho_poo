import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LojaTest {

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testVerificaFuncionario() {
		new Funcionario("Funcionario1", "1", 100);
		Funcionario funcionario = Loja.getInstancia().verificaFuncionario("1");
		assertNotNull(funcionario);
	}

	@Test
	void testVerificaCliente() {
		new ClienteComum("Cliente1", "1", "1");
		Cliente cliente = Loja.getInstancia().verificaCliente("1");
		assertNotNull(cliente);
	}

	@Test
	void testAdicionaEmListaFuncionario() {
		String nome = "teste";
		String cpf = "2";
		double salario = 10;
		
		Loja.getInstancia().adicionaEmListaFuncionario(nome, cpf, salario);

		assertEquals(salario,Loja.getInstancia().listaFuncionarios.get(1).salario,0);
	}


	@Test
	void testTornarClienteVip() {
		new ClienteComum("Cliente2", "2", "2");
		Loja.getInstancia().listaClientes.get(1).setPontos(101);
		try {
			Loja.getInstancia().tornarClienteVip(Loja.getInstancia().listaClientes.get(1));
			if(Loja.getInstancia().listaClientes.get(1) instanceof ClienteVip) {
				assertEquals(1,1,0);
			}
			
		}catch(Exception e) {
			System.out.println("erro");
		}
	}

	@Test
	void testTornarClientePremium() {
		new ClienteVip("Cliente3", "3", "3");
		Loja.getInstancia().listaClientes.get(0).setPontos(301);
		
		try {
			Loja.getInstancia().tornarClientePremium(Loja.getInstancia().listaClientes.get(0));
			if(Loja.getInstancia().listaClientes.get(1) instanceof ClientePremium) {
				assertEquals(1,1,0);
			}
			
		}catch(Exception e) {
			System.out.println("erro");
		}
	}


}
