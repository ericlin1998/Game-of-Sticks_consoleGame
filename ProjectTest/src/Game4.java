/**
 * 	author Eric Lin
 * 	Completed
 * 		Game4 class
 */


public class Game4 {
		private int MAX;
		private int initial;
		private int total;
		private int player = 2;
		private boolean repeat = true;
		private differentAI bot;
		//testing variable
		//private int games = 0;
		
		public Game4(){
			System.out.println("Initial stick amount:(10-100)");
			String str = Main.console.next();
			numError(str, 10, 100);
		}
		
		public void gameStart(){
			
			while(total>0 && repeat==true){
				if(player==1){
					System.out.println("Remaining:" + total);
					System.out.println("Player1: How many do you choose?(1-"+ MAX +")");
					String str1 = Main.console.next();
					inputError(str1,1,MAX);
					player=2;
				}
				else{
					int tempNum = bot.selectNum();
					System.out.println("Remaining:" + total);
					System.out.println("AI chooses " + tempNum + " sticks");
					total = total - tempNum;
					System.out.println(" ");
					player=1;
				}
			}
			if(repeat==true){
				if(player==2){
					System.out.println("Player1 loses");
				}
				else{
					System.out.println("AI loses");
				}
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
					bot = new differentAI(total);
					MAX = bot.findMAX(initial);
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
					bot.updatePlayerInput(num);
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
						System.out.println("Game4 ended");
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
				System.out.println("Game4 ended");
				return false;
			}
			else{
				return true;
			}
		}

}
