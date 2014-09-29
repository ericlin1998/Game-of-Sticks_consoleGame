/**
 * 	author Eric Lin
 * 	Completed
 * 		Player vs AI
 */

public class Game2 {
	private final int MAX = 4;
	private int initial;
	private int total;
	private int player = 2;
	private boolean repeat = true;
	private AI bot;
	//testing variable
	//private int games = 0;
	
	public Game2(){
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
				int tempNum = bot.chooseNum(total);
				bot.updateTemp(total, tempNum);
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
				bot.improve();
			}
			else{
				System.out.println("AI loses");
			}
			bot.editTemp();
			//games++;
			//System.out.println("games: " + games);
			player = 2;
			restart();
		}
		//bot.printArray();
	}
	
	public void numError(String temp, int min, int max){
		if(Main.isInteger(temp)){
			int num = Integer.parseInt(temp);
			if(num>=min && num<=max){
				total = num;
				initial = num;
				bot = new AI(total,MAX);
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
					System.out.println("Game2 ended");
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
			System.out.println("Game2 ended");
			return false;
		}
		else{
			return true;
		}
	}
}
