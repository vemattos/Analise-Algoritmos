
public class PreOrdem extends Ordem{
	private double valorVerificacao;
	
	public PreOrdem(String nomeInvestidor, String tipo, double valor, double valorVerificacao) {
		super(nomeInvestidor, tipo, valor);
		setValorVerificacao(valorVerificacao);
	}

	public double getValorVerificacao() {
		return valorVerificacao;
	}

	public void setValorVerificacao(double valorVerificacao) {
		this.valorVerificacao = valorVerificacao;
	}
}
