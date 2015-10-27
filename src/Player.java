
public class Player {
	int currentGame;
	int balance;
	int topUPList[] = {10, 25, 50, 100, 250, 500, 1000};
	Player(){
			currentGame = 0;
			balance = 10;
	}
	
	public int getCurrentGame() {
		return currentGame;
	}
	public void setCurrentGame(int currentGame) {
		this.currentGame = currentGame;
	}
	
	public void increaseCurrentGame(){
		currentGame = currentGame + 1; 
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void topUpBalance(int topUpAmount){
		balance = balance + topUpAmount;
	}
	//Print balance - sonrasinda Bet'e gore balance bilgisi buraya ekleyebilirsin
	public void printBalance(){
		if(balance > 5){
			System.out.println("Your current balance is" + balance);
		}
		else{
			System.out.println("You don't have any credits! Oups! You need to top up to play!");
		}
	}
	
}
