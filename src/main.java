import java.util.ArrayList;
import java.util.Random;

public class main {
	
	
	public static void main(String [ ] args)
	{
		ArrayList<treeNode> path = new ArrayList<treeNode>();
		boolean found;
		Random randomGenerator = new Random();
		treeNode main = new treeNode();
		treeNode head = main; // to bookmark root node
		path.add(head);
		do
		{
			found = false;
			int randomInt = randomGenerator.nextInt(5);
			if (checkVisited(path, main.expand(randomInt)))
			{
				main.setX(null);
				for (int j = 0; j < 4; j++)
				{
					randomInt = (randomInt + 1) % 5;
					if (!checkVisited(path, main.expand(randomInt)))
					{
						found = true;
						break;
					}
					main.setX(null);
				}
				if (found)
				{
					main.setX(main.expand(randomInt));
					main = main.expand(randomInt);
					path.add(main);
				}
			}
			else
			{
				main.setX(main.expand(randomInt));
				main = main.getX();
				path.add(main);
			}
			if (main.isFail())
				break;
			if (main.isFound())
				break;
		} while (true);
		
		if (main.isFound())
		{
			System.out.println("Found!");
		}
		else
		{
			System.out.println("Not Found!");
		}
		System.out.println("Program is finished with this order: ");
		System.out.println(toString(path));
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
	
	public static String toString(ArrayList<treeNode> nodeList)
	{
		String result = "";
		for (int i = 0; i < nodeList.size(); i++)
		{
			result += nodeList.get(i).getC() + "C, " + nodeList.get(i).getM() + "M, "  + "Boat position = " + nodeList.get(i).isBoat() + "\n";
		}
		return result;
	}
}
