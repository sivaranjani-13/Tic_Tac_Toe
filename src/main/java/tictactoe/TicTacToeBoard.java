package tictactoe;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {

  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param board The string representing the board
   */
        
  String board;
  static Logger logger=Logger.getLogger(TicTacToeBoard.class.getName());
  
  public TicTacToeBoard(String board) {
          this.board = board.toLowerCase();
  }

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
          if(board.length() != 9) {
                  return Evaluation.UnreachableState;
          }
          int xCount = 0;
          int oCount = 0;
          for(int i = 0; i < board.length(); i++) {
                  if(board.charAt(i) == 'x') {
                          xCount++;
                  }
                  if(board.charAt(i) == 'o') {
                          oCount++;
                  }
          }
          if(Math.abs(xCount - oCount) >= 2) {
                  return Evaluation.UnreachableState;
          }
          boolean xWins = checkWinner('x');
          boolean oWins = checkWinner('o');
          if(xWins && oWins) {
                  return Evaluation.UnreachableState;
          }
          if(xWins) {
                  return Evaluation.Xwins;
          }
          else if(oWins) {
                  return Evaluation.Owins;
          }
          else {
                  return Evaluation.NoWinner;
          }
  }
  
  public boolean checkWinner(char check) {
          if(board.charAt(0) == check && board.charAt(1) == check && board.charAt(2) == check) || (board.charAt(3) == check && board.charAt(4) == check && board.charAt(5) == check){
                  return true;
          }
          else if(board.charAt(3) == check && board.charAt(4) == check && board.charAt(5) == check) {
                  return true;
          }
          else if(board.charAt(6) == check && board.charAt(7) == check && board.charAt(8) == check) {
                  return true;
          }
          else if(board.charAt(0) == check && board.charAt(3) == check && board.charAt(6) == check) {
                  return true;
          }
          else if(board.charAt(1) == check && board.charAt(4) == check && board.charAt(7) == check) {
                  return true;
          }
          else if(board.charAt(2) == check && board.charAt(5) == check && board.charAt(8) == check) {
                  return true;
          }
          else if(board.charAt(0) == check && board.charAt(4) == check && board.charAt(8) == check) {
                  return true;
          }
          
          return board.charAt(2) == check && board.charAt(4) == check && board.charAt(6) == check;
  }
  
  public static void main(String[] args) {
                TicTacToeBoard x = new TicTacToeBoard("xoxoxxxoo");
                
                logger.log(Level.INFO,"{0}",x.evaluate());
                
  }
}
