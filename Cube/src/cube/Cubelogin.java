package cube;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

import db.RumiDAO;

public class Cubelogin extends JFrame implements ActionListener {
	private JLabel id, pw, name, login;
	private JTextField idT, nameT;
	private JPasswordField pwT;
	private JButton loginB, joinB, findid, findpw;
	private ImageIcon backicon = new ImageIcon("img\\loginbackground.png");
	// private JScrollPane scrollPane;
	private Font font = new Font("궁서체", Font.BOLD, 20);

	UserDTO dto = new UserDTO();
	RumiDAO dao = new RumiDAO();

	public Cubelogin() {

		login = new JLabel("Login");
		id = new JLabel("닉네임    :  ");
		pw = new JLabel("비밀번호 :  ");
		// name = new JLabel("Nickname");

		idT = new JTextField(30);
		pwT = new JPasswordField(30);
		// nameT = new JTextField();

		login.setForeground(Color.WHITE);
		loginB = new JButton(new ImageIcon("img\\loginBtn.png"));
		loginB.setBorderPainted(false); // 버튼 테두리 설정
		loginB.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		loginB.setFocusPainted(false); // 포커스 표시 설정

		joinB = new JButton(new ImageIcon("img\\joinBtn.png"));
		joinB.setBorderPainted(false); // 버튼 테두리 설정
		joinB.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		joinB.setFocusPainted(false); // 포커스 표시 설정

		id.setForeground(Color.WHITE);
		pw.setForeground(Color.WHITE);
		id.setFont(font);
		pw.setFont(font);
		// cancelB = new JButton("취소");
		findid = new JButton("Forgot ID?");
		findid.setBorderPainted(false); // 버튼 테두리 설정
		findid.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		findid.setFocusPainted(false); // 포커스 표시 설정
		findid.setForeground(Color.WHITE);

		findpw = new JButton("Forgot PW?");
		findpw.setBorderPainted(false); // 버튼 테두리 설정
		findpw.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		findpw.setFocusPainted(false); // 포커스 표시 설정
		findpw.setForeground(Color.WHITE);

		// setBounds(x,y,텍스트가로,텍스트세로)
		// Login 글자
		login.setBounds(500, 10, 100, 50);
		login.setLayout(null);
		login.setFont(font);

		loginB.setFont(loginB.getFont().deriveFont(18.0f));
		joinB.setFont(joinB.getFont().deriveFont(18.0f));
		// Email,pw 글자크기
		id.setFont(id.getFont().deriveFont(18.0f));
		pw.setFont(pw.getFont().deriveFont(18.0f));
		findid.setFont(findid.getFont().deriveFont(18.0f));

		findpw.setFont(font);
		// 배경화면
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {

				g.drawImage(backicon.getImage(), 0,0, null);
				setOpaque(false);
				super.paintComponent(g);

			}
		};

		JPanel p1 = new JPanel();

		p1.add(id);
		p1.add(idT);
		p1.setBounds(20, 100, 500, 50);
		p1.setOpaque(false);

		JPanel p2 = new JPanel();
		p2.add(pw);
		p2.add(pwT);
		p2.setBounds(20, 150, 500, 50);
		p2.setOpaque(false);

		JPanel p3 = new JPanel();
		p3.add(loginB);
		p3.setBounds(70, 200, 210, 50);
		p3.setOpaque(false);

		JPanel p4 = new JPanel();
		p4.add(joinB);
		p4.setBounds(330, 200, 180, 50);
		p4.setOpaque(false);

		JPanel p5 = new JPanel();
		p5.add(findid);
		p5.setBounds(50, 250, 140, 60);
		p5.setOpaque(false);

		JPanel p6 = new JPanel();
		p6.add(findpw);
		p6.setBounds(250, 250, 140, 60);
		p6.setOpaque(false);

		// scrollPane = new JScrollPane(panel);
		// panel.setLayout(null);

		Container c = this.getContentPane();
		c.add(login);
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		c.add(p5);
		c.add(p6);
		c.add(panel);

		setTitle("Login");
		setBounds(600, 300, 666, 375);
		setVisible(true);
		setResizable(true);
		// setContentPane(scrollPane);
		// setBackground(new Color(128,128,192));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(Cubelogin.this, "정말로 종료하시겠습니까", "종료",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (result == JOptionPane.YES_OPTION)
					System.exit(0);
				if (result == JOptionPane.NO_OPTION)
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == loginB) {
			String id = idT.getText();
			String pw = pwT.getText();

			int turn = 0;

			dto.setId(id);
			dto.setPw(pw);

			/*
			 * int result = dao.loginArticle(dto); if (result == 1) { // 로그인 유저 리스트에서 겹치는
			 * 유저가 있으면 이미 접속중이라고 알림창 뜨기
			 * 
			 * System.out.println("로그인 성공"); // 알림창 만들기 //dao.userArticle(dto); new
			 * Cubelobby().event(); dispose();
			 * 
			 * } else if (result == 0) { System.out.println("비밀번호 불일치"); // 알림창 만들기
			 * 
			 * } else if (result == -1) { System.out.println("아이디가 없음"); // 알림창 만들기 } else
			 * System.out.println("데이터 베이스 오류");
			 */
			new Cubelobby().event();
		} else if (e.getSource() == joinB) {
			new Cubejoin().event();

		} else if (e.getSource() == findid) {
			new Findid();

		} else if (e.getSource() == findpw) {
			new Findpw();
		}

	}

	public void event() {
		loginB.addActionListener(this);
		joinB.addActionListener(this);
		findid.addActionListener(this);
		findpw.addActionListener(this);
	}

	public static void main(String[] args) {
		new Cubelogin().event();

	}
}
