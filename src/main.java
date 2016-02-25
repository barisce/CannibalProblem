import java.util.ArrayList;
import java.util.Random;

public class main {
	
	
	public static void main(String [ ] args)
	{
		ArrayList<treeNode> path = new ArrayList<treeNode>();
		
		Random randomGenerator = new Random();
		treeNode main = new treeNode();
		treeNode head = main; // to bookmark root node
		path.add(head);
		while (main.isFail() || main.isFound())
		{
			int randomInt = randomGenerator.nextInt(5);
			if (checkVisited(path, main.expand(randomInt)))
			{
				//not possible to go to randomInt
			}
			else
			{
				main.setX(main.expand(randomInt));
				main = main.expand(randomInt);
				path.add(main);
			}
		}
		
		if (main.isFound())
		{
			System.out.println("Found!");
		}
		else
		{
			System.out.println("Not Found!");
		}
	}
	
	public static boolean checkVisited(ArrayList<treeNode> extendedList, treeNode node){
		for (int i = 0; i < extendedList.size(); i++)
		{
			if (extendedList.get(i).compare(node))
			{
				return true;
			}
		}
		return false;
	}
}
