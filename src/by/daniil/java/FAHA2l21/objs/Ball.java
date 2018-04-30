package by.daniil.java.FAHA2l21.objs;

import java.awt.Graphics;

import acm.graphics.GCanvas;
import acm.graphics.GImage;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRectangle;
import by.daniil.java.FAHA2l21.utils.Vector;

public class Ball extends GOval{	
	
	public Ball(double diam, String image) {
		super(diam, diam);
		move = new Vector(0,0);
		ball = new GImage(image);
		ball.setSize(diam, diam);
	}
	
	public Ball(double diam) {
		super(diam, diam);
		move = new Vector(0,0);
		ball = null;
	}
	
	public Vector move;
	public GImage ball;
	
	
	public void add(GCanvas canvas){
		if(ball==null)
		canvas.add(this);
		else
		canvas.add(ball);
	}
	
	@Override
	public void setLocation(double x, double y){
		super.setLocation(x, y);
		if(ball!=null)
		this.ball.setLocation(x, y);
	}
}
