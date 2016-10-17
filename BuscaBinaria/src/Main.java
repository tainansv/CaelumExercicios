
public class Main {

	public static void main(String[] args) {
		
		Buscador b = new Buscador();

		b.geraLista(0, 30);
		
		System.out.println(b.buscar(12));
		
		b.geraLista(2, 298);
		System.out.println(b.buscar(8));
	}

}
