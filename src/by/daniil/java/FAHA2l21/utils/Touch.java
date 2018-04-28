package by.daniil.java.FAHA2l21.utils;

import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GPoint;

public class Touch {
	public static GPoint getCenter(GOval oval){
		return new GPoint(oval.getX() + oval.getWidth()/2, oval.getY() + oval.getHeight()/2);
	}
	
	public static boolean is(GOval oval1, GOval oval2){
		GPoint center1 = getCenter(oval1);
		GPoint center2 = getCenter(oval2);
		double length = new Vector(Math.abs(center1.getX()-center2.getX()),Math.abs(center1.getY()-center2.getY())).length();
		return (length<=oval1.getHeight()/2 + oval2.getHeight()/2)?true:false;
	}
	
	public static boolean is(GOval oval, GLine line){
		GPoint c = getCenter(oval);
		double x0 = oval.getX();
		double y0 = oval.getY();
		Vector ov = new Vector(x0, y0);
		double x1 = line.getStartPoint().getX();
		double y1 = line.getStartPoint().getY();
		double x2 = line.getEndPoint().getX();
		double y2 = line.getEndPoint().getY();
		Vector l1 = new Vector(x1,y1);
		Vector l2 = new Vector(x2,y2);
		double h = Math.abs(((x2-x1)*(y0-y1)-(y2-y1)*(x0-x1))/(new Vector(x2-x1,y2-y1)).length());
		if(h<=oval.getWidth()/2)
			return true;
		else
			return false;
	}
}
