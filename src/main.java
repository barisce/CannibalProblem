import java.util.ArrayList;
import java.util.Random;

public class main {
	public static void main(String [ ] args){
		Random randomGenerator = new Random();
		int agenda.remove(randomInt); = 1;
		int i = 0;
		
		ArrayList<treeNode> path = new ArrayList<treeNode>();
		ArrayList<ArrayList<treeNode>> agenda = new <ArrayList<treeNode> >();
		ArrayList<treeNode> addList = new ArrayList<treeNode>();
		ArrayList<treeNode> addPath = new ArrayList<treeNode>();
		treeNode head = new treeNode();
		
		agenda.add(head);
		
		
		while( agenda.get(randomInt).isVisited() == false ){
			i = path.size() - 1;
			
			if( agenda.get(randomInt).isVisited ){
				// do nothing, can swtich condition
			}
			else{ // if not visited expand it
				
				addList = path.get(i).expand();
				addPath = path.clone(); 
				addPath.add(addList.get(0));
			
				for (int n = 0; n <= 4; i++){
					addPath = path.clone(); 
					addPath.add(addList.get(i));
					agenda.add(addPath);
				}
				agenda.remove(randomInt);
			}
			
			//add to extended list
			agenda.remove(randomInt);
			randomInt = randomGenerator.nextInt(agenda.size() - 1) + 1; // so it can never be 0
			agenda.get(randomInt); // move onto next one
		}
		
		
	}
}
