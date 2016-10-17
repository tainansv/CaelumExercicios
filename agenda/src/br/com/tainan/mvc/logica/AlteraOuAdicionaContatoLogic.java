package br.com.tainan.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tainan.agenda.dao.ContatoDao;
import br.com.tainan.agenda.modelo.Contato;

public class AlteraOuAdicionaContatoLogic implements Logica {
	
	Connection conexao;
	ContatoDao dao;

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		conexao =  (Connection) req.getAttribute("conexao");
		dao = new ContatoDao(conexao);
		if(req.getParameter("id").isEmpty())
			adicionaContato(req);
		else
			alteraContato(req);
		return "mvc?logica=ListaContatosLogic";
	}

	private void alteraContato(HttpServletRequest req) throws ParseException {
		int id = Integer.parseInt(req.getParameter("id"));
		Contato contato = new Contato();
		contato = dao.pesquisar(id);
		if(!req.getParameter("nome").isEmpty())
			contato.setNome(req.getParameter("nome"));
		if(!req.getParameter("email").isEmpty())
			contato.setEmail(req.getParameter("email"));
		if(!req.getParameter("endereco").isEmpty())
			contato.setEndereco(req.getParameter("endereco"));
		
		if(!req.getParameter("dataNascimento").isEmpty()){
			String dataEmTexto = req.getParameter("dataNascimento");
			Calendar dataNascimento = Calendar.getInstance();
			Date date =	new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento.setTime(date);
			contato.setDataNascimento(dataNascimento);
		}

		dao.altera(contato);
	}
	
	private void adicionaContato(HttpServletRequest req) {
		Contato contato = new Contato();
		contato.setNome(req.getParameter("nome"));
		contato.setEmail(req.getParameter("email"));
		contato.setEndereco(req.getParameter("endereco"));
		String dataTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		
		try {
			Date date =	new SimpleDateFormat("dd/MM/yyyy").parse(dataTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			System.out.println("Erro de conversão da data");
			
		}
		
		contato.setDataNascimento(dataNascimento);
		dao.adiciona(contato);
	}

}
