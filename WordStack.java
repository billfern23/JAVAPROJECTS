
public class WordStack {
	private String words;
	private char[] letterArray;
	private int length;

	private static int top = 1;
//	public void setWords(String words, int length) {
//		this.words = words;
//		this.length = length;
//		
//	
//	}
	
	
	
	public  WordStack(String words, int length) {
		words = words;
		this.length = length;
		this.top = length;
		letterArray = new char[length];
		}
	
	//pushes to the last one
	public void setPushone(char character) {
		top--;
//		System.out.print(letterArray[0]);
		letterArray[top] = character;
		
//		for(int i = 0; i < letterArray.length ; i++) {
//			
//			System.out.print(letterArray[i] + "\n");
//		}
		
	}
	
	public char getpopOne() {
		char onecharacter = letterArray[top++];
		//System.out.print("\n" + letterArray[0] + top);
		
		return onecharacter;
	}
	
	public char[] getLetterArray() {
		return letterArray;
		
		
	}
	public int getLength() {
		
		return length;
	}

	public static int getTop() {
		return top;
	}
	
	
	
}

	
//	public set
//		//System.out.print(words);
//	}
	
//	public String getWords() {
//		return this.words;
//	}
//	
//	public int getLength() {
//		return length;
//	}
//
//	public void setLength(int length) {
//		this.length = length;
//	}
//
//	public void setLetterArray(String words, char[] letterArray) {
//		for(int i = 0; i < this.getLength() ; i++) {
//			System.out.print(letterArray.length);
//		}
//		
//		
//		
//	}


