import java.util.Stack;

public class Runner 
{
	public static double sumReciprocal(int n)
	{
		if(n ==1)
			return 1;
		
		return (double)1/n + sumReciprocal(n-1); 
	}
	
	public static int productOfEven(int n)
	{
		
		return products(1,n,2);
		
	}
	private static int products(int index,int n,int current)
	{
		if(index ==n)
			return current;
		return current * products(index+1,n,current+2);
		
	}
	
	//future
	
	public static void doubleUp(Stack<Integer> nums)
	{
			//TODO
		if(nums.size() ==1)
			nums.push(nums.peek());
		else
		{
			int s = nums.pop();
			doubleUp(nums);
			nums.push(s);	
			nums.push(s);
			
			System.out.println(nums.toString());
		}
					
	}
	
	public static void countToBy(int n,int m)
	{
		if(n-m <0)
			System.out.print(n + ", ");
	
		else
		{
			countToBy(n-m, m);
			System.out.print(n+", ");
		}
			
		
	}
	
	public static int matchingDigits(int a, int b)
	{
		if(a ==b)
		{
			return 1;
					
		}
		else if(a%10 ==a || b%10 ==b)
			return -1;
		return 1+matchingDigits(a%10, b%10);
	}
	
	
	public static void prinntThis(int n)
	{
		double s = n%2;
		printRec(n,s==0);
	}
	
	private static void printRec(int n, Boolean b)
	{
		if(n ==1)
		{
			if(b)
				System.out.print("* * ");
			else
				System.out.print("* ");
		}
		
		else
			System.out.print('<'); prinntThis(n-1);System.out.print('>');
	}
	
	
	public static void printNums2(int n)
	{
		if(n ==1)
			System.out.print("1"+' ');
		else
		{
		printNums2(n-1); System.out.print(n +" ");
		}
	}
	public static void main(String[] args) {
		double s = sumReciprocal(10);
		Stack<Integer> nums = new Stack<>();
		nums.push(1);
		nums.push(4);
		nums.push(5);
		nums.push(8);
		doubleUp(nums);
//		countToBy(25,4);
//		printNums2(1);
	//	prinntThis(2);
//		System.out.println();
//		printNums2(2);
//		System.out.println();
//		printNums2(3);
//		System.out.println();
//		printNums2(4);
	}
}
