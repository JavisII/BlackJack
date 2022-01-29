package Prefabs;

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


}
