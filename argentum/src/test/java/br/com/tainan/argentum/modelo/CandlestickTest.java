package br.com.tainan.argentum.modelo;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class CandlestickTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new Candlestick(10, 20, 20, 10, 5, Calendar.getInstance());
	}

	@Test(expected=IllegalArgumentException.class)
	public void candleComValoresNegativos(){
		new Candlestick(10, -10, -5, 18, 5, Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void dataNaoPodeSerNula(){
		new Candlestick(10, 15, 5, 20, 5, null);
	}
	
	@Test
	public void quandoFechamentoIgualAberturaEhAlta(){
		Candlestick c = new Candlestick(20, 20, 3, 23.6, 5, Calendar.getInstance());
		
		assertEquals(true, c.isAlta());
		assertEquals(false, c.isBaixa());
	}
}
