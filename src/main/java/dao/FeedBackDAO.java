package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.FeedBackArrayBean;
import bean.FeedBackBean;
import exception.DatabaseException;
import exception.SystemException;
import parameter.ExceptionParameters;

public class FeedBackDAO extends DAOBase{
	
	PreparedStatement stmt;

	public FeedBackArrayBean getFeedBackArray()throws DatabaseException,SystemException{
		this.open();
		
		FeedBackArrayBean fbArray = new FeedBackArrayBean();
		
		String sql ="SELECT * FROM feedback ORDER BY id DESC";
		
		try {
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				FeedBackBean fbBean = new FeedBackBean();
				fbBean.setId(rs.getInt("id"));
				fbBean.setCk(rs.getInt("ck"));
				fbBean.setTitle(rs.getString("title"));
				fbBean.setMain(rs.getString("main"));
				fbBean.setDate(rs.getDate("date"));
				fbArray.addFeedBack(fbBean);
			}
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return fbArray;
	}
	
	public FeedBackBean getFeedBackDetail(int id)throws DatabaseException,SystemException{
		this.open();
		
		FeedBackBean selectBean = new FeedBackBean();
		
		String sql="SELECT * FROM feedback WHERE id = ?";
		String sql2 = "UPDATE feedback SET ck = 1 WHERE id = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				selectBean.setId(id);
				selectBean.setTitle(rs.getString("title"));
				selectBean.setMain(rs.getString("main"));
				selectBean.setDate(rs.getDate("date"));
			}
			stmt = con.prepareStatement(sql2);
			stmt.setInt(1, id);
			stmt.executeUpdate();	
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return selectBean;	
	}
}
