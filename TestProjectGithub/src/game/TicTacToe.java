package game;

import java.util.Scanner;

public class TicTacToe {

	// declare Variables for rows and column
	private static int row, col; 
	
	//scanner to take the input for our players
	private static Scanner scan = new Scanner(System.in);
	
	// board double character array 
	private static char [][] board = new char[3][3]; // size 3 by 3
	private static char turn = 'X'; // what players turn it is 
	
	public static void main(String[] args){
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++){
				board[i][j] = '_'; // will make all 9 spots in our array equal to _ until we replace them with X or O
			}
		}
		Play(); // starting the game in the main method
	}
	
	// custom methods to divide the workload 
	private static void Play(){ // start the game
		boolean playing = true;
		PrintBoard();					// print the board once, so people can look at it before playing...
		while (playing) { // while playing is true..
			System.out.println("Please enter a row and column: "); // instruction for the players
			row = scan.nextInt() - 1; // we are doing this because an array starts at value 0 and we want the player to be able to type in 1-3 for the rows and columns - more intuitive
			col = scan.nextInt() -1;
			board[row][col] = turn; // to begin the game with x we use the defined char turn = x
			
			if(GameOver(row, col)) {	//ckeck game status,  if gameover returns true based on conditions row, col
				playing = false;
				System.out.println("Game over! Player "+ turn +" wins!");
			}
			
			PrintBoard();
			if (turn == 'X') // after we are done playing the round we check if the last player was X and if he was it will be O turn
				turn = 'O';
			else 
				turn = 'X'; // otherwise it's X
		}
	}
	
	private static void PrintBoard() {
		for (int i = 0; i <  3; i++) {
			System.out.println();
			for (int j = 0; j < 3; j++){
				if (j == 0)
					System.out.print("| "); // to print additional | before the first _
				System.out.print(board[i][j] + " | "); // to get the | we add them here
			}
		}
		System.out.println();
	}
	
	private static boolean GameOver(int rMove, int cMove) { // decide if someone won the game, this is the main logic of the game! 
		if (board[0][cMove] == board[1][cMove] && board[0][cMove] == board[2][cMove]) // we are checking if the first value is equal to the second values and the first values is equal to the third, the game is over (because 3 in a row) 
			return true;
		if (board[rMove][0] == board[rMove][1] && board[rMove][0] == board[rMove][0]) // same for up and down
			return true;
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != '_') // diagonal aswell
			return true;
		if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != '_') // diagonal aswell
			return true;
		return false;
	}	
}
