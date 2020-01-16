package io;

import java.awt.Container;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPane extends JMenuBar{
	private JMenu fileM, editM, viewM, altC,altX,altV;
	private JMenuItem newM, openM, saveM, exitM, cutM, copyM, pasteM;
	public MenuPane() {
		//	파일		편집		보기
		//  JMenuItem
		fileM = new JMenu("파일");	editM = new JMenu("편집");	viewM = new JMenu("보기");
		newM = new JMenuItem("새로만들기");	openM = new JMenuItem("열기");
		saveM = new JMenuItem("저장");		exitM = new JMenuItem("종료");
		
		cutM = new JMenuItem("잘라내기");		copyM = new JMenuItem("복사");	pasteM = new JMenuItem("붙여넣기");
		cutM.setMnemonic('x');				copyM.setMnemonic('c');			pasteM.setMnemonic('v');
		
		
		fileM.add(newM);	fileM.add(openM);	fileM.add(saveM);	fileM.add(exitM);
		editM.add(cutM);	editM.add(copyM);	editM.add(pasteM);
		
		
	
		add(fileM);
		add(editM);
		add(viewM);
	}
	
	public JMenuItem getNewM() {
		return newM;
	}
	public JMenuItem getExitM() {
		return exitM;
	}
	public JMenuItem getOpenM() {
		return openM;
	}
	public JMenuItem getSaveM() {
		return saveM;
	}
	public JMenuItem getCutM() {
		return cutM;
	}
	public JMenuItem getCopyM() {
		return copyM;
	}
	public JMenuItem getPasteM() {
		return pasteM;
	}
	public JMenu getAltC() {
		return altC;
	}
	public JMenu getAltX() {
		return altX;
	}
	public JMenu getAltV() {
		return altV;
	}
	
}
