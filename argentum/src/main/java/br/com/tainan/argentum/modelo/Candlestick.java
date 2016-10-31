package br.com.tainan.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class Candlestick {

	private final double abertura;
	private final double fechamento;
	private final double minimo;
	private final double maximo;
	private final double volume;
	private final Calendar data;
	
	public Candlestick(double abertura, double fechamento, double minimo,
			double maximo, double volume, Calendar hoje) {
		
		if(maximo < minimo || maximo < 0 || fechamento < 0 || 
				abertura < 0 || hoje == null)
			throw new IllegalArgumentException("argumento invalido");
		
		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = hoje;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}
	
	public boolean isAlta() {
		return this.abertura <= this.fechamento;
	}
	
	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
		Date d = this.data.getTime();
		return "Abertura " + this.abertura + ", Fechamento " + this.fechamento
				+", Mínimo " + this.minimo + ", Máximo " + this.maximo
				+",\nVolume " + this.volume + ", Data "
				+ formatarData.format(d);
	}
}
