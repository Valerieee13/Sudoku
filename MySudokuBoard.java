//Valerie Chavez
//CS 143
//HW #3: Sudoku #3 (solve)
//This program updates adds a solve method that will take an unsolved sudoku board and solve it.

import java.util.*;
import java.io.*;

public class MySudokuBoard {

   private char[][] board;
   
   //Pre: There is a file to be read in.
   //Post: Creates a 2d array using data from a file that was scanned in.
   public MySudokuBoard(String filename)  {
   
      board = new char[9][9];
      
      try (Scanner file = new Scanner(new File(filename))) {
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
      } catch (FileNotFoundException e) {
         System.out.println("File not found: " + filename);
      }
   }
   
   //Pre: assumes board is initialized
   //Post: returns true if all other methods return true;
   public boolean isValid() {
      return hasValidChar() && hasValidRows() && 
      hasValidColumns() && hasValidMiniSquare();
   }
   
   //Post: returns true if valid data is a '.' or # 1-9. False otherwise.
   public boolean hasValidChar(){
   
      for (int r = 0; r < 9; r++) {
         for (int c = 0; c < 9; c++) {
            char value = board[r][c];
            if (value != '.' && (value < '1' || value > '9')) {
               return false;
            }
         }
      }
      return true;
   }
   
   //Pre: assumes board has been initialized and contains valid char
   //Post: returns true if each row doesnt't have duplicates of 1-9. False otherwise.
   public boolean hasValidRows() {
   
      for (int r = 0; r < 9; r++) {
         Set<Character> rows = new HashSet<>();
         for (int c = 0; c < 9; c++) {
            char value = board[r][c];
            if (value != '.' && rows.contains(value)) {
               return false;
            }
            if (value != '.') {
               rows.add(value);
            }
         }
      }
      return true;
   }
   
   //Pre: assumes board has been initialized and contains valid char
   //Post: returns true if each column doesn't have a duplicate of 1-9. False otherwise.
   public boolean hasValidColumns() {
   
      for (int c = 0; c < 9; c++) {
         Set<Character> columns = new HashSet<>();
         for (int r = 0; r < 9; r++) {
            char value = board[r][c];
            if (value != '.' && columns.contains(value)) {
               return false;
            }
            if (value != '.') {
               columns.add(value);
            }
         }
      }
      return true;
   }
   
   //Pre: assumes board has been initialized and contains valid char
   //Post: returns true if each minisquare doesn't have a duplicate of 1-9. False otherwise.
   private boolean hasValidMiniSquare() {
      for (int spot = 1; spot <= 9; spot++) {
         Set<Character> squares = new HashSet<>();
         char[][] mini = miniSquare(spot);
         for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
               char value = mini[r][c];
               if (value != '.' && squares.contains(value)) {
                  return false;
               }
               if (value != '.') {
                  squares.add(value);
               }
            }
         }
      }
      return true;
   }
   
   //Pre: Spot is an index passed in that represents the location of the mini square
   //Post: Returns a new 3x3 array per spot
   private char[][] miniSquare(int spot) {
   
      char[][] mini = new char[3][3];
      for (int r = 0; r < 3; r++) {
         for (int c = 0; c < 3; c++) {
            mini[r][c] = board[(spot - 1) / 3 * 3 + r][(spot - 1) % 3 * 3 + c];
         }
      }
      return mini;
   }
   
   
   //Post: Returns true if numbers 1-9 appear 9 times each. False otherwise.
   public boolean isSolved() {
      
      if (!isValid()) {
         return false;
      }
      Map<Character, Integer> solvedMap = new HashMap<>();
      for (int r = 0; r < 9; r++) {
         for (int c = 0; c < 9; c++) {
            char value = board[r][c];
            if (value == '.') {
               return false;
            }
            if (solvedMap.containsKey(value)) {
               solvedMap.put(value, solvedMap.get(value) + 1);
            } else {
               solvedMap.put(value, 1);
            }
         }
      }
      
      for (char num = '1'; num <= '9'; num++) {
         if (solvedMap.get(num) != 9) {
            return false;
         }
      }
      return true;
   }
   
   //Pre: Board is initialized and valid
   //Post: Returns true if board is solved. Otherwise, returns false
   public boolean solve() {
   
      if (!isValid()) {
         return false;
      }
      if (isSolved()) {
         return true;
      }
   
      for (int row = 0; row < 9; row++) {
         for (int col = 0; col < 9; col++) {
            if (board[row][col] == '.') {
            
               for (int x = 1; x <=9; x++) {
               
                  board[row][col] = (char) ('0' + x);
               
                  if (isValid() && solve()) {  
                     return true;
                  }
               }
               
               board[row][col] = '.';
               return false;
            }
         }
      }
      return false;
   }
   
   
   //Post: Returns a sudoku board where each number is in its own cell
   public String toString() {
      String sudokuGame = "_____________________________________\n";
      for (int i = 0; i < board.length; i++) {
          
         for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == '.') {
               sudokuGame += "| . ";
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