package interface_1;
/*
	1.��� ��ư�� ������
	JTextField(idT,pwdT)�� ������ �ʱ�ȭ
	2.�α��� ��ư�� ������
	�α��� ���� â�� ����(�α��μ��� or �α��ν���),����â���� xǥ�ô����� �ٽÿ���â���� - LoginResult.java
	LoginResult.java���� ���̵� ��� ��(���̵� - angel, ���-1004�̸� ���� �ƴϸ� ����)
	
 */

import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login extends JFrame implements WindowListener{
	private JLabel idL, pwdL;
	private JTextField idT,pwdT;
	private JButton loginB, cancelB;
	
	public Login() {
		this.setLayout(null);
		idL = new JLabel("���̵�");
		pwdL = new JLabel("��й�ȣ");
		loginB = new JButton("�α���");
		cancelB = new JButton("���");
		
		idT=new JTextField();
		pwdT=new JTextField();
		
//		idL.setLocation(50, 80);
//		idL.setSize(50,30);
		idL.setBounds(50,80,50,30);
		pwdL.setBounds(50,120,60,30);
		
		idT.setBounds(120,80,100,30);
		getPwdT().setBounds(120,120,100,30);
		
		loginB.setBounds(40,190,100,30);
		cancelB.setBounds(150,190,100,30);
		
		
		
		Container c = this.getContentPane();
		c.add(idL);
		c.add(getIdT());
		
		c.add(pwdL);
		c.add(getPwdT());
		
		c.add(loginB);
		c.add(cancelB);
		
		
		setBounds(800,300,300,300);
		setVisible(true);
		
		//�̺�Ʈ
		this.addWindowListener(this);
		
	}

	public static void main(String[] args) {
		new Login();
		

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	public JTextField getIdT() {
		return idT;
	}

	public void setIdT(JTextField idT) {
		this.idT = idT;
	}

	public JTextField getPwdT() {
		return pwdT;
	}

	public void setPwdT(JTextField pwdT) {
		this.pwdT = pwdT;
	}

}