package model;

public class Position {
	private int dx;
	private int dy;
	
	public Position(int dx, int dy){
		this.dx = dx;
		this.dy = dy;
	}
	
	public int getDx() {
		return dx;
	}
	
	public void setDx(int dx) {
		this.dx = dx;
	}
	
	public int getDy() {
		return dy;
	}
	
	public void setDy(int dy) {
		this.dy = dy;
	}
	
	public String toString(){
		return "X: "+this.dx + " Y: "+this.dy;
	}
}
