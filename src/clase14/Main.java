package clase14;

import clase14.Actividad2.Actividad2;

public class Main {
    public static void main(String[] args) {
        // Tablero 6x6 con una configuración que SÍ tiene solución
        int[][] board = {
                {2, 0, 0, 0, 0, 5},
                {3, 0, 4, 6, 0, 1},
                {6, 4, 0, 1, 5, 0},
                {4, 2, 0, 5, 3, 0},
                {5, 0, 3, 4, 0, 2},
                {1, 3, 5, 0, 6, 0}
        };

        if (Actividad2.solveSudoku(board)) {
            System.out.println("¡Sudoku 6x6 resuelto!");
            Actividad2.printBoard(board);
        } else {
            System.out.println("No existe solución para este Sudoku 6x6.");
        }
    }
}
