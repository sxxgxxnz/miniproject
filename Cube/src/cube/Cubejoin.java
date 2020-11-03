package cube;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import db.RummiDAO;

public class Cubejoin extends JFrame implements ActionListener {
	JLabel id, pw, email, join, rpw, gender, birth;
	JTextField idT, emailT, birthT;
	JButton okB, cancelB, overlapB;
	JPasswordField pwT, rpwT;
	JRadioButton male, female;
	JComboBox combo;
	ButtonGroup gender1;

	UserDTO dto = new UserDTO();
	RummiDAO dao = new RummiDAO();
	/*
	 * 비밀번호 '*'로 바꾸기 join할때 비밀번호 재확인 맞는지 확인 -> 회원가입 완료버튼 눌렀을때 검사
	 * 
	 */

	public Cubejoin() {
		// 라벨
		join = new JLabel("회원가입");
		id = new JLabel("id : ");
		pw = new JLabel("비밀번호 : ");
		rpw = new JLabel("비밀번호 재확인 : ");
		email = new JLabel("E@mail : ");
		birth = new JLabel("생년월일 : ");
		gender = new JLabel("성별     :");

		// 버튼
		okB = new JButton("확인");
		cancelB = new JButton("취소");
		overlapB = new JButton("중복체크");

		gender1 = new ButtonGroup();
		male = new JRadioButton("남자");
		female = new JRadioButton("여자");

		// 텍스트상자
		emailT = new JTextField(10);
		String mail[] = { "@naver.com", "@gmail.com" };
		combo = new JComboBox<String>(mail);

		pwT = new JPasswordField(16);
		idT = new JTextField(13);
		rpwT = new JPasswordField(15);
		birthT = new JTextField("YYMMDD으로 입력하세요", 15);

		// 글자 크기
		birth.setFont(birth.getFont().deriveFont(20.0f));

		join.setBounds(128, 1, 150, 50);
		join.setFont(join.getFont().deriveFont(30.0f));

		id.setFont(id.getFont().deriveFont(20.0f));
		pw.setFont(pw.getFont().deriveFont(18.0f));

		email.setFont(pw.getFont().deriveFont(20.0f));
		rpw.setFont(pw.getFont().deriveFont(18.0f));

		gender.setFont(pw.getFont().deriveFont(20.0f));
		male.setFont(pw.getFont().deriveFont(20.0f));
		female.setFont(pw.getFont().deriveFont(20.0f));

		// 비밀번호 확인
//	String pw = pwT.getText().trim();
//	String rpw = rpwT.getText().trim();

		// 패널
		JPanel p1 = new JPanel();
		p1.add(id);
		p1.add(idT);

		p1.setBounds(3, 50, 250, 50);

		JPanel p2 = new JPanel();
		p2.add(pw);
		p2.add(pwT);
		p2.setBounds(3, 100, 300, 50);

		JPanel p3 = new JPanel();
		p3.add(email);
		p3.add(emailT);
		p3.add(combo);
		p3.setBounds(10, 200, 350, 50);

		JPanel p4 = new JPanel();
		p4.add(okB);
		p4.setBounds(100, 450, 60, 50);

		JPanel p5 = new JPanel();
		p5.add(cancelB);
		p5.setBounds(220, 450, 60, 50);

		JPanel p6 = new JPanel();
		p6.add(overlapB);
		p6.setBounds(260, 50, 100, 50);

		JPanel p7 = new JPanel();
		p7.add(rpw);
		p7.add(rpwT);
		p7.setBounds(3, 150, 350, 60);

		JPanel p8 = new JPanel();
		p8.add(gender);
		gender1.add(male);
		gender1.add(female);
		p8.add(male);
		p8.add(female);
		p8.setBounds(30, 350, 250, 50);

		JPanel p9 = new JPanel();
		p9.add(birth);
		p9.add(birthT);
		p9.setBounds(3, 250, 300, 50);

		// 컨테이너
		Container c = this.getContentPane();
		c.add(join);
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		c.add(p5);
		c.add(p6);
		c.add(p7);
		c.add(p8);
		c.add(p9);

		setLayout(null);
		setBounds(700, 200, 400, 550);
		setVisible(true);
		setResizable(false);
		// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}

	private void joinArticle() {
		String id = idT.getText();
		String pw = pwT.getText();

		String birth = birthT.getText();
		String email = emailT.getText();
		String emailad = (String) this.combo.getSelectedItem();
		int gender = 0;
		if (male.isSelected())
			gender = 0;
		else if (female.isSelected())
			gender = 1;

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
		String id = idT.getText();
		dto.setId(id);

		int result = dao.checkidArticle(dto);

		if (result == 0) {
			System.out.println("사용 가능한 아이디"); // 알림창 만들어주세요
		} else if (result > 0) {
			System.out.println("중복 아이디가 있음"); // 알림창 만들어주세요
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okB) {

			if (idT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
			if (pwT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
			if (rpwT.getText().equals(""))
				JOptionPane.showMessageDialog(this, "재확인 비밀번호를 입력하세요");
			if (birthT.getText().length() != 6)
				JOptionPane.showMessageDialog(this, "생년월일을 6자리 입력해주세요");
			if (emailT.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "이메일을 입력하세요");

			}
			if ((male.isSelected() == false) && (female.isSelected() == false))
				JOptionPane.showMessageDialog(this, "성별을 선택해주세요");

			else if (pwT.getText() != null) {
				if(pwT.getText().equals(rpwT.getText())) {
				// 가입 완료
				joinArticle();
				JOptionPane.showConfirmDialog(null, "가입이 완료되었습니다", "알림", JOptionPane.PLAIN_MESSAGE);
				dispose();
				}else if(pwT.equals(rpwT)==false) {
					JOptionPane.showConfirmDialog(null, "비밀번호가 일치하지 않습니다", "에러", JOptionPane.PLAIN_MESSAGE);
					return;
				}
			} 

		} else if (e.getSource() == cancelB) {
			dispose();
		} else if (e.getSource() == overlapB) {
			checkidArticle();
		}
	}

	public void event() {
		okB.addActionListener(this);
		cancelB.addActionListener(this);
		overlapB.addActionListener(this);
	}

}
