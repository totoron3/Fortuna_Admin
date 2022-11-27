package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.NewsArrayBean;
import bean.NewsBean;
import exception.DatabaseException;
import exception.SystemException;
import parameter.ExceptionParameters;

public class NewsDAO extends DAOBase{
	
	PreparedStatement stmt;
	
	public NewsArrayBean getNews()throws DatabaseException,SystemException{
		this.open();
		
		NewsArrayBean nArray = new NewsArrayBean(); 
		
		String sql1 = "SELECT * FROM news";
		String sql2 = "SELECT * FROM category WHERE no = ?";
		
		try {
			stmt = con.prepareStatement(sql1);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				NewsBean nBean = new NewsBean();
				nBean.setId(rs.getInt("id"));
				nBean.setTitle(rs.getString("title"));
				nBean.setMain(rs.getString("main"));
				nBean.setDate(rs.getDate("date"));
				nBean.setCategory(rs.getInt("category"));
				stmt = con.prepareStatement(sql2);
				stmt.setInt(1, nBean.getCategory());
				ResultSet rs2 = stmt.executeQuery();
				while(rs2.next()) {
					nBean.setCat(rs2.getString("name"));
					nArray.addNews(nBean);
				}
			}
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return nArray;
	}
	
	public void NewsDelete(int id)throws DatabaseException,SystemException{
		this.open();
		
		String sql = "DELETE FROM news WHERE id = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
	}
	
	public void NewsUpdate(NewsBean cNews)throws DatabaseException,SystemException{
		this.open();
		
		String sql = "INSERT INTO news VALUES(?,?,?,?,?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, cNews.getId());
			stmt.setString(2, cNews.getTitle());
			stmt.setString(3, cNews.getMain());
			stmt.setDate(4, cNews.getDate());
			stmt.setInt(5, cNews.getCategory());
			stmt.executeUpdate();
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
	}
	
}
