package connectFour;

import connectFour.Player.ComputerPlayer;
import connectFour.Player.HumanPlayer;

public class ConnectFourDemo
{
	public static void main(String[] args)
	{
		HumanPlayer human = new HumanPlayer(1);
		ComputerPlayer computer = new ComputerPlayer(2);

		ConnectFourGame game = new ConnectFourGame(7, 6, human, computer);

		game.initializeGame();
		while (true)
		{
			game.play();
			game.visualize();
			if (game.checkGameCompletion())
			{
				game.completeGame();
				break;
			}
		}
	}
}
