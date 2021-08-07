package connectFour;

import connectFour.Player.ComputerPlayer;
import connectFour.Player.HumanPlayer;
import printTools.PrintTools;

public class ConnectFourGameCompletionCheckerTest
{
	public static void testVertical()
	{
		int WINNING_NUMBER = 4;
		int currentPlayerID = 2;
		int numberOfRows = 6;

		ColumnBoard columnBoard = new ColumnBoard(numberOfRows, 0);

		columnBoard.insertPiece(2);
		columnBoard.insertPiece(2);
		columnBoard.insertPiece(2);
		columnBoard.insertPiece(2);
		columnBoard.insertPiece(2);
		columnBoard.insertPiece(1);

		/**
		 * check vertical connect four. if yes, result = 1;
		 */
		boolean winning = true;
		for (int j = 0; j < numberOfRows - WINNING_NUMBER + 1; j++)
		{
			winning = true;
			System.out.println(j + " row.");
			for (int k = 0; k < WINNING_NUMBER; k++)
			{
				System.out.println(k + " ?");
				if (columnBoard.getOccupied(j + k) != currentPlayerID)
				{
					winning = false;
					break;
				}
			}

			if (winning)
			{
				System.out.println("WINNING");
				break;
			}
		}
	}

	public static void testHorizontal()
	{
		int WINNING_NUMBER = 4;
		int currentPlayerID = 2;
		int numberOfRows = 6;
		int numberOfColumns = 7;

		HumanPlayer human = new HumanPlayer(1);
		ComputerPlayer computer = new ComputerPlayer(2);
		ConnectFourGame game = new ConnectFourGame(7, 6, human, computer);

		ColumnBoard[] columnBoards = game.getColumnBoards();

		columnBoards[0].insertPiece(1);
		columnBoards[0].insertPiece(1);
		columnBoards[0].insertPiece(2);

		columnBoards[1].insertPiece(1);
		columnBoards[1].insertPiece(2);
		columnBoards[1].insertPiece(2);

		columnBoards[2].insertPiece(1);
		columnBoards[2].insertPiece(2);
		columnBoards[2].insertPiece(2);

		columnBoards[3].insertPiece(2);
		columnBoards[3].insertPiece(2);
		columnBoards[3].insertPiece(2);

		columnBoards[4].insertPiece(2);
		columnBoards[4].insertPiece(2);
		columnBoards[4].insertPiece(2);

		columnBoards[5].insertPiece(2);
		columnBoards[5].insertPiece(2);
		columnBoards[5].insertPiece(2);

		game.visualize();
		/**
		 * check vertical connect four. if yes, result = 1;
		 */
		boolean winning = true;
		for (int i = 0; i < numberOfRows; i++)
		{
			System.out.println("TEST " + i + " ROW");
			for (int j = 0; j < numberOfColumns - WINNING_NUMBER + 1; j++)
			{
				winning = true;
				System.out.println(j + " column start.");
				for (int k = 0; k < WINNING_NUMBER; k++)
				{
					System.out.println(k + " ?");
					if (columnBoards[j + k].getOccupied(i) != currentPlayerID)
					{
						winning = false;
						break;
					}
				}

				if (winning)
				{
					System.out.println("WINNING");
					break;
				}
			}

			if (winning)
			{
				System.out.println("not need to check anymore");
				break;
			}
		}
	}

	public static void testDiagonalRightUp()
	{
		int WINNING_NUMBER = 4;
		int currentPlayerID = 2;
		int numberOfRows = 6;
		int numberOfColumns = 7;

		HumanPlayer human = new HumanPlayer(1);
		ComputerPlayer computer = new ComputerPlayer(2);
		ConnectFourGame game = new ConnectFourGame(7, 6, human, computer);

		ColumnBoard[] columnBoards = game.getColumnBoards();

		columnBoards[0].insertPiece(1);
		columnBoards[0].insertPiece(1);
		columnBoards[0].insertPiece(2);
		columnBoards[0].insertPiece(2);
		columnBoards[0].insertPiece(2);
		columnBoards[0].insertPiece(2);
		columnBoards[0].insertPiece(2);

		columnBoards[1].insertPiece(1);
		columnBoards[1].insertPiece(2);
		columnBoards[1].insertPiece(2);
		columnBoards[1].insertPiece(1);
		columnBoards[1].insertPiece(2);
		columnBoards[1].insertPiece(2);

		columnBoards[2].insertPiece(1);
		columnBoards[2].insertPiece(2);
		columnBoards[2].insertPiece(2);
		columnBoards[2].insertPiece(1);
		columnBoards[2].insertPiece(2);
		columnBoards[2].insertPiece(2);

		columnBoards[3].insertPiece(1);
		columnBoards[3].insertPiece(2);
		columnBoards[3].insertPiece(2);
		columnBoards[3].insertPiece(2);
		columnBoards[3].insertPiece(2);
		columnBoards[3].insertPiece(2);

		columnBoards[4].insertPiece(2);
		columnBoards[4].insertPiece(2);
		columnBoards[4].insertPiece(2);
		columnBoards[4].insertPiece(2);
		columnBoards[4].insertPiece(2);
		columnBoards[4].insertPiece(2);

		columnBoards[5].insertPiece(2);
		columnBoards[5].insertPiece(2);
		columnBoards[5].insertPiece(2);
		columnBoards[5].insertPiece(2);
		columnBoards[5].insertPiece(2);
		columnBoards[5].insertPiece(2);
		
		columnBoards[6].insertPiece(2);
		columnBoards[6].insertPiece(2);
		columnBoards[6].insertPiece(2);
		columnBoards[6].insertPiece(2);
		columnBoards[6].insertPiece(2);
		columnBoards[6].insertPiece(2);

		game.visualize();
		/**
		 * check vertical connect four. if yes, result = 1;
		 */
		boolean winning = true;
		for (int i = 0; i < numberOfRows - WINNING_NUMBER + 1; i++)
		{
			System.out.println("TEST " + i + " ROW");
			for (int j = 0; j < numberOfColumns - WINNING_NUMBER + 1; j++)
			{
				winning = true;
				System.out.println(j + " column start.");
				for (int k = 0; k < WINNING_NUMBER; k++)
				{
					if (columnBoards[j + k].getOccupied(i + k) != currentPlayerID)
					{
						winning = false;
						break;
					}
					System.out.println(k + " ok");
				}

				if (winning)
				{
					System.out.println("WINNING");
					break;
				}
			}

			if (winning)
			{
				System.out.println("not need to check anymore");
				break;
			}
		}
	}
	
