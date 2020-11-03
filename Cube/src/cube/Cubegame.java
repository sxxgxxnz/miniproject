package cube;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Cubegame extends JFrame implements ActionListener{
	JButton up,re,skip,ze ,send;
	JList<UserDTO> user;
    JTextArea output;
    JTextField input;
	DefaultListModel<UserDTO> model;
	
	private JButton[] gsn=new JButton[180];
	
	public Cubegame() {
		
		model=new DefaultListModel<UserDTO>();
		user=new JList<UserDTO>(model);
		user.setBounds(950,5,200,200);

		output = new JTextArea("",8,22);
		
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		output.setEditable(false);
		
		input = new JTextField(13);
		send = new JButton("보내기");
		
		
		JPanel gs = new JPanel();		
		gs.setLayout(new GridLayout(9,20));
		gs.setBounds(0,0,930,550);
		for(int i = 0; i < 180; i++) {
			
			gs.add(gsn[i] = new JButton()).setBackground(new Color(0,193,193));
		
		}
		JPanel us = new JPanel();		
		us.setLayout(new GridLayout(2,20));
		us.setBounds(0,550,930,122);
		us.setBackground(new Color(220,255,255));
		for(int i = 0; i < 40; i++) {
			us.add(new JButton()).setBackground(new Color(102,51,0));
			
		}
		model = new DefaultListModel<UserDTO>();
//		list = new JList<UserDTO>(model);
//		//list.setBounds(x, y, width, height);
		
		
		
		up = new JButton("등록");
		re = new JButton("취소");
		skip = new JButton("스킵");
		ze = new JButton("정렬");
		
		
		up.setFont(up.getFont().deriveFont(18.0f));
		re.setFont(re.getFont().deriveFont(18.0f));
		skip.setFont(skip.getFont().deriveFont(18.0f));
		ze.setFont(ze.getFont().deriveFont(18.0f));
		
		
		JPanel p1 = new JPanel();
		p1.add(up);
		p1.setBounds(960,500,80,50);
		
		JPanel p2 = new JPanel();
		p2.add(re);
		p2.setBounds(1080,500,80,50);
		
		JPanel p3 = new JPanel();
		p3.add(skip);
		p3.setBounds(960,600,80,50);
		
		JPanel p4 = new JPanel();
		p4.add(ze);
		p4.setBounds(1080,600,80,50);
		
		JPanel p5 = new JPanel();
		p5.setBounds(850,350,400,50);
		p5.add(input);
		p5.add(send);
		
		JPanel p6 = new JPanel();
		p6.add(output);
		p6.setBounds(940,210,220,250);
	
		
		Container c = this.getContentPane();
		c.add(gs);
		c.add(us);
		c.add(user);
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		c.add(p5);
		c.add(p6);
		
		
		
		
		setLayout(null);
		setBounds(200,100,1200,720);
		setVisible(true);
		setResizable(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

	public void event() {
		for(int i =0; i<180; i++) {
			gsn[i].addActionListener(this);
		}
		
	}
}
