package cube;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import rumikkup.Rumikkup;
import rumikkup.UserDTO;
import rumikkup.CardDTO;

public class Cubegame extends JFrame implements ActionListener {
	private JButton up, re, skip, ze, send, gamestart;
	private JList<UserDTO> user;
	private JTextArea output;
	private JTextField input;
	private DefaultListModel<UserDTO> model;
	//버튼 배열 2차배열로 바꾸기
	private JButton[] gsn = new JButton[180];
	private JButton[] usn = new JButton[40];
	private ArrayList<UserDTO> userList = new ArrayList<UserDTO>();
	private Rumikkup rumi = new Rumikkup();
	private int turn = 0;
	private int myturn = 1;

	
	public Cubegame() {

		model = new DefaultListModel<UserDTO>();
		user = new JList<UserDTO>(model);
		user.setBounds(950, 5, 200, 200);

		output = new JTextArea("", 8, 22);

		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		output.setEditable(false);

		input = new JTextField(13);
		send = new JButton("보내기");

		JPanel gs = new JPanel();
		gs.setLayout(new GridLayout(9, 20));
		gs.setBounds(0, 0, 930, 550);
		for (int i = 0; i < 180; i++) {

			gs.add(gsn[i] = new JButton()).setBackground(new Color(255, 255, 255));

		}
		JPanel us = new JPanel();
		us.setLayout(new GridLayout(2, 20));
		us.setBounds(0, 550, 930, 122);
		us.setBackground(new Color(220, 255, 255));
		for (int i = 0; i < 40; i++) {
			us.add(usn[i] = new JButton()).setBackground(new Color(102, 51, 0));

		}
		model = new DefaultListModel<UserDTO>();
//		list = new JList<UserDTO>(model);
//		//list.setBounds(x, y, width, height);

		// 버튼
		up = new JButton("등록");
		re = new JButton("취소");
		skip = new JButton("스킵");
		ze = new JButton("정렬");
		gamestart = new JButton("START!");

		up.setFont(up.getFont().deriveFont(18.0f));
		re.setFont(re.getFont().deriveFont(18.0f));
		skip.setFont(skip.getFont().deriveFont(18.0f));
		ze.setFont(ze.getFont().deriveFont(18.0f));
		gamestart.setFont(new Font("HY백송B", Font.BOLD, 25));

		JPanel p1 = new JPanel();
		p1.add(up);
		p1.setBounds(960, 500, 80, 50);

		JPanel p2 = new JPanel();
		p2.add(re);
		p2.setBounds(1080, 500, 80, 50);

		JPanel p3 = new JPanel();
		p3.add(skip);
		p3.setBounds(960, 600, 80, 50);

		JPanel p4 = new JPanel();
		p4.add(ze);
		p4.setBounds(1080, 600, 80, 50);

		JPanel p5 = new JPanel();
		p5.setBounds(850, 350, 400, 35);
		p5.add(input);
		p5.add(send);

		JPanel p6 = new JPanel();
		p6.add(output);
		p6.setBounds(940, 210, 220, 200);

		JPanel p7 = new JPanel();
		p7.add(gamestart);
		p7.setBounds(980, 420, 160, 50);

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
		c.add(p7);

		setLayout(null);
		setBounds(200, 100, 1200, 720);
		setVisible(true);
		setResizable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < 180; i++) {
			if (e.getSource() == gsn[i]) {

			}
		}
		for (int i = 0; i < 40; i++) {
			if (e.getSource() == usn[i]) {

			}
		}

		if (e.getSource() == gamestart) {
			rumi.startGame();

//			userList = a.startGame();
			gamestart.setVisible(false);
			// gamestart.setEnabled(false);
			for (int i = 0; i < userList.get(turn).getUserSlotList().size(); i++) {
				// 내 버튼에 카드에 맞는 카드 이미지 올리기

			}

			// for(int i= )

		} else if (e.getSource() == up) {
			int index[]=new int[180];
			
//			rumi.setGameSlot(index);
//			
//			gsn.isSelected.
//			
//			if(rumi.confirm(dto));
//				//등록한 카드를 모든 버튼에 반영시키기
//			else 
//				//오류창 -> 카드가 잘못되었습니다...???
				
		} else if (e.getSource() == re) {
			//rumi.rollback();
		} else if (e.getSource() == skip) {
			//카드 한장 받고
			int newcardindx=rumi.newCard();
			
			//다음턴
			//rumi.nextTurn();
			turn++;
			//dto.setTurn(turn);
			
		} else if (e.getSource() == ze) {
			rumi.sort();
		}
		
	}

	

//	1번쨰 유저의 5번째 카드의 인덱스 정보 읽어 오기
// userList.get(0).userSlotList.get(4).getIndex();
	public void event() {
		for (int i = 0; i < 180; i++) {
			gsn[i].addActionListener(this);
		}
		for (int i = 0; i < 40; i++) {
			usn[i].addActionListener(this);
			gamestart.addActionListener(this);

		}

	}
}
