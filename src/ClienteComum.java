
public class ClienteComum extends Cliente {

	public ClienteComum(String nome, String cpf, String telefone) {
		super(nome, cpf, telefone);
	}

	@Override
	public void pontuar(Compra c) {
		if(c.getValorCompra() <50) {
			this.pontos += 10;
		}else if(c.getValorCompra() < 200) {
			this.pontos += 20;
		}else if(c.getValorCompra() < 500) {
			this.pontos += 30;
		} else {
			this.pontos += 50;
		}
	}

}
