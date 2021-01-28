 import java.util.LinkedList;
import java.util.Queue;

public class Runner 
{
	public static void main(String[] args) 
	{
		QueueProb test = new QueueProb();
		int[] a =  {3,2,5,4,6,3}; 
		System.out.println(test. Sieve(10));	
	}
	
	public static  Queue<Integer> makeQ(int[] lst)
	{
		Queue<Integer> list =new LinkedList();
		
		for(int obj :lst)
		{
			list.offer(obj);
		}
		return list;
		
	}
	
}
