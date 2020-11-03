package db;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUp extends JFrame implements ActionListener {
	private JLabel email, pw, name,birth,sex;
	private JTextField emailT, nameT,birthT;
	private JRadioButton male,female;
	
	private TextField pwT;
	private JButton regiBtn, loginBtn, checkidBtn;
	private RummiDAO dao = new RummiDAO();
	private UserDTO dto = new UserDTO();

	public SignUp() {
		name = new JLabel("�̸�");
		pw = new JLabel("��й�ȣ");
		email = new JLabel("�̸���");
		birth=new JLabel("������� (YYMMDD)�������� �ۼ�");
		sex=new JLabel("����");
		
		nameT = new JTextField(20);
		pwT = new TextField(20);
		emailT = new JTextField(20);
		birthT=new JTextField("YYMMDD�������� ������",20);
		
		male=new JRadioButton("����",true);
		female=new JRadioButton("����");

		ButtonGroup group=new ButtonGroup();
		group.add(male);
		group.add(female);
		
		
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

		
		JPanel p4=new JPanel();
		p4.add(sex);
		p4.add(male);
		p4.add(female);
		
		JPanel p5 = new JPanel();
		p5.add(regiBtn);
		//p4.add(loginBtn);
		//p4.add(checkidBtn);
		
		JPanel p6=new JPanel();
		p6.add(birth);
		p6.add(birthT);
		
		
		JPanel inputP = new JPanel();
		inputP.add(p1);
		inputP.add(p2);
		inputP.add(p3);
		inputP.add(p6);
		inputP.add(p4);

		Container c = this.getContentPane();
		c.add("Center", inputP);
		c.add("South", p5);

		setBounds(700, 300, 650, 530);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public void event() {
		regiBtn.addActionListener(this);
		
		checkidBtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == regiBtn) {
			joinArticle();
			
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



	private void joinArticle() {
		String name = nameT.getText();
		String pw = pwT.getText();
		String email = emailT.getText();
		int gender=0;
		if(male.isSelected())
			gender=0;
		else if(female.isSelected())
			gender=1;
		String birth=birthT.getText();
		
		UserDTO dto = new UserDTO();
		dto.setName(name);
		dto.setEmail(email);
		dto.setPw(pw);
		dto.setBirth(birth);
		dto.setSex(gender);
		
		dao.joinArticle(dto);

		System.out.println("��� �Ϸ�");
	}

	
}
