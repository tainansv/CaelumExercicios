
public class Empresa {

	private String nome;
	private String cnpj;
	private Funcionario[] empregados;
	private int count = 0;
	
	Empresa(int empregados) {
		this.empregados = new Funcionario[empregados];
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public Funcionario getEmpregados(int posicao) {
		return empregados[posicao];
	}


	void adiciona(Funcionario f){
		if(count < empregados.length){
			empregados[count] = f;
			count++;
		}
		else {
			int tamanho = empregados.length;
			Funcionario[] empregados = new Funcionario[tamanho + 10];
			this.empregados = empregados;
			this.empregados[tamanho] = f;
			count++;
		}
	}
	
	
	void mostraEpregados() {
		for(Funcionario f : empregados){
			if(f != null){
				f.mostra();
			}
		}
	}
	
	void contem(Funcionario x) {
		for(int i = 0; i < empregados.length; i++){
			if(empregados[i].getNome() == x.getNome()) {
				System.out.println("Funcionario existente.");
				break;
			}
		}
	}
}
