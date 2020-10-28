import java.util.Arrays;

/**
 * MagicSquare
 */
public class MagicSquare {

    public static void main(final String[] args) {
        int [][] magicSquare = magic(3);
        for (int[] row : magicSquare) {
            System.out.println(Arrays.toString(row));
        }

    }

    public static int[][] magic(int n) {
        int[][] square = new int[n][n];
        int last = n*n;

        //current position
        int row = 0;
        int col = n / 2;

        for (int i = 1; i <= last; i++) {
            square[row][col] = i;

            //next position
            int nextRow = row-1;
            int nextCol = col-1;

            // if  next position is outside the bounds of rows
            if (row == 0) {
                nextRow = n-1;
            }
            // if next position is outside the bounds of columns
            else if (col == 0) {
                nextCol = n-1;
            }

            // if next position is outside the bounds of both dimensions, OR is already occupied
            if ((row==0 && col==0) || square[nextRow][nextCol] != 0) {
                nextRow = row+1;
                nextCol = col;
            }

            row = nextRow;
            col = nextCol;

        }

        return square;
    }

}
