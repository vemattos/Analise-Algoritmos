import br.furb.analise.algoritmos.PersianaSolarius;

public class PersianaSolariusAdapter implements Persiana {
	private PersianaSolarius persianaSolarius;
	
	public PersianaSolariusAdapter(PersianaSolarius persianaSolarius) {
		this.persianaSolarius = persianaSolarius;
	}
	
	@Override
	public void abrir() {
		persianaSolarius.subirPersiana();
	}

	@Override
	public void fechar() {
		persianaSolarius.descerPersiana();
	}
}
