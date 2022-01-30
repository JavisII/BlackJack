package Game;

import java.util.ArrayList;

import Core.Console;

public class GameManager {
	private float winMultiplier = 1.5f;
	private int bank = 0;
	
	static GameManager instance;
	CardDeck cardDeck;
	boolean gameRoutineStarted = false;
	
	private ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Player> playerQue = new ArrayList<Player>();
	private Player dealer; // TODO: make dealer AI
	public GameManager() {
		if(instance!=null) {Console.Log("GameManager", "Error: Instance already set"); return;}
		instance = this;
		Setup();
		AddPlayer(new Dealer().setName("Player1").setMoney(100));
	}
	private void Setup() {
		dealer = new Dealer().setName("Dealer");
	}
	public GameManager AddPlayer(Player player) {
		playerQue.add(player);
		return this;
	}
	public GameManager setDeck(CardDeck cardDeck)
	{
		this.cardDeck = cardDeck;
		return this;
	}
	
	public void StartGameRoutine() {
		if(gameRoutineStarted) {return;}
		gameRoutineStarted = true;
		int ii = 0;
		while(ii <= 10){
			ii++;
			Core.Console.Log("GameManager", "Next Round");

			//Calculate Bets
			for (int i = 0; i < players.size(); i++) {
				Player player = players.get(i);
				
				if(player.money <= 0) {
					players.remove(player);
					Core.Console.Log("GameManager:" + player.name, "No More Money Left, Player Removed");
				}
				
				player.setBet(player.CalculateBet());
			}
			
			//Play Round
			for (int i = 0; i < players.size(); i++) {
				Player player = players.get(i);
				Core.Console.Log("GameManager:" + player.name, "Turn:");

				player.Turn();
			}
			dealer.Turn();
			int dealerValue = dealer.getValue();
			//Reward
			for (int i = 0; i < players.size(); i++) {
				Player player = players.get(i);
				if(player.getValue() > 21) {
					bank += (int)(player.getBet() * winMultiplier);
					Core.Console.Log("GameManager:" + player.name, "Bust! Now has: " + player.getMoney());
					continue;
				}
				if(player.getValue() > dealerValue) {
					bank -= (int)(player.getBet() * winMultiplier);
					player.money += (int)(player.getBet() * winMultiplier);
					Core.Console.Log("GameManager:" + player.name, "Won! Now has: " + player.getMoney());
					continue;
				}
				if(player.getValue() < dealerValue) {
					bank += (int)(player.getBet() * winMultiplier);
					Core.Console.Log("GameManager:" + player.name, "Lost! Now has: " + player.getMoney());
				}
				if(player.getValue() == dealerValue) {
					player.money += player.getBet();
					Core.Console.Log("GameManager:" + player.name, "Even! " + player.getMoney());
				}
			}
			
			//Reset
			for (int i = 0; i < players.size(); i++) {
				Player player = players.get(i);
				Core.Console.Log("GameManager:" + player.name, "Player Added to Game");

				player.Reset();
				
			}
			
			players.addAll(playerQue);
			playerQue.removeAll(playerQue);
		}
		
		
	}
}
