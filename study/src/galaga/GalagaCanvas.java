package galaga;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class GalagaCanvas extends Canvas{
	
	GalagaView gv;
	public GalagaCanvas(GalagaView gv) {
		this.gv = gv;
	}
	
	@Override
	public void paint(Graphics g) {
		Image image = getToolkit().getDefaultToolkit().getImage("image/Falcon.png");
		
		g.drawImage(image, gv.getX1(),gv.getY1(),gv.getX2(),gv.getY2(),0,0,100,150,this);
	}
	
	
}
