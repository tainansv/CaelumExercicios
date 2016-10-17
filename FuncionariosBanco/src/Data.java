
public class Data {

	private String dia;
	private String mes;
	private String ano;
	private String data;
	
	
	Data(String data) {
		if(!data.contains("/")) {
			this.dia =  data.substring(0, 2);
			this.mes = data.substring(2,4);
			this.ano = data.substring(4);
		}
	}
	
	
	
	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}


	public String dataFormatada() {
		this.data = this.getDia().toString()+"/"+this.getMes().toString()+"/"+this.getAno().toString();
		return this.data;
	}
}
