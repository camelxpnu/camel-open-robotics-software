package connectFour;

import connectFour.Player.ComputerPlayer;
import connectFour.Player.HumanPlayer;

public class ConnectFourDemo
{
	public static void main(String[] args)
	{
		HumanPlayer human = new HumanPlayer(1);
		human.play(1, 2, 3, 4, 7);
		
		ComputerPlayer computer = new ComputerPlayer(2);
		computer.play(1, 2, 3, 4, 7);
	}
}
