public class SparseMatrix {
    private static final int DEFAULT_SIZE = 20;
    private MatrixTerm[] matrix;

    public SparseMatrix() {
        this(DEFAULT_SIZE);
    }

    public SparseMatrix(int t) {
        matrix = new MatrixTerm[t];
    }

    public int getCols() {
        int cols = 0;
        for (int i = matrix.length-1; i >= 0; i--) {
            int col = matrix[i].getCol();
            if (col > cols) cols = col;
        }
        return ++cols;
    }

    public int getRows() {
        int rows = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            int row = matrix[i].getRow();
            if (row > rows) rows = row;
        }
        return ++rows;
    }

    public void setTerm(int index, int row, int col, int val) {
        matrix[index] = new MatrixTerm(row, col, val);
    }

    public SparseMatrix transpose() {
        SparseMatrix transposed = new SparseMatrix(matrix.length);
        final int ROW_SIZE = getCols();
        final int ARR_SIZE = matrix.length;
        int index = 0;

        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < ARR_SIZE; j++) {
                if (matrix[j].getCol() == i) {
                    int col = matrix[j].getRow();
                    int row = matrix[j].getCol();
                    int val = matrix[j].getVal();
                    transposed.setTerm(index, row, col, val);
                    index++;
                }
            }
        }

        return transposed;
    }

    public String arrayToString() {
        int max = 0;

        for (MatrixTerm matrixTerm : matrix) {
            int val = Math.abs(matrixTerm.getVal());
            if (val > max)
                max = val;
        }

        max = String.valueOf(max).length() + 2;
        String format = "%" + max + "d";


        StringBuilder rows = new StringBuilder("\nrow:");
        StringBuilder cols = new StringBuilder("\ncol:");
        StringBuilder vals = new StringBuilder("\nval:");


        for (MatrixTerm matrixTerm : matrix) {
            rows.append(String.format(format, matrixTerm.getRow()));
            cols.append(String.format(format, matrixTerm.getCol()));
            vals.append(String.format(format, matrixTerm.getVal()));
        }

        StringBuilder result = new StringBuilder();
        result.append(rows).append(cols).append(vals);

        return result.toString();
    }


    public String toString() {
        final int ROW_SIZE = getCols();
        final int COL_SIZE = getRows();
        int max = 0;

        for (MatrixTerm matrixTerm : matrix) {
            int val = Math.abs(matrixTerm.getVal());
            if (val > max) max = val;
        }

        max = Math.max(Math.max(ROW_SIZE, COL_SIZE), max);
        max = String.valueOf(max).length() + 2;

        String format = "%" + max + "d";
        String value = "";
        StringBuilder result = new StringBuilder();
        int k = 0;

        for (int i = 0; i < ROW_SIZE; i++) {
            for (int j = 0; j < COL_SIZE; j++) {
                int row = matrix[k].getRow();
                int col = matrix[k].getCol();

                if (row == i && col == j) {
                    value = String.format(format, matrix[k].getVal());
                    k = (k + 1) % matrix.length;
                } else {
                    value = String.format(format, 0);
                }
                result.append(value);
            }
            result.append("\n");
        }

        return result.toString();
    }

}