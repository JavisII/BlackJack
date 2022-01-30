package Prefabs;

import Game.CardData;
import Game.ICardObject;

public class ExampleCard implements ICardObject {
	private int number;
	private int symbol;
	
	public ExampleCard(CardData cardData) {
		setCardData(cardData);
	}
	public ExampleCard(int number, int symbol) {
		this.number = number;
		this.symbol = symbol;
	}
	
	
	@Override
	public CardData getCardData() {
		return new CardData(number, symbol);
	}

	@Override
	public void setCardData(CardData cardData) {
		number = cardData.cardNumber;
		symbol = cardData.cardType;
	}
	@Override
	public int getValue() {
		if(number == 1) {return 11;}
		if(number>10) {return 10;}
		return number;
	}


}
