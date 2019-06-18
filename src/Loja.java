import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Loja {
	String nome;
	List<Cliente> listaClientes = new ArrayList<Cliente>();
	List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	List<Compra> listaCompras = new ArrayList<Compra>();
	
	private static Loja instancia;
	
	public static Loja getInstancia()
    {
      if (instancia == null)
      {
         instancia = new Loja();
      }
      return instancia;
    }
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	public List<Funcionario> getListaFuncionarios() {
		return listaFuncionarios;
	}
	public void setListaFuncionarios(List<Funcionario> listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}
	public List<Compra> getListaCompras() {
		return listaCompras;
	}
	public void setListaCompras(List<Compra> listaCompras) {
		this.listaCompras = listaCompras;
	}
	
	public Funcionario verificaFuncionario(String cpfVendedor) {
		
		List<Funcionario> lista = this.getListaFuncionarios();
		Funcionario funcionario = null;
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCpf().equals(cpfVendedor)) {
				funcionario = lista.get(i);
				break;
			}
		}
		
		return funcionario;
		
	}
	
	public Cliente verificaCliente(String cpfCliente) {
		
		List<Cliente> lista = this.getListaClientes();
		Cliente cliente = null;
		
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCpf().equals(cpfCliente)) {
				cliente = lista.get(i);
				break;
			}
		}
		
		return cliente;
		
	}
	
	public void cadastrarFuncionario(Scanner ler) {
		
		System.out.printf("Digite o Cpf do Funcionario:\n");
		String cpfFuncionario = ler.next();
		System.out.printf("Digite o Nome do Funcionario:\n");
		String nomeFuncionario = ler.next();
		System.out.printf("Digite o Salário do Funcionario:\n");
		double salarioFuncionario = ler.nextDouble();
		
		new Funcionario(nomeFuncionario, cpfFuncionario, salarioFuncionario);
	}

	public void cadastrarCliente(Scanner ler) {
		
		System.out.printf("Digite o Cpf do Cliente:\n");
		String cpfCliente = ler.next();
		System.out.printf("Digite o Nome do Cliente:\n");
		String nomeCliente = ler.next();
		System.out.printf("Digite o Telefone do Cliente:\n");
		String telefoneCliente = ler.next();
		
		
		new ClienteComum(nomeCliente, cpfCliente, telefoneCliente);
		
	}
	
	
	public Cliente cadastrarCliente(String cpfCliente, Scanner ler) {
		
		System.out.printf("Digite o Nome do Cliente:\n");
		String nomeCliente = ler.next();
		System.out.printf("Digite o Telefone do Cliente:\n");
		String telefoneCliente = ler.next();
		
		Cliente cliente = new ClienteComum(nomeCliente, cpfCliente, telefoneCliente);
		
		return cliente;
	}
	
	public void adicionaEmListaFuncionario(String nome, String cpf, double salario) {
		Funcionario f = new Funcionario(nome, cpf, salario);
	}
	
	
	public void promoverCliente(Scanner ler) {
		System.out.printf("Digite o cpf do Cliente:\n");
		String cpfCliente = ler.next();
		
		Cliente cliente = verificaCliente(cpfCliente);
		if (cliente instanceof ClienteComum) {
			System.out.println("Tem certeza que dejesa tornar o cliente " + cliente.getNome() + " Vip? (1 - Sim | 2 - Não)");
			int confirmacao = ler.nextInt();
			
			if(confirmacao == 1) {
				try {
					tornarClienteVip(cliente);
					System.out.println("O Cliente foi promovido para Vip.");
				} catch(Exception e) {
					System.out.println(e);
				}
			}
		} else if(cliente instanceof ClienteVip) {
			System.out.println("Tem certeza que dejesa tornar o cliente " + cliente.getNome() + " Premium? (1 - Sim | 2 - Não)");
			int confirmacao = ler.nextInt();
			
			if(confirmacao == 1) {
				try {
					tornarClientePremium(cliente);
					System.out.println("O Cliente foi promovido para Premium.");
				} catch(Exception e) {
					System.out.println(e);
				}
			}
		} else {
			System.out.println("Não é possivel promover tal cliente");
		} 
		
	}
	
	public void tornarClienteVip(Cliente cliente) throws Exception{
		if(cliente instanceof ClienteComum) {
			if(cliente.pontos > 100) {
				Cliente auxiliar = cliente;
				/* Realizar exclusão desse cliente em listaClientes (Pendência) */
				new ClienteVip(auxiliar.nome, auxiliar.cpf, auxiliar.telefone, auxiliar.pontos);				
			}else {
				throw new Exception("O cliente n�o possui pontos suficiente para tornar-se Vip.");
			}
		}else {
			throw new Exception("O cliente n�o se encontra na categoria ClienteComum para poder tornar-se Vip.");
		}
	}
	
	public void tornarClientePremium(Cliente cliente) throws Exception{
		if(cliente instanceof ClienteVip) {
			if(cliente.pontos > 300) {
				Cliente auxiliar = cliente;
				/* Realizar exclusão desse cliente em listaClientes (Pendência) */
				new ClientePremium(auxiliar.nome, auxiliar.cpf, auxiliar.telefone, auxiliar.pontos);				
			}else {
				throw new Exception("O cliente não possui pontos suficiente para tornar-se Premium.");
			}
		}else {

			throw new Exception("O cliente não se encontra na categoria ClienteVip para poder tornar-se Premium.");
		}
	}
	
	public void realizarVenda(List<Produto> listaProdutos, Cliente cliente, Funcionario funcionario) {	
		
		Compra compra = new Compra(new Date(), listaProdutos, funcionario.getCpf());
		cliente.listaCompras.add(compra);
		this.listaCompras.add(compra);
		
		
		EstoqueProdutos.getInstancia().gerenciaProdutos(listaProdutos);
		
		cliente.pontuar(compra);
		funcionario.pontuar(compra);
				
	}

	@Override
	public String toString() {
		return "Loja [nome=" + nome + ", listaClientes=" + listaClientes + ", listaFuncionarios=" + listaFuncionarios
				+ ", listaCompras=" + listaCompras + "]";
	}
	
	
	
	
}
