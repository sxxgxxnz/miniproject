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
	JLabel email, pw, name,join,rpw;
	JTextField emailT, pwT, nameT,rpwT;
	JButton okB, cancelB, overlapB;
public Cubejoin() {
	//라벨
	email = new JLabel("E@mail : ");
	pw = new JLabel("비밀번호 : ");
	name = new JLabel("닉네임 : ");
	join = new JLabel("회원가입");
	rpw = new JLabel("비밀번호 재확인 : ");
	
	//버튼
	okB = new JButton("확인");
	cancelB = new JButton("취소");
	overlapB = new JButton("중복체크");
	//텍스트상자
	emailT = new JTextField(16);
	pwT = new JTextField(16);
	nameT = new JTextField(13);
	rpwT = new JTextField(15);
	
	//글자 크기
	join.setBounds(128,1,150,50);
	join.setFont(join.getFont().deriveFont(30.0f));
	
	email.setFont(email.getFont().deriveFont(20.0f));
	pw.setFont(pw.getFont().deriveFont(18.0f));
	
	name.setFont(pw.getFont().deriveFont(20.0f));
	rpw.setFont(pw.getFont().deriveFont(18.0f));
	
	
	//패널
	JPanel p1 = new JPanel();
	p1.add(email);
	p1.add(emailT);
	p1.setBounds(3,100,300,50);
	
	JPanel p2 = new JPanel();
	p2.add(pw);
	p2.add(pwT);
	p2.setBounds(3,150,300,50);
	
	JPanel p3 = new JPanel();
	p3.add(name);
	p3.add(nameT);
	p3.setBounds(10,50,250,50);
	
	JPanel p4 = new JPanel();
	p4.add(okB);
	p4.setBounds(100,350,60,50);
	
	JPanel p5 = new JPanel();
	p5.add(cancelB);
	p5.setBounds(220,350,60,50);
	
	JPanel p6 = new JPanel();
	p6.add(overlapB);
	p6.setBounds(260,50,100,50);
	
	JPanel p7 = new JPanel();
	p7.add(rpw);
	p7.add(rpwT);
	p7.setBounds(3,200,350,60);
	

	
	//컨테이너
	Container c = this.getContentPane();
	c.add(join);
	c.add(p1);
	c.add(p2);
	c.add(p3);
	c.add(p4);
	c.add(p5);
	c.add(p6);
	c.add(p7);
	
	setLayout(null);
	setBounds(700,200,400,500);
	setVisible(true);
	setResizable(false);
 //	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
}

@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()== okB) {
       dispose();// 로그인 연결
	}else if(e.getSource()==cancelB) {
		dispose();
	}

	
	
}

public void event() {	
	okB.addActionListener(this);
	cancelB.addActionListener(this);
}



}
