
public class Ordem {
	private String nomeInvestidor;
	private String tipo;
	private double valor;
	
	public Ordem(String nomeInvestidor, String tipo, double valor) {
		setNomeInvestidor(nomeInvestidor);
		setTipo(tipo);
		setValor(valor);
	}
	
	public String getNomeInvestidor() {
		return nomeInvestidor;
	}
	
	public void setNomeInvestidor(String nomeInvestidor) {
		this.nomeInvestidor = nomeInvestidor;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
}
