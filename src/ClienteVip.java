
public class ClienteVip extends Cliente{

	public ClienteVip(String nome, String cpf, String telefone) {
		super(nome, cpf, telefone);
	}
	
	public ClienteVip(String nome, String cpf, String telefone, int pontos) {
		super(nome, cpf, telefone);
		this.pontos = pontos;
	}

	@Override
	public void pontuar(Compra c) {
		if(c.getValorCompra() <50) {
			this.pontos += 20;
		}else if(c.getValorCompra() < 200) {
			this.pontos += 30;
		}else if(c.getValorCompra() < 500) {
			this.pontos += 50;
		} else {
			this.pontos += 70;
		}
	}
	
}
