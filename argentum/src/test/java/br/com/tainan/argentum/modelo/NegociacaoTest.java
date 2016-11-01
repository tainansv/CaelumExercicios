package br.com.tainan.argentum.modelo;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class NegociacaoTest{

	@Test
	public void dataDaNegociacaoEhImutavel() {
		Calendar data = Calendar.getInstance();
		data.set(Calendar.DAY_OF_MONTH, 15);
		Negociacao neg = new Negociacao(10, 5, data);
		
		neg.getData().set(Calendar.DAY_OF_MONTH, 20);
		
		assertEquals(15, neg.getData().get(Calendar.DAY_OF_MONTH));
	}

	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula(){
		new Negociacao(10, 5, null);
	}
	
	@Test
	public void mesmoMilisegundoEhDoMesmoDia(){
		Calendar agora = Calendar.getInstance();
		Calendar mesmoMomento = (Calendar) agora.clone();
		
		Negociacao neg = new Negociacao(40.0, 100, agora);
		assertTrue(neg.isMesmoDia(mesmoMomento));
	}
	
	@Test
	public void comHorasDiferentesmesmoDia(){
		Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
		Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);
		
		Negociacao neg = new Negociacao(40.0, 100, manha);
		assertTrue(neg.isMesmoDia(tarde));
	}
	
	@Test
	public void mesmoDiaMesesDiferentes(){
		Calendar outubro = new GregorianCalendar(2011, 10, 20);
		Calendar novembro = new GregorianCalendar(2011, 11, 20);
		
		Negociacao neg = new Negociacao(40, 100, novembro);
		assertFalse(neg.isMesmoDia(outubro));
	}
	
	@Test
	public void mesmoDiaEMesAnosDiferençtes(){
		Calendar ano11 = new GregorianCalendar(2011, 10, 20);
		Calendar ano12 = new GregorianCalendar(2012, 10, 20);
		
		Negociacao neg = new Negociacao(40, 100, ano11);
		assertFalse(neg.isMesmoDia(ano12));
	}
}
