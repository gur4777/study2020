package galaga;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;


public class GalagaCanvas extends Canvas implements Runnable{
	
	int x1=0;
	int y1=0;
	int x2=5600;
	int y2=1400;
	int cnt;
	int cnt1;
	Image imageB;
	Image imageF;
	GalagaView gv;
	Thread t;
	
	public GalagaCanvas(GalagaView gv) {
		this.gv = gv;
		
	}
	
	@Override
	public void update(Graphics g) {
		
		imageF = getToolkit().getDefaultToolkit().getImage("image/F-14.gif");
		imageB = getToolkit().getDefaultToolkit().getImage("image/space1.jpg");
		t = new Thread(this);
		if(cnt1==0) {
			t.start();
			cnt1=1;
		}
		
		
		g.drawImage(imageB, 0, 0, 5600, 1400,x1,y1,x2,y2,this);
		//g.drawImage(imageF, 0,0,80,50,0,0,150,75,this);
		g.drawImage(imageF, gv.getX1(),gv.getY1(),gv.getX2(),gv.getY2(),0,0,150,75,this);
		//
		paint(g);
	}
	public void paint(Graphics g) {
		//g.drawImage(imageB, x1, y1, this);
		if(cnt==0) {
			repaint();
			cnt++;
			System.out.println(cnt);
		}
	}
	
	@Override
	public void run() {
		synchronized(GalagaCanvas.class) {
			while(true) {
				x1+=10;
				x2+=10;
				if(x1 > 4000) {
					x1=0; x2=5400;
				}
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				repaint();
			}
		}
		
		
		
	}
	
}
