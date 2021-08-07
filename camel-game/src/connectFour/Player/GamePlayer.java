package connectFour.Player;

import java.util.ArrayList;

public abstract class GamePlayer
{
	private final int playerID;

	public GamePlayer(int playerID)
	{
		this.playerID = playerID;
	}

	public int getPlayerID()
	{
		return playerID;
	}

	protected void showAvailableColumns(ArrayList<Integer> availableColumns)
	{
		for (int i = 0; i < availableColumns.size(); i++)
		{
			System.out.print(availableColumns.get(i) + " ");
		}
		System.out.println();
	}

	/**
	 * player should answer where he would like to put his piece on which
	 * {@link connectFour.ColumnBoard}.
	 */
	public abstract int play(ArrayList<Integer> availableColumns);
}
