import java.util.ArrayList;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

public class BacktrakingProb 
{
	public static void main(String[] args) 
	{
//		printBinary(3);
		//climbStrairs(4);
		campSite(2,1);
	}
	public static void printBinary(int digit)
	{
		 BrinaryRuc(digit,"");
		 
	}
	
	private static void BrinaryRuc(int dig, String res)
	{
		if(res.length() ==dig && (res.contains("0") || res.contains("1")))
		{
			
			System.out.print(res+" ");
		}
		
		else
		{
			BrinaryRuc(dig, res +"0" );
//			System.out.println("branch out ");
			BrinaryRuc(dig, res+"1");
			
		}		
	}
	
	public static void climbStrairs(int cases)
	{
		climb(4,"");
	}
	
	private static void climb(int casses,String str)
	{
		if(casses <=0)
		{
			System.out.println(str);
			return;
		}
		climb(casses-1,str +" 1");
		if(casses-2 >=0)//check for boundry am i hitting than go back 
			climb(casses-2,str + " 2");
		return;
			
		}
	
	public static void campSite(int x,int y)
	{
		
		camp(x,y,"");
	}
	
	private static void camp(int x,int y,String map)
	{
		if(x<=0  &&  y<=0)
		{
	//		System.out.println(x +" " + y);
			System.out.println(map);
			return;
		}
		
		//System.out.println("current position (" + x+ " , " + y + ")");
		
		if(x-1>=0)//am i hiting a boundry then move side or diffrent location
		
			camp(x-1,y,map+" E");
//		System.out.println("2nd" + "(" + x+ " , " + y + ")");
		if(y-1>=0)
		{
			//System.out.println("going north current at  " + map);

			camp(x,y-1,map+" N");
			
			//System.out.println("we are back at " + map);
		}
//		System.out.println("3rd" + "(" + x+ " , " + y + ") " );
				
		if(x-1>=0 && y-1>=0)
			camp(x-1,y-1,map+" NE");
		return;
	}
	
	
	
}

