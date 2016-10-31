package br.com.tainan.argentum.reader;

import java.io.InputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.tainan.argentum.modelo.Negociacao;

public class LeitorXML {


	@SuppressWarnings("unchecked")
	public List<Negociacao> carrega(InputStream input){
		XStream stream = new XStream(new DomDriver());
		stream.alias("negociacao", Negociacao.class);
		try {
			return  (List<Negociacao>) stream.fromXML(input);
		} catch (Exception e) {
			throw new RuntimeException("erro ao obter lista",e);
		}
	}
}
