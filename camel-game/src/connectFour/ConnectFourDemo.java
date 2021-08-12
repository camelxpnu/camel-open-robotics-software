package connectFour;

import connectFour.Player.ComputerPlayer;
import connectFour.Player.HumanPlayer;

/**
 * this game is connect four.
 * you can see the rules and concept of this game here.
 * https://mathworld.wolfram.com/Connect-Four.html
 * 
 * @author Inho Lee
 */
public class ConnectFourDemo
{
	public static void main(String[] args)
	{
		HumanPlayer human = new HumanPlayer(1, "Inho");
		ComputerPlayer computer = new ComputerPlayer(2);

		TurnGameInterface game = new ConnectFourGame(7, 6, human, computer);

		game.initializeGame();
		while (true)
		{
			game.play();
			game.visualize();

			if (game.checkGameCompletion())
			{
				game.completeGame();
				return;
			}
			game.changePlayer();
		}
	}
}
