public class SparseMatrixDemo {

    public static void main(String[] args) {
        SparseMatrix s = new SparseMatrix(8); // create an instance of the SparceMatrix
        SparseMatrix sTrans = new SparseMatrix(8); // will hold the transposed matrix returned by the transpose method.


        s.setTerm(0,0,0,15);
        s.setTerm(1,0,3,22);
        s.setTerm(2,0,5,-15);
        s.setTerm(3,1,1,11);
        s.setTerm(4,1,2,3);
        s.setTerm(5,2,3,-6);
        s.setTerm(6,4,0,91);
        s.setTerm(7,5,2,28);

        // transpose the original matrix and copy to SparseMatrix reference sTrans.
        sTrans = s.transpose();

        // code to print out the original and transposed matrix goes here.
        System.out.println("\nMATRIX\n\n" + s + s.arrayToString());
        System.out.println("\nTRANSPOSED\n\n" + sTrans + sTrans.arrayToString() + "\n");
    }
}