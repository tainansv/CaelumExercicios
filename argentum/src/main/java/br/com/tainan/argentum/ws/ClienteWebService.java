package br.com.tainan.argentum.ws;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import br.com.tainan.argentum.modelo.Negociacao;
import br.com.tainan.argentum.reader.LeitorXML;

public class ClienteWebService {

	private final static String _url_webservice = 
			"http://argentumws.caelum.com.br/negociacoes";
	
	public List<Negociacao> getNegociacoes(){
		
		HttpsURLConnection conexao = null;
		
		try {
			URL url = new URL(_url_webservice);
			conexao = (HttpsURLConnection) url.openConnection();
			InputStream conteudo = conexao.getInputStream();
			
			return new LeitorXML().carrega(conteudo);
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			conexao.disconnect();
		}
	}
}
