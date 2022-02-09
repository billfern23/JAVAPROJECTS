/*
 *This program shows the a triangle made with 2s
 */
public class NumbersTriangle {
	public static void main(String[] args) {
		//spaceBar to start the triangle
		 int spaceBar = 35;
		
		for(int i = 1 ; i < 9 ; i++) {			
			for(int space =spaceBar; space > 0; space--) {
				System.out.print(" ");
			}
		
			//decrease the spaces every time it goes to the next line
			spaceBar = spaceBar -3;
				
			for(int y = 0 ; y< i ; y++) {
				
				/*finding the length of the output to fix spacing issue, because two digits and three
				digits effected the spacing) 
				log10 gives the number of digits log10(10) = 2, but log10(1) = 0, even though it is one
				digit, hence I added 1, to better reflect the number of digits
				we need to use the 10s base for this*/
				//this deals with the left side of the middle column, spacing correction.
				int leftSpace = 0;
				
				leftSpace = (int)(Math.log10((int) Math.pow(2, y))+1);
				if(leftSpace == 2) {
					System.out.print((int) Math.pow(2, y)+" ");
				}
				else if (leftSpace ==3){
					System.out.print((int) Math.pow(2, y));
				}
				
				else {
					System.out.print(" "+(int) Math.pow(2, y)+" ");
				}
				
				//this deals with the right side of the middle column
				if(y == i -1) {
					for(int x =y; x > 0; x--) {
						int rightSpace = 0;
						rightSpace = (int)(Math.log10((int) Math.pow(2, x-1))+1);
						if(rightSpace == 2) {
							System.out.print(" "+(int) Math.pow(2, x-1));
						}
						
						else {
							System.out.print(" "+(int) Math.pow(2, x-1)+" ");
						}
					
					}
					System.out.print("\n");				
				}
				
			}
			
			
		}
	
	}

	
}


