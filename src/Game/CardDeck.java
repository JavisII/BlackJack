package Game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import Core.Console;
import Prefabs.ExampleCard;

public class CardDeck {
	ArrayList<ICardObject> avaiableCards = new ArrayList<ICardObject>();
	ArrayList<ICardObject> usedCards = new ArrayList<ICardObject>();
	
	public CardDeck(){
		Setup(1);
	}
	public CardDeck(int totalDecks){
		Setup(totalDecks);
	}
	
	private void Setup(int totalDecks) {
		Console.Log("Deck", "Setup Begun!");
		for(int i = 0; i<totalDecks; i++) {
			for(int a = 0; a<4; a++) {
				for(int n = 1; n<=13; n++) {
					avaiableCards.add(new ExampleCard(n, a));
				}
			}
			Console.Log("Deck", "Deck "+ i +" Added");
		}
		Console.Log("Deck", "Total Cards: " + avaiableCards.size());
		Console.Log("Deck", "Start Shuffeling...");
		
		Collections.shuffle(avaiableCards);
		Collections.shuffle(avaiableCards);
		Collections.shuffle(avaiableCards);
		Collections.shuffle(avaiableCards);
		Collections.shuffle(avaiableCards);
		Collections.shuffle(avaiableCards);
		Collections.shuffle(avaiableCards);
		
		Console.Log("Deck", "Setup Complete!");
		
		
	}
	ICardObject GrabCardObject() {
		return avaiableCards.remove(0);
	}
	void PutCardAway(ICardObject card) {
		usedCards.add(card);
	}
}
