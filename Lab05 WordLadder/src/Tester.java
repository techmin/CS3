
public class Tester {
	public static void main(String[] args) {
		WordLadder test = new WordLadder("cat","bat"); 
		
		test.dictionay("dictionary.txt");
		test.checkCommon();
		System.out.println("the ladder" + test.toString()); 
		
	}
}
