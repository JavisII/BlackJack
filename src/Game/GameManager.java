package Game;

import java.util.ArrayList;

import Core.Console;
import Rendering.ConsoleRenderEngine;

public class GameManager {
	private float winMultiplier = 1.5f;
	public int bank = 0;
	
	public static GameManager instance;
	CardDeck cardDeck;
	boolean gameRoutineStarted = false;
	
	public ArrayList<Player> players = new ArrayList<Player>();
	private ArrayList<Player> playerQue = new ArrayList<Player>();
	public Player dealer; // TODO: make dealer AI
	public GameManager() {
		if(instance!=null) {Console.Log("GameManager", "Error: Instance already set"); return;}
		instance = this;
		Setup();
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
		while(true){
			if(playerQue.size()>0) {
				players.addAll(playerQue);
				playerQue.removeAll(playerQue);
				Core.Console.Log("GameManager", "Player Added");
			}
			if(players.size()==0) {continue;}
			Core.Console.Log("GameManager", "Next Round");
			dealer.Reset();
			ConsoleRenderEngine.ShowPlayerData(players);
			
			
			//Calculate Bets
			ArrayList<Player> playersToRemove = new ArrayList<Player>();
			
			for (int i = 0; i < players.size(); i++) {
				Player player = players.get(i);
				
				if(player.money <= 0) {
					playersToRemove.add(player);
					Core.Console.Log("GameManager:" + player.name, "No More Money Left, Player Removed");
					continue;
				}
				player.NewRound();
				player.setBet(player.CalculateBet());
				player.GrabCard().GrabCard();
			}
			for (Player player : playersToRemove) {
				players.remove(player);
			}
			playersToRemove.clear();
			dealer.GrabCard().GrabCard();
			//ConsoleRenderEngine.Render(dealer, players);
			//Play Round
			for (int i = 0; i < players.size(); i++) {
				Player player = players.get(i);
				Core.Console.Log("GameManager:" + player.name, "Turn:");

				player.Turn();
				
			}
			
			Core.Console.Log("GameManager:" + dealer.name, "Turn:");
			dealer.Turn();

			int dealerValue = dealer.getValue();
			//Reward
			for (int i = 0; i < players.size(); i++) {
				Player player = players.get(i);
				
				if(player.getValue() > 21&&dealerValue>21) {
					player.money += player.getBet();
					Core.Console.Log(player.name, "Bust! And Dealer Bust, resulting in a Draw. Player now has " + player.getMoney());
					continue;
				}
				if(player.getValue() > 21) {
					bank += (int)(player.getBet());
					Core.Console.Log(player.name, "Bust! Now has: " + player.getMoney());
					continue;
				}
				if(player.getValue() > dealerValue) {
					bank -= (int)(player.getBet() * winMultiplier);
					player.money += (int)(player.getBet() * winMultiplier);
					Core.Console.Log( player.name, "Won! Now has: " + player.getMoney());
					continue;
				}
				if(player.getValue() < dealerValue) {
					bank += (int)(player.getBet());
					Core.Console.Log(player.name, "Lost! Now has: " + player.getMoney());
				}
				if(player.getValue() == dealerValue) {
					player.money += player.getBet();
					Core.Console.Log(player.name, "Even! " + player.getMoney());
				}
			}
			
			//Reset
			for (int i = 0; i < players.size(); i++) {
				Player player = players.get(i);
				player.Reset();
				
			}
			
			
		}
		
		
	}
	public void test() {
		
		
	}
}
