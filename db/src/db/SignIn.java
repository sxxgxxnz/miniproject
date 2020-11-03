package db;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SignIn extends JFrame implements ActionListener {
	JLabel email, pw, name, login;
	JTextField emailT, pwT, nameT;
	JButton loginB, joinB;

	public SignIn() {

		login = new JLabel("Login");
		email = new JLabel("�г���   : ");
		pw = new JLabel("��й�ȣ :  ");
		// name = new JLabel("Nickname");

		emailT = new JTextField(30);
		pwT = new JTextField(30);
		// nameT = new JTextField();

		loginB = new JButton("���� ����!!");
		joinB = new JButton("ȸ������");
		// cancelB = new JButton("���");

		// setBounds(x,y,�ؽ�Ʈ����,�ؽ�Ʈ����)
		// Login ����
		login.setBounds(250, 1, 100, 50);
		login.setFont(login.getFont().deriveFont(30.0f));

		// Email,pw ����ũ��
		email.setFont(email.getFont().deriveFont(20.0f));
		pw.setFont(pw.getFont().deriveFont(18.0f));

		JPanel p1 = new JPanel();
		p1.add(email);
		p1.add(emailT);
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

		Container c = this.getContentPane();
		c.add(login);
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);

		setLayout(null);
		setBounds(600, 300, 600, 400);
		setVisible(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(SignIn.this, "������ �����Ͻðڽ��ϱ�", "����", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);

				if (result == JOptionPane.YES_OPTION)
					System.exit(0);
			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == loginB) {
			String name = emailT.getText();
			String pw = pwT.getText();
			// String email = emailT.getText();

			UserDTO dto = new UserDTO();
			dto.setName(name);
			// dto.setEmail(email);
			dto.setPw(pw);
			System.out.println(dto.getName() + "\t" + dto.getPw());	//�����͸� �� ���������� Ȯ��

			RummiDAO dao = new RummiDAO();
			int result = dao.loginArticle(dto);
			
			if (result == 1) {
				System.out.println("�α��� ����");
				dao.userArticle(dto);
				new Lobby();
			} else if (result == 0) {
				System.out.println("��й�ȣ ����ġ");
			} else if (result == -1) {
				System.out.println("���̵� ����");
			} else
				System.out.println("�����ͺ��̽� ����");

			
			
			
		} else if (e.getSource() == joinB) {
			new SignUp().event();

		}

	}

	public void event() {
		loginB.addActionListener(this);
		joinB.addActionListener(this);
	}

	public static void main(String[] args) {
		new SignIn().event();
	}
}
