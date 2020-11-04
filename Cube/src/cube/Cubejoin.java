package cube;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import db.RumiDAO;

public class Cubejoin extends JFrame implements ActionListener {
	private JLabel email, pw, id, rpw, gender, birth, code;
	private JTextField emailT, idT, birthT, emailcodeT;
	private JButton okB, cancelB, overlapB, emailcodeB, checkcodeB;
	private JPasswordField pwT, rpwT;
	private JRadioButton male, female;
	private ButtonGroup gender1;
	private JComboBox combo;
	private ImageIcon backicon = new ImageIcon("img\\loginbackground.png");

	private UserDTO dto = new UserDTO();
	private RumiDAO dao = new RumiDAO();

	/*
	 * 비밀번호 '*'로 바꾸기 join할때 비밀번호 재확인 맞는지 확인 -> 회원가입 완료버튼 눌렀을때 검사
	 * 
	 */

	public Cubejoin() {
		// 라벨
		email = new JLabel("E@mail : ");
		pw = new JLabel("비밀번호 : ");
		id = new JLabel("ID : ");
		// join = new JLabel("회원가입");
		rpw = new JLabel("비밀번호 재확인 : ");
		gender = new JLabel("성별     :");
		birth = new JLabel("생년월일 : ");
		code = new JLabel("인증 코드 : ");

		// 라벨 색깔
		email.setForeground(Color.white);
		pw.setForeground(Color.white);
		id.setForeground(Color.white);
		rpw.setForeground(Color.white);
		gender.setForeground(Color.white);
		birth.setForeground(Color.white);
		code.setForeground(Color.white);

		// 버튼
		// 버튼에 이미지 넣기
		okB = new JButton("확인");
		cancelB = new JButton("취소");
		overlapB = new JButton("중복체크");
		emailcodeB = new JButton("인증코드 받기");
		checkcodeB = new JButton("인증 완료");

		gender1 = new ButtonGroup();
		male = new JRadioButton("남자");
		female = new JRadioButton("여자");
		male.setOpaque(false);
		female.setOpaque(false);
		male.setForeground(Color.white);
		female.setForeground(Color.white);

		// 텍스트상자
		emailT = new JTextField(10);
		emailcodeT = new JTextField(15);
		String mail[] = { "@naver.com", "@gmail.com", "@nate.com", "@daum.net" };
		combo = new JComboBox<String>(mail);

		pwT = new JPasswordField(16);
		idT = new JTextField(13);
		rpwT = new JPasswordField(15);
		birthT = new JTextField("YYMMDD으로 입력하세요", 15);

		// 글자 크기
		birth.setFont(birth.getFont().deriveFont(20.0f));
//
//		join.setBounds(128, 1, 150, 50);
//		join.setFont(join.getFont().deriveFont(30.0f));

		email.setFont(email.getFont().deriveFont(20.0f));
		pw.setFont(pw.getFont().deriveFont(18.0f));
		code.setFont(code.getFont().deriveFont(20.0f));
		id.setFont(pw.getFont().deriveFont(20.0f));
		rpw.setFont(pw.getFont().deriveFont(18.0f));

		gender.setFont(pw.getFont().deriveFont(20.0f));
		male.setFont(pw.getFont().deriveFont(20.0f));
		female.setFont(pw.getFont().deriveFont(20.0f));

		// 비밀번호 확인
//	String pw = pwT.getText().trim();
//	String rpw = rpwT.getText().trim();

		// 배경화면
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(backicon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		// 패널
		JPanel p1 = new JPanel();
		p1.add(id);
		p1.add(idT);
		p1.add(overlapB);
		p1.setBounds(20, 70, 300, 50);
		p1.setOpaque(false);

		JPanel p2 = new JPanel();
		p2.add(pw);
		p2.add(pwT);
		p2.setBounds(20, 110, 300, 50);
		p2.setOpaque(false);

		JPanel p3 = new JPanel();
		p3.add(email);
		p3.add(emailT);
		p3.add(combo);
		p3.add(emailcodeB);
		p3.setBounds(6, 200, 500, 50);
		p3.setOpaque(false);

		JPanel p4 = new JPanel();
		p4.add(okB);
		p4.setBounds(110, 450, 60, 50);
		p4.setOpaque(false);

		JPanel p5 = new JPanel();
		p5.add(cancelB);
		p5.setBounds(300, 450, 60, 50);
		p5.setOpaque(false);

		JPanel p7 = new JPanel();
		p7.add(rpw);
		p7.add(rpwT);
		p7.setBounds(20, 150, 350, 60);
		p7.setOpaque(false);

		JPanel p8 = new JPanel();
		p8.add(gender);
		gender1.add(male);
		gender1.add(female);
		p8.add(male);
		p8.add(female);
		p8.setBounds(25, 370, 250, 50);
		p8.setOpaque(false);

		JPanel p9 = new JPanel();
		p9.add(birth);
		p9.add(birthT);
		p9.setBounds(25, 315, 300, 50);
		p9.setOpaque(false);

		JPanel p10 = new JPanel();
		p10.add(code);
		p10.add(emailcodeT);
		p10.add(checkcodeB);
		p10.setBounds(25, 250, 400, 50);
		p10.setOpaque(false);

		// 컨테이너
		Container c = this.getContentPane();
		// c.add(join);
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		c.add(p5);
		c.add(p7);
		c.add(p8);
		c.add(p9);
		c.add(p10);

		c.add(panel);

//		setLayout(null);
		setBounds(700, 200, 500, 575);
		setVisible(true);
		setResizable(false);
		// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Join");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okB) { // 회원등록버튼
			String pw = pwT.getText();
			String rpw = rpwT.getText();
			String birth = birthT.getText();

			// 입력을 했는지 확인
			if (idT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "아이디을 입력하세요");
			if (pwT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
			if (rpwT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "재확인 비밀번호를 입력하세요");
			if (emailT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "이메일을 입력하세요");
			if (emailcodeT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "인증번호를 입력해주세요");
			if (birth.length() != 6)
				JOptionPane.showMessageDialog(this, "생년월일을 6자리 입력해주세요");
			if ((male.isSelected() == false) && (female.isSelected() == false))
				JOptionPane.showMessageDialog(this, "성별을 선택해주세요");

			// 중복검사 했는지 확인
			if (overlapB.isEnabled()) {

				JOptionPane.showMessageDialog(this, "아이디 중복검사를 해주세요");

			}
			// 이메일 인증 확인
			if (emailcodeB.isEnabled()) {

				JOptionPane.showMessageDialog(this, "이메일 인증을 해주세요");

			}
//			//이메일 인증 완료 확인
//			if(!checkcodeB.isEnabled()) {
//				JOptionPane.showMessageDialog(this, "이메일 인증을 해주세요");
//				
//			}
			else if (pwT.getText() != null) {
				if (pwT.getText().equals(rpwT.getText())) {
					// 비밀번호가 null이 아니고 재확인 비밀번호랑 일치 할경우 가입완료

					// joinArticle();
					JOptionPane.showConfirmDialog(null, "가입이 완료되었습니다", "알림", JOptionPane.PLAIN_MESSAGE);
					dispose();

				} else if (pwT.getText().equals(rpwT.getText())) {

					JOptionPane.showConfirmDialog(null, "비밀번호가 일치하지 않습니다", "에러", JOptionPane.PLAIN_MESSAGE);
					return;
				}

			}

		} else if (e.getSource() == cancelB) { // 취소버튼
			dispose();
		} else if (e.getSource() == overlapB) { // 중복체크 버튼
			// checkidArticle();

			// 중복검사 완료후 버튼 비활성화
			overlapB.setEnabled(false);
			
			
		} else if (e.getSource() == emailcodeB) { // 이메일 인증번호 받기 버튼

		} else if (e.getSource() == checkcodeB) { // 인증 완료 버튼

			// 인증 완료했을경우 버튼 비활성화
			checkcodeB.setEnabled(false);
		}

	}

	private void joinArticle() {
		String id = idT.getText();
		String pw = pwT.getText();
		String birth = birthT.getText();
		String email = emailT.getText();
		String emailad = (String) this.combo.getSelectedItem();

		int gender=0;
		if(male.isSelected())
			gender=0;
		else if(female.isSelected())
			gender=1;
		
		dto.setId(id);
		dto.setPw(pw);
		dto.setBirth(birth);
		dto.setEmail(email);
		dto.setEmailad(emailad);
		dto.setGender(gender);
		
		dao.joinArticle(dto);
		
		System.out.println("등록완료");
	}

	private void checkidArticle() {
		String id=idT.getText();
		dto.setId(id);
		
		int result=dao.checkidArticle(dto);
		
		if(result==0) {
			JOptionPane.showMessageDialog(this, "사용 가능한 아이디 입니다");
		}else if(result>0) {
			JOptionPane.showMessageDialog(this,"중복 아이디가 있습니다.\n다른 아이디를 입력해주세요");
		}
	}

	public void event() {
		okB.addActionListener(this);
		cancelB.addActionListener(this);
		overlapB.addActionListener(this);
		emailcodeB.addActionListener(this);
		checkcodeB.addActionListener(this);

	}

}
