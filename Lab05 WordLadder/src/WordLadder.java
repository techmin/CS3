import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class WordLadder 
{
	private String firstword;
	private String endword;
	private Queue<Stack<String>> ladder;
	ArrayList<String>library; 
	public WordLadder(String firstword,String endword)
	{
			this.firstword = firstword;
			this.endword = endword;
			if(firstword.length() != endword.length())
				System.out.println(" not same length try again");
			ladder = new LinkedList(); 
			 library = new ArrayList<>();
	}
	/**
	 * reading the dictionary.txt and storing into a List
	 * @param filename
	 */
	public void dictionay(String filename)
	{
		
	
		try {
			Scanner rec = new Scanner(new File(filename));
			while(rec.hasNext())
			{
				library.add(rec.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * list of same length and find all the common that have the same kind of word; 
	 */
	public void checkCommon()
	{
		Stack<String> options = size(firstword.length());//simmlar length
		/*
		 * go through the stack of same length 
		 * compare each char of the time 
		 * if the char the same for first and end then keep
		 *  
		 * add stack to library as moving through the word char  
		 */
		Stack<String> dc = new Stack(); //differ
		Queue<Stack> list = new LinkedList();
		 
		dc.push(firstword);
		while(!options.isEmpty())
		{
			Stack<String> differcom = new Stack<>();	
//			System.out.println("first " + firstword);
//			System.out.println("in the stack " + differcom.peek());
			boolean isdouble = false; 
//			differcom.push(dc.pop());
			differcom = dc; 
			for(int ind =0; ind<firstword.length();ind++)
			{
				if(options.peek().contains(differcom.peek().substring(ind, ind+1)))
				{
					//System.out.println(differcom.peek() + " compare to " + options.peek());
					for(int i = ind+1; i<firstword.length();i++)
					{
						if(options.peek().contains(differcom.peek().substring(ind, ind+1)))
							isdouble=true; 
					}
					
				}
			}
			if(isdouble)
					options.pop();
			else
				differcom.push(options.pop());
			System.out.println("peeking "+differcom.peek());
			try
			{
				
				if(differcom.peek().equalsIgnoreCase(dc.peek()))
				{
					ladder.offer(differcom);
					dc = differcom; 
					System.out.println("dc " + dc.peek() + "dffck " + differcom.peek());
				}
				if(ladder.peek().peek().equalsIgnoreCase(endword))
					options.clear();
//				if(differcom.peek().equalsIgnoreCase(endword) || if())
//				{
//					
//					System.out.println(differcom.peek() + "= " + endword);
//					ladder.offer(differcom);
//					options.clear();
//					
//					System.out.println("em");
//					//differcom.clear(); 
//				}
			
			}catch(EmptyStackException e )
			{
				e.getMessage();
				options.clear(); 
			}
			
			
			  
		}
		
		
		
	}
	private Stack<String> size(int len)
	{
		Stack<String> w = new Stack<>(); 
		
		for(String s : library)
		{
			
			if(s.length() == len)
			{
			//	System.out.println("the length "+len +"the word" + s);
				
				w.push(s);
			}
		}
		return w; 
	}
	@Override
	public String toString()
	{
		
		return ladder.peek().toString(); 
	}
	
}
