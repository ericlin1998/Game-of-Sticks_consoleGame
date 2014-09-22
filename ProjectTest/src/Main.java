import java.util.Scanner;


public class Main {
	static boolean repeat= true;
	static Scanner console = new Scanner(System.in);
	static int total;
	static int num = 5;
	static final int MIN = 0;
	
	public static void main(String[] args){
		do{
		startGame();
		}
		while(repeat);
		console.close();
	}
	
	public static void startGame(){
		System.out.println("game1 = Player vs Player");
		System.out.println("game2 = Player vs Lame AI");
		System.out.println("game3 = Player vs Normal AI that, from time to time, act retarded");
		System.out.println("game4 = Player vs Somewhat unbeatable AI");
		System.out.println("Select game:(1-4)");
		String gameNum = console.next();
		gameNumError(gameNum,1,4);
		if(repeat==true){
			restart();
		}
	}
	
	public static void game(int num){
		if(num==1){
			game1();
		}
		if(num==2){
			game2();
		}
		if(num==3){
			game3();
		}
		if(num==4){
			game4();
		}
	}
	
	public static void game1(){
		//to be implemented
		System.out.println("game1 chosen");
	}
	
	public static void game2(){
		//to be implemented
		System.out.println("game2 chosen");

	}
	
	public static void game3(){
		//to be implemented
		System.out.println("game3 chosen");

	}
	
	public static void game4(){
		//to be implemented
		System.out.println("game4 chosen");

	}
	
	public static AI getAI(int total, int num){
		AI AI = new AI(total, num);
		return AI;
	}

	public static void gameNumError(String gameNum, int min, int max){
		if(isInteger(gameNum)){
			int num = Integer.parseInt(gameNum);
			if(num>=min && num<=max){
				game(num);
			}
			else{
				System.out.println("error: input int not within range of"+ min + "and" + max);
				gameNumError(console.next(),min,max);
			}
		}
		else if(checkInput(gameNum)){
			System.out.println("error: input not an int");
			gameNumError(console.next(),min,max);
		}
		else{
			repeat = false;
		}
	}
	
	public static void restartError(String num, int min, int max){
		if(isInteger(num)){
			int num2 = Integer.parseInt(num);
			if(num2>=min && num2<=max){
				if(num2==0){
					System.out.println("GAME OVER");
					repeat = false;
				}
			}
			else{
				System.out.println("error: input int not within range of"+ min + "and" + max);
				restartError(console.next(),min,max);
			}
		}
		else if(checkInput(num)){
			System.out.println("error: input not an int");
			restartError(console.next(),min,max);
		}
		else{
			repeat = false;
		}
	}
	
	public static boolean isInteger( String input ) {
	    try {
	        Integer.parseInt( input );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	}
	
	public static boolean checkInput(String str){
		if(str.toUpperCase().equals("ENDGAME")){
			System.out.println("GAME OVER");
			return false;
		}
		else{
			return true;
		}
	}
	
	public static void restart(){
		System.out.println("Play another game?(0-1)");
		restartError(console.next(),0,1);
	}
}
