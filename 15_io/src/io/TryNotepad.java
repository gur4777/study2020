package io;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class TryNotepad extends JFrame implements ActionListener{
	JTextArea jta;
	JScrollPane jsp;
	private MenuPane menu;
	private File file;
	public TryNotepad() {
		menu = new MenuPane();
		jta = new JTextArea("");
		jsp = new JScrollPane(jta);
		

		setTitle("간단 메모장");
		setBounds(700,300,600,500);
		
		jta.setFont(new Font("고딕체",Font.BOLD,15));
		
		Container c = this.getContentPane();
		c.add(jsp);
		setJMenuBar(menu);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(TryNotepad.this, "저장하시겠습니까?", "메모장", JOptionPane.YES_NO_CANCEL_OPTION);
				System.out.println(result);
				if(result == JOptionPane.YES_OPTION) {		//(result == 0)
					//파일 저장
					if(jta.getText().length()!=0) {
						saveDialog();
					}
					System.exit(0);
				}else if(result == JOptionPane.NO_OPTION) {	//(result == 1)
					System.exit(0);
				}	
				
			}
		});
		event();
		
		
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	public void event() {
		menu.getNewM().addActionListener(this);
		menu.getExitM().addActionListener(this);
		menu.getSaveM().addActionListener(this);
		menu.getCopyM().setAccelerator(KeyStroke.getKeyStroke('C',Event.ALT_MASK));
		
		menu.getCopyM().addActionListener(this);
		menu.getCutM().setAccelerator(KeyStroke.getKeyStroke('X',Event.ALT_MASK));
		menu.getCutM().addActionListener(this);
		menu.getOpenM().addActionListener(this);
		menu.getPasteM().setAccelerator(KeyStroke.getKeyStroke('V',Event.ALT_MASK));
		menu.getPasteM().addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand() == "새로만들기") {
			jta.setText("");
		}else if(e.getActionCommand() == "종료") {
			int result = JOptionPane.showConfirmDialog(this, "저장하시겠습니까?", "메모장", JOptionPane.YES_NO_CANCEL_OPTION);
			System.out.println(result);
			if(result == JOptionPane.YES_OPTION) {		//(result == 0)
				//파일 저장
				if(jta.getText().length()!=0) {
					saveDialog();
				}
				System.exit(0);
			}else if(result == JOptionPane.NO_OPTION) {	//(result == 1)
				System.exit(0);
			}	
		}else if(e.getSource() == menu.getOpenM()) {
			openDialog();//열기 다이얼로그
			fileRead();//파일 읽기
		}else if(e.getSource() == menu.getSaveM()) {
			saveDialog();
		}else if(e.getSource() == menu.getCutM()) {
			jta.cut();  // awt에는 없음
		}else if(e.getSource() == menu.getCopyM()) {
			jta.copy(); // swing에만 존재
		}else if(e.getSource() == menu.getPasteM()) {
			jta.paste();
		}
		
	}
	
	public void openDialog(){
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
		JOptionPane.showMessageDialog(this, file);
	}
	
	public void saveDialog(){
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);
		
		if(result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			try {
				BufferedWriter  br = new BufferedWriter(new FileWriter(file));
				br.write(jta.getText());
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		JOptionPane.showMessageDialog(this, file);
	}
	public void fileRead() {
		if(file == null) return;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine())!=null) {
				//jta.setText(line);
				jta.setText("");
				jta.append(line+"\n");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TryNotepad().event();
	}
}
