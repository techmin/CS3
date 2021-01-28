import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A model for the game of 20 questions
 *
 * @author Rick Mercer
 */
public class GameTree
{
	private Node TopRoot;
	private Node current;
	private String fileName;
	private class Node
	{
		String data;
		Node yes;
		Node no;
		boolean awnser;
		public Node(String d,Node y,Node n)
		{
			data =d;
			if(data.substring(data.length()-1,data.length()).equals("?"))
				{
					awnser =false;
					
		
				}
			else
				awnser = true; 
		
			yes = y;
			no =n;
		}
		public Node(String d)
		{
			this(d,null,null);
		}
	}
	/**
	 * Constructor needed to create the game.
	 *
	 * @param fileName
	 *          this is the name of the file we need to import the game questions
	 *          and answers from.
	 */
	public GameTree(String fileName)
	{
		
		Scanner rec = null;
		try 
		{
			this.fileName = fileName;
			rec = new Scanner(new File(fileName));
			
		} catch(FileNotFoundException e )
		{
			System.out.println("file not found");
			e.getMessage();
		}
		
		TopRoot = new Node(rec.nextLine().trim());
		current = TopRoot;
		recurssiveIntial(TopRoot, rec);
		
	}
	
	private void recurssiveIntial(Node root,Scanner sc)
	{
		if(!sc.hasNext())
		{
			return;
		}
		if(root.awnser)
			{
			
				return;
			}
		if(root !=null)
		{
			root.yes = new Node(sc.nextLine());
		//	System.out.println("yes is" + root.yes.data);
			recurssiveIntial(root.yes, sc);
			root.no = new Node(sc.nextLine());
			//System.out.println("no is " + root.no.data);
			recurssiveIntial(root.no, sc);
		//	System.out.println(root.no.data);
			
			//System.out.println(root.yes.data );

			
		}
	}

	/*
	 * Add a new question and answer to the currentNode. If the current node has
	 * the answer chicken, theGame.add("Does it swim?", "goose"); should change
	 * that node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken  horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQ
	 *          The question to add where the old answer was.
	 * @param newA
	 *          The new Yes answer for the new question.
	 */
	public void add(String newQ, String newA)
	{
		//TODO
		
		Node c = current; 
		current.data = newQ;
		current.yes = new Node(newA);
		current.no = c;
		
		
	}

	/**
	 * True if getCurrent() returns an answer rather than a question.
	 *
	 * @return False if the current node is an internal node rather than an answer
	 *         at a leaf.
	 */
	public boolean foundAnswer()
	{
		//TODO
		

		return current.awnser; //replace
	}

	/**
	 * Return the data for the current node, which could be a question or an
	 * answer.  Current will change based on the users progress through the game.
	 *
	 * @return The current question or answer.
	 */
	public String getCurrent()
	{
		
		return current.data; //replace
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or
	 * right for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 *
	 * @param yesOrNo
	 */
	public void playerSelected(Choice yesOrNo)
	{
		if(yesOrNo == Choice.Yes)
			current = current.yes;
		else
			current = current.no;
	}

	/**
	 * Begin a game at the root of the tree. getCurrent should return the question
	 * at the root of this GameTree.
	 */
	public void reStart()
	{
		
		current = TopRoot;
	}

	@Override
	public String toString()
	{
		
			
		return print(TopRoot,"");
	}
	
	private String print(Node root, String str)
	{
		String output ="";
		
		if(root != null)
		{
			output += "-"+ print(root.yes,str);
			output += root.data +"\n";
			output += "-"+print(root.no,str);
		}
		return output; 
	
		
	}

	/**
	 * Overwrite the old file for this gameTree with the current state that may
	 * have new questions added since the game started.
	 *
	 */
	public void saveGame()
	{
		//TODO
		String outFileName = "output.data";
		PrintWriter diskFile = null;
		
		try
		{
			diskFile = new  PrintWriter(new File(outFileName));
			
		}
		catch(IOException io)
		{
			System.out.println("could not make " + outFileName);
		}
		
		
		save(TopRoot,diskFile);
		
	}
	
	private void save(Node root, PrintWriter pw)
	{
		if(root == null)
			return;
		
		pw.println(root.data);
		save(root.yes,pw);
		save(root.no,pw);
	}
}
