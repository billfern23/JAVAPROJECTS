import java.util.Scanner;

public class Pallindrome {
	public static void main(String [] args) {
		// find number of arrays passed in
		int count = args.length;
		/* convert the arguments recieved one by one to an object since s[i] cannot be used
		  to create an object, this thing thinks it an array, which its not, was trying to name it.*/
		
		
		for (int i = 0; i < args.length ; i++) {
			int lengthOfArgument = 0;
			lengthOfArgument = args[i].length();
			String revers = "";
			WordStack s  =  new WordStack(args[i], lengthOfArgument);
			for (int j = 0; j < lengthOfArgument ; j++) {
							s.setPushone(args[i].charAt(j));
					
			}
			 while(s.getTop() != s.getLength()) {
				 revers += s.getpopOne();
			 }
			 System.out.print(revers + "\n");
			 
			 
//			s.setLetterArray(args[i]);
			
			//for()
			//char test = s.getpopOne();
			//System.out.print("\n" + s.getpopOne());
		}
		
	
		
			
			
			
			//System.out.print(args.length);
			
			
		
	}
	
	
	

}
