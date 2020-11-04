package cube;

import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;

public class Cubelobby extends JFrame implements ActionListener {
	// JTextField input;
	JList<UserDTO> user;
	JList room;
	// JTextArea output;
	JButton createB, loadB;
	PrintWriter pw;
	DefaultListModel<UserDTO> model;
	DefaultListModel roommodel;
	// List<UserDTO> dtoList;

	public Cubelobby() {
	
		// �α��� ������ ����Ʈ
		model = new DefaultListModel<UserDTO>();
		user = new JList<UserDTO>(model);
		user.setBounds(20, 310, 190, 190);

		// ������ ���ӷ� ����Ʈ
		roommodel = new DefaultListModel();
		room = new JList(model);
		room.setBounds(20, 5, 500, 300);

		// �� ����� ����
		createB = new JButton("�� �����");
		loadB = new JButton("�� ����");

		createB.setFont(new Font("�������", Font.BOLD, 28));
		loadB.setFont(new Font("�������", Font.BOLD, 25));

		JPanel p2 = new JPanel();
		p2.add(createB);
		p2.setBounds(350, 330, 170, 60);

		JPanel p3 = new JPanel();
		p3.add(loadB);
		p3.setBounds(350,430, 170, 60);
		
		JPanel p4 = new JPanel();
		// p4.add(img);

		Container c = this.getContentPane();
		// c.add(p1);
		// c.add(p1a);
		// c.add(p1b);
		c.add(p2);
		c.add(p3);
		c.add(user);
		c.add(room);

		setLayout(null);
		setBounds(400, 150, 750, 550);
		setVisible(true);
		setResizable(false);
		setTitle("Lobby");
		// ��� ���ڵ带 ������ JList�� �Ѹ���
		/*
		 * SignUPDAO dao=SignUpDAO.getInstance(); dtoList=dao.get -> friend�ڷ� ����
		 * 
		 * for(FriendDTO dto:dtoList){ model.addElement(dto);
		 */
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(Cubelobby.this, "������ �����Ͻðڽ��ϱ�", "����",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

				if (result == JOptionPane.YES_OPTION)
					System.exit(0);
				if (result == JOptionPane.NO_OPTION)
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

			}

		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == createB) {
			new CubeCreate().event();
		} else if (e.getSource() == loadB) {
			
		}

	}

	public void event() {
		createB.addActionListener(this);
		loadB.addActionListener(this);
	}

}
