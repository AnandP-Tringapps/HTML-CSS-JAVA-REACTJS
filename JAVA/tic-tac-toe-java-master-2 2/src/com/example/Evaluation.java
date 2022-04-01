package com.example;

/**
 * Created by zilles on 8/31/17.
 *
 * This enumeration specifies the possible results of the evaluation of a Tic-Tac-Toe board.
 */
public enum Evaluation {
  NoWinner, /* valid board, but the game hasn't been won by either player yet */
  Xwins, /* valid board, and the game was won by player X */
  Owins, /* valid board, and the game was won by player O */
  UnreachableState /* string describes a board, but not a board state that is reachable from a valid game */
}
