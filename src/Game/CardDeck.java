package Game;

import java.util.ArrayList;

import Prefabs.ExampleCard;

public class CardDeck {
	ArrayList<ICardObject> avaiableCards = new ArrayList<ICardObject>();
	ArrayList<ICardObject> usedCards = new ArrayList<ICardObject>();
	
	CardDeck(){
		Setup(1);
	}
	CardDeck(int totalDecks){
		Setup(totalDecks);
	}
	
	private void Setup(int totalDecks) {
		for(int i = 0; i<totalDecks; i++) {
			for(int a = 0; a<4; a++) {
				for(int n = 1; n<=13; n++) {
					avaiableCards.add(new ExampleCard(n, a));
				}
			}
		}
	}
}
