package cube;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;

//enum Color1 {RED, BLUE, YELLOW, BLACK, JOKER}

public class RumiDAO {
	private Connection conn;
	private PreparedStatement pstmt, pstmt2, pstmt3, pstmt4;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	private ResultSet rs;
	private int[] usedCardIndex = new int[105];

	private static RumiDAO instance;

	public RumiDAO() {
		try {
			Class.forName(driver);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static RumiDAO getInstance() {
		if (instance == null) {
			synchronized (RumiDAO.class) {
				instance = new RumiDAO(); // ó�� ������ �� �� �ѹ��� ����

			}
		}
		return instance;
	}

	public int getRoomSeq() {
		int seq = 0;
		String sql = "select seq_room.nextval from dual";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // sequnce�� ���ٰ� ����
			rs.next();

			seq = rs.getInt(1); // ���° column�� �ִ��� �����ͼ� seq�� �ִ´�.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return seq;
	}

	public int getUsrSeq() {
		int seq = 0;
		String sql = "select seq_gamelist.nextval from dual";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();

			seq = rs.getInt(1); // ���° column�� �ִ��� �����ͼ� seq�� �ִ´�.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return seq;
	}

	public List<RoomDTO> getPlayerList() {
		List<RoomDTO> dtoList = new ArrayList<>();
		RoomDTO dto = new RoomDTO();
		String sql = "select room_maker,p2,p3,p4 from room where room_name like '" + dto.getRoom_name()
				+ "' order by seq";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				dto.setSeq(rs.getInt("seq"));
				dto.setP2(rs.getString("p2"));
				dto.setP3(rs.getString("p3"));
				dto.setP4(rs.getString("p4"));

				dto.setP1(rs.getString("room_maker"));
				dtoList.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dtoList;
	}

	public List<RoomDTO> getRoomList() {
		List<RoomDTO> dtoList = new ArrayList<>();
		String sql = "select * from room order by seq";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				RoomDTO dto = new RoomDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setRoom_name(rs.getString("room_name"));
				// dto.setP1(rs.getString("p1"));
				dtoList.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dtoList;
	}

	public List<UserDTO> getGameList() {
		List<UserDTO> dtoList = new ArrayList<>();
		String sql = "select * from gamelist order by seq";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				UserDTO dto = new UserDTO();
				dto.setSeq(rs.getInt("seq"));
				dto.setId(rs.getString("username"));

				dtoList.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dtoList;
	}

	// ȸ������ ȸ�����
	public void joinArticle(UserDTO dto) {
		String sql = "insert into userinfo values('" + dto.getId() + "'" + ",'" + dto.getPw() + "', '" + dto.getEmail()
				+ dto.getEmailad() + "', 1000,'" + dto.getBirth() + "'," + dto.getGender() + ")";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, dto.getId());
//			pstmt.setString(2, dto.getPw());
//			pstmt.setString(3, dto.getEmail()+dto.getEmailad());
//			pstmt.setString(4, dto.getBirth());
//			pstmt.setInt(5, dto.getGender());

			System.out.println(sql);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// �α���
	public int loginArticle(UserDTO dto) {
		String sql = "select pw from userinfo where name='" + dto.getId() + "'";
		int result = -3;
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
			return result = -1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result; // �׳� -3�� ���ϵ��� ��� ��� ����
	}

	// ���� ���� Ȯ��
	public int checkuserArticle(UserDTO dto) {
		String sql = "select username from gamelist where username='" + dto.getId() + "'";
		getConnection();
		int result = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = 1; // �Է� ���̵�� ������ ������ ����
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	// ���̵� �ߺ�üũ
	public int checkidArticle(UserDTO dto) {
		String sql = "select count(name) as cnt from userinfo where name='" + dto.getId() + "'";
		getConnection();
		int result = 0; // default���� ��밡���� ���̵�(��, ���¾��̵�)

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
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;
	}

	// �α��� �����ؼ� �κ� ���� ���� ���� �߰�
	public void userArticle(UserDTO dto) {
		String sql = "insert into gamelist values('" + dto.getId() + "'," + dto.getSeq() + ")";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	// ���̵� ã��
	public void findidArticle(UserDTO dto) {
		String id = "";
		String sql = "select name from userinfo where birth like '" + dto.getBirth() + "' and email like '"
				+ dto.getEmail() + "'";
		getConnection();
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				id = rs.getString("name");
				JOptionPane.showMessageDialog(null, "���̵�� " + id + " �Դϴ�.");
			} else {
				JOptionPane.showMessageDialog(null, "���̵� ã�� ���߽��ϴ�.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// return id;
	}

	// ��й�ȣ ã��
	public void findpwArticle(UserDTO dto) {
		String pw = "";
		String sql = "select pw from userinfo where birth like '" + dto.getBirth() + "' and email like '"
				+ dto.getEmail() + "'";
		getConnection();
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				pw = rs.getString("pw");
				JOptionPane.showMessageDialog(null, "��й�ȣ�� " + pw + " �Դϴ�.");
			} else {
				JOptionPane.showMessageDialog(null, "��й�ȣ�� ã�� ���߽��ϴ�.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		// return pw;
	}

	// ȸ�� Ż�� -> ���̵�, ��й�ȣ ������ �����Ű��
	public void deleteacntArticle(UserDTO dto) {
		String sql = "delete userinfo where name='" + dto.getId() + "'";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	// ���� ����� ���� ���� ����Ʈ ���ڵ�� ����
	// ���� ����� �渮��Ʈ ���ڵ带 ����
	public void delArticle() {
		String sql = "delete gamelist";
		String sql2 = "delete room";
		String sql3 = "delete card";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
			pstmt3 = conn.prepareStatement(sql3);

			pstmt2.executeUpdate();
			pstmt3.executeUpdate();
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	// �� �����
	public void createArticle(RoomDTO dto) {
//		int port;
//		port++;
		String sql = "insert into room values('" + dto.getPort() + "','" + dto.getRoom_name() + "','" + dto.getRoom_pw()
				+ "','" + dto.getP1() + "','" + dto.getP2() + "','" + dto.getP3() + "','" + dto.getP4() + "',"
				+ dto.getPcnt() + "," + dto.getSeq() + ")";
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	// �� ���� -> list�� ���õ� �������� ������ ���� ���� pcnt�� 4�� �����ʵ��� (4���̻� ���ӽ� �̹� ���� ��, ��й�ȣ �Է�
	// Ȯ��)
	public void enterArticle(RoomDTO dto) {
		String sql = "update room set p2='" + dto.getP2() + "', p3='" + dto.getP3() + "', p4='" + dto.getP4();
		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	// ī�� ���̺� �ʱ�ȭ -> player�����Ϸ��� ����
	public void initcardArticle() {
		String sql = "insert into card values(0,0,0,0,0,0,0,0,0,0,0,0,0,'p1')";
		String sql2 = "insert into card values(0,0,0,0,0,0,0,0,0,0,0,0,0,'p2')";
		String sql3 = "insert into card values(0,0,0,0,0,0,0,0,0,0,0,0,0,'p3')";
		String sql4 = "insert into card values(0,0,0,0,0,0,0,0,0,0,0,0,0,'p4')";

		getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt2 = conn.prepareStatement(sql2);
			pstmt3 = conn.prepareStatement(sql3);
			pstmt4 = conn.prepareStatement(sql4);

			pstmt.executeUpdate();
			pstmt2.executeUpdate();
			pstmt3.executeUpdate();
			pstmt4.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	// card index ���
	public void insertcardArticle() {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {
				int index = newCard();
				String sql = "update card set c" + j + "=" + index + " where name='p" + i + "'";
				getConnection();

				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {

					try {
						if (rs != null)
							rs.close();
						if (pstmt != null)
							pstmt.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}
		}

	}

	// ��� �÷��̾��� ī�� �ε��� ��������
	public void allcardArticle() {
		String sql = "select c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13 from card";
//		int[][] card = new int[4][13];

		Vector<String> card = new Vector<String>();

		getConnection();

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				card.addElement(Integer.toString(rs.getInt("c1")));
				card.addElement(Integer.toString(rs.getInt("c2")));
				card.addElement(Integer.toString(rs.getInt("c3")));
				card.addElement(Integer.toString(rs.getInt("c4")));
				card.addElement(Integer.toString(rs.getInt("c5")));
				card.addElement(Integer.toString(rs.getInt("c6")));
				card.addElement(Integer.toString(rs.getInt("c7")));
				card.addElement(Integer.toString(rs.getInt("c8")));
				card.addElement(Integer.toString(rs.getInt("c9")));
				card.addElement(Integer.toString(rs.getInt("c10")));
				card.addElement(Integer.toString(rs.getInt("c11")));
				card.addElement(Integer.toString(rs.getInt("c12")));
				card.addElement(Integer.toString(rs.getInt("c13")));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (String s : card) {
			System.out.println(s);
		}
		System.out.println("--------------------------------------");
		
		UserDTO userDTO = new UserDTO();
		ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
		
		System.out.println(card.size());
		
		String[] str=new String[card.size()];
		str=(String[])card.toArray(str);
		
		
		
//		for (int i = 0; i < 4; i++) {
//			userList.add(userDTO);	//user 4�� ��������
//			for (int j = 0; j < 13; j++) {
//				userList.get(i).getUserSlotList()
//						.add(userDTO.getCardList().get(str));
//			}
//		}

		System.out.println(userDTO.getCardList().size());
	}

	public int newCard() {
		System.out.println("newCard()");
		int newCardIndex = ((int) (Math.random() * 104)); // 0~104������ ����
		while (usedCardIndex[newCardIndex] == 1) { // �̹� �й�� ī���� �ٽ� ������ ����
			newCardIndex = ((int) (Math.random() * 104));
		} // while
			// ������ ���� �ε�����ȣ�� ī��DTO�� ��üī���̿��� ���� ����DTO�� ����ī���̿� �߰��ϴ� ����

		usedCardIndex[newCardIndex] = 1; // �й�� ī�带 ǥ���ص�
		return newCardIndex;
	}// newCard

}

//////////////////////////////////////////
