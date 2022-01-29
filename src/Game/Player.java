package Game;

import java.util.ArrayList;

public abstract class Player {
	private ArrayList<ICardObject> handArrayList = new ArrayList<ICardObject>();
	
	Player Reset() {
		
		return this;
	}
	
	
	
	abstract decision Turn();
	abstract void NewRound();
	
	
	
}
