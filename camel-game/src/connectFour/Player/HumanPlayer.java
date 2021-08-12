package connectFour.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class HumanPlayer extends GamePlayer
{
	private Scanner scanner;
	private String name;

	public HumanPlayer(int playerID)
	{
		super(playerID);
	}

	public HumanPlayer(int playerID, String name)
	{
		super(playerID);
		this.name = name;
	}

	@Override
	public int play(ArrayList<Integer> availableColumns)
	{
		System.out.println("Hey Human(" + name + "), where would you put your piece?");
		showAvailableColumns(availableColumns);

		int desiredColumn = -1;
		while (true)
		{
			scanner = new Scanner(System.in);
			String strDesiredColumn = scanner.nextLine();

			for (int i = 0; i < availableColumns.size(); i++)
			{
				int availableColumn = availableColumns.get(i);
				String strColumn = Integer.toString(availableColumn);
				if (strDesiredColumn.contains(strColumn))
				{
					desiredColumn = availableColumn;
					System.out.println("You selected " + desiredColumn + ".");
					return desiredColumn;
				}
			}

			System.out.println("Your selection is not available. ");
			showAvailableColumns(availableColumns);
		}
	}

	@Override
	public String playerType()
	{
		return "Human(" + name + ")";
	}
}
