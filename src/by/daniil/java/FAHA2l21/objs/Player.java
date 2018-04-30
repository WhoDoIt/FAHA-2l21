package by.daniil.java.FAHA2l21.objs;

import by.daniil.java.FAHA2l21.utils.Vector;
import acm.graphics.GCanvas;
import acm.graphics.GFillable;
import acm.graphics.GImage;
import acm.graphics.GOval;
import acm.graphics.GResizable;
import acm.graphics.GScalable;

public class Player extends GOval{
	private GImage graphics;
	private double power = 8;
	
	public Player(double diam, String image){
		super(diam, diam);
		this.graphics = new GImage(image);
	}
	
	public Player(double diam){
		super(diam, diam);
		graphics = null;
	}
	
	public void add(GCanvas canvas){
		if(graphics==null)
		canvas.add(this);
		else
		canvas.add(graphics);
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}
	
	@Override
	public void setSize(double width, double height){
		super.setSize(width, height);
		if(graphics!=null)
		graphics.setSize(width, height);
	}
	
	@Override
	public void scale(double sx, double sy) {
		super.scale(sx, sy);
		if(graphics!=null)
		graphics.scale(sx, sy);
	}
	
	@Override
	public void setLocation(double x, double y){
		super.setLocation(x, y);
		if(graphics!=null)
		graphics.setLocation(x, y);
	}
	
	public void move(Vector vc){
		super.move(vc.x, vc.y);
		if(graphics!=null)
		graphics.move(vc.x, vc.y);
	}
}
