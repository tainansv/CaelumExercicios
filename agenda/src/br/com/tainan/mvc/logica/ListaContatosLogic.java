package br.com.tainan.mvc.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.tainan.agenda.dao.ContatoDao;
import br.com.tainan.agenda.modelo.Contato;

public class ListaContatosLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

		Connection conexao =  (Connection) req.getAttribute("conexao");
		List<Contato> contatos = new ContatoDao(conexao).getLista();
		
		req.setAttribute("contatos", contatos);
		
		return "WEB-INF/jsp/lista-contatos.jsp";
	}

}
