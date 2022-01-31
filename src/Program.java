import Game.CardDeck;
import Game.GameManager;
import Game.ManualPlayer;

public class Program {

	/* public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameManager()
		.setDeck(new CardDeck(1))
		.AddPlayer(new ManualPlayer().setName("Player1").setMoney(100))
		.AddPlayer(new ManualPlayer().setName("Player2").setMoney(100))
		.StartGameRo
	}
	*/
	public static void Start() {
		new GameManager()
		.setDeck(new CardDeck(6)).StartGameRoutine();
	}
}
