package swing;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;

public class JListEx extends JFrame{
	public JListEx() {
		super("JList Test");
		setLayout(new FlowLayout());
		String[] listData = {"Hong", "Gill", "Dong", "Java", "JSP"};
		JList list1 = new JList(listData);
		list1.setSelectedIndex(1);
	}
		
}

