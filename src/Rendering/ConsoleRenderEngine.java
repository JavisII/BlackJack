package Rendering;

import java.util.ArrayList;

import javax.imageio.plugins.tiff.ExifGPSTagSet;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import Game.CardData;
import Game.GameManager;
import Game.Player;


public class ConsoleRenderEngine {
	public static void Render() {
		Render(GameManager.instance.dealer, GameManager.instance.players);
	}
	public static void ShowPlayerData(ArrayList<Player> players) {
		System.out.println("");

		String z1 = "=";
		for(int i = (players.size())*10; i>0; i--) {z1 += "=";}
		
		String z2 = "";
		for (Player player : players) {
			z2 += String.format("|%9s", player.name);
		}
		z2 += "|";
		String z3 = "";
		for (Player player : players) {
			z3 += String.format("|%9s", player.getMoney()+"$");
		}
		z3 += "|";
		
		System.out.println(z1);
		System.out.println(z2);
		System.out.println(z3);
		System.out.println(z1);
	}
	public static void Render(Player dealer, ArrayList<Player> players) {
		System.out.println("");
		System.out.println("");
		System.out.println("");

		String z1 = "=";
		for(int i = (players.size()+1)*10; i>0; i--) {z1 += "=";}
		
		String z2 = "";
		z2 += String.format("|%9s", dealer.name);
		for (Player player : players) {
			z2 += String.format("|%9s", player.name);
		}
		z2 += "|";
		
		String z3 = "";
		z3 += String.format("|%9s", GameManager.instance.bank+"$");
		for (Player player : players) {
			z3 += String.format("|%9s", player.getMoney()+"$");
		}
		z3 += "|";
		
		
		System.out.println(z1);
		System.out.println(z2);
		System.out.println(z3);
		System.out.println(z1);
		
		z3="";
		z3 += String.format("|%9s", "");
		for (Player player : players) {
			z3 += String.format("|%9s", "Bet:" + player.bet);
		}
		z3+="|";
		
		System.out.println(z3);
		System.out.println(z1);
		
		
		
		int highestCardCount = dealer.handArrayList.size();
		for (Player player : players) {
			if(player.handArrayList.size()>highestCardCount) {highestCardCount = player.handArrayList.size();}
		}
		String z="";
		for (int zeile = 0; zeile < highestCardCount; zeile++) {
			z = "";
			if(dealer.handArrayList.size()>zeile) {
				z+= ConvertToString(dealer.handArrayList.get(zeile).getCardData());
			}else {z+= String.format("|%9s", "");}
			for (Player player2 : players) {
				if(player2.handArrayList.size()>zeile) {
					z+= ConvertToString(player2.handArrayList.get(zeile).getCardData());
				}else {z+= String.format("|%9s", "");}
			}
			System.out.println(z+"|");
		}
		
		System.out.println(z1);
		z3="";
		z3 += String.format("|%9s", "Value:" + dealer.getValue());
		for (Player player : players) {
			z3 += String.format("|%9s", "Value:" + player.getValue());
		}
		z3+="|";
		
		System.out.println(z3);
		System.out.println(z1);
		System.out.println("");
		System.out.println("");
		System.out.println("");

	}
	public static String ConvertToString(CardData cd) {
		String numString = Integer.toString(cd.cardNumber);
		if(cd.cardNumber == 1) { numString = "Ass";}
		if(cd.cardNumber == 11) { numString = "J";}
		if(cd.cardNumber == 12) { numString = "Q";}
		if(cd.cardNumber == 13) { numString = "K";}
		String r = "";
		if(cd.cardType == 0) {r = "Herz ";}
		if(cd.cardType == 1) {r =  "Karo ";}
		if(cd.cardType == 2) {r =  "Pik ";}
		if(cd.cardType == 3) {r =  "Kreuz ";}
		return String.format("|%-6s", r) +String.format("%3s", numString);
	}
}
