
public class ClientePremium extends Cliente{

	public ClientePremium(String nome, String cpf, String telefone) {
		super(nome, cpf, telefone);
	}
	
	public ClientePremium(String nome, String cpf, String telefone, int pontos) {
		super(nome, cpf, telefone);
		this.pontos = pontos;
	}

	@Override
	public void pontuar(Compra c) {
		if(c.getValorCompra() <50) {
			this.pontos += 30;
		}else if(c.getValorCompra() < 200) {
			this.pontos += 40;
		}else if(c.getValorCompra() < 500) {
			this.pontos += 60;
		} else {
			this.pontos += 80;
		}
	}
	
}
