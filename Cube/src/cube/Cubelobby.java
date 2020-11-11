package cube;

import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.util.*;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;

public class Cubelobby extends JFrame implements ActionListener{
    JTextField input;
    JList<UserDTO> user;
    JList room;
	JTextArea output;
	JButton createB, loadB, send;
    PrintWriter pw;
	DefaultListModel<UserDTO> model;
	DefaultListModel roommodel;
	//List<UserDTO> dtoList;
	
	public Cubelobby(){
		//로비 채팅부분
		output = new JTextArea("",20,57);
		
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		output.setEditable(false);
		
		input = new JTextField(50);
		
		send = new JButton("보내기");
		
		//로그인 접속자 리스트
		model=new DefaultListModel<UserDTO>();
		user=new JList<UserDTO>(model);
		user.setBounds(755, 5, 200, 200);
		
		//생성된 게임룸 리스트
		roommodel=new DefaultListModel();
		room=new JList(model);
		room.setBounds(62,5,630,250);
		
		
		JPanel p1 = new JPanel();
		p1.setBounds(30,500,700,50);
		p1.add(input);
		p1.add(send);
		
		JPanel p1a= new JPanel();
		p1a.add(output);
		p1a.setBounds(30,240,700,250);
		
		
		Image img = Toolkit.getDefaultToolkit().getImage("루미큐브.PNG");
		// 루미큐브 이미지 넣기
//		DefaultListModel<String> m = new DefaultListModel<>();
//		m.addElement("");
//		user = new JList(m);
		//리스트 , 대기방 창

//		JPanel p1b = new JPanel();
//		p1b.add(user);
//		p1b.setBounds(750,0,200,150);
//		
		//방 만들기 들어가기
		createB = new JButton("방 만들기");
		loadB = new JButton("방 들어가기");

		createB.setFont(new Font("맑은고딕", Font.BOLD, 28));
		loadB.setFont(new Font("맑은고딕", Font.BOLD, 25));
		
		JPanel p2 = new JPanel();
		p2.add(createB);
		p2.setBounds(770,400,170,60);
		
		JPanel p3 = new JPanel();
		p3.add(loadB);
		p3.setBounds(770,500,170,60);
		

		Container c = this.getContentPane();
		c.add(p1);
		c.add(p1a);
		//c.add(p1b);
		c.add(p2);
		c.add(p3);
		c.add(user);
		c.add(room);
		
		
		setLayout(null);
		setBounds(400,150,1000,600);
		setVisible(true);
		setResizable(false);
		
		//모든 레코드를 꺼내서 JList에 뿌리기
		/*
		 * SignUPDAO dao=SignUpDAO.getInstance();
		 * dtoList=dao.get	-> friend자료 참고
		 * 
		 * for(FriendDTO dto:dtoList){
		 * model.addElement(dto);
		 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(Cubelobby.this,
						"정말로 종료하시겠습니까", 
						"종료", 
						JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE);
				
				if(result == JOptionPane.YES_OPTION) System.exit(0);
				if(result == JOptionPane.NO_OPTION) setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
			}
			
		});
		

		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==createB) {
			new CubeCreate().event();
		}
		
	}
	
	public void event() {
		createB.addActionListener(this);
		loadB.addActionListener(this);
	}



}
