
public class Bet {
	//	int betList0[] = {5,10,25,50,100,250,500};
	int betList5[] = {5};
	int betList10[] = {5,10};
	int betList25[] = {5,10,25};
	int betList50[] = {5,10,25,50};
	int betList100[] = {5,10,25,50,100};
	int betList250[] = {5,10,25,50,100,250};
	int betList500[] = {5,10,25,50,100,250,500};
	int betListError[] = {0};
	
	public int[] possibleBets(Player player){
		if(player.getBalance() > 0 && player.getBalance() < 10){
			return betList5;
		}
		else if(player.getBalance() >= 10 && player.getBalance() < 25){
			return betList10;
		}
		else if(player.getBalance() >= 25 && player.getBalance() < 50){
			return betList25;
		}
		else if(player.getBalance() >= 50 && player.getBalance() < 100){
			return betList50;
		}
		else if(player.getBalance() >= 100 && player.getBalance() < 250){
			return betList100;
		}
		else if(player.getBalance() >= 250 && player.getBalance() < 500){
			return betList250;
		}
		else if(player.getBalance() >= 500){
			return betList500;
		}
		else{
			return betListError;
		}
		
	}
}
