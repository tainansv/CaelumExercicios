package br.com.tainan.agenda.teste;

import java.util.Calendar;

import br.com.tainan.agenda.dao.ContatoDao;
import br.com.tainan.agenda.dao.FuncionarioDao;
import br.com.tainan.agenda.modelo.Contato;
import br.com.tainan.agenda.modelo.Funcionario;

public class TestaInsere {

	public static void main(String[] args) {
		
		// pronto para gravar
		Contato contato = new Contato();
		contato.setNome("Tainan");
		contato.setEmail("contato@caelum.com.br");
		contato.setEndereco("R. Vergueiro 3185 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		
		// grave nessa conexão!!!
		ContatoDao dao = new ContatoDao(new Co);
		
		//metodo elegante
		dao.adiciona(contato);
		
		Funcionario func = new Funcionario();
		func.setNome("Tainan");
		func.setUsuario("tainasv");
		func.setSenha("senha");
		FuncionarioDao funcDao = new FuncionarioDao();
		funcDao.adiciona(func);
		
		System.out.println("Gravado!");
	}
}
