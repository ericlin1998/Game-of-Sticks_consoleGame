/**
 * 	author Eric Lin
 * 	Completed
 * 		Factor class
 */

public class Factor {

	public static int[] factor(int num){
		int temp1 = 1;
		int temp2 = 1;
		String str = "";
		for(temp1 = 1; temp1 <= num; temp1++){
			temp2 = num / temp1;
			if(temp1 * temp2 == num){
					str = str + temp1 + ", ";
				}
		}
		String[] str2 = str.split(", ");
		int[] factors = new int[str2.length];
		for(int x=0; x<str2.length; x++){
			factors[x] = Integer.parseInt(str2[x]);
		}
		return factors;
	}
}
