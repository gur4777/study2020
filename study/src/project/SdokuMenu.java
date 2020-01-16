package project;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.crypto.spec.DESedeKeySpec;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JWindow;

public class SdokuMenu extends JFrame implements ActionListener, MouseListener{
	ImageIcon iconB = new ImageIcon("blueRect.jpg");
	ImageIcon iconG = new ImageIcon("grayRect.jpg");
	ImageIcon icon1 = new ImageIcon("defaultNumber1.png");
	ImageIcon icon2 = new ImageIcon("defaultNumber2.png");
	ImageIcon icon3 = new ImageIcon("defaultNumber3.png");
	ImageIcon icon4 = new ImageIcon("defaultNumber4.png");
	ImageIcon icon5 = new ImageIcon("defaultNumber5.png");
	ImageIcon icon6 = new ImageIcon("defaultNumber6.png");
	ImageIcon icon7 = new ImageIcon("defaultNumber7.png");
	ImageIcon icon8 = new ImageIcon("defaultNumber8.png");
	ImageIcon icon9 = new ImageIcon("defaultNumber9.png");
	ImageIcon iconS1 = new ImageIcon("SelNumber1.png");
	ImageIcon iconS2 = new ImageIcon("SelNumber2.png");
	ImageIcon iconS3 = new ImageIcon("SelNumber3.png");
	ImageIcon iconS4 = new ImageIcon("SelNumber4.png");
	ImageIcon iconS5 = new ImageIcon("SelNumber5.png");
	ImageIcon iconS6 = new ImageIcon("SelNumber6.png");
	ImageIcon iconS7 = new ImageIcon("SelNumber7.png");
	ImageIcon iconS8 = new ImageIcon("SelNumber8.png");
	ImageIcon iconS9 = new ImageIcon("SelNumber9.png");
	
	private JRadioButton deselect;
	
	JRadioButton[][] jrB;
	ButtonGroup bg;
	JPanel jrP;
	
	SdokuAlgorithm sdokuA;
	int[][] question;
	int[][] dap;
	int cnt;
	
	boolean tf = true;
	JWindow w;
	JWindow check;
	
	private SdokuMenu() {
		w = new JWindow();
		check = new JWindow();
		sdokuA= new SdokuAlgorithm();
		question = sdokuA.getQuestion();
		dap = sdokuA.getDap();
		Container c = getContentPane();
		setBounds(600,300,600,600);
		setPanel();
		setButton();
		
		
		c.add(jrP);
		setVisible(true);
	
		for(int i=0; i<jrB.length;i++) {
			for(int j=0; j<jrB[0].length; j++) {
				if(jrB[i][j].getIcon().equals(iconB) || jrB[i][j].getIcon().equals(iconG) ||
				   jrB[i][j].getIcon().equals(iconS1)|| jrB[i][j].getIcon().equals(iconS2)||
				   jrB[i][j].getIcon().equals(iconS3)|| jrB[i][j].getIcon().equals(iconS4)||
				   jrB[i][j].getIcon().equals(iconS5)|| jrB[i][j].getIcon().equals(iconS6)||
				   jrB[i][j].getIcon().equals(iconS7)|| jrB[i][j].getIcon().equals(iconS8)||
				   jrB[i][j].getIcon().equals(iconS9)) {
					jrB[i][j].addActionListener(this);
					jrB[i][j].addMouseListener(this);
					
				}
			}
		}
		
		
	}
	
	public void setButton() {
		jrB = new JRadioButton[9][9];
		bg = new ButtonGroup();
		deselect = new JRadioButton();
		bg.add(deselect);
		for(int i=0; i<jrB.length;i++) {
			
			for(int j=0; j<jrB[0].length; j++) {
				if(question[i][j]==0) {
					jrB[i][j] = new JRadioButton(iconG);
					jrB[i][j].setSelectedIcon(iconB);
					bg.add(jrB[i][j]);
					jrP.add(jrB[i][j]);
					
				}else if(question[i][j]==1) {
					jrB[i][j] = new JRadioButton(icon1);
					bg.add(jrB[i][j]);
					jrP.add(jrB[i][j]);
				}else if(question[i][j]==2) {
					jrB[i][j] = new JRadioButton(icon2);
					bg.add(jrB[i][j]);
					jrP.add(jrB[i][j]);
				}else if(question[i][j]==3) {
					jrB[i][j] = new JRadioButton(icon3);
					bg.add(jrB[i][j]);
					jrP.add(jrB[i][j]);
				}else if(question[i][j]==4) {
					jrB[i][j] = new JRadioButton(icon4);
					bg.add(jrB[i][j]);
					jrP.add(jrB[i][j]);
				}else if(question[i][j]==5) {
					jrB[i][j] = new JRadioButton(icon5);
					bg.add(jrB[i][j]);
					jrP.add(jrB[i][j]);
				}else if(question[i][j]==6) {
					jrB[i][j] = new JRadioButton(icon6);
					bg.add(jrB[i][j]);
					jrP.add(jrB[i][j]);
				}else if(question[i][j]==7) {
					jrB[i][j] = new JRadioButton(icon7);
					bg.add(jrB[i][j]);
					jrP.add(jrB[i][j]);
				}else if(question[i][j]==8) {
					jrB[i][j] = new JRadioButton(icon8);
					bg.add(jrB[i][j]);
					jrP.add(jrB[i][j]);
				}else if(question[i][j]==9) {
					jrB[i][j] = new JRadioButton(icon9);
					bg.add(jrB[i][j]);
					jrP.add(jrB[i][j]);
				}
			}	
		}
	}
	
