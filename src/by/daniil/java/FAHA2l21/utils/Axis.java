package by.daniil.java.FAHA2l21.utils;

public class Axis {
	private int[] codes;
	public Axis(){
		codes = new int[223];
		for(int i = 0;i<223;i++){
			codes[i] = 0;
		}
	}
	
	public void press(int a){
		codes[a] = 1;
	}
	
	public void release(int a){
		codes[a] = 0;
	}
	
	public int get(int a){
		return codes[a];
	}
}
