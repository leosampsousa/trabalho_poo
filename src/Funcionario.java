public class Funcionario {
	String nome;
	String cpf;
	int pontos;
	double salario;
	
	
	
	
	public Funcionario(String nome, String cpf, double salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
		this.pontos = 0;
		
		Loja.getInstancia().listaFuncionarios.add(this);
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
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public void pontuar(Compra compra) {
		
		this.pontos += 20;	
		
	}

	@Override
	public String toString() {
		return "nome=" + nome + "/n" + "/t" + 
				"cpf=" + cpf + "/n" + "/t" +  
				"pontos=" + pontos + "/n" + "/t" + 
				"salario=" + salario  ;
	}
	
	
	
}
