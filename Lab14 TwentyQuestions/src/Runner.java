
public class Runner 
{
	public static void main(String[] args) {
		GameTree test  = new  GameTree("animals.txt");
		//System.out.println(test.toString());
		test.playerSelected(Choice.Yes);
		test.playerSelected(Choice.Yes);
		System.out.println(test.getCurrent());;
	}
}
