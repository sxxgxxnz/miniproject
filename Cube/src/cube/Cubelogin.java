package cube;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import db.RummiDAO;

public class Cubelogin extends JFrame implements ActionListener {
	JLabel id, pw, name, login;
	JTextField idT, nameT;
	JPasswordField pwT;
	JButton loginB, joinB, findid, findpw;

	UserDTO dto = new UserDTO();
	RummiDAO dao = new RummiDAO();

	public Cubelogin() {

		login = new JLabel("Login");
		id = new JLabel("���̵�   : ");
		pw = new JLabel("��й�ȣ :  ");
		// name = new JLabel("Nickname");

		idT = new JTextField(30);
		pwT = new JPasswordField(30);
		// nameT = new JTextField();

		loginB = new JButton("�α���");
		joinB = new JButton("ȸ������");
		// cancelB = new JButton("���");
		findid = new JButton("���̵� ã��");
		findpw = new JButton("��й�ȣ ã��");

		// setBounds(x,y,�ؽ�Ʈ����,�ؽ�Ʈ����)
		// Login ����
		login.setBounds(250, 1, 100, 50);
		login.setFont(login.getFont().deriveFont(30.0f));

		// Email,pw ����ũ��
		id.setFont(id.getFont().deriveFont(20.0f));
		pw.setFont(pw.getFont().deriveFont(18.0f));

		JPanel p1 = new JPanel();
		p1.add(id);
		p1.add(idT);
		p1.setBounds(20, 100, 500, 50);

		JPanel p2 = new JPanel();
		p2.add(pw);
		p2.add(pwT);
		p2.setBounds(20, 150, 500, 50);

		JPanel p3 = new JPanel();
		p3.add(loginB);
		p3.setBounds(120, 300, 100, 50);

		JPanel p4 = new JPanel();
		p4.add(joinB);
		p4.setBounds(360, 300, 90, 50);

		JPanel p5 = new JPanel();
		p5.add(findid);
		p5.setBounds(50, 200, 110, 40);

		JPanel p6 = new JPanel();
		p6.add(findpw);
		p6.setBounds(50, 240, 120, 40);

		Container c = this.getContentPane();
		c.add(login);
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		c.add(p5);
		c.add(p6);

		setLayout(null);
		setBounds(600, 300, 600, 400);
		setVisible(true);
		setResizable(false);
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

			int result = dao.loginArticle(dto);
			if (result == 1) {
				System.out.println("�α��� ����"); // �˸�â ������ּ���
				dao.userArticle(dto);

				new Cubelobby().event();

				dispose();
			} else if (result == 0) {
				System.out.println("��й�ȣ ����ġ"); // �˸�â ������ּ���
			} else if (result == -1) {
				System.out.println("���̵� ����"); // �˸�â ������ּ���
			} else
				System.out.println("�����ͺ��̽� ����");

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
