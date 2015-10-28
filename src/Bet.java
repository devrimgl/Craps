import java.util.Scanner;

public class Bet {
	int betList[] = {5,10,25,50,100,250,500};
	int minBet = betList[0];
	int maxBet;
	
	public int getMaxBet(int balance){
		for(int i=0;i<betList.length;i++){
			if(balance < betList[i]){
				return betList[i-1];
			}	
		}
		return 0;
	}
	
	public boolean betAmount(int balance, int bet){
		if(bet > balance){
			System.out.println("You cannot bet " + bet + "!");
			System.out.println("Your max possible bet amount is " + getMaxBet(balance));
			return false;
		} else{
			return true;
		}
	}
	
	public int getBet(Player player){
		int betAmount;
		System.out.println("Your current balance is "+ player.balance);
		System.out.println("Your possible bets are : ");
		for(int i=0;i<betList.length;i++){
			if(player.balance >= betList[i]){
				System.out.print(betList[i] + " ");
			}
			
		}
		System.out.println();
		betAmount = betScan();
		if(betAmount == -1){
			System.out.println("You cannot bet that amount!!");
			getBet(player);
		}
		return betAmount;
		
	}
	
	public int betScan(){
		System.out.println("How much you bet? : ");
		Scanner scan = new Scanner(System.in);
		int betAmount = scan.nextInt();
		for(int i=0; i<betList.length; i++){
			if(betAmount ==betList[i]){
				return betAmount;	
			}	
		}
		return -1;	
	}
	
	public int[] getBetList() {
		return betList;
	}
	public void setBetList(int[] betList) {
		this.betList = betList;
	}
	public int getMinBet() {
		return minBet;
	}
	public void setMinBet(int minBet) {
		this.minBet = minBet;
	}

	
	
	
}