	public void setPanel(){
		jrP = new JPanel(new GridLayout(9,9));
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JPanel p = new JPanel(new GridLayout(3,3));
		JButton[] b = new JButton[9];
		JButton checkB = new JButton("check");
		b[0]= new JButton(iconS1);	b[1]= new JButton(iconS2);	b[2]= new JButton(iconS3);
		b[3]= new JButton(iconS4);	b[4]= new JButton(iconS5);	b[5]= new JButton(iconS6);
		b[6]= new JButton(iconS7);	b[7]= new JButton(iconS8);	b[8]= new JButton(iconS9);
		
		for(int i=0; i<b.length; i++) { p.add(b[i]); }
		w.add(p);
		w.setSize(200,200);
		w.setLocation(getX()-w.getWidth(), getY());
		w.setVisible(tf);
		check.add(checkB);
		check.setSize(200,40);
		check.setLocation(getX()-w.getWidth(), getY()+200);
		check.setVisible(true);
		for(int i=0; i<b.length;i++) {
			
			b[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					for(int i=0; i<jrB.length;i++) {
						for(int j=0; j<jrB[0].length; j++) {
							if(jrB[i][j].isSelected()) {
								System.out.println("들어옴");
								if(e.getSource()==b[0])	{		 jrB[i][j].setIcon(iconS1); jrB[i][j].setSelectedIcon(iconS1); question[i][j]=1;}
								else if(e.getSource()==b[1])	{jrB[i][j].setIcon(iconS2); jrB[i][j].setSelectedIcon(iconS2); question[i][j]=2;}
								else if(e.getSource()==b[2])	{jrB[i][j].setIcon(iconS3); jrB[i][j].setSelectedIcon(iconS3); question[i][j]=3;}
								else if(e.getSource()==b[3])	{jrB[i][j].setIcon(iconS4); jrB[i][j].setSelectedIcon(iconS4); question[i][j]=4;}
								else if(e.getSource()==b[4])	{jrB[i][j].setIcon(iconS5); jrB[i][j].setSelectedIcon(iconS5); question[i][j]=5;}
								else if(e.getSource()==b[5])	{jrB[i][j].setIcon(iconS6); jrB[i][j].setSelectedIcon(iconS6); question[i][j]=6;}
								else if(e.getSource()==b[6])	{jrB[i][j].setIcon(iconS7); jrB[i][j].setSelectedIcon(iconS7); question[i][j]=7;}
								else if(e.getSource()==b[7])	{jrB[i][j].setIcon(iconS8); jrB[i][j].setSelectedIcon(iconS8); question[i][j]=8;}
								else if(e.getSource()==b[8])	{jrB[i][j].setIcon(iconS9); jrB[i][j].setSelectedIcon(iconS9); question[i][j]=9;}
								w.setVisible(false);
								return;
							}
						}
					}
				}
			});
		}
		
		checkB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<jrB.length;i++) {
					
					for(int j=0; j<jrB[0].length; j++) {
						if(question[i][j]!=0) {
							cnt++;
						}
					}
				}
				System.out.println(cnt);
				if(cnt == 81) {
					boolean result = sdokuA.checkDap(question);
					if(result) {
						JOptionPane.showMessageDialog(SdokuMenu.this, "정답입니다.");
					}else {
						JOptionPane.showMessageDialog(SdokuMenu.this, "오답입니다.");
					}
				}
				cnt=0;
				
			}
		});
		
	}

	public static void main(String[] args) {
		new SdokuMenu();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) {
			for(int i=0; i<jrB.length;i++) {
				for(int j=0; j<jrB[0].length; j++) {
					if(jrB[i][j].isSelected()) {
						jrB[i][j].setIcon(iconG); 
						jrB[i][j].setSelectedIcon(iconB);
						System.out.println("마우스클릭");
						deselect.setSelected(true);
						w.setVisible(false);
						question[i][j]=0;
						return;
					}
				}
			}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
