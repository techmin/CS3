import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Melody {
	private Queue<Note> notes;
	
	public Melody(Queue<Note> song)
	{
		notes = song; 
	}
	/**]
	 * the total of notes duration 
	 * @return total duration 
	 */
	public double getTotalDuration()
	{
		double tot = 0.0;
		Queue<Note> temp = notes;
		do
		{
			Note n = temp.poll();
			if(n.isRepeat())
			{
				tot += (n.getDuration())*2;
			}
			else
				tot+= n.getDuration();
			
		}while(!temp.isEmpty());
		
		return tot;
	}
	/**
	 * printing the notes 
	 */
	public String toString ()
	{
		String str = "";
		Queue<Note> temp = notes; 
		do
		{
			str+= temp.poll().toString() +"\n";
		}while(!temp.isEmpty());
		return str; 
	}
	/**]
	 * changing the tempo of the list of notes to tempo give 
	 *
	 * @param tempo
	 */
	void changeTempo(double tempo)
	{
		Queue<Note> temp = new LinkedList();
		do
		{
			Note n = notes.poll();
			n.setDuration(n.getDuration()*tempo);
			temp.offer(n);
			
		}while(!notes.isEmpty());
		notes = temp;
	}
	
	void reverse()
	{
		Stack<Note> n = new Stack();
		
		while(!notes.isEmpty())
		{
			n.push(notes.poll());
		}
		
		while(!n.isEmpty())
		{
			notes.offer(n.pop()); 
		}
	}
	void append(Melody other )
	{
		Queue<Note> ad = other.getNotes(); 
		while(!ad.isEmpty())
		{
			notes.offer(ad.poll()); 
		}
	}
	
	void play()
	{
			
		while(!notes.isEmpty())
		{
			if(notes.peek().isRepeat())
			{
				notes.peek().play();
				notes.poll().play();
			}
			else
				notes.poll().play();
		}
	}
	
	Queue<Note> getNotes(){return notes;}
	
}
