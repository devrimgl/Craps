import java.util.Scanner;

public class Game {
	private int diceResult;
	Player player = new Player();
	Dice dice = new Dice();
	int pointValue = 0;
	Game(Player player){
		this.player = player;
	}
	
	public void playGame(Player player, int bet){
		diceResult = dice.rollDice();

		System.out.println(diceResult);
		if(pointValue == 0){
			if(diceResult == 7 || diceResult == 11){
				System.out.println("WIN!!");
				player.winBalance(bet);
				//return 1;
			}
			else if(diceResult == 2 || diceResult == 3 || diceResult == 12){
				System.out.println("CRAPS!!");
				player.lostBalance(bet);
				//return 2;
			}
			else if(diceResult == 0){
				System.exit(-1);
			} else{
				pointValue = diceResult;
				System.out.println("Point value is "+ pointValue + " You need to roll dice again...");
				playGame(player, bet);
			}
		}
		else{
			if(diceResult == pointValue){
				System.out.println("WIN!!");
				player.winBalance(bet);
				
			}
			else if(diceResult == 7){
				System.out.println("CRAPS!!");
				player.lostBalance(bet);
				//return 2;
			}
			else if(diceResult == 0){
				System.exit(-1);
			} else {
				playGame(player, bet);
			}
		}
		
		diceResult = 0;
		pointValue = 0;
	}
	
}
