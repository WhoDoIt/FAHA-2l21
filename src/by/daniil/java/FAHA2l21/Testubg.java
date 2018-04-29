package by.daniil.java.FAHA2l21;

import java.util.ArrayList;

import by.daniil.java.FAHA2l21.objs.Player;
import by.daniil.java.FAHA2l21.utils.Touch;
import by.daniil.java.FAHA2l21.utils.Vector;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;

public class Testubg extends Gamemode {
	GOval oval = new GOval(25,25);
	GLine[] borders;
	Vector pl1;
	Vector pl2;
	Vector ball;
	double speed = 267;
	double ball_speed = 0;
	@Override
	public void startGame(){
		this.players = new ArrayList<Player>();
		
		players.add(new Player(50));
		players.add(new Player(50));
		
		borders = new GLine[2];
		borders[0] = new GLine(0, 0, 1280, 0);
		borders[1] = new GLine(1280, 720, 0, 720);
		
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
		add(oval);
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
		
		players.get(0).move(pl1.normilize().multiply(speed).multiply(this.deltaTime));
		players.get(1).move(pl2.normilize().multiply(speed).multiply(this.deltaTime));
		
		Vector temp = ball.normilize().multiply(ball_speed);
		
		oval.move(temp.x*this.deltaTime, temp.y*this.deltaTime);
		if(ball_speed>0){
			ball_speed-=600*this.deltaTime;
		}
		if(ball_speed<0){
			ball_speed = 0;
		}
		
		for(GLine line : borders){
			if(Touch.is(oval, line)){
				if(math(ball.y)==math( line.getY() - Touch.getCenter(oval).getY() ) )
				ball.y = -ball.y;
			}
		}
		
		if(Touch.is(players.get(0).getGOval(), oval)){
			GPoint center = Touch.getCenter(players.get(0).getGOval());
			GPoint center_ball = Touch.getCenter(oval);
			ball = new Vector(center_ball.getX()-center.getX(), center_ball.getY()-center.getY());
			ball_speed = players.get(0).getPower();
		}
		
		if(Touch.is(players.get(1).getGOval(), oval)){
			GPoint center = Touch.getCenter(players.get(1).getGOval());
			GPoint center_ball = Touch.getCenter(oval);
			ball = new Vector(center_ball.getX()-center.getX(), center_ball.getY()-center.getY());
			ball_speed = players.get(1).getPower();
		}
	}
}
