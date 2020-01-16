package study_teacher;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class DrCanvas extends Canvas {
	private MsPaint msPaint;
	private Image bufferImg;
	private Graphics bufferG;
	
	public DrCanvas(MsPaint msPaint) {
		this.msPaint = msPaint;
		this.setBackground(new Color(255,225,255));
	}
	
	@Override
	public void update(Graphics g) {
		Dimension d = this.getSize(); //사각 영역에대한 크기값 
		
		if(bufferG == null) {
			bufferImg = this.createImage(d.width,d.height);
			bufferG = bufferImg.getGraphics();
		}
		
		// 같은 색으로 캔버스를 덮어버린다.
		bufferG.setColor(this.getBackground());
		bufferG.fillRect(0, 0, d.width, d.height);
		
		
		legacy(g);
		//좌표
		int x1 = Math.min(Integer.parseInt(msPaint.getX1T().getText().trim()), Integer.parseInt(msPaint.getX2T().getText().trim()));
		int y1 = Math.min(Integer.parseInt(msPaint.getY1T().getText().trim()), Integer.parseInt(msPaint.getY2T().getText().trim()));
		int x2 = Math.max(Integer.parseInt(msPaint.getX1T().getText().trim()), Integer.parseInt(msPaint.getX2T().getText().trim()));
		int y2 = Math.max(Integer.parseInt(msPaint.getY1T().getText().trim()), Integer.parseInt(msPaint.getY2T().getText().trim()));
		int z1 = Integer.parseInt(msPaint.getZ1T().getText().trim());
		int z2 = Integer.parseInt(msPaint.getZ2T().getText().trim());
		
		switch(msPaint.getCombo().getSelectedIndex()) {
		case 0:	bufferG.setColor(new Color(255,0,0));	break;
		case 1:	bufferG.setColor(new Color(200,91,2)); break;
		case 2:	bufferG.setColor(new Color(255,255,0)); break;
		case 3:	bufferG.setColor(new Color(0,255,0)); break;
		case 4:	bufferG.setColor(new Color(0,0,255)); break;
		case 5:	bufferG.setColor(new Color(11,1,80)); break;
		case 6:	bufferG.setColor(new Color(255,0,255)); break;
		}
		
		if(msPaint.getFill().isSelected()) {
			if(msPaint.getLine().isSelected())
				bufferG.drawLine(x1, y1, x2, y2);
			else if(msPaint.getCircle().isSelected())
				bufferG.fillOval(x1, y1, x2-x1, y2-y1);
			else if(msPaint.getRect().isSelected())
				bufferG.fillRect(x1, y1, x2-x1, y2-y1);
			else if(msPaint.getRoundRect().isSelected())
				bufferG.fillRoundRect(x1, y1, x2-x1, y2-y1,z1,z2);
			else if(msPaint.getPen().isSelected())
				bufferG.drawLine(x1, y1, x2, y2);
		}else {
			if(msPaint.getLine().isSelected())
				bufferG.drawLine(x1, y1, x2, y2);
			else if(msPaint.getCircle().isSelected())
				bufferG.drawOval(x1, y1, x2-x1, y2-y1);
			else if(msPaint.getRect().isSelected())
				bufferG.drawRect(x1, y1, x2-x1, y2-y1);
			else if(msPaint.getRoundRect().isSelected())
				bufferG.drawRoundRect(x1, y1, x2-x1, y2-y1,z1,z2);
			else if(msPaint.getPen().isSelected())
				bufferG.drawLine(x1, y1, x2, y2);
		}
		
		paint(g);
		
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(bufferImg, 0, 0, this);
	}
	
	private void legacy(Graphics g) {
		for(ShapeDTO dto : msPaint.getList()) {
			int x1 = Math.min(dto.getX1(),dto.getX2());
			int y1 = Math.min(dto.getY1(),dto.getY2());
			int x2 = Math.max(dto.getX1(),dto.getX2());
			int y2 = Math.max(dto.getY1(),dto.getY2());
			int z1 = dto.getZ1();
			int z2 = dto.getZ2();
			
			switch(dto.getColor()) {
			case 0:	bufferG.setColor(new Color(255,0,0));	break;
			case 1:	bufferG.setColor(new Color(200,91,2)); break;
			case 2:	bufferG.setColor(new Color(255,255,0)); break;
			case 3:	bufferG.setColor(new Color(0,255,0)); break;
			case 4:	bufferG.setColor(new Color(0,0,255)); break;
			case 5:	bufferG.setColor(new Color(11,1,80)); break;
			case 6:	bufferG.setColor(new Color(255,0,255)); break;
			}
			
			if(dto.isFill()) {
				if(dto.getShape()==Figure.LINE)
					bufferG.drawLine(x1, y1, x2, y2);
				else if(dto.getShape()==Figure.CIRCLE)
					bufferG.fillOval(x1, y1, x2-x1, y2-y1);
				else if(dto.getShape()==Figure.RECT)
					bufferG.fillRect(x1, y1, x2-x1, y2-y1);
				else if(dto.getShape()==Figure.ROUNDRECT)
					bufferG.fillRoundRect(x1, y1, x2-x1, y2-y1,z1,z2);
				else if(dto.getShape()==Figure.PEN)
					bufferG.drawLine(x1, y1, x2, y2);
					
			}else {
				if(dto.getShape()==Figure.LINE)
					bufferG.drawLine(x1, y1, x2, y2);
				else if(dto.getShape()==Figure.CIRCLE)
					bufferG.drawOval(x1, y1, x2-x1, y2-y1);
				else if(dto.getShape()==Figure.RECT)
					bufferG.drawRect(x1, y1, x2-x1, y2-y1);
				else if(dto.getShape()==Figure.ROUNDRECT)
					bufferG.drawRoundRect(x1, y1, x2-x1, y2-y1,z1,z2);
				else if(dto.getShape()==Figure.PEN)
					bufferG.drawLine(x1, y1, x2, y2);
			}
			
		}
	}

}
















