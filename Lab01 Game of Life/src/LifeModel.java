import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Timer;

public class LifeModel implements ActionListener
{

	/*
	 *  This is the Model component.
	 */

	private static int SIZE = 60;
	private LifeCell[][] grid;

	LifeView myView;
	Timer timer;

	/** Construct a new model using a particular file */
	public LifeModel(LifeView view, String fileName) throws IOException
	{       
		int r, c;
		grid = new LifeCell[SIZE][SIZE];
		for ( r = 0; r < SIZE; r++ )
			for ( c = 0; c < SIZE; c++ )
				grid[r][c] = new LifeCell();

		if ( fileName == null ) //use random population
		{                                           
			for ( r = 0; r < SIZE; r++ )
			{
				for ( c = 0; c < SIZE; c++ )
				{
					if ( Math.random() > 0.85) //15% chance of a cell starting alive
						grid[r][c].setAliveNow(true);
				}
			}
		}
		else
		{                 
			Scanner input = new Scanner(new File(fileName));
			int numInitialCells = input.nextInt();
			for (int count=0; count<numInitialCells; count++)
			{
				r = input.nextInt();
				c = input.nextInt();
				grid[r][c].setAliveNow(true);
			}
			input.close();
		}

		myView = view;
		myView.updateView(grid);

	}

	/** Constructor a randomized model */
	public LifeModel(LifeView view) throws IOException
	{
		this(view, null);
	}

	/** pause the simulation (the pause button in the GUI */
	public void pause()
	{
		timer.stop();
	}

	/** resume the simulation (the pause button in the GUI */
	public void resume()
	{
		timer.start();
	}
	/** reseting the simulation (the reset button in the GUI*/
	public void reset()
	{
		timer.setCoalesce(false);
	}
	/** run the simulation (the pause button in the GUI */
	public void run()
	{
		timer = new Timer(50, this);
		timer.setCoalesce(true);
		timer.start();
	}

	/** called each time timer fires */
	public void actionPerformed(ActionEvent e)
	{
		oneGeneration();
		myView.updateView(grid);
	}

	/** main logic method for updating the state of the grid / simulation */
	private void oneGeneration()
	{

		for(int r = 0; r< grid.length ; r++ )
		{

			for(int c = 0; c< grid[r].length; c++)
			{

				int has=Neighbor_nearMe(r,c);
				if(has != 2 && has !=3)
				{
					grid[r][c].setAliveNext(false);
				}
				else
				{
					if(grid[r][c].isAliveNow())
					{
						if(has==2 || has == 3)
							grid[r][c].setAliveNext(grid[r][c].isAliveNow());
					}
					else if(has ==3)
						grid[r][c].setAliveNext(true);


				}
			}
		}


	
	for(LifeCell[] lc :grid)
	{
		for(LifeCell l :lc)
		{

			l.setAliveNow(l.isAliveNext());
		}
	}
}

//added method 
private int Neighbor_nearMe(int r,int c)
{
	int count=0;


	for(int y = r-1; y <= r+1;y++)
	{
		for(int x = c-1; x<= c+1; x++)
		{
			if(y<0 || x <0 || y>=grid.length || x>=grid[y].length ) continue;
			if(y == r && x == c) continue;
			else if(grid[y][x].isAliveNow())
			{	count++;}
		}
	}

	//	if(c>0)
	//		{
	//			if(grid[r][c-1].isAliveNow() )
	//			{
	//				count++;
	//			}
	//		}
	//		if(c<grid[r].length)
	//		{
	//			if(grid[r][c+1].isAliveNow())
	//				count++;
	//		}
//	System.out.println(count);
	return count;
}
}

