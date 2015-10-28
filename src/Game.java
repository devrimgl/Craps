public class Game {
	//private int diceResult;
	Player player = new Player();
	Dice dice = new Dice();
	//int pointValue = 0;
	Game(Player player){
		this.player = player;
	}
	
	public void playGame(Player player, int bet){
		int diceResult = dice.rollDice();
		int pointValue = 0;
		System.out.println(diceResult);
		if(pointValue == 0){
			if(diceResult == 7 || diceResult == 11){
				System.out.println("WIN!!");
				player.winBalance(bet);
				return;

			}
			else if(diceResult == 2 || diceResult == 3 || diceResult == 12){
				System.out.println("CRAPS!!");
				player.lostBalance(bet);
				return;
			}
			else if(diceResult == 0){
				//System.exit(-1);
			} 
			else {
				pointValue = diceResult;
				System.out.println("Point value is "+ pointValue + " You need to roll dice again...");
				playGame(player, bet);
				return;
			}
		}
		else{
			if(diceResult == pointValue){
				System.out.println("WIN!!");
				player.winBalance(bet);
				return;
				
			}
			else if(diceResult == 7){
				System.out.println("CRAPS!!");
				player.lostBalance(bet);
				return;
			}
			else if(diceResult == 0){
				//System.exit(-1);
			} 
			else {
				playGame(player, bet);
				return;
			}
		}
	}
	
}
