package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.AddSpotBean;
import exception.DatabaseException;
import exception.SystemException;
import parameter.ExceptionParameters;

public class AddSpotsDAO extends DAOBase{
	
	private PreparedStatement stmt;
	
	public void AddSpot(AddSpotBean asBean)throws DatabaseException,SystemException{
		this.open();
		
		String sql = "INSERT INTO spot VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(asBean.getNo()));
			stmt.setString(2, asBean.getGenre());
			stmt.setString(3, asBean.getSubGenre());
			stmt.setString(4, asBean.getName());
			stmt.setString(5, asBean.getCity());
			stmt.setString(6, asBean.getAddress());
			stmt.setString(7, asBean.getRest());
			stmt.setString(8, asBean.getHours());
			stmt.setString(9, asBean.getAccess1());
			stmt.setString(10, asBean.getAccess2());
			stmt.executeUpdate();
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return;
	}
	
	public void AddSpotInfo(AddSpotBean asBean)throws DatabaseException,SystemException{
		this.open();
		
		String sql="INSERT INTO spotinfo VALUES(?,?,?,?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(asBean.getNo()));
			stmt.setString(2, asBean.getPage1());
			stmt.setString(3, asBean.getPage2());
			stmt.setString(4, asBean.getIntro());
			stmt.executeUpdate();
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return;
	}
	
	public void AddMap(AddSpotBean asBean)throws DatabaseException,SystemException{
		this.open();
		
		String sql="INSERT INTO map VALUES(?,?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(asBean.getNo()));
			stmt.setString(2, asBean.getMapURL());
			stmt.executeUpdate();
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return;
	}
	
	public void AddQuestion(AddSpotBean asBean)throws DatabaseException,SystemException{
		this.open();
		
		String sql="INSERT INTO question VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		String fa,fr,lo;
		
		if(asBean.getFamily()== null){
			fa = "0";
		}else {
			fa = "1";
		}
		
		if(asBean.getFriend()== null) {
			fr = "0";
		}else {
			fr = "1";
		}
		
		if(asBean.getCupple()== null) {
			lo = "0";
		}else {
			lo = "1";
		}
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(asBean.getNo()));
			stmt.setString(2, asBean.getName());
			stmt.setString(3, asBean.getFeel());
			stmt.setString(4, "1");
			stmt.setString(5, fa);
			stmt.setString(6, fr);
			stmt.setString(7, lo);
			stmt.setString(8, asBean.getFamous());
			stmt.setString(9, asBean.getInout());
			stmt.setString(10, asBean.getArea());
			stmt.setString(11, asBean.getSeason());
			stmt.executeUpdate();	
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return;
	}
	
	public void AddImage(AddSpotBean asBean)throws DatabaseException,SystemException{
		this.open();
		
		String sql ="INSERT INTO img VALUES(?,?,?,?,?,?)";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(asBean.getNo()));
			stmt.setString(2, asBean.getImg1());
			stmt.setString(3, asBean.getImg2());
			stmt.setString(4, asBean.getImg3());
			stmt.setString(5, asBean.getImg4());
			stmt.setString(6, asBean.getImg5());
			stmt.executeUpdate();
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return;
	}
	
	public int SpotDup(int id)throws DatabaseException,SystemException{
		this.open();
		
		int dup = 0;
		int sid = 99999999;
		String sql = "SELECT * FROM spot WHERE id = ?";
		
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				sid = Integer.parseInt(rs.getString("id"));
				if(sid == id) {
					dup = 1;
					break;
				}
			}
		}catch(SQLException e){
			throw new DatabaseException(ExceptionParameters.DATABASE_CONNECTION_EXCEPTION_MESSAGE,e);
		}finally {
			this.close(stmt);
		}
		return dup;
	}
}
