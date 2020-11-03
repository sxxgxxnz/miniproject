package cube;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CubeCreate extends JFrame implements ActionListener{
	JLabel rn;
	JTextField rnT;
	JButton okB, cancelB;
	
	public CubeCreate() {
		rn = new JLabel("방 제목");
		
		rn.setBounds(130,1,150,40);
		rn.setFont(rn.getFont().deriveFont(20.0f));
		
		rnT = new JTextField(25);
		
		okB = new JButton("확인");
		cancelB = new JButton("취소");
		
		JPanel p1 = new JPanel();
		p1.add(rnT);
		p1.setBounds(15,60,300,40);
		
		JPanel p2 = new JPanel();
		p2.add(okB);
		p2.setBounds(65,100,60,50);
		
		JPanel p3 = new JPanel();
		p3.add(cancelB);
		p3.setBounds(205,100,60,50);
		
		
		Container c = this.getContentPane();
		c.add(rn);
		c.add(p1);
		c.add(p2);
		c.add(p3);
		
		setLayout(null);
		setBounds(700,370,350,200);
		setVisible(true);
		setResizable(false);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== okB) {
			new Cubegame().event();
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
