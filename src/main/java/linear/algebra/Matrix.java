package linear.algebra;

public class Matrix {
    public double[][] generateMat(int rowSize, int colSise) throws MatrixSizeThrowable {
        if (rowSize <= 0) {
            throw new MatrixSizeThrowable("Matrix size should be more than 0. And the current size is " + rowSize);
        }
        if (colSise <= 0) {
            throw new MatrixSizeThrowable("Matrix size should be more than 0. And the current size is " + colSise);
        }

        double[][] myMat = new double[rowSize][colSise];

        for (int i = 0; i < myMat.length; i++) {
            for (int j = 0; j < myMat[0].length; j++) {
                myMat[i][j] = Math.random();
            }
        }

        return myMat;
    }

    public double[][] generateMat(int size) throws MatrixSizeThrowable {
        return generateMat(size, size);
    }

    public double[][] ijkMatMul(double[][] aMat, double[][] bMat) throws MatrixSizeThrowable {
        if (aMat[0].length != bMat.length) {
            throw new MatrixSizeThrowable("aMat colmunSize should be same bMat rowSize.\n"
                    + "aMat columnSize = " + aMat[0].length + "\n"
                    + "bMat rowSize = " + bMat.length);
        }
        int n = aMat[0].length;

        double[][] cMat = new double[aMat.length][bMat[0].length];

        for (int i = 0; i < aMat.length; i++) {
            for (int j = 0; j < bMat[0].length; j++) {
                for (int k = 0; k < n; k++) {
                    cMat[i][j] += aMat[i][k] * bMat[k][j];
                }
            }
        }

        return cMat;
    }

    public double[][] ikjMatMul(double[][] aMat, double[][] bMat) throws MatrixSizeThrowable {
        if (aMat[0].length != bMat.length) {
            throw new MatrixSizeThrowable("aMat colmunSize should be same bMat rowSize.\n"
                    + "aMat columnSize = " + aMat[0].length + "\n"
                    + "bMat rowSize = " + bMat.length);
        }
        int n = aMat[0].length;

        double[][] cMat = new double[aMat.length][bMat[0].length];

        for (int i = 0; i < aMat.length; i++) {
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < bMat[0].length; j++) {
                    cMat[i][j] += aMat[i][k] * bMat[k][j];
                }
            }
        }

        return cMat;
    }

    public void printMat(double[][] myMat) {
        for (int i = 0; i < myMat.length; i++) {
            printRow(myMat[i]);
        }
    }

    private void printRow(double[] myRow) {
        for (int i = 0; i < myRow.length; i++) {
            System.out.print(myRow[i] + "\t");
        }
        System.out.println();
    }
}
