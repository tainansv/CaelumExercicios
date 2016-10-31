package br.com.tainan.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {

	public Candlestick constroiCandleParaData(Calendar hoje,
			List<Negociacao> negociacoes) {
		
		double max = 0;
		double min = Double.MAX_VALUE;
		double volume = 0;
		
		for (Negociacao negociacao : negociacoes) {
			volume += negociacao.getVolume();
			
			if(negociacao.getPreco() > max)
				max = negociacao.getPreco();
			
			if(negociacao.getPreco() < min)
				min = negociacao.getPreco();
		}
		
		if(min == Double.MAX_VALUE)
			min = 0;
		
		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 :
			negociacoes.get(negociacoes.size() - 1).getPreco();
		
		return new Candlestick(abertura, fechamento, min, max, volume, hoje);
	}

	public List<Candlestick> constroiCandles(List<Negociacao> todasNegociacoes) {
		List<Candlestick> candles = new ArrayList<Candlestick>();
		
		List<Negociacao> negDoDia = new ArrayList<Negociacao>();
		Calendar dataDoDia = Calendar.getInstance();
		
		for (Negociacao negociacao : todasNegociacoes) {
			if(negociacao.getData().before(dataDoDia))
				throw new IllegalStateException("negociações em ordem errada");
			
			if(!negociacao.isMesmoDia(dataDoDia)){
				Candlestick candleDoDia = constroiCandleParaData(dataDoDia, negDoDia);
				candles.add(candleDoDia);
				negDoDia = new ArrayList<Negociacao>();
				dataDoDia = negociacao.getData();
			}
				
			negDoDia.add(negociacao);
		}
		
		Candlestick candleDoDia = constroiCandleParaData(dataDoDia, negDoDia);
		candles.add(candleDoDia);
		
		return candles;
	}
}
