import java.util.ArrayList;

public class Acao {
	private String nome;
	private double valor;
	private ArrayList<Ordem> listaOrdens;
	private ArrayList<Investidor> listaInvestidoresRegistrados;
	private ArrayList<PreOrdem> listaPreOrdens;
	
	public Acao(String nome, double valor) {
		setNome(nome);
		setValor(valor);
		listaOrdens = new ArrayList<>();
		listaInvestidoresRegistrados = new ArrayList<>();
		listaPreOrdens = new ArrayList<>();
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
	
	public void addOrdem(Ordem o) {
		listaOrdens.add(o);
		verificaMatch(o);
	}
	
	public void addRegistro(Investidor i) {
		listaInvestidoresRegistrados.add(i);
	}
	
	public void addPreOrdem(PreOrdem po) {
		if (po.getValorVerificacao() == getValor()) {
			listaOrdens.add(new Ordem(po.getNomeInvestidor(), po.getTipo(), po.getValor()));
		} else {
			listaPreOrdens.add(po);
		}
	}
	
	private void verificaMatch(Ordem o) {
		for (Ordem ordem : listaOrdens) {
			if (!(o.getTipo().equals(ordem.getTipo())) && ordem.getValor() == o.getValor()) {
				setValor(o.getValor());
				notificaInvestidores();
				verificaPreOrdens(getValor());
				listaOrdens.remove(o);
				listaOrdens.remove(ordem);
				return;
			}
		}
	}
	
	private void notificaInvestidores() {
		String notif = "O valor da ação " + getNome() + " alterou!\n";
		notif += "Novo valor da ação: R$ " + String.format("%.2f", getValor());
		
		for (Investidor i : listaInvestidoresRegistrados) {
			i.addNotificacao("Notificação para: " + i.getNome() + "\n" + notif);
		}
	}
	
	private void verificaPreOrdens(double novoValor) {
		for (PreOrdem po : listaPreOrdens) {
			if (po.getValorVerificacao() == novoValor) {
				addOrdem(new Ordem(po.getNomeInvestidor(), po.getTipo(), po.getValor()));
			}
		}
	}
	
	public String exibirOrdens() {
		String s = "";
		
		for (int i = 0; i < listaOrdens.size(); i++) {
			Ordem o = listaOrdens.get(i);
			s += "Investidor associado: " + o.getNomeInvestidor() + " - Tipo ordem: " + o.getTipo() + " - Valor: R$ " + String.format("%.2f", o.getValor());
			
			if (i != listaOrdens.size() - 1) {
				s += "\n";
			}
		}
		
		return s;
	}
}
