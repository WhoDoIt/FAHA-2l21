package by.daniil.java.FAHA2l21;

import java.awt.Color;
import java.util.ArrayList;

import by.daniil.java.FAHA2l21.objs.Player;
import by.daniil.java.FAHA2l21.utils.Touch;
import by.daniil.java.FAHA2l21.utils.Vector;
import acm.graphics.GImage;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;

public class Testubg extends Gamemode {
	GOval oval = new GOval(25,25);
	GImage oval_im = new GImage("C:\\Users\\Даниил\\Pictures\\ball.png");
	GLine[] borders;
	Vector pl1;
	Vector pl2;
	Vector ball;
	double speed = 325;
	double ball_speed = 0;
	GLine goalborder_L;
	GLine goalborder_R;
	int state = 0;
	@Override
	public void startGame(){
		this.players = new ArrayList<Player>();
		
		add(new GLine(640, 0, 640, 720));
		
		players.add(new Player(50));
		players.add(new Player(50));
		
		players.get(0).getGOval().setColor(Color.BLUE);
		players.get(1).getGOval().setColor(Color.RED);
		
		borders = new GLine[2];
		borders[0] = new GLine(0, 0, 1280, 0);
		borders[1] = new GLine(1280, 720, 0, 720);
		
		goalborder_L = new GLine(0, 0, 0, 720);
		goalborder_R = new GLine(1280, 0, 1280, 720);
		
		pl1 = new Vector(0,0);
		pl2 = new Vector(0,0);
		ball = new Vector(0,0);
		
		for(Player player : players){
			add(player.getGOval());
			player.setPower(540);
		}
		
		for(GLine line : borders)
			add(line);
		oval.setLocation(100,100);
		oval_im.setLocation(100, 100);
		oval_im.setSize(25, 25);
		add(oval_im);
		add(goalborder_L);
		add(goalborder_R);
		
		oval.setLocation(getWidth()/2-oval.getWidth()/2, getHeight()/2-oval.getHeight()/2);
		oval_im.setLocation(getWidth()/2-oval.getWidth()/2, getHeight()/2-oval.getHeight()/2);
		players.get(0).setLocation(0, getHeight()/2-players.get(0).getRadius()/2);
		players.get(1).setLocation(1280 - players.get(0).getRadius(), getHeight()/2-players.get(0).getRadius()/2);
	}
	
	public int math(double a){
		if(a>0)
			return 1;
		else if(a<0)
			return -1;
		else
			return 0;
	}
	
	@Override
	public void update(){
		
		pl1 = new Vector(-axis.get(65) + axis.get(68), -axis.get(87) + axis.get(83));
		pl2 = new Vector(-axis.get(37) + axis.get(39), -axis.get(38) + axis.get(40));
		
		if(state!=2)
		players.get(0).move(pl1.normilize().multiply(speed).multiply(this.deltaTime));
		
		if(state!=1)
		players.get(1).move(pl2.normilize().multiply(speed).multiply(this.deltaTime));
		
		Vector temp = ball.normilize().multiply(ball_speed);
		
		oval.move(temp.x*this.deltaTime, temp.y*this.deltaTime);
		oval_im.move(temp.x*this.deltaTime, temp.y*this.deltaTime);
		
		if(ball_speed>0){
			ball_speed-=600*this.deltaTime;
		}
		if(ball_speed<0){
			ball_speed = 0;
		}
		
		if(Touch.is(players.get(0).getGOval(), oval) && Touch.is(players.get(1).getGOval(), oval)){ball_speed = 0;}
		else if(Touch.is(players.get(0).getGOval(), oval)){
			GPoint center = Touch.getCenter(players.get(0).getGOval());
			GPoint center_ball = Touch.getCenter(oval);
			ball = new Vector(center_ball.getX()-center.getX(), center_ball.getY()-center.getY());
			ball_speed = players.get(0).getPower();
			state = 0;
		} else if(Touch.is(players.get(1).getGOval(), oval)){
			GPoint center = Touch.getCenter(players.get(1).getGOval());
			GPoint center_ball = Touch.getCenter(oval);
			ball = new Vector(center_ball.getX()-center.getX(), center_ball.getY()-center.getY());
			ball_speed = players.get(1).getPower();
			state = 0;
		}
		
		if(Touch.is(goalborder_L, oval)){
			ball_speed = 0;
			players.get(0).setLocation(1280/8 - players.get(0).getRadius()/2, oval.getY()-players.get(0).getRadius()/4);
			players.get(1).setLocation(1280/4*3 - players.get(1).getRadius(), 360-players.get(1).getRadius()/2);
			oval.setLocation(1280/4-oval.getWidth()/2, oval.getY());
			oval_im.setLocation(1280/4-oval.getWidth()/2, oval.getY());
			state = 1;
		} else if(Touch.is(goalborder_R, oval)){
			ball_speed = 0;
			players.get(1).setLocation(1280/8*7 - players.get(1).getRadius()/2, oval.getY()-players.get(1).getRadius()/4);
			players.get(0).setLocation(1280/4 - players.get(0).getRadius()/2, 360-players.get(0).getRadius()/2);
			oval.setLocation(1280/4*3-oval.getWidth()/2, oval.getY());
			oval_im.setLocation(1280/4*3-oval.getWidth()/2, oval.getY());
			state = 2;
		}
		
		for(GLine line : borders){
			if(Touch.is(line, oval)){
				System.err.println(line.getStartPoint().getY()-Touch.getCenter(oval).getY());
				if(math(ball.y)==math( line.getStartPoint().getY() - Touch.getCenter(oval).getY() ) )
				ball.y = -ball.y;
			}
		}
	}
}
