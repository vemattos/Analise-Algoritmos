package controladores;

import br.furb.analise.algoritmos.PersianaNatLight;
import br.furb.analise.algoritmos.PersianaSolarius;
import java.util.ArrayList;
import java.util.List;

class ControladorPersiana {
	private List<Object> listaPersiana;
	
	public ControladorPersiana() {
		listaPersiana = new ArrayList<>();
	}
	
	public void addPersiana(Object persiana) {
		listaPersiana.add(persiana);
	}
	
	public void removePersiana(Object persiana) {
		listaPersiana.remove(persiana);
	}
	
	public void abrirPersiana() {
		for (Object o : listaPersiana) {
			if (o instanceof PersianaNatLight) {
				PersianaNatLight persiana = (PersianaNatLight) o;
				persiana.abrirPalheta();
				try {
					persiana.subirPalheta();
				} catch (Exception e) {
					
				}
			} else {
				PersianaSolarius persiana = (PersianaSolarius) o;
				persiana.subirPersiana();
			}
		}
	}
	
	public void fecharPersiana() {
		for (Object o : listaPersiana) {
			if (o instanceof PersianaNatLight) {
				PersianaNatLight persiana = (PersianaNatLight) o;
				persiana.descerPalheta();
				try {
					persiana.fecharPalheta();
				} catch (Exception e) {
					
				}
			} else {
				PersianaSolarius persiana = (PersianaSolarius) o;
				persiana.descerPersiana();
			}
		}
	}
}
