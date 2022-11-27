package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.AddNewsBean;
import exception.DatabaseException;
import exception.SystemException;
import parameter.ExceptionParameters;

public class AddNewsDAO extends DAOBase{
	PreparedStatement stmt;
	
	public int getID() throws DatabaseException,SystemException{
		this.open();

		int id = 0;
		String sql = "SELECT * FROM news";
		
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				id = rs.getInt("id");
			}
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return id;
	}
	
	public void AddNews(AddNewsBean anBean)throws DatabaseException,SystemException{
		this.open();
		
		String sql ="INSERT INTO news VALUES(?,?,?,?,?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, anBean.getId());
			stmt.setString(2, anBean.getTitle());
			stmt.setString(3, anBean.getMain());
			stmt.setDate(4, anBean.getDate());
			stmt.setInt(5, anBean.getCategory());
			stmt.executeUpdate();
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return;
	}
}
