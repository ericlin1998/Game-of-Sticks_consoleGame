/**
 * 	author Eric Lin
 * 	Completed-not
 * 		Player vs trained AI
 */

public class Game3 {
	private final int TIMES = 1000;
	private final int MAX = 4;
	private int initial;
	private int total;
	private int player = 2;
	private boolean repeat = true;
	private AI bot1;
	private AI bot2;
	
	public Game3(){
		System.out.println("Initial stick amount:(10-100)");
		String str = Main.console.next();
		numError(str, 10, 100);
	}
	
	public void gameStart(){
		
		while(total>0 && repeat==true){
			if(player==2){
				System.out.println("Remaining:" + total);
				System.out.println("Player1: How many do you choose?(1-"+ MAX +")");
				String str1 = Main.console.next();
				inputError(str1,1,MAX);
				player=1;
			}
			else{
				int tempNum = bot1.chooseNum(total);
				bot1.updateTemp(total, tempNum);
				System.out.println("Remaining:" + total);
				System.out.println("AI chooses " + tempNum + " sticks");
				total = total - tempNum;
				System.out.println(" ");
				player=2;
			}
		}
		if(repeat==true){
			if(player==1){
				System.out.println("Player" + player + " loses");
				bot1.improve();
			}
			else{
				System.out.println("AI loses");
			}
			bot1.editTemp();
			player = 2;
			restart();
		}
	}
	
	public void numError(String temp, int min, int max){
		if(Main.isInteger(temp)){
			int num = Integer.parseInt(temp);
			if(num>=min && num<=max){
				total = num;
				initial = num;
				bot1 = new AI(total,MAX);
				bot2 = new AI(total,MAX);
				trainAI(bot1, bot2);
				gameStart();
			}
			else{
				System.out.println("error: input int not within range of "+ min + " and " + max);
				numError(Main.console.next(),min,max);
			}
		}
		else if(Main.checkInput(temp)){
			System.out.println("error: input not an int");
			numError(Main.console.next(),min,max);
		}
		else{
			repeat = false;
		}
	}
	
	public void trainAI(AI bot1, AI bot2){
		System.out.println("AI in training");
		for(int x=0; x<TIMES; x++){
			while(total>0){
				if(player==2){
					player=1;
					int tempNum = bot1.chooseNum(total);
					bot1.updateTemp(total, tempNum);
					total = total - tempNum;
				}
				else{
					player=2;
					int tempNum = bot2.chooseNum(total);
					bot2.updateTemp(total, tempNum);
					total = total - tempNum;
				}
			}
			if(player==1){
					bot2.improve();
			}
			else{
				bot1.improve();
			}
			bot1.editTemp();
			bot2.editTemp();
			player = 2;
			total = initial;
		}
	}
	
	public void inputError(String temp, int min, int max){
		if(Main.isInteger(temp)){
			int num = Integer.parseInt(temp);
			if(num>=min && num<=max){
				total -= num;
			}
			else{
				System.out.println("error: input int not within range of "+ min + " and " + max);
				inputError(Main.console.next(),min,max);
			}
		}
		else if(checkInput(temp)){
			System.out.println("error: input not an int");
			inputError(Main.console.next(),min,max);
			
		}
		else{
			repeat = false;
		}
	}
	
	public boolean getRepeat(){
		return repeat;
	}
	
	public void restart(){
		System.out.println("Play again?(0-1)");
		restartError(Main.console.next(),0,1);
	}
	
	public void restartError(String num, int min, int max){
		if(Main.isInteger(num)){
			int num2 = Integer.parseInt(num);
			if(num2>=min && num2<=max){
				if(num2==0){
					System.out.println("Game3 ended");
					repeat = false;
				}
				else{
					total = initial;
				}
			}
			else{
				System.out.println("error: input int not within range of "+ min + " and " + max);
				restartError(Main.console.next(),min,max);
			}
		}
		else if(Main.checkInput(num)){
			System.out.println("error: input not an int");
			restartError(Main.console.next(),min,max);
		}
		else{
			repeat = false;
		}
	}
	
	public static boolean checkInput(String str){
		if(str.toUpperCase().equals("ENDGAME")){
			System.out.println("Game3 ended");
			return false;
		}
		else{
			return true;
		}
	}
}
