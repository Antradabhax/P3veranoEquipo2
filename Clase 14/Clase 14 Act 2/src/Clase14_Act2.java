public class Clase14_Act2 {

    //modificamos el tamaño del tablero a 6x6
    private static final int SIZE = 6;

    //creamos el main con un tablero 6x6 para un ejemplo que se pueda resolver
    public static void main(String[] args) {
        int[][] board = {
                {0, 2, 0, 0, 0, 5},
                {0, 0, 0, 0, 6, 0},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 5, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {6, 0, 0, 0, 3, 0}
        };

        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("No existe solución para este Sudoku.");
        }
    }

    //metodo que resuelve el Sudoku usando backtracking
    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {  //se encuentra una celda vacía
                    //se prueban los números del 1 al 6
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            //se intenta resolver el tablero con recursividad
                            if (solveSudoku(board)) {
                                return true;
                            }

                            //retrosedemos si la asignación no conduce a solución
                            board[row][col] = 0;
                        }
                    }
                    return false;  //si ningún número es válido, retrocede
                }
            }
        }
        return true;  //se completo el tablero con posiciones validas
    }

    //metodo para verificar si un número puede ser colocado en la posición (row, col)
    private static boolean isValid(int[][] board, int row, int col, int num) {
        //verificamos si el número está en la fila
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        //verificamos si el número está en la columna
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        //verificamos para el subcuadrante de 2x3
        int blockRow = row - row % 2;
        int blockCol = col - col % 3;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[blockRow + i][blockCol + j] == num) {
                    return false;
                }
            }
        }

        return true;  //si pasa todas las pruebas, es válido
    }

    //metodo para imprimir el tablero
    private static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}