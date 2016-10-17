package br.com.tainan.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tainan.agenda.dao.ContatoDao;
import br.com.tainan.agenda.modelo.Contato;

public class PaginaAlteraOuAdicionaLogic implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getParameter("id").isEmpty())
			return "WEB-INF/jsp/adiciona-contato.jsp";
		int id = Integer.parseInt(req.getParameter("id"));
		Connection conexao =  (Connection) req.getAttribute("conexao");
		Contato contato = new ContatoDao(conexao).pesquisar(id);
		req.setAttribute("contato", contato);
		return "WEB-INF/jsp/altera-contato.jsp";
	}

}
