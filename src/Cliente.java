import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	String nome;
	String cpf;
	String telefone;
	int pontos;
	List<Compra> listaCompras;
	
	
	
	public Cliente(String nome, String cpf, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.pontos = 0;
		this.listaCompras  = new ArrayList<Compra>();
		
		Loja.getInstancia().listaClientes.add(this);
	}


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public List<Compra> getListaCompras() {
		return listaCompras;
	}
	public void setListaCompras(List<Compra> listaCompras) {
		this.listaCompras = listaCompras;
	}
	
	public void adicionaEmListaCompras(Compra c) {
		this.listaCompras.add(c);
	}
	
	
	public abstract void pontuar(Compra c);


	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", telefone=" + telefone + ", pontos=" + pontos
				+ ", listaCompras=" + listaCompras + "]";
	}
	
	
	
	
	
}
