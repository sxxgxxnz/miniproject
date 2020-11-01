package db;

import java.sql.*;

public class SignUpDAO {
	private Connection conn;
	private PreparedStatement pstmt;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	private ResultSet rs;

	public SignUpDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// getConnection

	public void insertArticle(UserDTO dto) {
		String sql = "insert into userInfo values(?,?,?,1000)";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getEmail());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				} // if
			} catch (SQLException e) {
				e.printStackTrace();
			} // try
		} // try

	}

	public int checkidArticle(UserDTO dto) {
		String sql = "select count(name) as cnt from userinfo where name='" + dto.getName() + "'";
		getConnection();
		int result = 0;	//default���� ��밡���� ���̵�

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next() == true) {
				//cnt�� 1�̸� �ߺ����̵� ����
				result = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				} // if
			} catch (SQLException e) {
				e.printStackTrace();
			} // try
		} // try
		return result;

	}

	public int loginArticle(UserDTO dto) {

		String sql = "select pw from userinfo where name='" + dto.getName() + "'";
		int result = -3;
		System.out.println(sql);
		getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				if (rs.getString(1).equals(dto.getPw())) {
					return result = 1; // �α��� ����
				} else
					return result = 0; // ��й�ȣ ����ġ
			}
			return result = -1; // ���̵� ����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				} // if
			} catch (SQLException e) {
				e.printStackTrace();
			} // try
		} // try
		return result; // �׳� -3�� ������ ��� ������
	}
}
