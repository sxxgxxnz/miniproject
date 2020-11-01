package db;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUp extends JFrame implements ActionListener {
	private JLabel email, pw, name;
	private JTextField emailT, nameT;
	private TextField pwT;
	private JButton regiBtn, loginBtn, checkidBtn;
	private SignUpDAO dao = new SignUpDAO();
	private UserDTO dto = new UserDTO();

	public SignUp() {
		name = new JLabel("�̸�");
		pw = new JLabel("��й�ȣ");
		email = new JLabel("�̸���");

		nameT = new JTextField(20);
		pwT = new TextField(20);
		emailT = new JTextField(20);

		regiBtn = new JButton("���");
		//loginBtn = new JButton("�α���");
		checkidBtn = new JButton("���̵� �ߺ�üũ");

		pwT.setEchoChar('*');

		JPanel p1 = new JPanel();
		p1.add(name);
		p1.add(nameT);
		p1.add(checkidBtn);

		JPanel p2 = new JPanel();
		p1.add(pw);
		p1.add(pwT);

		JPanel p3 = new JPanel();
		p3.add(email);
		p3.add(emailT);

		JPanel p4 = new JPanel();
		p4.add(regiBtn);
		//p4.add(loginBtn);
		//p4.add(checkidBtn);
		
		JPanel inputP = new JPanel();
		inputP.add(p1);
		inputP.add(p2);
		inputP.add(p3);
		// inputP.add(p4);

		Container c = this.getContentPane();
		c.add("Center", inputP);
		c.add("South", p4);

		setBounds(700, 300, 650, 530);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void event() {
		regiBtn.addActionListener(this);
		//loginBtn.addActionListener(this);
		checkidBtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == regiBtn) {
			insertArticle();
		} else if (e.getSource() == loginBtn) {
			//loginArticle();
		} else if (e.getSource() == checkidBtn) {
			checkidArticle();
		}
	}

	private void checkidArticle() {
		// TODO Auto-generated method stub
		String name = nameT.getText();

		dto.setName(name);

		int result=dao.checkidArticle(dto);
		
		if(result==0) {
			System.out.println("��밡���� ���̵�");
		}else if(result>0) {
			System.out.println("�ߺ� ���̵� ����");
		}
	}



	private void insertArticle() {
		String name = nameT.getText();
		String pw = pwT.getText();
		String email = emailT.getText();

		UserDTO dto = new UserDTO();
		dto.setName(name);
		dto.setEmail(email);
		dto.setPw(pw);

		dao.insertArticle(dto);

		System.out.println("��� �Ϸ�");
	}

	public static void main(String[] args) {
		new SignUp().event();
	}

}
