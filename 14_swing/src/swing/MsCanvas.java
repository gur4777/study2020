package swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

public class MsCanvas extends Canvas {
	
	
	private int x1,y1,	x2,y2,	z1,z2;
	private int width, height;
	private String shape;
	private boolean fill;
	private Color color;
	
	private static Stack<Integer> t_f;
	
	private Vector<HashMap<String, Object>> v;
	
	public MsCanvas() {
		v = new Vector<HashMap<String, Object>>();
		t_f = new Stack<Integer>();
		t_f.push(0);
	}
	
	public void setting(String shape, boolean fill, Color color, String x1, String y1, String x2, String y2, String z1, String z2) {
		this.shape = shape;
		this.fill = fill;
		this.color = color;
		this.x1 = Math.min(Integer.parseInt(x1),Integer.parseInt(x2));
		this.y1 = Math.min(Integer.parseInt(y1),Integer.parseInt(y2));
		this.x2 = Math.max(Integer.parseInt(x1),Integer.parseInt(x2));
		this.y2 = Math.max(Integer.parseInt(y1),Integer.parseInt(y2));
		width = this.x2 - this.x1;
		height = this.y2 - this.y1;
		
		//용도 불명
		this.z1 = Integer.parseInt(z1);
		this.z2 = Integer.parseInt(z2);
		
		
		HashMap<String, Object> data = new HashMap<String, Object>();
		if(shape!="pen") {
			data.put("shape", this.shape);
			data.put("fill", this.fill);
			data.put("color", this.color);
			data.put("x1L", Integer.parseInt(x1));
			data.put("x2L", Integer.parseInt(x2));
			data.put("y1L", Integer.parseInt(y1));
			data.put("y2L", Integer.parseInt(y2));
			data.put("x1", this.x1);
			data.put("y1", this.y1);
			data.put("x2", this.x2);
			data.put("y2", this.y2);
			data.put("z1", this.z1);
			data.put("z2", this.z2);
			data.put("width", this.width);
			data.put("height", this.height);
			t_f.push(1);
		}else {
			// shape가 pen이면
			data.put("shape", this.shape);
			data.put("fill", this.fill);
			data.put("color", this.color);
			data.put("x1L", Integer.parseInt(x1));
			data.put("x2L", Integer.parseInt(x2));
			data.put("y1L", Integer.parseInt(y1));
			data.put("y2L", Integer.parseInt(y2));
			data.put("x1", this.x1);
			data.put("y1", this.y1);
			data.put("x2", this.x2);
			data.put("y2", this.y2);
			data.put("z1", this.z1);
			data.put("z2", this.z2);
			data.put("width", this.width);
			data.put("height", this.height);
			t_f.push(2);
		}
		v.add(data);
		
		repaint();
	}
	
	public void del() {
		int cnt = 0;
		if(!t_f.isEmpty())
		while(t_f.pop()==2) {
			cnt = 1;
			if(v.size()-1 >= 0) v.remove(v.size()-1);
		}
		
		if(cnt == 0 && v.size()-1 >= 0) v.remove(v.size()-1);
		repaint();
	}
	
	public void cls() {
		v.clear();
		t_f.clear();
		repaint();
		
	}
	
	@Override
	public void paint(Graphics g) {
		
		for(HashMap<String,Object> data : v) {
			g.setColor((Color)data.get("color"));
			
			if(fill) {
				
				if(data.get("shape") == "line")	g.drawLine((int)data.get("x1L"), (int)data.get("y1L"), (int)data.get("x2L"), (int)data.get("y2L"));
				else if(data.get("shape") == "pen") g.drawLine((int)data.get("x1L"), (int)data.get("y1L"), (int)data.get("x2L"), (int)data.get("y2L"));
				else if(data.get("shape") == "cycle") g.fillOval((int)data.get("x1"), (int)data.get("y1"), (int)data.get("width"),(int)data.get("height"));
				else if(data.get("shape") == "rect") g.fillRect((int)data.get("x1"), (int)data.get("y1"), (int)data.get("width"),(int)data.get("height"));
				else if(data.get("shape") == "roundRect") g.fillRoundRect((int)data.get("x1"), (int)data.get("y1"), (int)data.get("width"),(int)data.get("height"),25,25);
			}else {
				if(data.get("shape") == "line")	g.drawLine((int)data.get("x1L"), (int)data.get("y1L"), (int)data.get("x2L"), (int)data.get("y2L"));
				else if(data.get("shape") == "pen") g.drawLine((int)data.get("x1L"), (int)data.get("y1L"), (int)data.get("x2L"), (int)data.get("y2L"));
				else if(data.get("shape") == "cycle") g.drawOval((int)data.get("x1"), (int)data.get("y1"), (int)data.get("width"),(int)data.get("height"));
				else if(data.get("shape") == "rect") g.drawRect((int)data.get("x1"), (int)data.get("y1"), (int)data.get("width"),(int)data.get("height"));
				else if(data.get("shape") == "roundRect") g.drawRoundRect((int)data.get("x1"), (int)data.get("y1"), (int)data.get("width"),(int)data.get("height"),25,25);
			}
		}
	}
	
	public void setT_F(int i) {
		t_f.push(i);
	}
}
