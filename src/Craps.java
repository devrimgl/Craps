import java.util.Scanner;

public class Craps {
	
	static boolean isFirstTime = true;
	static Player player = new Player();
	static Bet bet = new Bet();
	static Game game = new Game(player);
	static int topUpAmount = 0;
	static int betAmount;
	static boolean canBet = true;
	static String input;
	
	public static void main (String[] args)
	{
		welcome();
		
		if(player.balance >= 5){
			canBet = true;
		} else canBet = false;
		
		while(true){
			if(canBet){				
				input = canBet();
				switch(input){
					case "p": {
						betAmount = bet.getBet(player);
						game.playGame(player, betAmount);
						
						if(player.balance >= 5){
							canBet = true;
						} else canBet = false;
						break;
					}
					case "t": {
						player.topUpBalance(topUpAmount);
						System.out.println("topped up: " + player.balance);
						if(player.balance >= 5){
							canBet = true;
						} else canBet = false;
						break;
					}
					case "q":{
						System.exit(-1);
						break;
					}
					case "e":{
						System.out.println("ERROR!!! CAN BET ERROR");
						if(player.balance >= 5){
							canBet = true;
						} else canBet = false;
						break;
					}
					
				}
			} else { 
				input = cannotBet();
				switch(input){
				
					case "t": {
						System.out.println("Please enter the amount you want to top up. You need to enter between 10 and 1000.");
						System.out.println("Top up amount : ");
						Scanner scan = new Scanner(System.in);
						topUpAmount = scan.nextInt();
						System.out.println(topUpAmount);
						player.topUpBalance(topUpAmount);
						if(player.balance >= 5){
							canBet = true;
						} else canBet = false;
						break;
					}
					case "q":{
						System.exit(-1);
						break;
					}
					case "e":{
						System.out.println("ERROR!!! CANNOT BET ERROR");
						if(player.balance >= 5){
							canBet = true;
						} else canBet = false;
						break;
					}
				
				}
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
	public static String cannotBet(){
		System.out.println("You cannot bet!");
		player.printBalance();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Press");
		System.out.println("T if tou want to top up your balance");
		System.out.println("Q if you want to say good bye!");
		
		System.out.println("What do you want? : ");
		String userInput = scanner.nextLine();
		
		if(userInput.equals("P") || userInput.equals("p")){
			return "p";
		} 
		else if(userInput.equals("T") || userInput.equals("t")){
			return "t";
		} 
		else if(userInput.equals("Q") || userInput.equals("q")){
			System.out.println("Bye!..");
			return "q";
		} else{
			System.out.println("Oups! Aren't you sure what you want to do?");
			return "e";
		}
	}
	
	public static String canBet(){
		System.out.println("/n ------------------------------------ /n");
		player.printBalance();

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Press");
		System.out.println("P if you want to play CRAPS!!");
		System.out.println("T if tou want to top up your balance");
		System.out.println("Q if you want to say good bye!");
		
		System.out.println("What do you want? : ");
		String userInput = scanner.nextLine();
		
		if(userInput.equals("P") || userInput.equals("p"))
		{
			return "p";
		} 
		else if(userInput.equals("T") || userInput.equals("t")){
			return "t";
		} 
		else if(userInput.equals("Q") || userInput.equals("q")){
			System.out.println("Bye!..");
			return "q";
		} else{
			System.out.println("Oups! Aren't you sure what you want to do?");
			return "e";
		}
	}
}
