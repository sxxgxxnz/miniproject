package cube;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CubeCreate extends JFrame implements ActionListener {
	JLabel rn, ip, pw;
	JTextField rnT, ipT;
	JButton okB, cancelB;
	JPasswordField pwT;

	public CubeCreate() {

		rnT = new JTextField(15);
		ipT = new JTextField(15);
		pwT = new JPasswordField(10);

		rn = new JLabel("�� ���� : ");
		okB = new JButton("Ȯ��");
		cancelB = new JButton("���");
		ip = new JLabel("����IP : ");
		pw = new JLabel("��й�ȣ : ");

		rn.setFont(rn.getFont().deriveFont(18.0f));
		ip.setFont(ip.getFont().deriveFont(18.0f));
		pw.setFont(pw.getFont().deriveFont(18.0f));

		JPanel p1 = new JPanel();
		p1.add(rn);
		p1.add(rnT);
		p1.setBounds(5, 70, 300, 40);

		JPanel p2 = new JPanel();
		p2.add(okB);
		p2.setBounds(65, 200, 60, 50);

		JPanel p3 = new JPanel();
		p3.add(cancelB);
		p3.setBounds(205, 200, 60, 50);

		JPanel p4 = new JPanel();
		p4.add(ip);
		p4.add(ipT);
		p4.setBounds(5, 20, 300, 40);

		JPanel p5 = new JPanel();
		p5.add(pw);
		p5.add(pwT);
		p5.setBounds(5, 120, 250, 40);

		Container c = this.getContentPane();
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		c.add(p5);

		setLayout(null);
		setBounds(700, 370, 350, 300);
		setVisible(true);
		setResizable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okB) {
			new Cubegame().event();
			dispose();// �α��� ����
		} else if (e.getSource() == cancelB) {
			dispose();
		}

	}

	public void event() {
		okB.addActionListener(this);
		cancelB.addActionListener(this);
	}

}
