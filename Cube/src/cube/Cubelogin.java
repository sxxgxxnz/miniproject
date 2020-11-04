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
	private Font font = new Font("�ü�ü", Font.BOLD, 20);

	UserDTO dto = new UserDTO();
	RumiDAO dao = new RumiDAO();

	public Cubelogin() {

		login = new JLabel("Login");
		id = new JLabel("�г���    :  ");
		pw = new JLabel("��й�ȣ :  ");
		// name = new JLabel("Nickname");

		idT = new JTextField(30);
		pwT = new JPasswordField(30);
		// nameT = new JTextField();

		login.setForeground(Color.WHITE);
		loginB = new JButton(new ImageIcon("img\\loginBtn.png"));
		loginB.setBorderPainted(false); // ��ư �׵θ� ����
		loginB.setContentAreaFilled(false); // ��ư ���� ��� ǥ�� ����
		loginB.setFocusPainted(false); // ��Ŀ�� ǥ�� ����

		joinB = new JButton(new ImageIcon("img\\joinBtn.png"));
		joinB.setBorderPainted(false); // ��ư �׵θ� ����
		joinB.setContentAreaFilled(false); // ��ư ���� ��� ǥ�� ����
		joinB.setFocusPainted(false); // ��Ŀ�� ǥ�� ����

		id.setForeground(Color.WHITE);
		pw.setForeground(Color.WHITE);
		id.setFont(font);
		pw.setFont(font);
		// cancelB = new JButton("���");
		findid = new JButton("Forgot ID?");
		findid.setBorderPainted(false); // ��ư �׵θ� ����
		findid.setContentAreaFilled(false); // ��ư ���� ��� ǥ�� ����
		findid.setFocusPainted(false); // ��Ŀ�� ǥ�� ����
		findid.setForeground(Color.WHITE);

		findpw = new JButton("Forgot PW?");
		findpw.setBorderPainted(false); // ��ư �׵θ� ����
		findpw.setContentAreaFilled(false); // ��ư ���� ��� ǥ�� ����
		findpw.setFocusPainted(false); // ��Ŀ�� ǥ�� ����
		findpw.setForeground(Color.WHITE);

		// setBounds(x,y,�ؽ�Ʈ����,�ؽ�Ʈ����)
		// Login ����
		login.setBounds(500, 10, 100, 50);
		login.setLayout(null);
		login.setFont(font);

		loginB.setFont(loginB.getFont().deriveFont(18.0f));
		joinB.setFont(joinB.getFont().deriveFont(18.0f));
		// Email,pw ����ũ��
		id.setFont(id.getFont().deriveFont(18.0f));
		pw.setFont(pw.getFont().deriveFont(18.0f));
		findid.setFont(findid.getFont().deriveFont(18.0f));

		findpw.setFont(font);
		// ���ȭ��
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
				int result = JOptionPane.showConfirmDialog(Cubelogin.this, "������ �����Ͻðڽ��ϱ�", "����",
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
			 * int result = dao.loginArticle(dto); if (result == 1) { // �α��� ���� ����Ʈ���� ��ġ��
			 * ������ ������ �̹� �������̶�� �˸�â �߱�
			 * 
			 * System.out.println("�α��� ����"); // �˸�â ����� //dao.userArticle(dto); new
			 * Cubelobby().event(); dispose();
			 * 
			 * } else if (result == 0) { System.out.println("��й�ȣ ����ġ"); // �˸�â �����
			 * 
			 * } else if (result == -1) { System.out.println("���̵� ����"); // �˸�â ����� } else
			 * System.out.println("������ ���̽� ����");
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
