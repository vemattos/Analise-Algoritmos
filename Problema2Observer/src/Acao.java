import java.util.ArrayList;
import java.util.List;

public class Acao implements Subject {
	private String nome;
	private double valor;
	private List<Ordem> listaOrdens;
	private List<Observer> observers;
	private List<PreOrdem> listaPreOrdens;
	
	public Acao(String nome, double valor) {
		setNome(nome);
		setValor(valor);
		listaOrdens = new ArrayList<>();
		observers = new ArrayList<>();
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
				notifyObservers();
				verificaPreOrdens(getValor());
				listaOrdens.remove(o);
				listaOrdens.remove(ordem);
				return;
			}
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

	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers) {
			o.update(this);
		}
	}
}
