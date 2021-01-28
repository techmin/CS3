import java.util.PriorityQueue;

public class Dijkstra 
{
	private Graph graph;
	private Vertex[] node;
	public Dijkstra(Graph graph)
	{
		
		this.graph = graph;
		node = graph.getV();
	}
	
	public double distance(int source , int destination)
	{
//		return graph.distance(source, destination);
		double ct = System.currentTimeMillis();
		dijkstra(source, destination);
		return ct - System.currentTimeMillis();
	}
	
	
	private void dijkstra(int s, int d)
	{
		PriorityQueue<Vertex> pq = new PriorityQueue();
		
		Vertex current = node[s];
		pq.offer(current);
		while(!pq.isEmpty())
		{
			current = pq.poll();
			for(int i =0; i<current.getAdj().size();i++)
			{
				if(node[(int) current.getAdj().get(i)].cost > current.cost)
					node[(int) current.getAdj().get(i)].cost  =  current.distance(node[(int) current.getAdj().get(i)]) + current.cost;
				if(pq.contains(node[(int) current.getAdj().get(i)] ))
					pq.add(node[(int) current.getAdj().get(i)]);
			}
			
			current.Visited();
			
			System.out.println(current.cost);
//			if(pq.peek().cost> current.cost)
//			{
//				pq.peek().cost = current.distance(pq.peek()) + current.cost;
//			}
			 
			
		}
		
		
		
	}
	
	public static void main(String[] args) {
		Graph g = new Graph("input6.txt");
			Dijkstra D = new Dijkstra(g);
		double time =	D.distance(g.getS(),g.getD() );
	}
}
