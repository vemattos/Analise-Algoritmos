
public class Produto {
	private String nome;
	private double valor;
	private double peso;
	
	public Produto(String nome, double valor, double peso) {
		setNome(nome);
		setValor(valor);
		setPeso(peso);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
}
