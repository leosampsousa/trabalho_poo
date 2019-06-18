import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstoqueProdutosTest {

	@BeforeEach
	void setUp() throws Exception {
		new Perfume("Perfume1", 10, 20, 23);
		new Perfume("Perfume2", 10, 20, 17);
		new Sabonete("Sabonete1", 10, 20, 14);
		new Sabonete("Sabonete2", 10, 20, 30);
		new Shampoo("Shampoo1", 10, 20, 11);
		new Shampoo("Shampoo2", 10, 20, 13);
		new Desodorante("Desodorante1", 10, 20, 10);
		new Desodorante("Desodorante2", 10, 20, 8);
		
		EstoqueProdutos.getInstancia().listaProdutos.get(0).setQtVendidos(6);
		EstoqueProdutos.getInstancia().listaProdutos.get(1).setQtVendidos(3);
		EstoqueProdutos.getInstancia().listaProdutos.get(2).setQtVendidos(2);
		EstoqueProdutos.getInstancia().listaProdutos.get(3).setQtVendidos(9);
		EstoqueProdutos.getInstancia().listaProdutos.get(4).setQtVendidos(5);
		EstoqueProdutos.getInstancia().listaProdutos.get(5).setQtVendidos(13);
		EstoqueProdutos.getInstancia().listaProdutos.get(6).setQtVendidos(4);
		EstoqueProdutos.getInstancia().listaProdutos.get(7).setQtVendidos(7);
	}

	@Test
	void testListarPorCategoria() {
		List<Produto> lista = new ArrayList<Produto>();
		List<Produto> categoria = new ArrayList<Produto>();
		//categoria deve ter os produtos do tipo perfume.No metodo setUp, 
		//instanciei 2 perfumes, 1 com 23 de quantidade e o outro com 17.
		//agora é só verificar se são esses produtos que estao na lista categoria
		lista = EstoqueProdutos.getInstancia().listaProdutos;
		
		//passando perfume no metodo listarPorCategoria
		categoria = EstoqueProdutos.getInstancia().listarPorCategoria(1);
		
		//Perfume
		
		int qtEsperadaPerfume = categoria.get(0).getQtProduto();
		int qtRealPerfume = lista.get(0).getQtProduto();
		
		assertEquals(qtEsperadaPerfume,qtRealPerfume,0);
		
		qtEsperadaPerfume = categoria.get(1).getQtProduto();
		qtRealPerfume = lista.get(1).getQtProduto();
		
		assertEquals(qtEsperadaPerfume,qtRealPerfume,0);
		
		//Sabonete
		
		categoria = EstoqueProdutos.getInstancia().listarPorCategoria(2);
		
		int qtEsperadaSabonete = categoria.get(0).getQtProduto();
		int qtRealSabonete = lista.get(2).getQtProduto();
		
		assertEquals(qtEsperadaSabonete,qtRealSabonete,0);
		
		qtEsperadaSabonete = categoria.get(1).getQtProduto();
		qtRealSabonete = lista.get(3).getQtProduto();
		
		assertEquals(qtEsperadaSabonete,qtRealSabonete,0);
		
		//Shampoo
		categoria = EstoqueProdutos.getInstancia().listarPorCategoria(3);
		
		int qtEsperadaShampoo = categoria.get(0).getQtProduto();
		int qtRealShampoo = lista.get(4).getQtProduto();
		
		assertEquals(qtEsperadaShampoo,qtRealShampoo,0);
		
		qtEsperadaShampoo = categoria.get(1).getQtProduto();
		qtRealShampoo = lista.get(5).getQtProduto();
		
		assertEquals(qtEsperadaShampoo,qtRealShampoo,0);
		
		//Desodorante
		
		categoria = EstoqueProdutos.getInstancia().listarPorCategoria(4);
		
		int qtEsperadaDesodorante = categoria.get(0).getQtProduto();
		int qtRealDesodorante = lista.get(6).getQtProduto();
		
		assertEquals(qtEsperadaDesodorante, qtRealDesodorante,0);
		
		qtEsperadaDesodorante = categoria.get(1).getQtProduto();
		qtRealDesodorante = lista.get(7).getQtProduto();
		
		assertEquals(qtEsperadaDesodorante,qtRealDesodorante,0);
	}

	@Test
	void testListarMaisVendidos() {
		List<Produto> maisVendidos = new ArrayList<Produto>();
		maisVendidos = EstoqueProdutos.getInstancia().listarMaisVendidos(8);
		
		int retornoEsperado;
		int retorno;
		
		//Confirmando que o método ordenou pelos mais vendidos
		
		retornoEsperado = EstoqueProdutos.getInstancia().listaProdutos.get(5).getQtVendidos();
		retorno = maisVendidos.get(0).getQtVendidos();
		assertEquals(retornoEsperado, retorno, 0);
		
		retornoEsperado = EstoqueProdutos.getInstancia().listaProdutos.get(3).getQtVendidos();
		retorno = maisVendidos.get(1).getQtVendidos();
		assertEquals(retornoEsperado, retorno, 0);
		
		retornoEsperado = EstoqueProdutos.getInstancia().listaProdutos.get(7).getQtVendidos();
		retorno = maisVendidos.get(2).getQtVendidos();
		assertEquals(retornoEsperado, retorno, 0);
		
		retornoEsperado = EstoqueProdutos.getInstancia().listaProdutos.get(0).getQtVendidos();
		retorno = maisVendidos.get(3).getQtVendidos();
		assertEquals(retornoEsperado, retorno, 0);
		
		retornoEsperado = EstoqueProdutos.getInstancia().listaProdutos.get(4).getQtVendidos();
		retorno = maisVendidos.get(4).getQtVendidos();
		assertEquals(retornoEsperado, retorno, 0);
		
		retornoEsperado = EstoqueProdutos.getInstancia().listaProdutos.get(6).getQtVendidos();
		retorno = maisVendidos.get(5).getQtVendidos();
		assertEquals(retornoEsperado, retorno, 0);
		
		retornoEsperado = EstoqueProdutos.getInstancia().listaProdutos.get(1).getQtVendidos();
		retorno = maisVendidos.get(6).getQtVendidos();
		assertEquals(retornoEsperado, retorno, 0);
		
		retornoEsperado = EstoqueProdutos.getInstancia().listaProdutos.get(2).getQtVendidos();
		retorno = maisVendidos.get(7).getQtVendidos();
		assertEquals(retornoEsperado, retorno, 0);
	}

	@Test
	void testListarMaisVendidosPorCategoria() {
		
		List<Produto> lista = new ArrayList<Produto>();
		List<Produto> categoria = new ArrayList<Produto>();		
		
		//Perfume
		categoria = EstoqueProdutos.getInstancia().listarPorCategoria(1);
		lista = EstoqueProdutos.getInstancia().listarMaisVendidosPorCategoria(2, 1);
		
		int qtEsperadaPerfume = lista.get(0).getQtVendidos();
		int qtRealPerfume = categoria.get(0).getQtVendidos();
		assertEquals(qtEsperadaPerfume,qtRealPerfume,0);
		
		
		qtEsperadaPerfume = lista.get(1).getQtVendidos();
		qtRealPerfume = categoria.get(1).getQtVendidos();
		assertEquals(qtEsperadaPerfume,qtRealPerfume,0);
		
		//Sabonete
		categoria = EstoqueProdutos.getInstancia().listarPorCategoria(2);
		lista = EstoqueProdutos.getInstancia().listarMaisVendidosPorCategoria(2, 2);
		
		int qtEsperadaSabonete = lista.get(0).getQtVendidos();
		int qtRealSabonete = categoria.get(1).getQtVendidos();
		
		assertEquals(qtEsperadaSabonete,qtRealSabonete,0);

		qtEsperadaPerfume = lista.get(1).getQtVendidos();
		qtRealPerfume = categoria.get(0).getQtVendidos();
		assertEquals(qtEsperadaSabonete,qtRealSabonete,0);
		
	}

}
