package Game;

import Core.Console;
import Prefabs.ExampleCard;

public class Dealer extends Player {

	@Override
	decision Decide() {
		if(getValue()< 17) {Console.Log(name, "Hit!");return decision.hit;}
		Console.Log(name, "Stand!");
		return decision.stand;
	}

	@Override
	int CalculateBet() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	void NewRound() {
		// TODO Auto-generated method stub
		
	}

}
