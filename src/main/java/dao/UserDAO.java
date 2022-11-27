package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.UserInfoArrayBean;
import bean.UserInfoBean;
import exception.DatabaseException;
import exception.SystemException;
import parameter.ExceptionParameters;
import sha2.SaltUserPassword;

public class UserDAO extends DAOBase{
	
	PreparedStatement stmt;	
	
	public UserInfoArrayBean UserSearch(String id)throws DatabaseException,SystemException{
		this.open();
		
		String sql = "SELECT * FROM users WHERE id like ?";
		
		UserInfoArrayBean uiArrayBean = new UserInfoArrayBean();
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+id+"%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				UserInfoBean uiBean = new UserInfoBean();
				uiBean.setId(rs.getString("id"));
				uiBean.setPassword(rs.getString("password"));
				uiBean.setNickname(rs.getString("nickname"));
				uiArrayBean.addUser(uiBean);
			}
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return uiArrayBean;
	}
	
	public void UserInfoUpdate(String id, String updateValue,String column)throws DatabaseException,SystemException{
		this.open();
		
		String sql = "UPDATE users SET "+column+"= ? WHERE id = ?";
		
		String value = null;
		
		System.out.println(column);
		
		if(column.equals("password")) {
			SaltUserPassword sha2 = new SaltUserPassword();
			value = sha2.getDigest(id, updateValue);
		}else {
			value = updateValue;
		}
		System.out.println(value);
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, value);
			stmt.setString(2, id);
			stmt.executeUpdate();
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return;
	}
	
	public UserInfoBean UserIdSearch(String id)throws DatabaseException,SystemException{
		this.open();
		
		String sql = "SELECT * FROM users WHERE id = ?";
		UserInfoBean uiBean = new UserInfoBean();
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {		
				uiBean.setId(rs.getString("id"));
				uiBean.setPassword(rs.getString("password"));
				uiBean.setNickname(rs.getString("nickname"));
			}
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return uiBean;
	}
	
	public void UserDelete(String id)throws DatabaseException,SystemException{
		this.open();
		
		String sql1 = "DELETE FROM favorite WHERE kid = ?";
		String sql2 = "DELETE FROM users WHERE id = ?";
		
		try {
			stmt = con.prepareStatement(sql1);
			stmt.setString(1, id);
			stmt.executeUpdate();
			stmt = con.prepareStatement(sql2);
			stmt.setString(1, id);
			stmt.executeUpdate();
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return;
		
	}
	
}
