package by.daniil.java.FAHA2l21;

import by.daniil.java.FAHA2l21.utils.Touch;
import by.daniil.java.FAHA2l21.utils.Vector;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class Testubg extends Gamemode {
	GOval oval = new GOval(25,25);
	@Override
	public void startGame(){
		oval.setLocation(0, 0);
		add(oval);
		System.out.println("sosi huy");
	}
	
	@Override
	public void update(){
		double deltaTimeDouble = (double) deltaTime.toMillis()/1000;
		System.out.println(deltaTimeDouble);
		oval.move(00*deltaTimeDouble, 00*deltaTimeDouble);
	}
}
