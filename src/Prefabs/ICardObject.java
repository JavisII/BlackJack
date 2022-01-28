package Prefabs;

public interface ICardObject {
	public CardData getCardData();
	public void setCardData(CardData cardData);
	public void CalculateValue();	//For Game Logic
	public void CalculateValue(boolean useAssAsEleven);	//For Game Logic
}
