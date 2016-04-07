package model;

import java.util.ArrayList;

public class Route {
	private ArrayList<Position> route;
	
	public Route(){
		route = new ArrayList<Position>();
	}

	public ArrayList<Position> getRoute() {
		return route;
	}

	public void setRoute(ArrayList<Position> route) {
		this.route = route;
	}
	
	public void addPosition(Position subroute){
		route.add(subroute);
	}
	
	public Position getSubroute(int i){
		return route.get(i);
	}
	
	public String toString(){
		String temp="";
		for (int i = 0; i<route.size(); i++)
			temp+=""+route.get(i).toString()+ " ";
		return temp;
	}
}

