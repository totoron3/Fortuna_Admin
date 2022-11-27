package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.SpotsUpdateArrayBean;
import bean.SpotsUpdateBean;
import exception.DatabaseException;
import exception.SystemException;
import parameter.ExceptionParameters;

public class SpotsUpdateDAO extends DAOBase{
	
	private PreparedStatement stmt;
	
	public SpotsUpdateArrayBean SpotsUpdateIDSearch(String id)throws DatabaseException,SystemException{
		this.open();
		
		String sql ="SELECT * FROM spot WHERE id = ?";

		
		SpotsUpdateArrayBean suArray = new SpotsUpdateArrayBean();
		
		try {
			stmt = con.prepareStatement(sql);	
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
			SpotsUpdateBean suBean = new SpotsUpdateBean();
			
			suBean.setNo(String.valueOf(rs.getInt("id")));
			suBean.setGenre(rs.getString("genre"));
			suBean.setSubGenre(rs.getString("subgenre"));
			suBean.setName(rs.getString("name"));
			suBean.setCity(rs.getString("city"));
			suBean.setAddress(rs.getString("address"));
			suBean.setRest(rs.getString("rest"));
			suBean.setHours(rs.getString("hours"));
			suBean.setAccess1(rs.getString("access1"));
			suBean.setAccess2(rs.getString("access2"));
	
			suArray.addSpots(suBean);
			}
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return suArray;
	}
	
	public SpotsUpdateArrayBean SpotsUpdateNameSearch(String name)throws DatabaseException,SystemException{
		this.open();
		
		String sql ="SELECT * FROM spot WHERE name like ?";
		
		SpotsUpdateArrayBean suArray = new SpotsUpdateArrayBean();
		
		try {
			stmt = con.prepareStatement(sql);	
			stmt.setString(1, "%"+name+"%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				SpotsUpdateBean suBean = new SpotsUpdateBean();
				
				suBean.setNo(String.valueOf(rs.getInt("id")));
				suBean.setGenre(rs.getString("genre"));
				suBean.setSubGenre(rs.getString("subgenre"));
				suBean.setName(rs.getString("name"));
				suBean.setCity(rs.getString("city"));
				suBean.setAddress(rs.getString("address"));
				suBean.setRest(rs.getString("rest"));
				suBean.setHours(rs.getString("hours"));
				suBean.setAccess1(rs.getString("access1"));
				suBean.setAccess2(rs.getString("access2"));
				suArray.addSpots(suBean);
			}
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return suArray;
	}
	
	public SpotsUpdateBean SelectSpots(String id)throws DatabaseException,SystemException{
		this.open();
		
		String sql1 = "SELECT * FROM spot WHERE id = ?";
		String sql2 = "SELECT * FROM spotinfo WHERE id = ?";
		String sql3 = "SELECT * FROM map WHERE id = ?";
		String sql4 = "SELECT * FROM question WHERE id = ?";
		String sql5 = "SELECT * FROM img WHERE id = ?";
		
		SpotsUpdateBean suBean = new SpotsUpdateBean();
		
		try {
			stmt = con.prepareStatement(sql1);
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				suBean.setNo(id);
				suBean.setName(rs.getString("name"));
				suBean.setGenre(rs.getString("genre"));
				suBean.setSubGenre(rs.getString("subgenre"));
				suBean.setCity(rs.getString("city"));
				suBean.setAddress(rs.getString("address"));
				suBean.setRest(rs.getString("rest"));
				suBean.setHours(rs.getString("hours"));
				suBean.setAccess1(rs.getString("access1"));
				suBean.setAccess2(rs.getString("access2"));
				
				stmt = con.prepareStatement(sql2);
				stmt.setString(1, id);
				ResultSet rs2 = stmt.executeQuery();
				while(rs2.next()) {
					suBean.setPage1(rs2.getString("page1"));
					suBean.setPage2(rs2.getString("page2"));
					suBean.setIntro(rs2.getString("intro"));
					
					stmt = con.prepareStatement(sql3);
					stmt.setString(1, id);
					ResultSet rs3 = stmt.executeQuery();
					while(rs3.next()) {
						suBean.setMapURL(rs3.getString("map"));
						
						stmt = con.prepareStatement(sql4);
						stmt.setString(1, id);
						ResultSet rs4 = stmt.executeQuery();
						while(rs4.next()) {
							suBean.setFeel(rs4.getString("feel"));
							suBean.setFamily(rs4.getString("FA"));
							suBean.setFriend(rs4.getString("FR"));
							suBean.setCupple(rs4.getString("LO"));
							suBean.setFamous(rs4.getString("FOH"));
							suBean.setInout(rs4.getString("IO"));
							suBean.setArea(rs4.getString("area"));
							suBean.setSeason(rs4.getString("season"));
							
							stmt = con.prepareStatement(sql5);
							stmt.setString(1, id);
							ResultSet rs5 = stmt.executeQuery();
							while(rs5.next()) {
								suBean.setImg1(rs5.getString("img1"));
								suBean.setImg2(rs5.getString("img2"));
								suBean.setImg3(rs5.getString("img3"));
								suBean.setImg4(rs5.getString("img4"));
								suBean.setImg5(rs5.getString("img5"));
							}
						}
					}
				}
			}
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return suBean;
	}
	
	public void SpotsDelete(String id)throws DatabaseException,SystemException{
		this.open();
		
		String sql1 = "DELETE FROM spotinfo WHERE id = ?";
		String sql2 = "DELETE FROM map WHERE id = ?";
		String sql3 = "DELETE FROM question WHERE id = ?";
		String sql4 = "DELETE FROM img WHERE id = ?";
		String sql5 = "DELETE FROM spot WHERE id = ?";
		
		
		try {
		
			stmt = con.prepareStatement(sql1);
			stmt.setString(1, id);
			stmt.executeUpdate();
			
			stmt = con.prepareStatement(sql2);
			stmt.setString(1, id);
			stmt.executeUpdate();
			
			stmt = con.prepareStatement(sql3);
			stmt.setString(1, id);
			stmt.executeUpdate();
			
			stmt = con.prepareStatement(sql4);
			stmt.setString(1, id);
			stmt.executeUpdate();
			
			stmt = con.prepareStatement(sql5);
			stmt.setString(1, id);
			stmt.executeUpdate();
		
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return;
	}
	
	public void SpotsUpdateValue(String id,String updateValue,String db,String column )throws DatabaseException,SystemException{
		this.open();
		
		String sql = "UPDATE "+db+" SET "+column+" = ? WHERE id = ?";
		
		try {
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, updateValue);
			stmt.setInt(2, Integer.parseInt(id));
			stmt.executeUpdate();
			
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return;	
	}
	
	public void SpotsUpdateImage(String id,String img, int num)throws DatabaseException,SystemException{
		this.open();
		
		String sql = null;
		
		if(num == 1) {
			sql = "UPDATE img SET img1 = ? WHERE id = ?";
		}else if(num == 2) {
			sql = "UPDATE img SET img2 = ? WHERE id = ?";
		}else if(num == 3) {
			sql = "UPDATE img SET img3 = ? WHERE id = ?";
		}else if(num == 4) {
			sql = "UPDATE img SET img4 = ? WHERE id = ?";
		}else if(num == 5) {
			sql = "UPDATE img SET img5 = ? WHERE id = ?";
		}
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, img);
			stmt.setInt(2, Integer.parseInt(id));
			stmt.executeUpdate();
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return;	
	}
}
