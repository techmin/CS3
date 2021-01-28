
import java.util.LinkedList;
import java.util.Queue;
public class QueueProb 
{
	public  Queue<Integer> evenFirst(Queue<Integer>  num)
	{
		Queue<Integer> odds = new LinkedList<>();
		Queue<Integer> list = new LinkedList<>();
		
		while(!num.isEmpty())
		{
			if(num.peek()%2 ==0)
			{
				list.offer(num.poll());
			}
			else
				odds.offer(num.poll());
		}
		
		while(!odds.isEmpty())
		{
			list.offer(odds.poll());
		}
		
		return list;
	}
	
	public Queue<Integer> Sieve(int n)
	{
		Queue<Integer> prime = new LinkedList<>();
//		prime.offer(i);
		Queue<Integer> numbers = new LinkedList<>();
		//adding from 2 to n into queue 
		for(int s =2; s <n; s++)
		{
			numbers.offer(s);
		}
		System.out.println("the list " + numbers.toString());
		while(!numbers.isEmpty())
		{
			if(numbers.peek() ==2)
			{
				prime.offer(numbers.poll());
				int p = prime.peek();
				Queue<Integer> options = new LinkedList();
				for(int i = numbers.peek(); i<numbers.size();i++)
				{
					
					if(i%p==0)
					{
						numbers.poll(); 
					}
					else
						options.offer(numbers.poll());
						
				}
				numbers =transfer(options); 
				System.out.println("the list after 2 " + numbers.toString());
				
			}
			else
			{
				int p = numbers.poll();
				prime.offer(p);
				
				Queue<Integer> options = new LinkedList();
				for(int i = numbers.peek(); i<numbers.size();i++)
				{
					
					if(i%p==0)
					{
						numbers.poll(); 
					}
					else
					{
						System.out.println("i : " + i +" the list " +numbers);
						options.offer(numbers.poll());
					}
						
				}
				numbers =transfer(options);
			}
			
		}
		
		return prime;
		
		
	}
	private Queue<Integer> transfer( Queue<Integer> frm)
	{
		Queue<Integer> to = new LinkedList();
		while(!frm.isEmpty())
		{
			to.offer(frm.poll());
		}
		return to;
	}
}
