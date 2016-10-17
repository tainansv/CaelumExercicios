
public class Main {

	public static void main(String[] args) {

		Empresa empresa = new Empresa(5);
		
		Funcionario f1 = new Funcionario();
		f1.setNome("Hugo");
		f1.setSalario(100);
		f1.setAdmissao("10041992");

		Funcionario f2 = new Funcionario();
		f2.setNome("Daniel");
		f2.setSalario(100);
		f2.setAdmissao("27121992");
		
		empresa.adiciona(f1);
		empresa.adiciona(f2);
		
		empresa.mostraEpregados();
		empresa.contem(f1);
		System.out.println(f1.getAdmissao().getDia());
		
	}

}
