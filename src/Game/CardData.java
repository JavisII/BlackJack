package Game;

public class CardData {
	public int cardNumber; // 1: Ass 2-10: Numbers 11:J 12:Q 13:K
	public int cardType; // 0: 1: 2: 3: TODO: PASCAL: Such dir aus welche ID welches Symbol ist
	
	public CardData(int number, int type) {
		cardNumber = number;
		cardType = type;
	}
}
