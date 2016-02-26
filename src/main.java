import java.util.ArrayList;
import java.util.Random;

public class main {
	private static int freq = 0;
	
	public static void main(String [ ] args)
	{
		for (int i = 0; i < 1000; i++)
		{
			mandc();
		}
		System.out.println(freq);
	}
	
	public static void mandc()
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
				else
					break;
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
			{
				freq++;
				System.out.println(toString(path));
				break;
			}
		} while (true);
		
		/*
		if (main.isFound())
		{
			System.out.println("Found!");
		}
		else
		{
			System.out.println("Not Found!");
		}*/
		
	}
	
	public static boolean checkVisited(ArrayList<treeNode> extendedList, treeNode node){
		if (node == null)
			return true;
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
			result += nodeList.get(i).getC() + "C, " + nodeList.get(i).getM() + "M, "  + "Right = " + nodeList.get(i).isBoat() + "\n";
		}
		return result;
	}
}
