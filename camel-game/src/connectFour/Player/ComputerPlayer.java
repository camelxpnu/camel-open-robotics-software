package connectFour.Player;

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
	public int play(int... availableColumns)
	{
		PrintTools.info("Hey AI, where would you put your piece?");
		showAvailableColumns(availableColumns);

		int numberOfAvailableColumns = availableColumns.length;
		int randomNumber = randomSelecter.nextInt(numberOfAvailableColumns);

		System.out.println("I WOULD PUT MY PIECE ON COLUMN [" + availableColumns[randomNumber] + "] !");
		return availableColumns[randomNumber];
	}
}
