
public class Funcionario {

	private String nome;
	private String departamento;
	private String rg;
	private double salario;
	private Data admissao;
	private int identificador;
	public static int count;
	
	public Funcionario() {
		Funcionario.count++;
		this.identificador = count;
	}
	
	public Funcionario(String nome){
		this();
		this.nome = nome;
	}
	
	public int getIdentificador() {
		return this.identificador;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Data getAdmissao() {
		return admissao;
	}

	public void setAdmissao(String admissao) {
		this.admissao = new Data(admissao);
	}
	
	public double getBonificacao() {
		return this.salario * 1.2;
		}

	void recebeAumento(double aumento) {
		this.salario += aumento;
	}
	
	double calculaGanhoAnual() {
		return this.salario * 12;
	}
	
	void mostra() {
		System.out.println("Nome: "+nome);
		System.out.println("Departamento: "+departamento);
		System.out.println("Data de admissão: "+this.getAdmissao().toString());
		System.out.println("RG: "+rg);
		System.out.println("Salário: "+salario);
		System.out.println("Salário anual: "+this.calculaGanhoAnual());
		System.out.println();
	}
}
