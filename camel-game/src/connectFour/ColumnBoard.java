package connectFour;

import printTools.PrintTools;

public class ColumnBoard
{
	private final int rows;
	private final int columnID;
	/**
	 * 0: not occupied. 1: first player. 2: second player.
	 */
	private int[] occupiedData;

	public ColumnBoard(int rows, int columnID)
	{
		this.rows = rows;
		this.columnID = columnID;
		this.occupiedData = new int[rows];
	}

	public boolean isFull()
	{
		if (getOccupied(getRows() - 1) == 0)
			return false;
		else
			return true;
	}

	public void insertPiece(int playerID)
	{
		if (!(playerID == 1 || playerID == 2))
		{
			System.out.println("The playerID is not registered.");
			return;
		}

		for (int i = 0; i < rows; i++)
		{
			if (occupiedData[i] == 0)
			{
				occupiedData[i] = playerID;
				return;
			}
		}
	}

	public int getRows()
	{
		return this.rows;
	}

	public int getColumnID()
	{
		return this.columnID;
	}

	public int getOccupied(int row)
	{
		if (row >= getRows() || row < 0)
		{
			PrintTools.error("You tried to access outside of the game board.");
			return -1;
		}

		return occupiedData[row];
	}	
}
