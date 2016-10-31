package br.com.tainan.argentum.reader;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.tainan.argentum.modelo.Negociacao;

public class GerardorAleatorioDeXML {

	public static void main(String[] args) throws IOException {

		Calendar data = Calendar.getInstance();
		Random random = new Random(123);
		List<Negociacao> negociacoes = new ArrayList<Negociacao>();
		double valor = 40;
		int quantidade;

		for (int dias = 0; dias < 30; dias++) {
			int quantNegociacoesDia = random.nextInt(20);

			for (int negociacao = 0; negociacao < quantNegociacoesDia; negociacao++) {
				valor += (random.nextInt(200) - 100) / 100.0;
				if (valor < 5)
					valor = 5;

				quantidade = random.nextInt(1000) + 500;

				Negociacao n = new Negociacao(valor, quantidade, data);
				negociacoes.add(n);
			}

			data = (Calendar) data.clone();
			data.add(Calendar.DAY_OF_YEAR, 1);
		}
		
		XStream stream = new XStream(new DomDriver());
		stream.alias("negociacao", Negociacao.class);
		stream.setMode(XStream.NO_REFERENCES);
		PrintStream out = new PrintStream(new File("negociacao.xml"));
		out.println(stream.toXML(negociacoes));
	}
}