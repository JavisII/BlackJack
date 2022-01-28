package Prefabs;

public class ExampleCard implements ICardObject {
	private int value; //den eigentlichen wert der karte
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
	public void CalculateValue() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void CalculateValue(boolean useAssAsEleven) {
		// TODO Auto-generated method stub
		
	}

}
