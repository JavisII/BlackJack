package Game;

import java.util.ArrayList;

import Core.Console;
import Rendering.ConsoleRenderEngine;

public abstract class Player {
	public ArrayList<ICardObject> handArrayList = new ArrayList<ICardObject>();
	
	public String name = "";
	int money = 0;
	public int bet = 0;
	
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
	public Player setMoney(int money) {
		this.money = money;
		return this;
	}

	public Player setName(String name) {
		this.name = name;
		return this;
	}

	
	int getBet() {return bet;}
	public int getMoney() {return money;}
	
	public int getValue() {
		
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
		ConsoleRenderEngine.Render();
		if(getValue()==21) {Console.Log(name, "BlackJack!!!"); return;}
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
		if(getValue()>21) {Console.Log(name, "Bust!!! :(");return;}

		Turn();
	}
	
	abstract decision Decide();
	abstract int CalculateBet();
	abstract void NewRound();
	
	
	
}
