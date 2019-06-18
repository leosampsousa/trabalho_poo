import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		new ClienteComum("Cliente1", "1", "1");
		new ClienteComum("Cliente2", "2", "2");
		new ClienteComum("Cliente3", "3", "3");
		new ClienteComum("Cliente4", "4", "4");
		
		new Funcionario("Funcionario1", "1", 100);
		new Funcionario("Funcionario2", "2", 200);
		new Funcionario("Funcionario3", "3", 300);
		new Funcionario("Funcionario4", "4", 400);
		new Funcionario("Funcionario4", "5", 250);
		new Funcionario("Funcionario4", "6", 300);
		new Funcionario("Funcionario4", "7", 250);
		new Funcionario("Funcionario4", "8", 350);
		new Funcionario("Funcionario4", "9", 400);
		new Funcionario("Funcionario4", "10", 150);
		
		new Perfume("Perfume1", 10, 20, 23);
		new Perfume("Perfume2", 10, 20, 17);
		new Perfume("Perfume3", 10, 20, 15);
		new Perfume("Perfume4", 10, 20, 12);
		new Sabonete("Sabonete1", 10, 20, 14);
		new Sabonete("Sabonete2", 10, 20, 30);
		new Sabonete("Sabonete3", 10, 20, 21);
		new Sabonete("Sabonete4", 10, 20, 10);
		new Shampoo("Shampoo1", 10, 20, 11);
		new Shampoo("Shampoo2", 10, 20, 13);
		new Shampoo("Shampoo3", 10, 20, 14);
		new Shampoo("Shampoo4", 10, 20, 17);
		new Desodorante("Desodorante1", 10, 20, 10);
		new Desodorante("Desodorante2", 10, 20, 8);
		new Desodorante("Desodorante3", 10, 20, 12);
		new Desodorante("Desodorante4", 10, 20, 15);
		
		System.out.println(Loja.getInstancia().toString());
		
		String auxiliador;
		boolean menu = true;
		while(menu) {
			auxiliador = abrirMenu();
			
			if(auxiliador == "8") {
				menu = false;
			}
		}

	}
	
	private static String abrirMenu() {
		System.out.println("-------------------");
		System.out.println("Menu Loja");
		System.out.println("-------------------");


		System.out.println("1 - Realizar venda");
		System.out.println("2 - Consultar informações dos clientes");
		System.out.println("3 - Consultar informações dos produtos");
		System.out.println("4 - Consultar informações dos funcionários");
		System.out.println("5 - Consultar informações de compras");
		System.out.println("6 - Consultar estoque");
		System.out.println("7 - Sobre");
		System.out.println("8 - Sair");
		
		Scanner ler = new Scanner(System.in);
		
		boolean entradaErrada = true;
		String auxiliador = "";
	
		while(entradaErrada) {
			System.out.printf("Informe a sua entrada:\n");
			auxiliador = ler.next();
		
			if(!auxiliador.equals("1") && !auxiliador.equals("2") && !auxiliador.equals("3") && !auxiliador.equals("4") && !auxiliador.equals("5") && !auxiliador.equals("6")) {
				System.out.printf("Entrada inv�lida:\n");
			}else {entradaErrada = false;}
		}
			
		if(auxiliador.equals("1")) {
			realizarVenda(ler);
		} else if(auxiliador.equals("2")) {
			abrirMenuCliente(ler);
		} else if(auxiliador.equals("3")) {
			abrirMenuProduto(ler);
		} else if(auxiliador.equals("4")) {
			abrirMenuFuncionario(ler);
		} else if(auxiliador.equals("5")){
			System.out.println(Loja.getInstancia().getListaCompras().toString());
		} else if(auxiliador.equals("6")) {
			abrirMenuEstoque(ler);
		}
				
		return auxiliador;
	}
	
	private static void abrirMenuCliente(Scanner ler) {
		System.out.println("-------------------");
		System.out.println("Clientes");
		System.out.println("-------------------");
		System.out.println("1 - Cadastrar Cliente");
		System.out.println("2 - Promover Cliente");
		System.out.println("3 - Exibir Clientes");
		System.out.println("4 - Sair");
			
		String auxiliador = "";
		boolean entradaErrada = true;
		while(entradaErrada) {
			System.out.printf("Informe a sua entrada:\n");
			auxiliador = ler.next();
			if(!auxiliador.equals("1") && !auxiliador.equals("2") && !auxiliador.equals("3") && !auxiliador.equals("4")) {
				System.out.printf("Entrada inv�lida:\n");
			}else {entradaErrada = false;}
		}
		
		if(auxiliador.equals("1")) {
			Loja.getInstancia().cadastrarCliente(ler);
		} else if(auxiliador.equals("2")) {
			Loja.getInstancia().promoverCliente(ler);
		} else if(auxiliador.equals("3") ) {
			System.out.println(Loja.getInstancia().getListaClientes().toString());
		} else {
			abrirMenu();
		}
		
		
	}
	
	private static void abrirMenuProduto(Scanner ler) {
		System.out.println("-------------------");
		System.out.println("Produtos");
		System.out.println("-------------------");
		System.out.println("1 - Cadastrar Produto");
		System.out.println("2 - Remover Produto");
		System.out.println("3 - Sair");
			
		String auxiliador = "";
		boolean entradaErrada = true;
		while(entradaErrada) {
			System.out.printf("Informe a sua entrada:\n");
			auxiliador = ler.next();
			if(!auxiliador.equals("1") && !auxiliador.equals("2") && !auxiliador.equals("3") && !auxiliador.equals("4")) {
				System.out.printf("Entrada inv�lida:\n");
			}else {entradaErrada = false;}
		}
		
		if(auxiliador.equals("1")) {
			EstoqueProdutos.getInstancia().cadastrarProduto(ler);
		} else if(auxiliador.equals("2")) {
			System.out.printf("Deseja remover todo o produto do estoque ou apenas uma unidade?\n");
			System.out.printf("1 - Tudo\n");
			System.out.printf("2 - Unidade\n");
			int entrada = ler.nextInt();
			if(entrada == 1) {
				System.out.printf("Digite o nome do produto: \n");
				String nomeProduto = ler.next();
				EstoqueProdutos.getInstancia().removerProduto(nomeProduto);
			}else {
				System.out.printf("Digite o nome do produto: \n");
				String nomeProduto = ler.next();
				EstoqueProdutos.getInstancia().removerProdutoUnidade(nomeProduto);
			}
		} else{
			abrirMenu();
		} 
		
	}
	
	private static void abrirMenuFuncionario(Scanner ler) {
		System.out.println("-------------------");
		System.out.println("Funcionários");
		System.out.println("-------------------");
		System.out.println("1 - Cadastrar Funcionário");
		System.out.println("2 - Exibir Funcionários");
		System.out.println("3 - Sair");
			
		String auxiliador = "";
		boolean entradaErrada = true;
		while(entradaErrada) {
			System.out.printf("Informe a sua entrada:\n");
			auxiliador = ler.next();
			if(!auxiliador.equals("1") && !auxiliador.equals("2") && !auxiliador.equals("3") ) {
				System.out.printf("Entrada inv�lida:\n");
			}else {entradaErrada = false;}
		}
		
		if(auxiliador.equals("1")) {
			Loja.getInstancia().cadastrarFuncionario(ler);
		} else if(auxiliador.equals("2")) {
			System.out.println(Loja.getInstancia().getListaFuncionarios().toString());
		} else {
			abrirMenu();
		}
		
		
	}
	
	private static void abrirMenuEstoque(Scanner ler) {
		System.out.println("-------------------");
		System.out.println("Estoque");
		System.out.println("-------------------");
		System.out.println("1 - Listar produtos");
		System.out.println("2 - Listar produtos mais vendidos");
		System.out.println("3 - Listar produtos por categoria");
		System.out.println("4 - Listar produtos mais vendidos por categoria");
		System.out.println("5 - Sair");
			
		String auxiliador = "";
		boolean entradaErrada = true;
		while(entradaErrada) {
			System.out.printf("Informe a sua entrada:\n");
			auxiliador = ler.next();
			if(!auxiliador.equals("1") && !auxiliador.equals("2") && !auxiliador.equals("3") && !auxiliador.equals("4")) {
				System.out.printf("Entrada inv�lida:\n");
			}else {entradaErrada = false;}
		}
		
		if(auxiliador.equals("1")) {
			System.out.println(EstoqueProdutos.getInstancia().getListaProdutos());
		} else if(auxiliador.equals("2")) {
			System.out.printf("Informe a quantidade de produtos:\n");
			int quantidade = ler.nextInt();
			
			System.out.println(EstoqueProdutos.getInstancia().listarMaisVendidos(quantidade));
		} else if(auxiliador.equals("3")) {
			System.out.println("Digite de qual categoria voce deseja ver os produtos");
			System.out.println("1 - Perfume");
			System.out.println("2 - Sabonete");
			System.out.println("3 - Shampoo");
			System.out.println("4 - Desodorante");
			int entrada = ler.nextInt();
			System.out.println(EstoqueProdutos.getInstancia().listarPorCategoria(entrada).toString());
		} else if(auxiliador.equals("4")) {
			System.out.println("Digite de qual categoria voce deseja ver os produtos mais vendidos");
			System.out.println("1 - Perfume");
			System.out.println("2 - Sabonete");
			System.out.println("3 - Shampoo");
			System.out.println("4 - Desodorante");
			int entrada1 = ler.nextInt();
			System.out.println("Digite a quantidade de produtos que deseja ver");
			int entrada2 = ler.nextInt();
			System.out.println(EstoqueProdutos.getInstancia().listarMaisVendidosPorCategoria(entrada2, entrada1).toString());
		} else {
			abrirMenu();
		}
		
		
	}

	private static void realizarVenda(Scanner ler) {
		
		boolean lerProdutos = true;
		Cliente cliente = null;
		List<Produto> listaProdutos = EstoqueProdutos.getInstancia().getListaProdutos();
		List<Produto> produtos = new ArrayList<Produto>();
		
		System.out.printf("Digite o cpf do Vendedor:\n");
		String cpfVendedor = ler.next();
		
		Funcionario funcionario = Loja.getInstancia().verificaFuncionario(cpfVendedor);
		
		System.out.printf("Digite o cpf do Cliente:\n");
		String cpfCliente = ler.next();
		
		cliente = Loja.getInstancia().verificaCliente(cpfCliente);
		
		if(cliente == null) {
			System.out.println("Cliente não cadastrado. Por favor, realize o cadastro:\n");
			cliente = Loja.getInstancia().cadastrarCliente(cpfCliente, ler);
			System.out.println("Cliente cadastrado com sucesso!");
		} 
		
		//Lê todos os produtos da compra
		while (lerProdutos){
			System.out.printf("Informe o codigo do produto:\n");
			int codigoProduto = ler.nextInt();
			
			for(int i = 0; i < listaProdutos.size(); i++) {
				if(listaProdutos.get(i).getId() == codigoProduto) {
					produtos.add(listaProdutos.get(i));
				}
			}
			
			System.out.printf("Deseja adicionar outro produto? (1 - Sim | 2 - Não)\n");
			int adicionarOutroProduto = ler.nextInt();
			
			if(adicionarOutroProduto == 2) {
				lerProdutos = false;
			}			
		}
		
		if(produtos != null && cliente != null && funcionario != null){
			Loja.getInstancia().realizarVenda(produtos, cliente, funcionario);
			System.out.println("Compra realizada com sucesso.");
		} else {
			System.out.println("Não foi possível realizar a compra.");
		}

	}

}
