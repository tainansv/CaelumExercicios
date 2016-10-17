import java.util.ArrayList;
import java.util.List;

public class Buscador {

	List<Integer> lista = new ArrayList<>();
	
	public void geraLista(int comeco, int fim) {
		for (int i = comeco; i < fim; i++) {
			lista.add(i);
		}
	}
	
	public String buscar(int i) {
		int inicio = 0;
		int fim = lista.size()-1;
		int meio;
		while (inicio <= fim) {
			meio = (inicio + fim) /2;
			if(lista.get(meio) == i)
				return "Número encontrado";
			else{
				if(i < meio)
					fim = meio-1;
				else
					inicio = meio+1;
			}
		}
		return "Número não encontrado";
	}
}
