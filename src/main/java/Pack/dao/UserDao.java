package Pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import Pack.dto.UserDTO;
import Pack.util.JdbcTemplate;

@Repository
public class UserDao {
	Connection con;
	PreparedStatement pstm;
	ResultSet rs;
	
	void connect(String sql) throws SQLException {
		con = JdbcTemplate.getConnection();
		pstm = con.prepareStatement(sql);	
	}
	
	void close() throws SQLException {
		rs.close();
		pstm.close();
		con.close();
	}
	
	public boolean signUp(UserDTO dto) {
		String sql = "insert into user value(null, ?, ?, ?)";
		
		try {
			connect(sql);
		
			pstm.setString(1, dto.getName());
			pstm.setString(2, dto.getId());
			pstm.setString(3, dto.getPw());
			
			pstm.execute();
			
			close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public UserDTO login(UserDTO dto) {
		String sql = "select * from user where id = ?";
		UserDTO user = null;
		
		try {
			connect(sql);
		
			pstm.setString(1, dto.getId());
			
			rs = pstm.executeQuery();
			while (rs.next()) {
				user = new UserDTO();
				
				user.setUserNo(rs.getInt("userNo"));
				user.setName(rs.getString("name"));
				user.setId(rs.getString("id"));
				user.setPw(rs.getString("pw"));
			}
			
			close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
}
