package connectFour;

import connectFour.Player.GamePlayer;

public abstract class TwoPlayerTurnGame implements TurnGameInterface
{
	private final GamePlayer firstPlayer;
	private final GamePlayer secondPlayer;

	protected GamePlayer currentPlayer;

	public TwoPlayerTurnGame(GamePlayer firstPlayer, GamePlayer secondPlayer)
	{
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		currentPlayer = firstPlayer;
	}

	@Override
	public void changePlayer()
	{
		if (currentPlayer == firstPlayer)
		{
			currentPlayer = secondPlayer;
		}
		else
		{
			currentPlayer = firstPlayer;
		}
	}
}
