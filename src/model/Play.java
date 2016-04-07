package model;

import java.util.ArrayList;

public class Play {
    private ArrayList<Player> players;
    
    public Play(){
    	players = new ArrayList<Player>();
    	
    	ArrayList<Position> route1 = new ArrayList<Position>();
    	ArrayList<Position> route2 = new ArrayList<Position>();
    	
    	for (int i = 0; i < 30; i++){
    		route1.add(new Position(4,0));
    		route2.add(new Position(1,2));
    	}
    	
    	for (int i = 0; i < 30; i++){
    		route1.add(new Position(-4,0));
    		route2.add(new Position(4,0));
    	}
    	for (int i = 0; i < 30; i++)
    		route1.add(new Position(0,4));

    	//for (int i = 100; i <600; i+=30)
        players.add(new Player(200,500, route1));
        players.add(new Player(400,500, route2));

    }

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}
    
    
}