	public static void testDiagonalRightDown()
	{
		int WINNING_NUMBER = 4;
		int currentPlayerID = 2;
		int numberOfRows = 6;
		int numberOfColumns = 7;

		HumanPlayer human = new HumanPlayer(1);
		ComputerPlayer computer = new ComputerPlayer(2);
		ConnectFourGame game = new ConnectFourGame(7, 6, human, computer);

		ColumnBoard[] columnBoards = game.getColumnBoards();

		columnBoards[0].insertPiece(1);
		columnBoards[0].insertPiece(1);
		columnBoards[0].insertPiece(2);
		columnBoards[0].insertPiece(2);
		columnBoards[0].insertPiece(2);
		columnBoards[0].insertPiece(2);
		columnBoards[0].insertPiece(2);

		columnBoards[1].insertPiece(1);
		columnBoards[1].insertPiece(2);
		columnBoards[1].insertPiece(2);
		columnBoards[1].insertPiece(1);
		columnBoards[1].insertPiece(2);
		columnBoards[1].insertPiece(2);

		columnBoards[2].insertPiece(1);
		columnBoards[2].insertPiece(2);
		columnBoards[2].insertPiece(2);
		columnBoards[2].insertPiece(1);
		columnBoards[2].insertPiece(2);
		columnBoards[2].insertPiece(2);

		columnBoards[3].insertPiece(1);
		columnBoards[3].insertPiece(2);
		columnBoards[3].insertPiece(2);
		columnBoards[3].insertPiece(2);
		columnBoards[3].insertPiece(2);
		columnBoards[3].insertPiece(2);

		columnBoards[4].insertPiece(2);
		columnBoards[4].insertPiece(2);
		columnBoards[4].insertPiece(2);
		columnBoards[4].insertPiece(2);
		columnBoards[4].insertPiece(2);
		columnBoards[4].insertPiece(2);

		columnBoards[5].insertPiece(2);
		columnBoards[5].insertPiece(2);
		columnBoards[5].insertPiece(2);
		columnBoards[5].insertPiece(2);
		columnBoards[5].insertPiece(2);
		columnBoards[5].insertPiece(2);
		
		columnBoards[6].insertPiece(1);
		columnBoards[6].insertPiece(2);
		columnBoards[6].insertPiece(2);
		columnBoards[6].insertPiece(2);
		columnBoards[6].insertPiece(2);
		columnBoards[6].insertPiece(2);

		game.visualize();
		/**
		 * check vertical connect four. if yes, result = 1;
		 */
		boolean winning = true;
		for (int i = WINNING_NUMBER - 1; i < numberOfRows; i++)
		{
			System.out.println("TEST " + i + " ROW");
			for (int j = 0; j < numberOfColumns - WINNING_NUMBER + 1; j++) 
			{
				winning = true;
				System.out.println(j + " column start.");
				for (int k = 0; k < WINNING_NUMBER; k++)
				{
					if (columnBoards[j + k].getOccupied(i - k) != currentPlayerID)
					{
						winning = false;
						break;
					}
					System.out.println(k + " ok");
				}

				if (winning)
				{
					System.out.println("WINNING");
					break;
				}
			}

			if (winning)
			{
				System.out.println("not need to check anymore");
				break;
			}
		}
	}

	public static void main(String[] args)
	{
		PrintTools.info("testVertical");
		//testVertical();

		PrintTools.info("testHorizontal");
		//testHorizontal();

		PrintTools.info("testDiagonalRightUp");
		testDiagonalRightUp();
		
		PrintTools.info("testDiagonalRightDown");
		testDiagonalRightDown();
	}
}
