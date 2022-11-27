package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.AdminBean;
import exception.DatabaseException;
import exception.SystemException;
import parameter.ExceptionParameters;

public class AdminDAO extends DAOBase{
	
	private PreparedStatement stmt;
	
	public AdminBean AdminLogin(String id) throws DatabaseException,SystemException{
		this.open();
		
		String sql ="SELECT * FROM admin WHERE id = ?";
		
		AdminBean adBean = new AdminBean();
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				adBean.setId(rs.getString("id"));
				adBean.setPasswd(rs.getString("passwd"));
			}
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return adBean;
	}

}
