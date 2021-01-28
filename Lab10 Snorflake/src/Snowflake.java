import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel
{
	public SnowFlakePanel()
	{
		super.setPreferredSize(new Dimension(400, 400));
		super.setBackground(Color.WHITE);
	}

	public void paintComponent(Graphics g)
	{
		int width  = getWidth();
		int height = getHeight();

		super.paintComponent(g);

		/*
		 * DRAWING CODE BELOW
		 */
		g.setColor(Color.BLUE);
		//SnowFlake.drawStar(g,20,50,10);
		drawStar(g, width/2, height/2, 50);
		starRec(g,width/2,height/2,50,6);
	//	hangingRec(g,width/2,height/2,100,1);
	}
	public static void drawStar(Graphics g, int x , int y, int size)
	{
		for(int i =0; i<6;i++)
		{
			double angle = (i*(2*Math.PI)/6);
			int X= x-(int)(size*Math.cos(angle));
			int Y =  y-(int)(size*Math.sin(angle));
			g.drawLine(x,x, X,Y );
	
		}
	}
	public static void starRec(Graphics g, int x, int y,int size ,int  side)
	{
		if(side ==1)
			drawStar(g, x, y, size);
		else
		{
			side--;
			hangingRec(g, x, y, size,side );
			double angle = (side*(2*Math.PI)/6);
			int X= x-(int)(size*Math.cos(angle));
			int Y =  y-(int)(size*Math.sin(angle));
			drawStar(g, X, Y, size);
		}	

	}
	public static void hangingRec(Graphics g,int x,int y,int size, int side)
	{
		if(side ==6)
			drawStar(g, x, y, size);
		else
		{
			side++;
			hangingRec(g, x, y, size,side );
			double angle = (side*(2*Math.PI)/6);
			int X= x-(int)(size*Math.cos(angle));
			int Y =  y-(int)(size*Math.sin(angle));
			drawStar(g, X, Y, size);
		}	
	}
}



public class Snowflake
{
	public static void main ( String[] args )
	{
		/*
		 * A frame is a container for a panel
		 * The panel is where the drawing will take place
		 */
		JFrame frame = new JFrame("Snowflake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SnowFlakePanel());
		frame.pack();
		frame.setVisible(true);
	}
	
	
}
