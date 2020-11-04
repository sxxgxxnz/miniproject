package cube;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import db.RumiDAO;

public class Cubejoin extends JFrame implements ActionListener {
	private JLabel email, pw, id, rpw, gender, birth, code;
	private JTextField emailT, idT, birthT, emailcodeT;
	private JButton okB, cancelB, overlapB, emailcodeB, checkcodeB;
	private JPasswordField pwT, rpwT;
	private JRadioButton male, female;
	private ButtonGroup gender1;
	private JComboBox combo;
	private ImageIcon backicon = new ImageIcon("img\\loginbackground.png");

	private UserDTO dto = new UserDTO();
	private RumiDAO dao = new RumiDAO();

	/*
	 * ��й�ȣ '*'�� �ٲٱ� join�Ҷ� ��й�ȣ ��Ȯ�� �´��� Ȯ�� -> ȸ������ �Ϸ��ư �������� �˻�
	 * 
	 */

	public Cubejoin() {
		// ��
		email = new JLabel("E@mail : ");
		pw = new JLabel("��й�ȣ : ");
		id = new JLabel("ID : ");
		// join = new JLabel("ȸ������");
		rpw = new JLabel("��й�ȣ ��Ȯ�� : ");
		gender = new JLabel("����     :");
		birth = new JLabel("������� : ");
		code = new JLabel("���� �ڵ� : ");

		// �� ����
		email.setForeground(Color.white);
		pw.setForeground(Color.white);
		id.setForeground(Color.white);
		rpw.setForeground(Color.white);
		gender.setForeground(Color.white);
		birth.setForeground(Color.white);
		code.setForeground(Color.white);

		// ��ư
		// ��ư�� �̹��� �ֱ�
		okB = new JButton("Ȯ��");
		cancelB = new JButton("���");
		overlapB = new JButton("�ߺ�üũ");
		emailcodeB = new JButton("�����ڵ� �ޱ�");
		checkcodeB = new JButton("���� �Ϸ�");

		gender1 = new ButtonGroup();
		male = new JRadioButton("����");
		female = new JRadioButton("����");
		male.setOpaque(false);
		female.setOpaque(false);
		male.setForeground(Color.white);
		female.setForeground(Color.white);

		// �ؽ�Ʈ����
		emailT = new JTextField(10);
		emailcodeT = new JTextField(15);
		String mail[] = { "@naver.com", "@gmail.com", "@nate.com", "@daum.net" };
		combo = new JComboBox<String>(mail);

		pwT = new JPasswordField(16);
		idT = new JTextField(13);
		rpwT = new JPasswordField(15);
		birthT = new JTextField("YYMMDD���� �Է��ϼ���", 15);

		// ���� ũ��
		birth.setFont(birth.getFont().deriveFont(20.0f));
//
//		join.setBounds(128, 1, 150, 50);
//		join.setFont(join.getFont().deriveFont(30.0f));

		email.setFont(email.getFont().deriveFont(20.0f));
		pw.setFont(pw.getFont().deriveFont(18.0f));
		code.setFont(code.getFont().deriveFont(20.0f));
		id.setFont(pw.getFont().deriveFont(20.0f));
		rpw.setFont(pw.getFont().deriveFont(18.0f));

		gender.setFont(pw.getFont().deriveFont(20.0f));
		male.setFont(pw.getFont().deriveFont(20.0f));
		female.setFont(pw.getFont().deriveFont(20.0f));

		// ��й�ȣ Ȯ��
//	String pw = pwT.getText().trim();
//	String rpw = rpwT.getText().trim();

		// ���ȭ��
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(backicon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		// �г�
		JPanel p1 = new JPanel();
		p1.add(id);
		p1.add(idT);
		p1.add(overlapB);
		p1.setBounds(20, 70, 300, 50);
		p1.setOpaque(false);

		JPanel p2 = new JPanel();
		p2.add(pw);
		p2.add(pwT);
		p2.setBounds(20, 110, 300, 50);
		p2.setOpaque(false);

		JPanel p3 = new JPanel();
		p3.add(email);
		p3.add(emailT);
		p3.add(combo);
		p3.add(emailcodeB);
		p3.setBounds(6, 200, 500, 50);
		p3.setOpaque(false);

		JPanel p4 = new JPanel();
		p4.add(okB);
		p4.setBounds(110, 450, 60, 50);
		p4.setOpaque(false);

		JPanel p5 = new JPanel();
		p5.add(cancelB);
		p5.setBounds(300, 450, 60, 50);
		p5.setOpaque(false);

		JPanel p7 = new JPanel();
		p7.add(rpw);
		p7.add(rpwT);
		p7.setBounds(20, 150, 350, 60);
		p7.setOpaque(false);

		JPanel p8 = new JPanel();
		p8.add(gender);
		gender1.add(male);
		gender1.add(female);
		p8.add(male);
		p8.add(female);
		p8.setBounds(25, 370, 250, 50);
		p8.setOpaque(false);

		JPanel p9 = new JPanel();
		p9.add(birth);
		p9.add(birthT);
		p9.setBounds(25, 315, 300, 50);
		p9.setOpaque(false);

		JPanel p10 = new JPanel();
		p10.add(code);
		p10.add(emailcodeT);
		p10.add(checkcodeB);
		p10.setBounds(25, 250, 400, 50);
		p10.setOpaque(false);

		// �����̳�
		Container c = this.getContentPane();
		// c.add(join);
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		c.add(p5);
		c.add(p7);
		c.add(p8);
		c.add(p9);
		c.add(p10);

		c.add(panel);

//		setLayout(null);
		setBounds(700, 200, 500, 575);
		setVisible(true);
		setResizable(false);
		// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Join");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okB) { // ȸ����Ϲ�ư
			String pw = pwT.getText();
			String rpw = rpwT.getText();
			String birth = birthT.getText();

			// �Է��� �ߴ��� Ȯ��
			if (idT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "���̵��� �Է��ϼ���");
			if (pwT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է��ϼ���");
			if (rpwT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "��Ȯ�� ��й�ȣ�� �Է��ϼ���");
			if (emailT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "�̸����� �Է��ϼ���");
			if (emailcodeT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "������ȣ�� �Է����ּ���");
			if (birth.length() != 6)
				JOptionPane.showMessageDialog(this, "��������� 6�ڸ� �Է����ּ���");
			if ((male.isSelected() == false) && (female.isSelected() == false))
				JOptionPane.showMessageDialog(this, "������ �������ּ���");

			// �ߺ��˻� �ߴ��� Ȯ��
			if (overlapB.isEnabled()) {

				JOptionPane.showMessageDialog(this, "���̵� �ߺ��˻縦 ���ּ���");

			}
			// �̸��� ���� Ȯ��
			if (emailcodeB.isEnabled()) {

				JOptionPane.showMessageDialog(this, "�̸��� ������ ���ּ���");

			}
//			//�̸��� ���� �Ϸ� Ȯ��
//			if(!checkcodeB.isEnabled()) {
//				JOptionPane.showMessageDialog(this, "�̸��� ������ ���ּ���");
//				
//			}
			else if (pwT.getText() != null) {
				if (pwT.getText().equals(rpwT.getText())) {
					// ��й�ȣ�� null�� �ƴϰ� ��Ȯ�� ��й�ȣ�� ��ġ �Ұ�� ���ԿϷ�

					// joinArticle();
					JOptionPane.showConfirmDialog(null, "������ �Ϸ�Ǿ����ϴ�", "�˸�", JOptionPane.PLAIN_MESSAGE);
					dispose();

				} else if (pwT.getText().equals(rpwT.getText())) {

					JOptionPane.showConfirmDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�", "����", JOptionPane.PLAIN_MESSAGE);
					return;
				}

			}

		} else if (e.getSource() == cancelB) { // ��ҹ�ư
			dispose();
		} else if (e.getSource() == overlapB) { // �ߺ�üũ ��ư
			// checkidArticle();

			// �ߺ��˻� �Ϸ��� ��ư ��Ȱ��ȭ
			overlapB.setEnabled(false);
			
			
		} else if (e.getSource() == emailcodeB) { // �̸��� ������ȣ �ޱ� ��ư

		} else if (e.getSource() == checkcodeB) { // ���� �Ϸ� ��ư

			// ���� �Ϸ�������� ��ư ��Ȱ��ȭ
			checkcodeB.setEnabled(false);
		}

	}

	private void joinArticle() {
		String id = idT.getText();
		String pw = pwT.getText();
		String birth = birthT.getText();
		String email = emailT.getText();
		String emailad = (String) this.combo.getSelectedItem();

		int gender=0;
		if(male.isSelected())
			gender=0;
		else if(female.isSelected())
			gender=1;
		
		dto.setId(id);
		dto.setPw(pw);
		dto.setBirth(birth);
		dto.setEmail(email);
		dto.setEmailad(emailad);
		dto.setGender(gender);
		
		dao.joinArticle(dto);
		
		System.out.println("��ϿϷ�");
	}

	private void checkidArticle() {
		String id=idT.getText();
		dto.setId(id);
		
		int result=dao.checkidArticle(dto);
		
		if(result==0) {
			JOptionPane.showMessageDialog(this, "��� ������ ���̵� �Դϴ�");
		}else if(result>0) {
			JOptionPane.showMessageDialog(this,"�ߺ� ���̵� �ֽ��ϴ�.\n�ٸ� ���̵� �Է����ּ���");
		}
	}

	public void event() {
		okB.addActionListener(this);
		cancelB.addActionListener(this);
		overlapB.addActionListener(this);
		emailcodeB.addActionListener(this);
		checkcodeB.addActionListener(this);

	}

}
