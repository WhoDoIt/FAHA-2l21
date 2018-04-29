package by.daniil.java.FAHA2l21;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import acm.program.GraphicsProgram;
import by.daniil.java.FAHA2l21.objs.Player;
import by.daniil.java.FAHA2l21.utils.Axis;

public abstract class Gamemode extends GraphicsProgram{
	protected ArrayList<Player> players;
	protected Axis axis;
	protected double deltaTime;
	
	public final void run(){
		axis = new Axis();
		addKeyListeners();
		startGame();
		deltaTime = 0.001;
		while(true){
			update();
			pause(1);
		}
	};
	
	public void startGame(){
		System.out.println("START GAME");
	};
	
	public void update(){
		System.out.println("UPDATE");
	}
	
	public void keyPressed(KeyEvent e){
		axis.press(e.getKeyCode());
	}
	
	public void keyReleased(KeyEvent e){
		axis.release(e.getKeyCode());
	}
}
