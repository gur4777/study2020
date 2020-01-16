package exam;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.ButtonGroup;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MsPaint extends JFrame {
	private JLabel x1L,y1L,x2L,y2L,z1L,z2L;
	private JTextField x1T,y1T,x2T,y2T,z1T,z2T;
	private JCheckBox fill;
	private JRadioButton line, circle, rect, roundRect, pen;
	private JComboBox combo;
	private JButton draw;
	private DrCanvas can;
	
	
	
	public MsPaint(String title) {
		x1L = new JLabel("x1");
		y1L = new JLabel("y1");
		x2L = new JLabel("x2");
		y2L = new JLabel("y2");
		z1L = new JLabel("z1");
		z2L = new JLabel("z2");
		
		x1T = new JTextField("0",5);
		y1T = new JTextField("0",5);
		x2T = new JTextField("0",5);
		y2T = new JTextField("0",5);
		z1T = new JTextField("50",5);
		z2T = new JTextField("50",5);
		
		fill = new JCheckBox("채우기");
				
		ButtonGroup jb = new ButtonGroup();
		
		line = new JRadioButton("선");
		circle = new JRadioButton("원");
		rect = new JRadioButton("사각형", true);
		roundRect = new JRadioButton("둥근사각형");
		pen = new JRadioButton("연필");
		
		ButtonGroup group = new ButtonGroup();
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);
		
		String rainbow[] = {"빨강색", "주황색", "노랑색", "초록색", "파랑색", "남색","보라색"};
		combo = new JComboBox<String>(rainbow);
		
		draw = new JButton("그리기");
		
		can = new DrCanvas(this);
		
		JPanel northP = new JPanel();
		northP.add(x1L); northP.add(x1T);
		northP.add(y1L); northP.add(y1T);
		northP.add(x2L); northP.add(x2T);
		northP.add(y2L); northP.add(y2T);
		northP.add(z1L); northP.add(z1T);
		northP.add(z2L); northP.add(z2T);
		northP.add(fill);
		
		JPanel southP = new JPanel();
		southP.add(line);
		southP.add(circle);
		southP.add(rect);
		southP.add(pen);
		southP.add(combo);
		southP.add(draw);
		
		Container c = this.getContentPane();
		c.add("North", northP);
		c.add("South", southP);
		c.add("Center",can);
		
		setBounds(900,100,700,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//이벤트
		draw.addActionListener(new ActionListener() {//클래스
			
			@Override
			public void actionPerformed(ActionEvent e) {
				can.repaint();
				
			}
		});
		can.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x1T.setText(e.getX()+"");
				y1T.setText(e.getY()+"");		
				
			}
		});
		can.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
//				if(pen.isSelected()) {
//					x2T.setText(e.getX()+"");
//					y2T.setText(e.getY()+"");
//					can.repaint();
//
//					x1T.setText(x2T.getText());
//					y1T.setText(y2T.getText());
//				
//				}else {
					x2T.setText(e.getX()+"");
					y2T.setText(e.getY()+"");
					can.repaint();
//				}
				  
					
			}
		});
		can.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public static void main(String[] args) {
		new MsPaint("간단 그림판");
	}
	public JTextField getX1T() {
		return x1T;
	}
	public JTextField getY1T() {
		return y1T;
	}
	public JTextField getX2T() {
		return x2T;
	}
	public JTextField getY2T() {
		return y2T;
	}
	public JTextField getZ1T() {
		return z1T;
	}
	public JTextField getZ2T() {
		return z2T;
	}
	public JComboBox getCombo() {
		return combo;
	}
	public JCheckBox getFill() {
		return fill;
	}
	public JRadioButton getLine() {
		return line;
	}
	public JRadioButton getCircle() {
		return circle;
	}
	public JRadioButton getRect() {
		return rect;
	}
	public JRadioButton getRoundRect() {
		return roundRect;
	}
	public JRadioButton getPen() {
		return pen;
	}

}
