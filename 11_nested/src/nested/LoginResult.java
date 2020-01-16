package nested;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginResult extends JFrame implements WindowListener{
	String success = "angel";
	String failed = "1004";
	//private String id, pwd;
	
		
	public LoginResult (LoginMain d) {
		
	
	}
    public LoginResult (String user, String passwd) {   
    	//this.id = id;
    	//this.pwd = pwd;
    	
    	JLabel p1 = new JLabel("로그인 성공");
    	JLabel p2 = new JLabel("로그인 실패");
    	p1.setHorizontalAlignment(JLabel.CENTER);
    	p2.setHorizontalAlignment(JLabel.CENTER);
    	
    	
    	setBounds(900,400,150,150);
        setVisible(true);
        
        //이벤트
        this.addWindowListener(this);
        
        if(user.equals(success) && passwd.equals(failed)) {
        	add(p1);
        }else {
        	add(p2);
        }
          
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
		setVisible(false);
		//System.exit(0);
		
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
}
