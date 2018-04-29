package by.daniil.java.FAHA2l21.objs;

import by.daniil.java.FAHA2l21.utils.Vector;
import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GPoint;

public class Player {
	private GObject[] graphics;
	private GOval main;
	private double power = 8;
	
	public GOval getGOval(){
		return this.main;
	}
	
	public Player(GObject[] graphics, double radius){
		this.graphics = graphics;
		this.main = new GOval(radius, radius);
	}
	
	public Player(double radius){
		graphics = null;
		main = new GOval(radius, radius);
	}
	
	public double getRadius(){
		return this.main.getWidth();
	}
	
	public void setRadius(double radius){
		main.scale(radius/main.getHeight());
	}
	
	public GPoint getLocation(){
		return main.getLocation();
	}
	
	public void setLocation(GPoint gp){
		if(graphics!=null){
			for(GObject obj : graphics)
				obj.setLocation(gp);
		}
		main.setLocation(gp);
	}
	
	public void setLocation(double x, double y){
		if(graphics!=null){
			for(GObject obj : graphics)
				obj.setLocation(x, y);
		}
		main.setLocation(x, y);
	}
	
	public void move(Vector move){
		this.move(move.x, move.y);

	}
	
	public void move(double dx, double dy){
		if(graphics!=null){
			for(GObject obj : graphics)
				obj.move(dx, dy);
		}
		main.move(dx, dy);
	}
	
	public double getPower(){
		return this.power;
	}
	
	public void setPower(double power){
		this.power = power;
	}
}
