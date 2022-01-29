package Game;

public interface ICardObject {
	public CardData getCardData();
	public void setCardData(CardData cardData);
	public int getValue();//returns the initial value off the card, 1 in ASS and must be convertet to 11 if necesarry
}
