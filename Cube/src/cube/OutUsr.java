package cube;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.*;



public class OutUsr extends JFrame implements ActionListener {

	// Ż���� ���̵�� ��й�ȣ �Է�
	private JLabel id, pw;
	private JTextField idT;
	private JPasswordField pwT;
	private JButton outB, cancelB;

	private RumiDAO dao = new RumiDAO();
	private UserDTO dto = new UserDTO();

	private ImageIcon backicon = new ImageIcon("img\\loginbackground.png");
	private Font font = new Font("�޸յձ�������", Font.PLAIN, 15);

	public OutUsr() {
		// ������ â ������
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image iconimg = toolkit.getImage("img\\logo.png");

		id = new JLabel("ID  : ");
		id.setForeground(Color.white);
		id.setFont(font);
	
		id.setBounds(250, 1, 100, 50);

		pw = new JLabel("PW : ");
		pw.setForeground(Color.white);
	
		pw.setFont(font);
		pw.setBounds(350, 100, 100, 300);

		idT = new JTextField(20);
		pwT = new JPasswordField(20);

		outB = new JButton(new ImageIcon("img\\Ȯ��.png"));
		outB.setBorderPainted(false); // ��ư �׵θ� ����
		outB.setContentAreaFilled(false); // ��ư ���� ��� ǥ�� ����
		outB.setFocusPainted(false); // ��Ŀ�� ǥ�� ����

		cancelB = new JButton(new ImageIcon("img\\���.png"));
		cancelB.setBorderPainted(false); // ��ư �׵θ� ����
		cancelB.setContentAreaFilled(false); // ��ư ���� ��� ǥ�� ����
		cancelB.setFocusPainted(false); // ��Ŀ�� ǥ�� ����

		// ���ȭ��
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(backicon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		JPanel p1 = new JPanel();
		p1.add(id);
		p1.add(idT);
		p1.setBounds(10, 100, 350, 50);
		p1.setOpaque(false);

		JPanel p2 = new JPanel();
		p2.add(pw);
		p2.add(pwT);
		p2.setBounds(10, 150, 350, 50);
		p2.setOpaque(false);

		JPanel p3 = new JPanel();
		p3.add(outB);
		p3.add(cancelB);
		p3.setBounds(50, 200, 280, 150);
		p3.setOpaque(false);

		Container c = this.getContentPane();
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(panel);

		setBounds(600, 300, 390, 320);
		setVisible(true);
		setResizable(false);
		setIconImage(iconimg);
		setTitle("Delete Account");
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(OutUsr.this, "������ �����Ͻðڽ��ϱ�", "����", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);

				if (result == JOptionPane.YES_OPTION)
					dispose();
				if (result == JOptionPane.NO_OPTION)
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

			}
		});

		outB.addActionListener(this);
		cancelB.addActionListener(this);
	}

	public int inputcheck() {
		int cnt = 0;
		// �Է��� �ߴ��� Ȯ��
		if (idT.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "ID�� �Է��ϼ���");
			cnt++;
		}
		if (pwT.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "PW�� �Է��ϼ���");
			cnt++;
		}
		return cnt;
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == outB) {

			String id = idT.getText();
			String pw = pwT.getText();

			//id�� pw�� �Է��ߴ���
			int check = inputcheck();
			if (check > 0) {//�Է¾ȵǾ�����
				return;
			} else if (check == 0) {
				dto.setId(id);
				dto.setPw(pw);

				// ���̵�� ��й�ȣ�� �´��� Ȯ��
				int corr = dao.loginArticle(dto);
				if (corr == 1) {
					// �´� id��pw�� ���� ���� �Ϸ�
					dao.deleteacntArticle(dto);
					JOptionPane.showConfirmDialog(null, id+"���� ������ �����Ǿ����ϴ�.");
					dispose();
				} else if (corr == 0) {
					// id�� pw�� �ٸ�
					 JOptionPane.showMessageDialog(this, "ID�� PW�� ���� �ʽ��ϴ�.\n�ٽ� �Է����ּ���","����",JOptionPane.INFORMATION_MESSAGE);
					 
					return;

				}
			}

		}else if(e.getSource()==cancelB) {
			dispose();
		}
	}
}
