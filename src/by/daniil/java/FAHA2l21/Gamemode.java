package by.daniil.java.FAHA2l21;

import java.awt.event.KeyEvent;
import java.sql.Time;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

import acm.program.GraphicsProgram;
import by.daniil.java.FAHA2l21.objs.Player;
import by.daniil.java.FAHA2l21.utils.Axis;

public abstract class Gamemode extends GraphicsProgram{
	protected ArrayList<Player> players;
	protected Axis axis;
	protected Duration deltaTime;
	
	public final void run(){
		axis = new Axis();
		addKeyListeners();
		startGame();
		deltaTime = Duration.ZERO;
		Instant beginTime = Instant.now();
		while(true){
			update();
			deltaTime = Duration.between(beginTime, Instant.now());
		}
	};
	
	public void startGame(){
		System.out.println("START GAME");
	};
	
	public void update(){
		System.out.println("UPDATE");
	}
	
	public final void keyPressed(KeyEvent e){
		axis.press(e.getKeyCode());
	}
	
	public final void keyRelesed(KeyEvent e){
		axis.release(e.getKeyCode());
	}
}
