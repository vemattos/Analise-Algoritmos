import java.util.ArrayList;

public class Investidor implements Observer {
	private String nome;
	private ArrayList<String> listaNotificacoes;
	
	public Investidor(String nome) {
		setNome(nome);
		listaNotificacoes = new ArrayList<>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void addNotificacao(String notificacao) {
		listaNotificacoes.add(notificacao);
	}
	
	public void registrarOrdem(Acao a, String tipo, double valor) {
		a.addOrdem(new Ordem(getNome(), tipo, valor));
	}
	
	public void registrarPreOrdem(Acao a, String tipo, double valor, double valorVerificacao) {
		a.addPreOrdem(new PreOrdem(getNome(), tipo, valor, valorVerificacao));
	}
	
	public String verNotificacoes() {
		String s = "";
		
		for (int i = 0; i < listaNotificacoes.size(); i++) {
			s += listaNotificacoes.get(i);
			
			if (i != listaNotificacoes.size() - 1) {
				s += "\n";
			}
		}
		
		return s;
	}
	
	public String verUltimaNotificacao() {
		return listaNotificacoes.get(listaNotificacoes.size() - 1);
	}

	@Override
	public void update(Subject s) {
		Acao a = (Acao) s;
		String notif = "O valor da ação " + a.getNome() + " alterou!\n";
		notif += "Novo valor da ação: R$ " + String.format("%.2f", a.getValor());
		
		addNotificacao("Notificação para: " + getNome() + "\n" + notif);
	}
}
