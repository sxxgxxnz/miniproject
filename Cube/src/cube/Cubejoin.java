package cube;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cubejoin extends JFrame implements ActionListener{
	JLabel email, pw, name,join;
	JTextField emailT, pwT, nameT;
	JButton okB, cancelB;
public Cubejoin() {
	//��
	email = new JLabel("E@mail : ");
	pw = new JLabel("��й�ȣ : ");
	name = new JLabel("�г��� : ");
	join = new JLabel("ȸ������");
	
	//��ư
	okB = new JButton("Ȯ��");
	cancelB = new JButton("���");
	//�ؽ�Ʈ����
	emailT = new JTextField(20);
	pwT = new JTextField(20);
	nameT = new JTextField(20);
	
	//���� ũ��
	join.setBounds(128,1,150,50);
	join.setFont(join.getFont().deriveFont(30.0f));
	
	email.setFont(email.getFont().deriveFont(20.0f));
	pw.setFont(pw.getFont().deriveFont(18.0f));
	
	name.setFont(pw.getFont().deriveFont(20.0f));
	
	//�г�
	JPanel p1 = new JPanel();
	p1.add(email);
	p1.add(emailT);
	p1.setBounds(20,100,350,50);
	
	JPanel p2 = new JPanel();
	p2.add(pw);
	p2.add(pwT);
	p2.setBounds(20,150,350,50);
	
	JPanel p3 = new JPanel();
	p3.add(name);
	p3.add(nameT);
	p3.setBounds(20,200,350,50);
	
	JPanel p4 = new JPanel();
	p4.add(okB);
	p4.setBounds(100,350,60,50);
	
	JPanel p5 = new JPanel();
	p5.add(cancelB);
	p5.setBounds(220,350,60,50);

	
	//�����̳�
	Container c = this.getContentPane();
	c.add(join);
	c.add(p1);
	c.add(p2);
	c.add(p3);
	c.add(p4);
	c.add(p5);
	
	setLayout(null);
	setBounds(700,200,400,500);
	setVisible(true);
	setResizable(false);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()== okB) {
       
	}else if(e.getSource()==cancelB) {
		setVisible(false);
	}

	
	
}

public void event() {	
	okB.addActionListener(this);
	cancelB.addActionListener(this);
}



}
