package io;

import java.io.File;

import javax.swing.JTextArea;

public interface Score {
	public void input(ScoreDTO dto);
	public void print(JTextArea output);
	public void search(JTextArea output,String hak);
	public void tot_desc(); //����
	public void save(File file);
	public void load(File file,JTextArea output);
}
