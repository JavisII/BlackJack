package Game;

import java.util.ArrayList;

public abstract class Player {
	private ArrayList<ICardObject> handArrayList = new ArrayList<ICardObject>();
	
	String name = "";
	int money = 0;
	int bet = 0;
	
	Player Reset() {
		for (ICardObject iCardObject : handArrayList) {
			GameManager.instance.cardDeck.PutCardAway(iCardObject);
		}
		handArrayList.clear();
		bet = 0;
		
		return this;
	}
	Player AddCard(ICardObject card1) {
		handArrayList.add(card1);
		return this;
	}
	Player GrabCard() {
		AddCard(GameManager.instance.cardDeck.GrabCardObject());
		return this;
	}
	Player setBet(int bet) {
		if(bet>money) {
			this.bet = money;
		}else {
			this.bet = bet;
		}
		money -= this.bet;
		return this;
	}
	Player setMoney(int money) {
		this.money = money;
		return this;
	}

	Player setName(String name) {
		this.name = name;
		return this;
	}

	
	int getBet() {return bet;}
	public int getMoney() {return money;}
	
	int getValue() {
		
		int value = 0;
		int ass = 0;
		
		for (ICardObject card : handArrayList) {
			if(card.getValue() == 11) {ass++;}
			value += card.getValue();
		}
		
		if(value > 21 && ass!=0) {
			for(int i = ass; i > 0; i--) {
				value -= 10;
				if(value <= 21) {
					break;
				}
			}
		}
		
		
		return value;
	}
	
	void Turn() {
		decision resultDecision = Decide();
		
		if(resultDecision == decision.hit) {
			GrabCard();
		}
		if(resultDecision == decision.stand) {
			return;
		}
		if(resultDecision == decision.doubleDown) {
			setBet(bet*2);
			GrabCard();
			return;
		}
		if(getValue()>=21||resultDecision==null) {return;}
		Turn();
	}
	
	abstract decision Decide();
	abstract int CalculateBet();
	abstract void NewRound();
	
	
	
}
