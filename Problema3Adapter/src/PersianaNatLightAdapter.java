import br.furb.analise.algoritmos.PersianaNatLight;

public class PersianaNatLightAdapter implements Persiana {
	private PersianaNatLight persianaNatLight;
	
	public PersianaNatLightAdapter(PersianaNatLight persianaNatLight) {
		this.persianaNatLight = persianaNatLight;
	}
	
	@Override
	public void abrir() {
		persianaNatLight.abrirPalheta();
		try {
			persianaNatLight.subirPalheta();
		} catch (Exception e) {}
	}

	@Override
	public void fechar() {
		persianaNatLight.descerPalheta();
		try {
			persianaNatLight.fecharPalheta();
		} catch (Exception e) {}
	}
}
