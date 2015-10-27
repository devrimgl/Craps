import java.util.Scanner;

public class Craps {
	
	public static void main (String[] args)
	{
		System.out.println("Welcome!");
		boolean isFirstTime = true;
		Player player = new Player();
		Bet bet = new Bet();
		Game game = new Game(player);
		int topUpAmount = 0;
		System.out.println("Welcome to Craps Game!");
		System.out.println("Your current balance is "+player.balance);
		
		// Burayi recursive yap! 
		System.out.println("Play - P");
		System.out.println("Top up - T");
		System.out.println("Quit - Q");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("What do you want to do? Press related char : ");
		String userInput = scanner.nextLine();
		
		if(userInput.equals("P") || userInput.equals("p"))
		{
			game.playGame();
		} else if(userInput.equals("T") || userInput.equals("t")){
			player.topUpBalance(topUpAmount);
		} else if(userInput.equals("Q") || userInput.equals("q")){
			System.out.println("Bye!..");
		} else{
			System.out.println("Oups! Aren't you sure what you want to do?");
		}
			
	}
}
