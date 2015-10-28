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
						System.out.println("Please enter the amount you want to top up. You need to enter between 10 and 1000.");
						System.out.println("Top up amount : ");
						Scanner scan = new Scanner(System.in);
						topUpAmount = scan.nextInt();
						if(topUpAmount <=10 && topUpAmount <=1000 ){
							System.out.println(topUpAmount);
							player.topUpBalance(topUpAmount);
							System.out.println("topped up: " + player.balance);
						}
						else {
							System.out.println("Please enter the amount you want to top up. You need to enter between 10 and 1000.");
							break;
						}
						
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
						if(topUpAmount <=10 && topUpAmount <=1000 ){
							System.out.println(topUpAmount);
							player.topUpBalance(topUpAmount);
							System.out.println("topped up: " + player.balance);
						}
						else {
							System.out.println("Please enter the amount you want to top up. You need to enter between 10 and 1000.");
							break;
						}
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
		System.out.println("Casino Craps (Basic Game) explanation:"
				+ "\nThe game of 'craps' is commonly played in Casino’s. "
				+ "\n\nGenerally, the game works as follows:"
				+ "\nA player rolls two dice (each with 6 possible values, 1 – 6). After rolling the two dice,"
				+ "\nthe sum of the scores are added. If the sum is 7 or 11 on the first throw, the player wins."
				+ "\n\nIf the sum is 2, 3 or 12 on the first throw – it is called 'craps' and the player loses."
				+ "\n\nIf the sum is any of the remaining values (4, 5, 6, 8, 9 or 10) this is called the players"
				+ "\n'point' (or 'point-value')."
				+ "\n\nRolling a point-value gives the player a chance to roll again. The player can win the game if they roll"
				+ "\ntheir point-value; however, if they roll a 7 first (i.e. before rolling their 'point') they lose. "
				+ "\n\nThe player can keep rolling until they roll their 'point' (in which case they win), or they"
				+ "\nroll a 7 (in which case they loose)."
				+ "\n"
				+ "You can bet 5 - 10 - 25 - 50 - 100 - 250 or 500"
				+ "\nYou can top up your balance after each game"
				+ "\nThe min top up amount is 10 and the max is 1000"
				+ "\nYou need to enter numeric value of your top up amount"
				+ "\nIn the beginning of the game your balance is 10"
				+ "I hope you enjoy playing CRAPS with us!! ");
		
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
			System.out.println("Please enter the amount you want to top up. You need to enter between 10 and 1000.");
			System.out.println("Top up amount : ");
			Scanner scan = new Scanner(System.in);
			topUpAmount = scan.nextInt();
			if(topUpAmount <=10 && topUpAmount <=1000 ){
				System.out.println(topUpAmount);
				player.topUpBalance(topUpAmount);
				System.out.println("topped up: " + player.balance);
			}
			else {
				System.out.println("You need to enter between 10 and 1000.");
			}
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
