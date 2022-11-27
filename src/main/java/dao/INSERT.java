package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import exception.DatabaseException;
import exception.SystemException;
import parameter.ExceptionParameters;

public class INSERT extends DAOBase{
	
	private PreparedStatement stmt;
	
	
	public void Insert()throws DatabaseException,SystemException{
		this.open();
		
		String sql = "INSERT INTO img VALUES(?,null,null,null,null,null)";
		
		int i = 1;
		
		
		try {		
			stmt = con.prepareStatement(sql);
			while(i <= 175)  {
			stmt.setInt(1, i);
			stmt.executeUpdate();
			i = i + 1;
			}
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return;
	}
}
