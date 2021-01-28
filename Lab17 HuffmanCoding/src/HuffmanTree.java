import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.Other;

	final class Node implements Comparable<Node> 
	{
		int weight; 
		Node left, right;
		Character val; 
		/**
		 * initializer 
		 */
		public Node(char val,int weight, Node left, Node right)
		{
			this.weight = weight;
			this.left  = left;
			this.right  = right;
			this.val = val;
			
		}
		
		public Node(char val,int w)
		{
			this(val,w,null,null);
		}
		
		public Node(int w )
		{
			this((Character) null,w);
		}
	
		/**
		 * comparing the nodes for ordering
		 */
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return weight - o.weight;
		}
	
		@Override
		public String toString()
		{
			String s = "";
			if(val != null)
				s+=val +" ";
			else
				s+= weight;
			return s;
		}
		
		
		
	}
public class HuffmanTree 
{
	public HashMap<Character,String>table;
    private	Node Toproot;
    private String binary;
	public HuffmanTree(int[] count)
	{
		
		/*
		 *find the  frequent used 
		 *add them first then the rare
		 * 
		 */
		 
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i =0; i<count.length; i++)
		{
			Node n = new Node((char)i, count[i]);
			pq.add(n);
		}
		System.out.println("test the order" + "\n" + pq.toString());//testing purposes
		/*
		 * merging to tree
		 */
		
		Node n;
		while(pq.size() >1)
		{
			Node a = pq.poll();
			Node b = pq.poll();
			int comb = b.weight + a.weight;
			 n = new Node((char)comb,comb);
			n.left = a;
			n.right =b;
			//n= n.left;
			
			pq.offer(n);
			
		}
	}
	
	public HuffmanTree(String codeFile)
	{
		Scanner rec = null;
		try
		{
			rec = new Scanner(new File(codeFile));
		}catch(FileNotFoundException e)
		{
			e.getStackTrace();
		}
		
		while(rec.hasNext())
		{
			int n = Integer.parseInt(rec.nextLine());
			String code = rec.nextLine();
			
			Node root = Toproot;
			for(int i =0; i<code.length();i++)
			{
				if(code.substring(i, i+1).equals("0"))
				{
					root = root.left;
				}
				else
					root = root.right;
			}
			root = new Node((char)n, 0);
		}
		
	}
	
	public void decode(BitInputStream in , String outFile)
	{
		BitOutputStream bitout = new BitOutputStream(outFile);
		MAIN: while(true)
		{
			int first = in.readBit();
			Node node = first==0 ? Toproot.left : Toproot.right;
			while(true)
			{
				if(node.left ==null && node.right ==null)
				{
					if(node.val == (char)256)
					{
						break MAIN;
					}
					bitout.writeBit((int)node.val);
					break;
				}
				node = in.readBit() ==0 ? node.left : node.right;
				
			}
					
		}
		in.close();
		bitout.close();
			
	}
	
	private  PrintWriter ds;
	public  void write(String fileName)
	{
		Scanner rec = null;
		String s = fileName.substring(0,fileName.indexOf('.'));
		 ds =null;
		try {
			ds = new PrintWriter(s+".code");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try
		{
			rec = new Scanner(new File(fileName));
		}catch(FileNotFoundException e)
		{
			e.getStackTrace();
		}
		
		int[] count = new int[256];
		table  = new HashMap<>();
		while(rec.hasNext())
		{
			char[] c = rec.next().toCharArray();
			for(char ch : c)
			{
				table = Write(ds,Toproot,ch,"",table);
				ds.println();
			}
		
		
		}

		ds.close();
		try {
			rec = new Scanner(new File(s+".code"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(rec.hasNext())
		{
			binary +=rec.nextLine(); 
		}
		rec.close();
		
	
	}
	@Override
	public String toString() { return binary;}
	
	public PrintWriter getFile() {return ds;}
	
	private HashMap<Character,String> Write(PrintWriter w,Node n,char c,String str,HashMap<Character,String>t)
	{
		if(t.containsKey(c))
			{
				w.println((int)c);
				w.print(t.get(c));
				return t;
			}
		if(n.val ==c && n.left ==null && n.right == null)
		{
			w.println((int)c);
			w.print(str);
			t.put(c, str);
			return t;
		}
		else
		{
			if(n.left !=null)
				return Write(w,n.left,c,str+="0",t); binary += 0;
			if(n.right != null)
				return Write(w,n.right,c,str+="1",t);
		
		}
		return t;
	}
	
	
	
}


