
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
	
	public crossRiver treeNode( int c, int m){ // c or m <=2 && c+m <= 2 && c + m > 0
		int cNew = 0;
		int mNew = 0;
		
		if( boat){
			cNew = this.c - c;
			mNew = this.m - m;
			return treeNode( cNew, mNew, false);
		}
		else{
			cNew = this.c + c;
			mNew = this.m + m;
			return treeNode( cNew, mNew, false);
		}
	}
	
	public boolean isFail(){
		
		if ( (Math.abs(c - m ) > 0 ) && (c!= 0) && (m!= 0))
			return true;
	}
	
}


	public void expand(){
		if ( this.isFail() || this.isVisited() )
			return;
		else {
			x = crossRiver(2, 0);
			y = crossRiver(1, 1);
			z = crossRiver(1, 1);
			t = crossRiver(0, 1);
			k = crossRiver(0, 2);
			return; // return childList shallow copy childList.clone()
		}
	}
	
	public void checkVisited(ArrayList<treeNode> extendedList){
		// check the iterator shits
		// compare and shit
	
		
	}
	
	public boolean compare( treeNode extendedNode){
		if ( ( extendedNode.getC() == this.c) && ( extendedNode.getM() == this.m) && (extendedNode.isBoat() == this.boat) )
			return true;
		else
			return false;
	}