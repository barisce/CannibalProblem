
public class treeNode {
	private boolean visited;
	private int m;
	private int c;
	private treeNode x, y, z, t, k; 

    public treeNode () { 
    	m = 3;
    	c = 3;
    	visited = false;
        x = null;
        y = null;
        z = null;
        t = null;
        k = null; 
    } 
    
    public treeNode (int m, int c) { 
        this.m = m;
        this.c = c;
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
	
}
