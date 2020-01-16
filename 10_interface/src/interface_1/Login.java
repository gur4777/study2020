package interface_1;
/*
	1.취소 버튼을 누르면
	JTextField(idT,pwdT)의 내용이 초기화
	2.로그인 버튼을 누르면
	로그인 성공 창을 띄우기(로그인성공 or 로그인실패),성공창에서 x표시누르면 다시원래창으로 - LoginResult.java
	LoginResult.java에서 아이디 비번 비교(아이디 - angel, 비번-1004이면 성공 아니면 실패)
	
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
		idL = new JLabel("아이디");
		pwdL = new JLabel("비밀번호");
		loginB = new JButton("로그인");
		cancelB = new JButton("취소");
		
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
		
		//이벤트
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
