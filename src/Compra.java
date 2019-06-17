import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Compra {
	int id;
	Date data;
	String funcionario;
	List<Produto> listaProdutos;
	double valorCompra;
	double lucroCompra;
	
	private static final AtomicInteger count = new AtomicInteger(0); 
	
	public Compra(Date data, List<Produto> listaProdutos,  String funcionario) {
		this.id = count.incrementAndGet();
		this.data = data;
		this.listaProdutos = listaProdutos;
		this.funcionario = funcionario;
		
		this.valorCompra = calculaValor(listaProdutos);
		this.lucroCompra = calculaLucro(listaProdutos);
	}
	
	private double calculaValor(List<Produto> listaProdutos) {
		
		double valor = 0;
		
		for(int i = 0; i < listaProdutos.size(); i++) {
			valor += listaProdutos.get(i).getPrecoVenda();
		}
		
		return valor;
	}

	private double calculaLucro(List<Produto> listaProdutos) {
		
		double lucro = 0;
		
		for(int i = 0; i < listaProdutos.size(); i++) {
			lucro += listaProdutos.get(i).getPrecoVenda() - listaProdutos.get(i).getPrecoCompra();
		}
		
		return lucro;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}
	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}
	public double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public double getLucroCompra() {
		return lucroCompra;
	}
	public void setLucroCompra(double lucroCompra) {
		this.lucroCompra = lucroCompra;
	}
	
	@Override
	public String toString() {
		return "Compra [id=" + id + ", data=" + data + ", funcionario=" + funcionario + ", listaProdutos="
				+ listaProdutos + ", valorCompra=" + valorCompra + ", lucroCompra=" + lucroCompra + "]";
	}
	
	
	
	
}
