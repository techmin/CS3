public class FireModel
{
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;

    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

    /*
        recursiveFire method here
     */

    public void solve()
    {
        // student code here
        myView.updateView(myGrid);
    }
    
    public void Start(int row,int col) {
    	Spred(row,col);
    	solve();
    }
    private  void Spred(int row , int col)
    {
    	if(myGrid[row][col].getStatus() == 0)
    		return;
    	if(myGrid[row+1][col].isTree())
    	{
    		myGrid[row+1][col].setFire();
    		Spred(row+1,col);
    	}
    	if(myGrid[row][col+1].isTree())
    	{
    		myGrid[row][col+1].setFire();
    		Spred(row,col+1);
    		
    	}
    	if(myGrid[row-1][col].isTree())
    	{
    		myGrid[row-1][col].setFire();
    		Spred(row-1,col);
    	}
    	if(myGrid[row][col-1].isTree())
    	{
    		myGrid[row][col-1].setFire();
    		Spred(row, col-1);
    	}
    	
    }
    
    

}
