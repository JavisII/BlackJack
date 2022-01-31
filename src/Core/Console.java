package Core;

import java.util.Scanner;

public class Console {
	public static void Log(String sender, String message) {
		System.out.println("["+ sender+"] " + message);
	}
	static Scanner scanner = new Scanner(System.in);
	public static String getInput() {
		return scanner.nextLine();
	}
	
	
}
