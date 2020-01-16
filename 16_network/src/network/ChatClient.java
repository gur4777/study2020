package network;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatClient extends JFrame{
	
	JTextArea output;
	JTextField input;
	JButton send;
	
	public ChatClient(){
		//실행시 세로 스크롤바가 항상 뜨게
		//에어리어에 입력이 안되게
		
		output = new JTextArea();
		output.setEditable(false);
		input = new JTextField();
		send = new JButton("전송");
		
		
		JPanel southP = new JPanel(new BorderLayout());
		southP.add("Center",input); southP.add("East",send);
		
		
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		// 스크롤바가 항상 떠있게  ^
		
		Container con = getContentPane();
		con.add("Center",scroll);
		con.add("South",southP);
		
		setTitle("채팅");
		setBounds(800,300,400,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void service() {
		String serverIP = JOptionPane.showInputDialog(this,"서버IP를 입력하세요.", "127.0.0.1");
		if(serverIP==null || serverIP.length()==0) {
			System.out.println("서버IP가 입력되지 않았습니다.");
			System.exit(0);
		}
		
		String nickName = JOptionPane.showInputDialog(this,"닉네임을 입력하세요.","",JOptionPane.INFORMATION_MESSAGE);
		if(nickName ==null || nickName.length() == 0) {
			nickName="guest";
		}
		
	}	
	
	
	public static void main(String[] args) {
		new ChatClient().service();
	}
}
