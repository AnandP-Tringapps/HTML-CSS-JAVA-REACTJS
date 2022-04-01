package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */
public class TicTacToeBoard {
	String str;
	
  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param board The string representing the board
   */
  public TicTacToeBoard(String board) {
	  this.str=board.toLowerCase();

  }
 public static void main(String[] args) {
	 TicTacToeBoard obj=new TicTacToeBoard("xooxxoxxo");
	 System.out.println(obj.evaluate());
 }
  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
	  if(str.length()!=9)
		  return Evaluation.UnreachableState;
	  int xcount=0,ocount=0;
	  for(int i=0;i<str.length();i++)
	  {
		  if(str.charAt(i)=='x')
			  xcount++;
		  else if(str.charAt(i)=='o')
			  ocount++;
	  }
	  if(Math.abs(xcount-ocount)>1)
		  return Evaluation.UnreachableState;
	  for(int i=0;i<3;i++)
	  {
		  if(str.charAt(i)==str.charAt(i+3)&&(str.charAt(i+3)==(str.charAt(i+6)))) {
				 if(str.charAt(i)=='x')
					 return Evaluation.Xwins;
				 else if(str.charAt(i)=='o')
					 return Evaluation.Owins;
			  }
	  }
	  for(int i=0;i<str.length();i+=3)
	  {
		  if(str.charAt(i)==str.charAt(i+1)&&(str.charAt(i+1)==(str.charAt(i+2)))) {
				 if(str.charAt(i)=='x')
					 return Evaluation.Xwins;
				 else if(str.charAt(i)=='o')
					 return Evaluation.Owins;
			  }
	  }
	  if(str.charAt(0)==str.charAt(4)&&(str.charAt(4)==(str.charAt(8)))) {
			 if(str.charAt(0)=='x')
				 return Evaluation.Xwins;
			 else if(str.charAt(0)=='o')
				 return Evaluation.Owins;
		  }
	  if(str.charAt(2)==str.charAt(4)&&(str.charAt(4)==(str.charAt(6)))) {
			 if(str.charAt(4)=='x')
				 return Evaluation.Xwins;
			 else if(str.charAt(4)=='o')
				 return Evaluation.Owins;
		  }
	  return Evaluation.NoWinner;
  }
}