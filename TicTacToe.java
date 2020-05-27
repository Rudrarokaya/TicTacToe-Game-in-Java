import java.util.*;
import java.util.Scanner;


public class TicTacToe{
    static Scanner sc;
    static char player1Marker;
    static char player2Marker;
    static int turn = 0;
    static int p1choice;
    static int p2choice;
    static char[][] board = {{'1','2','3'}, {'4','5','6'},{'7','8','9'}};
    public static void main(String[] args){
        sc = new Scanner(System.in);
        System.out.print(" " + "Enter the first player name: ");
        String player1 = sc.nextLine();
        System.out.print(" " + "Enter the second player name: ");
        String player2 = sc.nextLine();

        TicTacToe game = new TicTacToe();
        game.userChoice(player1, player2);
        game.displayBoard(board);
        System.out.println(" |=================|");
        game.switchPlayer(board,player1Marker,player2Marker,player1,player2);
        System.out.println();
        System.out.println(" "+"Final Result: ");
        game.checkForWinner(player1Marker, player2Marker, player1, player2);
    }

    public boolean userChoice(String player1, String player2){
        System.out.print(" " + player1 + " Choose the marker (X / O) :"+" ");
        player1Marker = sc.next().charAt(0);
        player2Marker = '\0';

        if(player1Marker != 'X' && player1Marker != 'O'){
            System.out.println();
            System.out.println(" " + "Enter the marker correctly!");
            userChoice(player1, player2);
        }
        else{
            if(player1Marker == 'X'){
                player2Marker = 'O';
            }
            else{
                player2Marker = 'X';
            }
            System.out.println();
            System.out.println("|######################|");
            System.out.println("  " + "Players Information: ");
            System.out.println(" "+" Name: "+player1 + "  "+" Marker: "+ player1Marker);
            System.out.println(" "+" Name: "+player2 + "  "+" Marker: "+ player2Marker);
            System.out.println("|######################|");
            System.out.println();
            System.out.println("   TicTacToe Board. ");
            System.out.println(" |=================|");
        }
        return true;
    }
    public void displayBoard(char[][] board){ // display TicTacToe game board.
        for(char[] i : board){
            for(char j : i){
                System.out.print(" | ");
                System.out.print(j + " | ");
            }
            System.out.println();
        }
    }public void switchPlayer(char[][] board,char player1Marker,char player2Marker,String player1, String player2){ //using switch method just to switch player turn. and by default/first turn has been initialized to firstplayer.
            turn = 1;
            switch(turn){
                case 1:
                player1Turn(board,player1Marker,player1, player2);

                case 2:
                player2Turn(board,player2Marker,player2, player1);

                case 3:
                player1Turn(board,player1Marker,player1,player2);

                case 4:
                player2Turn(board,player2Marker,player2, player1);

                case 5:
                player1Turn(board,player1Marker,player1, player2);

                case 6:
                player2Turn(board,player2Marker,player2, player1);

                case 7:
                player1Turn(board,player1Marker,player1, player2);

                case 8:
                player2Turn(board,player2Marker,player2, player1);

                case 9:
                player1Turn(board,player1Marker,player1,player2);
                break;

                default:
                System.out.println("Sorry Try next.");
            }
    }
    public void player1Turn(char[][] board, char player1Marker, String player1, String player2){
            System.out.println();
            System.out.print(" " + player1 + ", Your's Turn: ");
            p1choice = sc.nextInt();
            char num1 = (char)(p1choice+'0'); //converting / (type casting) integer to character.
            if(p1choice == p2choice){
                System.out.println(" " + "The number is already taken by "+ player2 + ". Please, enter another number.");
                player1Turn(board, player1Marker, player1, player2);
            }
            else{
                if(!(p1choice > 0 && p1choice <= 9)){ //to make user choose between 1 - 9 only.
                    System.out.println(" " + "Invalid value, Enter Again Between(1-9)");
                    player1Turn(board,player1Marker,player1, player2);
                }
                else{
                    replace(board, num1, player1Marker);
                    System.out.println();
                    System.out.println(" |=================|");
                    displayBoard(board);
                    System.out.println(" |=================|");
                }
            }
    }
    public void player2Turn(char[][] board, char player2Marker, String player2,String player1){
            System.out.println();
            System.out.print(" " + player2+ ", Your's Turn: ");
            p2choice = sc.nextInt();
            char num2 = (char)(p2choice+ '0');
            if(p2choice == p1choice){
                System.out.println(" " + "The number is already taken by " + player1 + ". Please, enter another number.");
                player2Turn(board, player2Marker, player2, player1);
            }
            else{
                if(!(p2choice > 0 && p2choice <= 9)){
                    System.out.println(" " + "Invalid Input, Enter Again Between (1-9)");
                    player2Turn(board, player2Marker, player2, player1);
                }
                else{
                    replace(board, num2, player2Marker);
                    System.out.println();
                    System.out.println(" |=================|");
                    displayBoard(board);
                    System.out.println(" |=================|");
                }
            }
    }
    public void replace(char[][] board, char choice, char marker){ //takes playerChoice and replace value with respective Marker.
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if (board[i][j] == choice) {
                    board[i][j] = marker;
                }
            }
        }
    }
    public void checkForWinner(char player1Marker, char player2Marker, String player1, String player2){ //check for winner.
        int flag = 0; // for 'X' marker
        int count = 0; // for 'O' marker
        char marker = '\0';
        for(int i=0; i<=8; i++){
            int line = 0;
            switch(i){
                case 1:
                line = board[0][0] + board[0][1] + board[0][2];
				break;

				case 2:
				line = board[1][0] + board[1][1] + board[1][2];
				break;

				case 3:
				line = board[2][0] + board[2][1] + board[2][2];
				break;

				case 4:
				line = board[0][0] + board[1][0] + board[2][0];
				break;

				case 5:
				line = board[0][1] + board[1][1] + board[2][1];
				break;

				case 6:
				line = board[0][2] + board[1][2] + board[2][2];
				break;

				case 7:
				line = board[0][0] + board[1][1] + board[2][2];
				break;

				case 8:
				line = board[0][2] + board[1][1] + board[2][0];
				break;
            }
            if(line == (88+88+88)){ // representing XXX to ASCII value of 'X' marker which is 88.
                flag = flag + 1;
                marker = 'X';
            }
            else if(line == (79 + 79 + 79)){ // representing 'OOO' to ASCII value of 'O' marker which is 79.
                count = count + 1;
                marker = 'O';
            }
        }
        if(flag != 0 || count != 0){
            if (flag == count) {
                System.out.println(" " + "No Winner.Game Draw.");
            }
            else if(flag > count){
                if(player1Marker == marker){
                    System.out.println(" "+"Congratulation, "+player1 + "!!, you're the winner.");
                }
                else {
                    System.out.println(" "+"Congratulation, "+player2 + "!!, you're the winner.");
                }
            }
            else{
                if(player1Marker == marker){
                    System.out.println(" "+"Congratulation, "+player1 + "!!, you're the winner");
                }
                else{
                    System.out.println(" "+"Congratulation, "+player2 + "!!, you're the winner.");
                }
            }
        }
        else{
            System.out.println(" " + "Game Draw.");
        }
    }
}
