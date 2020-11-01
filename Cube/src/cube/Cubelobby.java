package cube;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.PrintWriter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class Cubelobby extends JFrame implements ActionListener{
    JTextField input;
    JList user;
    JTextArea output;
	JButton createB, loadB, send;
    PrintWriter pw;
	
	public Cubelobby(){
		//�κ� ä�úκ�
		output = new JTextArea("",20,57);
		
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		output.setEditable(false);
		
		input = new JTextField(50);
		
		send = new JButton("������");
		
		JPanel p1 = new JPanel();
		p1.setBounds(30,500,700,50);
		p1.add(input);
		p1.add(send);
		
		JPanel p1a= new JPanel();
		p1a.add(output);
		p1a.setBounds(30,240,700,250);
		
		
		Image img = Toolkit.getDefaultToolkit().getImage("���ť��.PNG");
		// ���ť�� �̹��� �ֱ�
		DefaultListModel<String> m = new DefaultListModel<>();
		m.addElement("");
		user = new JList(m);
		//����Ʈ , ���� â

		JPanel p1b = new JPanel();
		p1b.add(user);
		p1b.setBounds(750,0,200,150);
		
		//�� ����� ����
		createB = new JButton("�� �����");
		loadB = new JButton("�� ����");

		
		JPanel p2 = new JPanel();
		p2.add(createB);
		p2.setBounds(810,400,90,50);
		
		JPanel p3 = new JPanel();
		p3.add(loadB);
		p3.setBounds(800,500,110,50);
		

		Container c = this.getContentPane();
		c.add(p1);
		c.add(p1a);
		c.add(p1b);
		c.add(p2);
		c.add(p3);
		
		
		
		
		setLayout(null);
		setBounds(400,150,1000,600);
		setVisible(true);
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(Cubelobby.this,
						"������ �����Ͻðڽ��ϱ�", 
						"����", 
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
