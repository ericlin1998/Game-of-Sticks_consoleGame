
/**
 * 	author Eric Lin
 * 	Completed
 * 		differentAI class
 */

public class differentAI {
	private int total;
	private int num;
	private int firstNum;
	private int playerInput = 0;
	private int MAX;
	
	public differentAI(int total){
		this.total = total;
	}
	
	public int selectNum(){
		if(playerInput!=0){
			return MAX+1-playerInput;
		}
		else{
			return firstNum;
		}
	}
	
	public void updatePlayerInput(int num){
		this.playerInput = num;
	}
	
	public int findMAX(int initial){
		int[] fList = Factor.factor(initial);
		int x=0;
		while(fList.length<=2){
			x++;
			fList = Factor.factor(initial+x);
		}
		for(int y=1; y<fList.length; y++){
			if(fList[y]>2){
				MAX= fList[y]-1;
				break;
			}
		}
		firstNum = MAX-x;
		return MAX;
	}
}
