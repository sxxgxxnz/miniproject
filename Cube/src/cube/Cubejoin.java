package cube;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Cubejoin extends JFrame implements ActionListener {
	JLabel email, pw, name, join, rpw, gender ,birth;
	JTextField emailT, nameT, birthT;
	JButton okB, cancelB, overlapB;
	JPasswordField pwT, rpwT;
	JRadioButton male, female;
	ButtonGroup gender1;

	/*
	 * ��й�ȣ '*'�� �ٲٱ� join�Ҷ� ��й�ȣ ��Ȯ�� �´��� Ȯ�� -> ȸ������ �Ϸ��ư �������� �˻�
	 * 
	 */

	public Cubejoin() {
		// ��
		email = new JLabel("E@mail : ");
		pw = new JLabel("��й�ȣ : ");
		name = new JLabel("�г��� : ");
		join = new JLabel("ȸ������");
		rpw = new JLabel("��й�ȣ ��Ȯ�� : ");
		gender = new JLabel("����     :");
		birth = new JLabel("������� : ");

		// ��ư
		okB = new JButton("Ȯ��");
		cancelB = new JButton("���");
		overlapB = new JButton("�ߺ�üũ");

		gender1 = new ButtonGroup();
		male = new JRadioButton("����");
		female = new JRadioButton("����");

		// �ؽ�Ʈ����
		emailT = new JTextField(10);
		String mail[] = { "@naver.com", "@gmail.com"};
		JComboBox combo = new JComboBox<String>(mail);
		
		pwT = new JPasswordField(16);
		nameT = new JTextField(13);
		rpwT = new JPasswordField(15);
		birthT = new JTextField("YYMMDD���� �Է��ϼ���",15);

		// ���� ũ��
		birth.setFont(birth.getFont().deriveFont(20.0f));
		
		join.setBounds(128, 1, 150, 50);
		join.setFont(join.getFont().deriveFont(30.0f));

		email.setFont(email.getFont().deriveFont(20.0f));
		pw.setFont(pw.getFont().deriveFont(18.0f));

		name.setFont(pw.getFont().deriveFont(20.0f));
		rpw.setFont(pw.getFont().deriveFont(18.0f));
		
		gender.setFont(pw.getFont().deriveFont(20.0f));
		male.setFont(pw.getFont().deriveFont(20.0f));
		female.setFont(pw.getFont().deriveFont(20.0f));

		// ��й�ȣ Ȯ��
//	String pw = pwT.getText().trim();
//	String rpw = rpwT.getText().trim();

		// �г�
		
		JPanel p3 = new JPanel();
		p3.add(name);
		p3.add(nameT);
		p3.setBounds(10, 50, 250, 50);
		
		JPanel p6 = new JPanel();
		p6.add(overlapB);
		p6.setBounds(260, 50, 100, 50);
		
		JPanel p2 = new JPanel();
		p2.add(pw);
		p2.add(pwT);
		p2.setBounds(3, 100, 300, 50);
		
		
		JPanel p7 = new JPanel();
		p7.add(rpw);
		p7.add(rpwT);
		p7.setBounds(3, 150, 350, 60);
		
		JPanel p1 = new JPanel();
		p1.add(email);
		p1.add(emailT);
		p1.add(combo);
		p1.setBounds(3, 200, 350, 50);
		
		JPanel p9 = new JPanel();
		p9.add(birth);
		p9.add(birthT);
		p9.setBounds(3,250,300,50);

		JPanel p8 = new JPanel();
		p8.add(gender);
		gender1.add(male);
		gender1.add(female);
		p8.add(male);
		p8.add(female);
		p8.setBounds(30,350,250,50);

		JPanel p4 = new JPanel();
		p4.add(okB);
		p4.setBounds(100, 450, 60, 50);

		JPanel p5 = new JPanel();
		p5.add(cancelB);
		p5.setBounds(220, 450, 60, 50);



		// �����̳�
		Container c = this.getContentPane();
		c.add(join);
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		c.add(p5);
		c.add(p6);
		c.add(p7);
		c.add(p8);
		c.add(p9);

		setLayout(null);
		setBounds(700, 200, 400, 550);
		setVisible(true);
		setResizable(false);
		// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okB) {
			String pw = pwT.getText();
			String rpw = rpwT.getText();
			String birth = birthT.getText();
			System.out.println(pw);
			System.out.println(rpw);

			
//			if (birth.trim().length()<6) 
//				JOptionPane.showMessageDialog(this, "��������� 6�ڸ� �Է����ּ���");
//			
			if (nameT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "�̸��� �Է��ϼ���");
			if (emailT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "���̵� �Է��ϼ���");
			if (pwT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է��ϼ���");
			if (rpwT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "��Ȯ�� ��й�ȣ�� �Է��ϼ���");
			if (birth.length()!=6) 
				JOptionPane.showMessageDialog(this, "��������� 6�ڸ� �Է����ּ���");
			// if(pnT.getText().equals("010-"))JOptionPane.showMessageDialog(this,"��ȭ��ȣ��
			// �Է��ϼ���");
			else if (pw != null&&pw.equals(rpw) ) {

				JOptionPane.showConfirmDialog(null, "������ �Ϸ�Ǿ����ϴ�", "�˸�", JOptionPane.PLAIN_MESSAGE);
				dispose();

			} else {
				JOptionPane.showConfirmDialog(null, "��й�ȣ�� ��ġ���� �ʽ��ϴ�", "����", JOptionPane.PLAIN_MESSAGE);
				return;
			}

			
		} else if (e.getSource() == cancelB) {
			dispose();
		}

	}

	public void event() {
		okB.addActionListener(this);
		cancelB.addActionListener(this);

	}

}
