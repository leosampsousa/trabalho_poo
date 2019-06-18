import static org.junit.jupiter.api.Assertions.*;

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
		
	}

	@Test
	void testListarPorCategoria() {
		fail("Not yet implemented");
	}

	@Test
	void testListarMaisVendidos() {
		fail("Not yet implemented");
	}

	@Test
	void testListarMaisVendidosPorCategoria() {
		fail("Not yet implemented");
	}

}
