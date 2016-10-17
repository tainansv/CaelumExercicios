package br.com.tainan.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.tainan.agenda.ConnectionFactory;
import br.com.tainan.agenda.modelo.Funcionario;

public class FuncionarioDao {

	private Connection conexao;
	
	public FuncionarioDao() {
		this.conexao = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Funcionario funcionario) {
		String sql = "insert into funcionarios " +
		"(nome,usuario,senha)" +
		" values (?,?,?)";
		
		try {
			// prepared statement para inserção
			PreparedStatement stmt = conexao.prepareStatement(sql);
		
			// seta os valores
			stmt.setString(1,funcionario.getNome());
			stmt.setString(2,funcionario.getUsuario());
			stmt.setString(3,funcionario.getSenha());
			
			// executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new DAOException(e);
			}
		}
}
