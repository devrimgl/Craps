
public class Game {
	private int diceResult;
	Player player = new Player();
	Dice dice = new Dice();
	int pointValue = 0;
	Game(Player player){
		this.player = player;
	}
	
	public void playGame(){
		diceResult = dice.rollDice();
		if(pointValue == 0){
			if(diceResult == 7 || diceResult == 11){
				System.out.println("WIN!!");
			}
			else if(diceResult == 2 || diceResult == 3 || diceResult == 12){
				System.out.println("CRAPS!!");
			}
			else{
				pointValue = diceResult;
				System.out.println("Point value is "+ pointValue);
				System.out.println("Roll dice again!!");
				playGame();
			}
		}
		else{
			if(diceResult == pointValue){
				System.out.println("WIN!!");
			}
			else if(diceResult == 7){
				System.out.println("CRAPS!!");
			}
			else{
				System.out.println("Roll dice again!!");
				playGame();
			}
		}
		
	}
	
}
