import java.util.Random;

public class Dice {
	
	int diceSum = 0;
	
	public int rollDice(){
		return dice();
	}
	
	private int dice(){	
		Random random = new Random();
		int dice1 = random.nextInt(6) + 1;
		int dice2 = random.nextInt(6) + 1;
		return diceSum = dice1 + dice2;
	}
}
