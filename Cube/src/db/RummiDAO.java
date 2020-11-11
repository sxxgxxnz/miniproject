package db;

import java.sql.*;

import cube.UserDTO;

public class RummiDAO {
	private Connection conn;
	private PreparedStatement pstmt;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	private ResultSet rs;

	public RummiDAO() {
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

	// ȸ������ ȸ�� ���
	public void joinArticle(UserDTO dto) {
		String sql = "insert into userInfo values(?,?,?,1000,?,?)";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getEmail() + dto.getEmailad());
			pstmt.setString(4, dto.getBirth());
			pstmt.setInt(5, dto.getGender());

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

	// ���̵� �ߺ� üũ
	public int checkidArticle(UserDTO dto) {
		String sql = "select count(name) as cnt from userinfo where name='" + dto.getId() + "'";
		getConnection();
		int result = 0; // default���� ��밡���� ���̵�

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next() == true) {
				// cnt�� 1�̸� �ߺ����̵� ����
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

		String sql = "select pw from userinfo where name='" + dto.getId() + "'";
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

	// �α��� ���� ����Ʈ
	public void userArticle(UserDTO dto) {
		String sql = "insert into gamelist values(?)";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
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

	// ����� ���� ���� ���� ����
	public void exitArticle(UserDTO dto) {

	}

	// ���̵� ã��
	public String findidArticle(UserDTO dto) {
		String id = "";
		String sql = "select name from userinfo where birth like '" + dto.getBirth() + "' and email like '"
				+ dto.getEmail() + "'";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				// System.out.println("ddddddddd");
				id = rs.getString("name");
			} else {
				id = "���̵� ã�� ���߽��ϴ�";
				// System.out.println("aaaaaaaaa");
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

		return id;
	}

	// ��й�ȣ ã��
	public String findpwArticle(UserDTO dto) {
		String pw = "";
		String sql = "select pw from userinfo where birth like '" + dto.getBirth() + "' and id like '" + dto.getId()+"'";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			//System.out.println(dto.getId());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				// System.out.println("ddddddddd");
				pw = rs.getString("pw");
			} else {
				pw = "��й�ȣ�� ã�� ���߽��ϴ�";
				// System.out.println("aaaaaaaaa");
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

		return pw;
	}
}
