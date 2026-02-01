//Valerie Chavez
//CS 143
//HW #1: Sudoku #1
//This program print a Sudoku board using data from a file

import java.io.*;

public class PlaySudoku {

   //This method instantiates an object and prints the object to the screen
   public static void main(String[] args) throws FileNotFoundException {
   
      SudokuBoard game = new SudokuBoard("data1-1-1.sdk");
      
      System.out.print(game);
   }
}

/*
 
  ----jGRASP exec: java PlaySudoku
 _____________________________________
 | 2 |   |   | 1 |   | 5 |   |   | 3 |
 _____________________________________
 |   | 5 | 4 |   |   |   | 7 | 1 |   |
 _____________________________________
 |   | 1 |   | 2 |   | 3 |   | 8 |   |
 _____________________________________
 | 6 |   | 2 | 8 |   | 7 | 3 |   | 4 |
 _____________________________________
 |   |   |   |   |   |   |   |   |   |
 _____________________________________
 | 1 |   | 5 | 3 |   | 9 | 8 |   | 6 |
 _____________________________________
 |   | 2 |   | 7 |   | 1 |   | 6 |   |
 _____________________________________
 |   | 8 | 1 |   |   |   | 2 | 4 |   |
 _____________________________________
 | 7 |   |   | 4 |   | 2 |   |   | 1 |
 _____________________________________
 
  ----jGRASP: Operation complete.
 
*/