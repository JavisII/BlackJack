package Game;

import Prefabs.ExampleCard;

public class Dealer extends Player {

	@Override
	decision Decide() {
		if(getValue()< 17) {return decision.hit;}
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
