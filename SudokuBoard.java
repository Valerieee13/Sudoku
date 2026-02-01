//Valerie Chavez
//CS 143
//HW #1: Sudoku #1
//This program creates an object called sudokuboard

import java.util.*;
import java.io.*;

public class SudokuBoard {

   private char[][] board;
   
   //Pre: There is a file to be read in.
   //Post: Creates a 2d array using data from a file that was scanned in.
   public SudokuBoard(String filename) throws FileNotFoundException {
   
      board = new char[9][9];
      Scanner file = new Scanner(new File(filename));
      int row = 0;
      
      while (row < 9 && file.hasNextLine()) {
         String line = file.nextLine();
         int column = 0;
         
         while (column < 9) {
            board[row][column] = line.charAt(column);
            column++;
         }
         row++;
      }
   }
   
   //Post: Returns a sudoku board where each number is in its own cell
   public String toString() {
      String sudokuGame = "_____________________________________\n";
      for (int i = 0; i < board.length; i++) {
          
         for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == '.') {
               sudokuGame += "|   ";
            } else {
               sudokuGame += "| " + board[i][j] + " ";
            }
         }
         
         sudokuGame += "|\n";
         sudokuGame += "_____________________________________\n";
      }
      return sudokuGame;
   }

}