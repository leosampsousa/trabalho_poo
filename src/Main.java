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
		
		new Produto("Produto1", 10, 20, 10);
		new Produto("Produto2", 10, 20, 10);
		new Produto("Produto3", 10, 20, 10);
		new Produto("Produto4", 10, 20, 10);
		
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
		//System.out.println("3 - Consultar informações dos produtos");
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
			//Loja.getInstancia().cadastrarProduto(ler);
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
		System.out.println("2 - Listar mais vendidos");
		System.out.println("3 - Cadastrar produto");
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
			System.out.println(EstoqueProdutos.getInstancia().getListaProdutos());
		} else if(auxiliador.equals("2")) {
			System.out.printf("Informe a quantidade de produtos:\n");
			int quantidade = ler.nextInt();
			
			System.out.println(EstoqueProdutos.getInstancia().listarMaisVendidos(quantidade));
		} else if(auxiliador.equals("3")) {
			System.out.println(Loja.getInstancia().getListaClientes().toString());
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
