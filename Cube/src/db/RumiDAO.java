package db;

import java.sql.*;

import cube.UserDTO;

public class RumiDAO {
	private Connection conn;
	private PreparedStatement pstmt;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	private ResultSet rs;

	public RumiDAO() {
		try {
			Class.forName(driver);
					
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(url,username,password);
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//회원가입 회원등록
	public void joinArticle(UserDTO dto) {
		String sql="insert into userinfo values(?,?,?,1000,?,?)";
		getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,dto.getId());
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//아이디 중복 체크
	public int checkidArticle(UserDTO dto) {
		int result=0;
		
		return result;
	}
}
