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
import javax.swing.JTextField;

public class Cubelogin extends JFrame implements ActionListener{
	JLabel email, pw, name,login;
	JTextField emailT, pwT, nameT;
	JButton loginB, joinB;

	public Cubelogin() {
		
		login = new JLabel("Login");
		email = new JLabel("�г���   : ");
		pw = new JLabel("��й�ȣ :  ");
	//	name = new JLabel("Nickname");
		
		emailT = new JTextField(30);
		pwT = new JTextField(30);
	//	nameT = new JTextField();
		
      	loginB = new JButton("���� ����!!");
		joinB = new JButton("ȸ������");
	//	cancelB = new JButton("���");
		
		
		//setBounds(x,y,�ؽ�Ʈ����,�ؽ�Ʈ����)
		//Login ����
		login.setBounds(250,1,100,50);
		login.setFont(login.getFont().deriveFont(30.0f));

		//Email,pw ����ũ��
		email.setFont(email.getFont().deriveFont(20.0f));
		pw.setFont(pw.getFont().deriveFont(18.0f));
		
		
		JPanel p1 = new JPanel();
		p1.add(email);
		p1.add(emailT);
		p1.setBounds(20,100,500,50);
		
		JPanel p2 = new JPanel();
		p2.add(pw);
		p2.add(pwT);
		p2.setBounds(20,150,500,50);
		
		JPanel p3 = new JPanel();
		p3.add(loginB);
		p3.setBounds(120,300,100,50);
		
		JPanel p4 = new JPanel();
		p4.add(joinB);
		p4.setBounds(360,300,90,50);
		


		

		Container c = this.getContentPane();
		c.add(login);
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);



		setLayout(null);
		setBounds(600,300,600,400);
		setVisible(true);
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(Cubelogin.this,
						"������ �����Ͻðڽ��ϱ�", 
						"����", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE);
				
				if(result == JOptionPane.YES_OPTION) System.exit(0);
				if(result == JOptionPane.NO_OPTION) setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==loginB) {
			new Cubelobby().event();;
			dispose();
			
		}else if(e.getSource()==joinB) {
			new Cubejoin().event();
			
			
		}
		
	}
	
	public void event() {
		loginB.addActionListener(this);
		joinB.addActionListener(this);
	}
	
	
	
	
	public static void main(String[] args) {
		new Cubelogin().event();

		
	}
}

