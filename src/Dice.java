import java.util.Random;
import java.util.Scanner;

public class Dice {
	
	int diceSum = 0;
	
	public int rollDice(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Press Enter to Roll");
		String userInput = scanner.nextLine();
		
		if(userInput.equals(""))
		{
			return dice();
		}else{
			System.out.println("Bye...");
			return 0;
		}
		
	}
	
	private int dice(){	
		Random random = new Random();
		int dice1 = random.nextInt(6) + 1;
		int dice2 = random.nextInt(6) + 1;
		return diceSum = dice1 + dice2;
	}
}
