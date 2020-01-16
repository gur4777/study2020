package exam;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import javax.swing.JTextField;

public class DrCanvas extends Canvas{
	private Vector<ShapeDTO> vc = new Vector<ShapeDTO>(); 
	private MsPaint msPaint;
	private Color color;
	private String shape;
	
	
	public DrCanvas(MsPaint msPaint) {
		this.msPaint = msPaint;
		this.setBackground(new Color(255,200,205));
		shape = "rect";
		
	}
	
	public void aa() {
		int x1 = Integer.parseInt(msPaint.getX1T().getText().trim());
		int y1 = Integer.parseInt(msPaint.getY1T().getText().trim());
		int x2 = Integer.parseInt(msPaint.getX2T().getText().trim());
		int y2 = Integer.parseInt(msPaint.getY2T().getText().trim());
		int z1 = Integer.parseInt(msPaint.getZ1T().getText().trim());
		int z2 = Integer.parseInt(msPaint.getZ2T().getText().trim());
		
		
		//색
		switch(msPaint.getCombo().getSelectedIndex()) {
			case 0 : color=new Color(255,0,0); break;
			case 1 : color=new Color(200,91,2); break;
			case 2 : color=new Color(255,255,0); break;
			case 3 : color=new Color(0,255,0); break;
			case 4 : color=new Color(0,0,255); break;
			case 5 : color=new Color(24,2,176); break;
			case 6 : color=new Color(255,0,2); break;
		}
		//
		if(msPaint.getPen().isSelected()) shape = "pen";
		if(msPaint.getPen().isSelected()) shape = "rect";
		if(msPaint.getPen().isSelected()) shape = "roundRect";
		if(msPaint.getPen().isSelected()) shape = "circle";
		//도형
		ShapeDTO shapeDTO = new ShapeDTO(x1, y1, x2, y2, z1, z2, color, shape, msPaint.getFill().isSelected());
		vc.add(shapeDTO);
	}
	
	@Override
	public void paint(Graphics g) {
		//좌표
		
		
	
		
		for(ShapeDTO dto : vc) {
			if(dto.getFill()) {//채워진 도형
				
				if(dto.getShape().equals("pen")) {
					g.drawLine(dto.getX1T(), dto.getY1T(), dto.getX2T(), dto.getY2T());
				}
				else if(dto.getShape().equals("circle")){
					g.fillOval(Math.min(dto.getX1T(), dto.getX2T()), Math.min(dto.getY1T(), dto.getY2T()), Math.abs(dto.getX2T()-dto.getX1T()), Math.abs(dto.getY2T()-dto.getY1T()));
				}
				else if(dto.getShape().equals("rect")) {
					g.fillRect(Math.min(dto.getX1T(), dto.getX2T()), Math.min(dto.getY1T(), dto.getY2T()), Math.abs(dto.getX2T()-dto.getX1T()), Math.abs(dto.getY2T()-dto.getY1T()));
				}
				else if(dto.getShape().equals("roundRect")) {
					g.fillRoundRect(Math.min(dto.getX1T(), dto.getX2T()), Math.min(dto.getY1T(), dto.getY2T()), Math.abs(dto.getX2T()-dto.getX1T()), Math.abs(dto.getY2T()-dto.getY1T()), dto.getZ1T(),dto.getZ2T());
					
				}else if(dto.getShape().equals("line")) {
					g.drawLine(dto.getX1T(), dto.getY1T(), dto.getX2T(), dto.getY2T());
				}
			
			}else {//빈도형
				System.out.println(dto.getShape());
				if(dto.getShape().equals("pen")) {
					g.drawLine(dto.getX1T(), dto.getY1T(), dto.getX2T(), dto.getY2T());
				}
				else if(dto.getShape().equals("circle")){
					g.drawOval(Math.min(dto.getX1T(), dto.getX2T()), Math.min(dto.getY1T(), dto.getY2T()), Math.abs(dto.getX2T()-dto.getX1T()), Math.abs(dto.getY2T()-dto.getY1T()));
				}
				else if(dto.getShape().equals("rect")) {
					g.drawRect(Math.min(dto.getX1T(), dto.getX2T()), Math.min(dto.getY1T(), dto.getY2T()), Math.abs(dto.getX2T()-dto.getX1T()), Math.abs(dto.getY2T()-dto.getY1T()));
				}
				else if(dto.getShape().equals("roundRect")) {
					g.drawRoundRect(Math.min(dto.getX1T(), dto.getX2T()), Math.min(dto.getY1T(), dto.getY2T()), Math.abs(dto.getX2T()-dto.getX1T()), Math.abs(dto.getY2T()-dto.getY1T()), dto.getZ1T(),dto.getZ2T());
					
				}else if(dto.getShape().equals("line")) {
					g.drawLine(dto.getX1T(), dto.getY1T(), dto.getX2T(), dto.getY2T());
				}
			
			}	
		}
	}

	@Override
	public void update(Graphics g) {
//		paint(g);
		super.update(g);
	}
	

}
