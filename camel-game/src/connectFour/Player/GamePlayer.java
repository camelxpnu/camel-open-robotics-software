package connectFour.Player;

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

	protected void showAvailableColumns(int[] availableColumns)
	{
		for (int i = 0; i < availableColumns.length; i++)
		{
			System.out.print(availableColumns[i] + " ");
		}
		System.out.println();
	}

	/**
	 * player should answer where he would like to put his piece on which
	 * {@link connectFour.ColumnBoard}.
	 */
	public abstract int play(int... availableColumns);
}
