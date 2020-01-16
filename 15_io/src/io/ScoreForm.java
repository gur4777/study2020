package io;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ScoreForm extends JFrame implements ActionListener{
	
	private JLabel hakL, nameL, korL, engL, mathL;
	private JTextField hakT, nameT, korT, engT, mathT; 
	//private JTable view;
	private JTextArea output;
	private JButton inputB, outputB, searchB, rankB, saveB, loadB;
	private JScrollPane jsp;
	
	private JPanel incomP,btnP,viewP;
	
	private ScoreImpl si;
	private File file;
	
	public ScoreForm() {
		si = new ScoreImpl();
		
		setBounds(700,300,650,240);
		
		setLayout(null);
		
		hakL=new JLabel("�й�");	nameL=new JLabel("�̸�");
		korL=new JLabel("����");	engL=new JLabel("����");	mathL=new JLabel("����");
		
		hakT=new JTextField(20);	nameT=new JTextField(20);
		korT=new JTextField(20);	engT=new JTextField(20);	mathT=new JTextField(20);
		
		inputB = new JButton("�Է�");	outputB  = new JButton("���");	searchB = new JButton("�˻�");
		rankB  = new JButton("����");	saveB = new JButton("���� ����");	loadB = new JButton("���� �б�");
		
		incomP = new JPanel();	btnP = new JPanel(new GridLayout(1,6));	viewP = new JPanel();
		incomP.setBounds(10,10,280,150);
		btnP.setBounds(0,160,635,40);
		
		///���߿� �ٲܰ�--------------------------------
		output = new JTextArea("  ����   �̸�   ����   ����   ����   ����   ���\n");
		jsp = new JScrollPane(output);
		
		viewP.setLayout(new BorderLayout());
		viewP.add(jsp);
		viewP.setBounds(300,10,300,130);
		//
		
		incomP.add(hakL);	incomP.add(hakT);	incomP.add(nameL);	incomP.add(nameT);
		incomP.add(korL);	incomP.add(korT);	incomP.add(engL);	incomP.add(engT);
		incomP.add(mathL);	incomP.add(mathT);
		
		btnP.add(inputB);	btnP.add(outputB);	btnP.add(searchB);	
		btnP.add(rankB);	btnP.add(saveB);	btnP.add(loadB);
		
		Container con = getContentPane();
		con.add(incomP);
		con.add(viewP);
		con.add(btnP);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		event();
		
	}

	

	
	public void event(){
		inputB.addActionListener(this); 
		outputB.addActionListener(this);
		searchB.addActionListener(this);
		rankB.addActionListener(this);
		saveB.addActionListener(this);
		loadB.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == inputB) {
			ScoreDTO dto = new ScoreDTO();
			dto.setHak(hakT.getText());
			dto.setName(nameT.getText());
			dto.setKor(Integer.parseInt(korT.getText().trim()));
			dto.setEng(Integer.parseInt(engT.getText().trim()));
			dto.setMath(Integer.parseInt(mathT.getText().trim()));
			dto.setTot(dto.getKor()+dto.getEng()+dto.getMath());
			dto.setAvg((dto.getKor()+dto.getEng()+dto.getMath())/3.);
			si.input(dto);
			hakT.setText(""); nameT.setText(""); korT.setText(""); engT.setText(""); mathT.setText("");
			JOptionPane.showMessageDialog(this, "�Է� �Ϸ�");
			hakT.requestFocus(true);
			
		}else if(e.getSource() == outputB) {
			si.print(output);
		}else if(e.getSource() == searchB) {
			String hak = JOptionPane.showInputDialog(this,"�й� �Է�: ");
			si.search(output,hak);
			
		}else if(e.getSource() == rankB) {
			si.tot_desc();
			si.print(output);
			
		}else if(e.getSource() == saveB) {
			JFileChooser chooser = new JFileChooser();
			int result = chooser.showSaveDialog(this);

			if(result == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();
			}
			if(file==null) return;
			si.save(file);
		}else if(e.getSource() == loadB) {
			JFileChooser chooser = new JFileChooser();
			int result = chooser.showSaveDialog(this);

			if(result == JFileChooser.APPROVE_OPTION) {
				file = chooser.getSelectedFile();
			}
			if(file==null) return;
			si.load(file,output);
		}
	}

	public static void main(String[] args) {
		new ScoreForm();
	}

}