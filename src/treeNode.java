public class treeNode {
	private boolean visited;
	private boolean boat; //if false boat is going left if true boat is going right. Or true = boat is left side, false = boat is right side 
	private int m;	// missionaries on left side, right side missionaries = 3 - m
	private int c;	// cannibals on left side, right side cannibals = 3 - c
	private treeNode x;

    public treeNode () { 
    	m = 3;
    	c = 3;
    	boat = false;
    	visited = false;
        x = null;
    } 
    
    public boolean isBoat() {
		return boat;
	}

	public void setBoat(boolean boat) {
		this.boat = boat;
	}

	public treeNode (int m, int c) { 
        this.m = m;
        this.c = c;
        boat = false;
        visited = false;
        x = null;
    }
	
	public treeNode (int m, int c, boolean boat) { 
        this.m = m;
        this.c = c;
        this.boat = boat;
        visited = false;
        x = null;
    }

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public treeNode getX() {
		return x;
	}

	public void setX(treeNode x) {
		this.x = x;
	}

	public treeNode crossRiver( int c, int m){ // c or m <=2 && c+m <= 2 && c + m > 0
		int cNew = 0;
		int mNew = 0;
		
		if( boat){
			cNew = this.c + c;
			mNew = this.m + m;
			return new treeNode( cNew, mNew, false);
		}
		else{
			cNew = this.c - c;
			mNew = this.m - m;
			return new treeNode( cNew, mNew, true);
		}
	}
	
	public boolean isFail()
	{
		if ( (c - m  > 0 ) && (c!= 0) && (m!= 0))
		{
			return true;
		}
		return false;
	}
	
	public boolean isFound()
	{
		if (this.getC() == 0 && this.getM() == 0)
			return true;
		else
			return false;
	}

	public treeNode expand(int i)
	{
		
		/*if ( this.isFail() || this.isVisited() )
			return null;*/
		if ( i == 0 )
		{
			x = crossRiver(2, 0);
			return x;
		}
		if ( i == 1 )
		{
			x = crossRiver(1, 0);
			return x;
		}
		if ( i == 2 )
		{
			x = crossRiver(1, 1);
			return x;
		}
		if ( i == 3 )
		{
			x = crossRiver(0, 1);
			return x;
		}
		if ( i == 4 )
		{
			x = crossRiver(0, 2);
			return x;
		}
		return null;
	}
	
	//compares two treeNodes that if they are the same or not
	public boolean compare( treeNode extendedNode){
		if ( ( extendedNode.getC() == this.c) && ( extendedNode.getM() == this.m) && (extendedNode.isBoat() == this.boat) )
			return true;
		else
			return false;
	}
}