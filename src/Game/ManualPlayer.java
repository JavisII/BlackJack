package Game;

import Core.Console;

public class ManualPlayer extends Player {

	@Override
	decision Decide() {
		Console.Log(name, "Your value is " + getValue() + ", what do you wanna do?(h/s/dd)");
		while (true){
		String input = Console.getInput().toLowerCase();
		if(input.contains("s")) {return decision.stand;}
		if(input.contains("h")) {return decision.hit;}
		if(input.contains("dd")) {return decision.doubleDown;}
		Console.Log("ERROR", "Invalid Input, Try again: ");
		}
	}

	@Override
	int CalculateBet() {
		Console.Log(name,"What amount do you wanna bet:");
		while (true){
			String input = Console.getInput().toLowerCase();
			try{
	            int number = Integer.parseInt(input);
	            return number;
	        }
	        catch (NumberFormatException ex){
	        	Console.Log("ERROR", "Invalid Input, Try again: ");
	        }
			
		}
		
	}

	@Override
	void NewRound() {
		// TODO Auto-generated method stub
		
	}

}
