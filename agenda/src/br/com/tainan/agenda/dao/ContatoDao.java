package br.com.tainan.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.tainan.agenda.modelo.Contato;

public class ContatoDao {

	private Connection conexao;
	
	public ContatoDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contatos " +
		"(nome,email,endereco,dataNascimento)" +
		" values (?,?,?,?)";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);
		
			// seta os valores
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4, new Date(
			contato.getDataNascimento().getTimeInMillis()));
			
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
			}
		}
	
	public List<Contato> getLista(){
		
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.conexao.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
			return contatos;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public Contato pesquisar(int id){
		Contato contato = new Contato();
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.conexao.prepareStatement("select * from contatos where id = "+ id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				contatos.add(contato);
			}
			
			rs.close();
			stmt.close();
			return contato;
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
	
	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?,"+
		"endereco=?, dataNascimento=? where id=?";
		
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
			.getTimeInMillis()));
			stmt.setLong(5, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
			}
	}
	
	public void remove(Contato contato) {
		try {
			PreparedStatement stmt = conexao
			.prepareStatement("delete from contatos where id=?");
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		 }
	}

}
