package connectFour.Player;

import java.util.ArrayList;
import java.util.Random;

import printTools.PrintTools;

public class ComputerPlayer extends GamePlayer
{
	private final Random randomSelecter = new Random();

	public ComputerPlayer(int playerID)
	{
		super(playerID);
	}

	@Override
	public int play(ArrayList<Integer> availableColumns)
	{
		PrintTools.info("Hey AI, where would you put your piece?");
		showAvailableColumns(availableColumns);

		int numberOfAvailableColumns = availableColumns.size();
		int randomNumber = randomSelecter.nextInt(numberOfAvailableColumns);

		Integer computerSelection = availableColumns.get(randomNumber);
		System.out.println("I WOULD PUT MY PIECE ON COLUMN [" + computerSelection + "] !");
		return computerSelection;
	}

	@Override
	public String playerType()
	{
		return "AI";
	}
}
