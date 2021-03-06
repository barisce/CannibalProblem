import java.util.ArrayList;

public class treeNode {
	private boolean visited;
	private boolean boat; //if false boat is going left if true boat is going right. Or true = boat is left side, false = boat is right side 
	private int m;	// missionaries on left side, right side missionaries = 3 - m
	private int c;	// cannibals on left side, right side cannibals = 3 - c
	private treeNode x, y, z, t, k; 
	private ArrayList<treeNode> childList;

    public treeNode () { 
    	m = 3;
    	c = 3;
    	boat = false;
    	visited = false;
        x = null;
        y = null;
        z = null;
        t = null;
        k = null; 
		childList = new ArrayList<treeNode>(5);
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
        y = null;
        z = null;
        t = null;
        k = null;
        childList = new ArrayList<treeNode>(5);
    }
	
	public treeNode (int m, int c, boolean boat) { 
        this.m = m;
        this.c = c;
        this.boat = boat;
        visited = false;
        x = null;
        y = null;
        z = null;
        t = null;
        k = null;
        childList = new ArrayList<treeNode>(5);
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

	public treeNode getY() {
		return y;
	}

	public void setY(treeNode y) {
		this.y = y;
	}

	public treeNode getZ() {
		return z;
	}

	public void setZ(treeNode z) {
		this.z = z;
	}

	public treeNode getT() {
		return t;
	}

	public void setT(treeNode t) {
		this.t = t;
	}

	public treeNode getK() {
		return k;
	}

	public void setK(treeNode k) {
		this.k = k;
	} 
	
	public treeNode crossRiver( int c, int m){ // c or m <=2 && c+m <= 2 && c + m > 0
		int cNew = 0;
		int mNew = 0;
		
		if( boat){
			cNew = this.c - c;
			mNew = this.m - m;
			return new treeNode( cNew, mNew, false);
		}
		else{
			cNew = this.c + c;
			mNew = this.m + m;
			return new treeNode( cNew, mNew, true);
		}
	}
	
	public boolean isFail()
	{
		if ( (Math.abs(c - m ) > 0 ) && (c!= 0) && (m!= 0))
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

	public ArrayList<treeNode> expand()
	{
		if ( this.isFail() || this.isVisited() )
			childList.clear();
		else 
		{
			x = crossRiver(2, 0);
			y = crossRiver(1, 0);
			z = crossRiver(1, 1);
			t = crossRiver(0, 1);
			k = crossRiver(0, 2);
			childList.add(x);
			childList.add(y);
			childList.add(z);
			childList.add(t);
			childList.add(k);
		}
		return childList;
	}
	
	//compares two treeNodes that if they are the same or not
	public boolean compare( treeNode extendedNode){
		if ( ( extendedNode.getC() == this.c) && ( extendedNode.getM() == this.m) && (extendedNode.isBoat() == this.boat) )
			return true;
		else
			return false;
	}
	
	//returns the visited child node since only one child can be visited per run
	private treeNode getVisitedChild()
	{
		if (this.getX().visited)
			return this.x;
		if (this.getY().visited)
			return this.y;
		if (this.getZ().visited)
			return this.z;
		if (this.getT().visited)
			return this.t;
		if (this.getK().visited)
			return this.k;
		return this;
	}
	
	public String toString(treeNode node)
	{
		String result = "";
		while (!node.getVisitedChild().compare(node))
		{
			result += "C = " + node.getC() + "M = " + node.getM() + "Boat position = " + node.isBoat() + "\n";
			node = node.getVisitedChild();
		}
		return result;
	}
}