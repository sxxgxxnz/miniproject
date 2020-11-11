package cube;

import java.awt.Container;
import java.awt.event.*;

import javax.swing.*;

import db.RummiDAO;

public class Findid extends JFrame implements ActionListener {
	// 아이디 찾기할때 필요한 요소
	private JLabel birth, email;
	private JTextField birthT, emailT;
	private JButton findidB;
	private JTextArea result;
	private JScrollPane scroll;
	private RummiDAO dao = new RummiDAO();
	private UserDTO dto = new UserDTO();

	public Findid() {
		birth = new JLabel("생년월일");
		email = new JLabel("이메일");

		birthT = new JTextField("YYMMDD으로 입력하세요");
		emailT = new JTextField(13);

		findidB = new JButton("아이디 찾기");
		result = new JTextArea("", 20, 57);

		scroll = new JScrollPane(result);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		result.setEditable(false);

		birth.setBounds(250, 1, 100, 50);
		email.setBounds(350, 100, 100, 300);

		JPanel p1 = new JPanel();
		p1.add(birth);
		p1.add(birthT);
		p1.setBounds(20, 100, 500, 50);

		JPanel p2 = new JPanel();
		p2.add(email);
		p2.add(emailT);
		p2.setBounds(20, 150, 500, 50);

		JPanel p3 = new JPanel();
		p3.add(findidB);
		p3.add(result);
		p3.setBounds(50, 240, 100, 150);

		Container c = this.getContentPane();
		c.add(p1);
		c.add(p2);
		c.add(p3);

		setLayout(null);
		setBounds(600, 300, 600, 400);
		setVisible(true);
		setResizable(false);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(Findid.this, "정말로 종료하시겠습니까", "종료", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);

				if (result == JOptionPane.YES_OPTION)
					System.exit(0);
				if (result == JOptionPane.NO_OPTION)
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});

		findidB.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == findidB) {
			String birth = birthT.getText();
			String email = emailT.getText();

			dto.setBirth(birth);
			dto.setEmail(email);

			String id = dao.findidArticle(dto);
			System.out.println(id);
		}
	}
}
