import java.util.Scanner;

public class Craps {
	
	static boolean isFirstTime = true;
	static Player player = new Player();
	static Bet bet = new Bet();
	static Game game = new Game(player);
	static int topUpAmount = 0;
	static int betAmount;
	static boolean canBet = true;
	
	public static void main (String[] args)
	{
		welcome();
		while(true){
			System.out.println("Play - P");
			System.out.println("Top up - T");
			System.out.println("Quit - Q");
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("What do you want to do? Press related char : ");
			String userInput = scanner.nextLine();
			
			if(userInput.equals("P") || userInput.equals("p"))
			{
				betAmount = bet.getBet(player);
				game.playGame(player, betAmount);
				//print edilecek degerler
			} else if(userInput.equals("T") || userInput.equals("t")){
				player.topUpBalance(topUpAmount);
			} else if(userInput.equals("Q") || userInput.equals("q")){
				System.out.println("Bye!..");
				break;
			} else{
				System.out.println("Oups! Aren't you sure what you want to do?");
			}
		}
		
			
	}
	public static void welcome(){
		System.out.println("Welcome to Craps Game!");
		player.printBalance();
		System.out.println("----RULES OF THE GAME----");
		System.out.println("bla bla bla bla bla bla");
		// print max bet
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Press");
		System.out.println("P if you want to play CRAPS!!");
		System.out.println("T if tou want to top up your balance");
		System.out.println("Q if you want to say good bye!");
		
		System.out.println("What do you want? : ");
		String userInput = scanner.nextLine();
		
		if(userInput.equals("P") || userInput.equals("p"))
		{
			betAmount = bet.getBet(player);
			game.playGame(player, betAmount);
		} 
		else if(userInput.equals("T") || userInput.equals("t")){
			player.topUpBalance(topUpAmount);
		} 
		else if(userInput.equals("Q") || userInput.equals("q")){
			System.out.println("Bye!..");
			//!!!break buraya olmuyor!
		} else{
			System.out.println("Oups! Aren't you sure what you want to do?");
		}
		
	}
}
