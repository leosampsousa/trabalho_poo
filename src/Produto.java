import java.util.concurrent.atomic.AtomicInteger;

public class Produto {
	int id;
	String nome;
	double precoCompra;
	double precoVenda;
	int qtProduto;
	int qtVendidos;
	private static final AtomicInteger count = new AtomicInteger(0); 
	
	public Produto(String nome, double precoCompra, double precoVenda, int qtProduto) {
		this.id = count.incrementAndGet();
		this.nome = nome;
		this.precoCompra = precoCompra;
		this.precoVenda = precoVenda;
		this.qtProduto = qtProduto;
		this.qtVendidos = 0;
		
		EstoqueProdutos.getInstancia().listaProdutos.add(this);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPrecoCompra() {
		return precoCompra;
	}
	public void setPrecoCompra(double precoCompra) {
		this.precoCompra = precoCompra;
	}
	public double getPrecoVenda() {
		return precoVenda;
	}
	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}	
	public int getQtProduto() {
		return qtProduto;
	}

	public void setQtProduto(int qtProduto) {
		this.qtProduto = qtProduto;
	}

	public int getQtVendidos() {
		return qtVendidos;
	}

	public void setQtVendidos(int qtVendidos) {
		this.qtVendidos = qtVendidos;
	}

	public void retiraItem() {
		this.qtProduto--;
	}
	public void adicionaItem() {
		this.qtProduto++;
	}
	public void vendeItem() {
		this.qtProduto--;
		this.qtVendidos++;
	}

	@Override
	public String toString() {
		return "Produto id=" + id + "\n" + "\t"
			+ "nome=" + nome + "\n" + "\t"
			+"precoCompra=" + precoCompra + "\n"+ "\t" 
			+"precoVenda=" + precoVenda + "\n" + "\t"
			+"qtProduto=" + qtProduto + "\n" + "\t"
		    +"qtVendidos=" + qtVendidos + "\n" + "\n" ;
	}
	
	
}
