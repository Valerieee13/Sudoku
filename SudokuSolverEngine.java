//Valerie Chavez
//CS 143
//HW 3: Part 3
//Update: will print a statement if board is in an invalid state or if it's solved
//Otherwise, will print a solved board



public class SudokuSolverEngine {

   public static void main(String[] args) {
      // Here I have called my class `MySudokuBoard` if you named your class
      // differently, modify the line below to use your own class name
      MySudokuBoard board = new MySudokuBoard("boards/very-fast-solve.sdk");
      System.out.println("Initial board");
      System.out.println(board);
      System.out.println();
      
      if (!board.isValid()) {
         System.out.println("The board can't be solved.");
      } else if (board.isSolved()) {
         System.out.println("The board is already solved.");
      } else {

            System.out.print("Solving board...");
            long start = System.currentTimeMillis();
            board.solve();
            long stop = System.currentTimeMillis();
            System.out.printf("SOLVED in %.3f seconds.\n", ((stop-start)/1000.0));
            System.out.println();
            System.out.println(board);
      }
      
   }
}

/*

  ----jGRASP exec: java SudokuSolverEngine
 Initial board
 _____________________________________
 | . | 3 | 4 | 6 | 7 | 8 | 9 | 1 | 2 |
 _____________________________________
 | . | 7 | 2 | 1 | 9 | 5 | 3 | 4 | 8 |
 _____________________________________
 | 1 | 9 | 8 | 3 | 4 | 2 | 5 | 6 | 7 |
 _____________________________________
 | . | . | 9 | . | 6 | 1 | 4 | 2 | 3 |
 _____________________________________
 | . | 2 | 6 | 8 | 5 | 3 | 7 | 9 | 1 |
 _____________________________________
 | . | 1 | 3 | 9 | 2 | 4 | . | 5 | 6 |
 _____________________________________
 | . | 6 | 1 | 5 | 3 | 7 | 2 | 8 | 4 |
 _____________________________________
 | . | 8 | . | 4 | 1 | 9 | 6 | 3 | 5 |
 _____________________________________
 | 3 | 4 | 5 | . | 8 | 6 | 1 | 7 | 9 |
 _____________________________________
 
 
 Solving board...SOLVED in 0.009 seconds.
 
 _____________________________________
 | 5 | 3 | 4 | 6 | 7 | 8 | 9 | 1 | 2 |
 _____________________________________
 | 6 | 7 | 2 | 1 | 9 | 5 | 3 | 4 | 8 |
 _____________________________________
 | 1 | 9 | 8 | 3 | 4 | 2 | 5 | 6 | 7 |
 _____________________________________
 | 8 | 5 | 9 | 7 | 6 | 1 | 4 | 2 | 3 |
 _____________________________________
 | 4 | 2 | 6 | 8 | 5 | 3 | 7 | 9 | 1 |
 _____________________________________
 | 7 | 1 | 3 | 9 | 2 | 4 | 8 | 5 | 6 |
 _____________________________________
 | 9 | 6 | 1 | 5 | 3 | 7 | 2 | 8 | 4 |
 _____________________________________
 | 2 | 8 | 7 | 4 | 1 | 9 | 6 | 3 | 5 |
 _____________________________________
 | 3 | 4 | 5 | 2 | 8 | 6 | 1 | 7 | 9 |
 _____________________________________
 
 
  ----jGRASP: Operation complete.
 
*/