import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph 
{
	private int E,V;
	private int S,D;
	static Vertex start,destination; 
	private  Vertex[] vertexs;
	public Graph(String fileName)
	{
		
		Scanner rec = null;
		try
		{
			rec = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("file not found");
			 
		}
		V = rec.nextInt();
		E = rec.nextInt();
		rec.nextLine();
		vertexs =  new Vertex[V];
	
		for(int i =0; i<V;i++)
		{
			int id = rec.nextInt(); 
			vertexs[id] = new Vertex(id,rec.nextInt(),rec.nextInt());
		}
		rec.nextLine();
		for(int i =0; i<E;i++)
		{
				vertexs[rec.nextInt()].add(rec.nextInt());
			
		}
		rec.nextLine();
		S = rec.nextInt();
		D = rec.nextInt();
	}
	
	public double distance(int s,int v)
	{
		return vertexs[s].distance(vertexs[v]);
	}
	
	public Vertex[] getV() {return vertexs;}
	public int getS() {return S;	}
	public int getD() {return D;}
	@Override
	public String toString()
	{
		String str ="";
		for(Vertex v :vertexs)
		{
			str+= v.toString();
			str +="\n";
		}
		return str;
	}
}
