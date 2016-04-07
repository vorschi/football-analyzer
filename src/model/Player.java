package model;

import java.util.ArrayList;

public class Player {
	
	private double scale;
	private int startX;
	private int startY;
	private int actX;
	private int actY;
	private int routeSeg = 0;
	private ArrayList<Position> route;
	
	public Player(int startX, int startY, ArrayList<Position> route) {
		this.startX = startX;
		this.startY = startY;
		this.actX = startX;
		this.actY = startY;
		this.route = route;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getActX() {
		if (routeSeg<route.size())
				setActX(actX-=route.get(routeSeg).getDx());
		return actX;
	}

	public void setActX(int actX) {
		this.actX = actX;
	}

	public int getActY() {
		if (routeSeg<route.size()){
			setActY(actY-=route.get(routeSeg).getDy());
			routeSeg++;
		}
		
		return actY;
	}

	public void setActY(int actY) {
		this.actY = actY;
	}

	public String getRoute() {
			String temp="";
			for (int i = 0; i<route.size(); i++)
				temp+=""+route.get(i).toString()+ " ";
			return temp;
		}

	public void setRoute(ArrayList<Position> route) {
		this.route = route;
	}

	public int getRouteSeg() {
		return routeSeg;
	}

	public void setRouteSeg(int routeSeg) {
		this.routeSeg = routeSeg;
	}

}
