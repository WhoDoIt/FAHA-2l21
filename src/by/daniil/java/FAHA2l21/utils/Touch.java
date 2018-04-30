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
	
	public static double lengthForPoints(  double x1,
			double y1,
			double x2,
			double y2	){ // Ќаходим рассто€ние между точка в пространстве
		return Math.sqrt( Math.pow( Math.abs( x1-x2 ), 2 ) + Math.pow( Math.abs( y1-y2 ), 2 ) );
	}
	
	public static boolean is(GLine line, GOval oval){ // ѕересекаютс€ ли отрезок и круг
		if( line.getStartPoint().getX() == line.getEndPoint().getX() ){
			return lengthForPoints( oval.getX()+oval.getWidth()/2, 
									oval.getY()+oval.getWidth()/2,
									line.getStartPoint().getX(),
									oval.getY()+oval.getWidth()/2)
									<= oval.getWidth()/2;
		} else {
			return lengthForPoints( oval.getX()+oval.getWidth()/2,
									oval.getY()+oval.getWidth()/2,
									oval.getX()+oval.getWidth()/2,
									line.getStartPoint().getY() )
									<=
									oval.getWidth()/2;
		}
	}
}
