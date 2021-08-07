package connectFour;

import java.util.ArrayList;
import java.util.Random;

import connectFour.Player.GamePlayer;
import printTools.PrintTools;

public class ConnectFourGame extends TwoPlayerTurnGame
{
	private final int numberOfColumnBoards;
	private final ColumnBoard[] columnBoards;
	private static final int WINNING_NUMBER = 4;

	public ConnectFourGame(int columns, int rows, GamePlayer firstPlayer, GamePlayer secondPlayer)
	{
		super(firstPlayer, secondPlayer);

		PrintTools.info("");
		System.out.println("First Player  : [O].");
		System.out.println("Second Player : [X].");

		numberOfColumnBoards = columns;
		columnBoards = new ColumnBoard[columns];
		for (int i = 0; i < columns; i++)
		{
			columnBoards[i] = new ColumnBoard(rows, i);
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
		for (int i = columnBoards[0].getRows() - 1; i >= 0; i--)
		{
			for (int j = 0; j < numberOfColumnBoards; j++)
			{
				System.out.print("|");
				if (columnBoards[j].getOccupied(i) == 1)
				{
					System.out.print("O");
				}
				else if (columnBoards[j].getOccupied(i) == 2)
				{
					System.out.print("X");
				}
				else
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

	private boolean isConnectFourVertical()
	{
		int currentPlayerID = currentPlayer.getPlayerID();
		int numberOfRows = columnBoards[0].getRows();

		for (int i = 0; i < numberOfColumnBoards; i++)
		{
			boolean winning = true;
			for (int j = 0; j < numberOfRows - WINNING_NUMBER + 1; j++)
			{
				winning = true;
				for (int k = 0; k < WINNING_NUMBER; k++)
				{
					if (columnBoards[i].getOccupied(j + k) != currentPlayerID)
					{
						winning = false;
						break;
					}
				}

				if (winning)
				{
					return true;
				}
			}
		}
		return false;
	}

	private boolean isConnectFourHorizontal()
	{
		int currentPlayerID = currentPlayer.getPlayerID();
		int numberOfRows = columnBoards[0].getRows();

		boolean winning = true;
		for (int i = 0; i < numberOfRows; i++)
		{
			for (int j = 0; j < numberOfColumnBoards - WINNING_NUMBER + 1; j++)
			{
				winning = true;
				for (int k = 0; k < WINNING_NUMBER; k++)
				{
					if (columnBoards[j + k].getOccupied(i) != currentPlayerID)
					{
						winning = false;
						break;
					}
				}

				if (winning)
				{
					return true;
				}
			}
		}
		return false;
	}

	private boolean isConnectFourDiagonalRightUp()
	{
		int currentPlayerID = currentPlayer.getPlayerID();
		int numberOfRows = columnBoards[0].getRows();

		boolean winning = true;
		for (int i = 0; i < numberOfRows - WINNING_NUMBER + 1; i++)
		{
			for (int j = 0; j < numberOfColumnBoards - WINNING_NUMBER + 1; j++)
			{
				winning = true;
				for (int k = 0; k < WINNING_NUMBER; k++)
				{
					if (columnBoards[j + k].getOccupied(i + k) != currentPlayerID)
					{
						winning = false;
						break;
					}
				}

				if (winning)
				{
					return true;
				}
			}
		}
		return false;
	}

	private boolean isConnectFourDiagonalRightDown()
	{
		int currentPlayerID = currentPlayer.getPlayerID();
		int numberOfRows = columnBoards[0].getRows();

		boolean winning = true;
		for (int i = WINNING_NUMBER - 1; i < numberOfRows; i++)
		{
			for (int j = 0; j < numberOfColumnBoards - WINNING_NUMBER + 1; j++)
			{
				winning = true;
				for (int k = 0; k < WINNING_NUMBER; k++)
				{
					if (columnBoards[j + k].getOccupied(i - k) != currentPlayerID)
					{
						winning = false;
						break;
					}
				}

				if (winning)
				{
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean checkGameCompletion()
	{
		/**
		 * result(0): no more space;
		 * result(1): vertical connect four.
		 * result(2): horizontal connect four.
		 * result(3): diagonal connect four(right-up direction).
		 * result(4): diagonal connect four(right-down direction).
		 */
		int result = -1;

		/**
		 * check there is no more empty space of column boards.
		 */
		for (int i = 0; i < numberOfColumnBoards; i++)
		{
			if (columnBoards[i].isFull())
			{
				if (i == numberOfColumnBoards - 1)
				{
					result = 0;
				}
				continue;
			}
			else
			{
				break;
			}
		}

		/**
		 * check vertical connect four. if yes, result = 1;
		 */
		if (isConnectFourVertical())
		{
			result = 1;
		}

		/**
		 * check horizontal connect four. if yes, result = 2;
		 */
		if (isConnectFourHorizontal())
		{
			result = 2;
		}

		/**
		 * check diagonal connect four. if yes, result = 3;
		 */
		if (isConnectFourDiagonalRightUp())
		{
			result = 3;
		}

		/**
		 * check diagonal connect four. if yes, result = 4;
		 */
		if (isConnectFourDiagonalRightDown())
		{
			result = 4;
		}

		if (result == -1)
		{
			return false;
		}
		else
		{
			switch (result)
			{
			case 0:
				System.out.println("There is no more space.");
				break;
			case 1:
				System.out.println("There is vertical connect four!");
				break;
			case 2:
				System.out.println("There is horizontal connect four!");
				break;
			case 3:
				System.out.println("There is diagonal(right-up direction) connect four!");
				break;
			case 4:
				System.out.println("There is diagonal(right-down direction) connect four!");
				break;
			}
			return true;
		}
	}

	@Override
	public void completeGame()
	{
		System.out.println("Winner is " + currentPlayer.playerType());
	}

	@Override
	protected void provideAvailableActionsAndPlay()
	{
		ArrayList<Integer> availableColumns = new ArrayList<Integer>();
		for (int i = 0; i < numberOfColumnBoards; i++)
		{
			if (!columnBoards[i].isFull())
			{
				availableColumns.add(i);
			}
		}
		int playerSelction = currentPlayer.play(availableColumns);
		columnBoards[playerSelction].insertPiece(currentPlayer.getPlayerID());
	}

	public ColumnBoard[] getColumnBoards()
	{
		return columnBoards;
	}

}
