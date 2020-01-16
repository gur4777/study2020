package galaga;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GalagaView extends JFrame implements KeyListener{
	
		GalagaCanvas can;
		GalagaAttack gAtk;
		private int x1 = 0;
		private int y1 = 0;
		private int x2 = 80;
		private int y2 = 50;
		private boolean keyUp, keyDown, keyLeft, keyRight;
		//0,0,80,50,0,0,150,75
		
		public GalagaView() {
			
			can= new GalagaCanvas(this);
			gAtk = new GalagaAttack();
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(600,200,1000,600);
			
//			can.setBackground(Color.black);
			add(can);

			Thread move = new Thread(can);
			move.start();
			
			setVisible(true);
			addKeyListener(this);
			
			
		}
		
	


		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void keyPressed(KeyEvent e) {

			if(e.getKeyCode()== KeyEvent.VK_LEFT) {
				keyLeft = true;
				if(x1!=-20) { x1-=10; x2-=10;}
			}else if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
				keyRight = true;
				if(x2!=1000) {x1+=10; x2+=10;}
			}else if(e.getKeyCode()== KeyEvent.VK_UP) {
				keyUp = true;
				if(y1!=0) {y1-=10; y2-=10;}
			}else if(e.getKeyCode()== KeyEvent.VK_DOWN) {
				keyDown = true;
				System.out.println(y2);
				if(y2!=570) {y1+=10; y2+=10;}
			}
			
//			if(e.getKeyCode()== KeyEvent.VK_SPACE) {
//				Thread atk = new Thread(gAtk);
//				
//				atk.start();
//			}
			
			keyProcess();
			can.repaint();
			
		}

		

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode()== KeyEvent.VK_LEFT) {
				keyLeft = false;
			}else if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
				keyRight = false;
			}else if(e.getKeyCode()== KeyEvent.VK_UP) {
				keyUp = false;
			}else if(e.getKeyCode()== KeyEvent.VK_DOWN) {
				keyDown = false;
			}if(e.getKeyCode()== KeyEvent.VK_SPACE) {
				
			}
		}
		
		public void keyProcess() {
			if(keyUp && keyLeft) {
				if(x1>0 && y1>0) {
					x1-=10; x2-=10;
					y1-=10; y2-=10;
				}
			}else if(keyUp && keyRight) {
				if(x2<1000 && y1>0) {
					System.out.println(x1);
					System.out.println(y1);
					x1+=10; x2+=10;
					y1-=10; y2-=10;
				}
			}else if(keyDown && keyLeft) {
				if(x1>0 && y2<570) {
					x1-=10; x2-=10;
					y1+=10; y2+=10;
				}
			}else if(keyDown && keyRight) {
				if(x2<1000 && y2<570) {
					x1+=10; x2+=10;
					y1+=10; y2+=10;
				}
			}
		}

		public int getX2() {
			return x2;
		}



		public void setX2(int x2) {
			this.x2 = x2;
		}



		public int getX1() {
			return x1;
		}



		public void setX1(int x1) {
			this.x1 = x1;
		}



		public int getY1() {
			return y1;
		}



		public void setY1(int y1) {
			this.y1 = y1;
		}



		public int getY2() {
			return y2;
		}



		public void setY2(int y2) {
			this.y2 = y2;
		}
		
		
	
		
		public static void main(String[] args) {
			new GalagaView();
		}


		
}
