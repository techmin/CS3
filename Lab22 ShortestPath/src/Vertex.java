import java.awt.List;
import java.util.ArrayList;

public  class Vertex<E extends Comparable<E>> implements Comparable<Vertex<E>>
{
	private int X;
	private int Y;
	int ID;
	private boolean visit =false;
	private int by;
	public E data;
	double cost = Double.POSITIVE_INFINITY;
	private ArrayList<Integer> adj = new ArrayList();
//	ArrayList<Vertex> adj = new ArrayList<>();
	
	public Vertex(int I,int x,int y)
	{
		this.ID = I;
		this.X = x;
		this.Y =y;
	}
	
	public void add(int i)
	{
		adj.add(i);
	}
	public int getX() {return X;}
	public int getY() {return Y;}
	public double distance(Vertex v)
	{
		return Math.sqrt(Math.pow(v.getX()-X, 2)+Math.pow(v.getY()-Y, 2));
	}
	@Override
	public int compareTo(Vertex<E> v )
	{
		E otherData = v.data;
		return this.data.compareTo(otherData);
	}

	public boolean getVisit() {return visit;}
	public void Visited()
	{
//		by = cb;
	visit = true;}
	public int from() {return by;}
	public ArrayList<Integer> getAdj(){return adj;}
	@Override
	public String toString()
	{
		return ID +":"  +"(" +X +"," +Y+") "+"\n"+ " cost " + cost;
	}

}
