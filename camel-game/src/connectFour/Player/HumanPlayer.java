package connectFour.Player;

import java.util.Scanner;

import printTools.PrintTools;

public class HumanPlayer extends GamePlayer
{
	private Scanner scanner;

	public HumanPlayer(int playerID)
	{
		super(playerID);
	}
	
	@Override
	public int play(int... availableColumns)
	{
		PrintTools.info("Hey Human, where would you put your piece?");
		showAvailableColumns(availableColumns);

		int desiredColumn = -1;
		while (true)
		{
			scanner = new Scanner(System.in);
			String strDesiredColumn = scanner.nextLine();

			for (int i = 0; i < availableColumns.length; i++)
			{
				int availableColumn = availableColumns[i];
				String strColumn = Integer.toString(availableColumn);
				if (strDesiredColumn.contains(strColumn))
				{
					desiredColumn = availableColumn;
					PrintTools.info("You selected " + desiredColumn + ".");
					return desiredColumn;
				}
			}
			
			System.out.println("Your selection is not available. ");
			showAvailableColumns(availableColumns);
		}
	}
}
