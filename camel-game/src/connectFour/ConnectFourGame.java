package connectFour;

import java.util.ArrayList;
import java.util.Random;

import connectFour.Player.GamePlayer;
import printTools.PrintTools;

public class ConnectFourGame extends TwoPlayerTurnGame
{
	private final int numberOfColumnBoards;
	private final ColumnBoard[] columBoards;

	public ConnectFourGame(int columns, int rows, GamePlayer firstPlayer, GamePlayer secondPlayer)
	{
		super(firstPlayer, secondPlayer);

		PrintTools.info("");
		System.out.println("First Player  : [O].");
		System.out.println("Second Player : [X].");

		numberOfColumnBoards = columns;
		columBoards = new ColumnBoard[columns];
		for (int i = 0; i < columns; i++)
		{
			columBoards[i] = new ColumnBoard(rows, i);
		}
	}

	@Override
	public void initializeGame()
	{
		Random randomSelecter = new Random();
		boolean randomTurn = randomSelecter.nextBoolean();
		if (randomTurn)
		{
			changeCurrentPlayer();
		}
	}

	@Override
	public void visualize()
	{
		/**
		 * annotate column id.
		 */
		for (int i = 0; i < numberOfColumnBoards; i++)
		{
			System.out.print("|" + i);
		}
		System.out.println("|");

		/**
		 * dividing line.
		 */
		for (int i = 0; i < numberOfColumnBoards * 2; i++)
		{
			System.out.print("-");
		}
		System.out.println("-");

		/**
		 * visualize column boards.
		 */
		for (int i = columBoards[0].getRows() - 1; i >= 0; i--)
		{
			for (int j = 0; j < numberOfColumnBoards; j++)
			{
				System.out.print("|");
				if (columBoards[j].getOccupied(i) == 1)
				{
					System.out.print("O");
				} else if (columBoards[j].getOccupied(i) == 2)
				{
					System.out.print("X");
				} else
				{
					System.out.print(" ");
				}
			}
			System.out.println("|");
		}

		/**
		 * dividing line.
		 */
		for (int i = 0; i < numberOfColumnBoards * 2; i++)
		{
			System.out.print("-");
		}
		System.out.println("-");
	}

	@Override
	public boolean checkGameCompletion()
	{
		return false;
	}

	@Override
	public void completeGame()
	{

	}

	@Override
	protected void provideAvailableActionsAndPlay()
	{
		ArrayList<Integer> availableColumns = new ArrayList<Integer>();
		for (int i = 0; i < numberOfColumnBoards; i++)
		{
			if (!columBoards[i].isFull())
			{
				availableColumns.add(i);
			}
		}
		int playerSelction = currentPlayer.play(availableColumns);
		columBoards[playerSelction].insertPiece(currentPlayer.getPlayerID());
	}
}
