package quickmailer.dataAccessObjectClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import quickmailer.entities.Contact;
import quickmailer.entities.Login;
import quickmailer.jdbc.ConnectionProvider;

public class ContactDao {
	
	private static Connection con;
	
	public ContactDao(){
		try {
			con=ConnectionProvider.getConnectivity();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String loginValidate(Login login) throws SQLException{
		String userType=null;
		String sql="select * from admin where uname=? and password=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, login.getUname());
		ps.setString(2, login.getPassword());
	ResultSet rs=	ps.executeQuery();
	if(rs.next()){
		userType="VALID";
		
	}else {
		userType="INVALID";
	}
		
		
		
		return userType;
	}
	
	public void checkContact(Contact contact) throws SQLException{
		String sql="select * from contact where mobile=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setLong(1, contact.getMobile());
		if(ps.executeQuery().next()){
			updateContact(contact);
		}else {
			addContact(contact);
		}
	}
	
	public void addContact(Contact contact) throws SQLException{
		String sql="insert into contact(uname,dob,email,mobile) values(?,?,?,?)";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, contact.getUname());
		ps.setString(2, contact.getDob());
		ps.setString(3, contact.getEmail());
		ps.setLong(4, contact.getMobile());
		ps.executeUpdate();
	}

	
	public void updateContact(Contact contact) throws SQLException{
//String sql="update contact set UNAME=?,set DOB=?,set EMAIL=? where MOBILE=?";
	String sql="update contact set uname=?,dob=?,email=? where mobile=?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, contact.getUname());
		
		ps.setString(2, contact.getDob());
		ps.setString(3, contact.getEmail());
		ps.setLong(4, contact.getMobile());
		ps.executeUpdate();
	}
}
