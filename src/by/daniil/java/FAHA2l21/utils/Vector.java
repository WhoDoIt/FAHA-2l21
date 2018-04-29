package by.daniil.java.FAHA2l21.utils;
public class Vector{

	public double x;
	public double y;
	
	public Vector(double x, double y){
		this.x=x;
		this.y=y;
	}
	
	public Vector plus(Vector vc){
		return new Vector(vc.x+this.x, vc.y+this.y);
	}
	
	public Vector minus(Vector vc){
		return new Vector(this.x-vc.x,this.y-vc.y);
	}
	
	public Vector multiply(Vector vc){
		return new Vector(this.x*vc.x, this.y*vc.y);
	}
	
	public Vector multiply(double sclr){
		return new Vector(this.x*sclr, this.y*sclr);
	}
	
	public Vector normilize(){
		double length = this.length();
		if(this.length()==0)
			return new Vector(0,0);
		return new Vector(this.x/length, this.y/length);
	}
	
	public double length(){
		return Math.sqrt(Math.pow(this.x,2)+Math.pow(Math.abs(this.y),2));
	}
	
	public double angle(Vector vc){
		double multi = this.x*vc.x + this.y * vc.y;
		return Math.toDegrees(Math.acos(multi/(this.length()*vc.length())));
	}
	
	
	@Override
	public String toString(){
		return "X: " + this.x + " Y: " + this.y + " NX: " + this.normilize().x + " NY: " + this.normilize().y;
	}
}
