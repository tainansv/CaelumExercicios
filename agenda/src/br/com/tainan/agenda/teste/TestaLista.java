package br.com.tainan.agenda.teste;

import java.text.SimpleDateFormat;
import java.util.List;

import br.com.tainan.agenda.dao.ContatoDao;
import br.com.tainan.agenda.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {

		ContatoDao dao = new ContatoDao();

		List<Contato> contatos = dao.getLista();
		
		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());
			String data = new SimpleDateFormat("dd/MM/yyyy").format(contato.getDataNascimento().getTime());
			System.out.println("Data de Nascimento: " +	data + "\n");
		}
		
		
	}

}
