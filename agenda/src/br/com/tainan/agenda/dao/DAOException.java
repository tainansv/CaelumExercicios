package br.com.tainan.agenda.dao;

import java.sql.SQLException;

public class DAOException extends RuntimeException {

	public DAOException(SQLException e) {
		super(e);
	}

}
