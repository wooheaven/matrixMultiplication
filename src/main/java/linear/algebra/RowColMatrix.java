package linear.algebra;

import linear.algebra.throwable.MatrixSizeThrowable;

public class RowColMatrix {
    public double[][] generateRowColMatrtix(int rowSize, int colSize) throws MatrixSizeThrowable {
        if (rowSize <= 0) {
            throw new MatrixSizeThrowable("RowColMatrix rowSize should be more than 0. And the current rowSize is " + rowSize);
        }
        if (colSize <= 0) {
            throw new MatrixSizeThrowable("RowColMatrix columnSise should be more than 0. And the current columnSise is " + colSize);
        }

        double[][] resultRowColMatrix = new double[rowSize][colSize];

        for (int i = 0; i < resultRowColMatrix.length; i++) {
            for (int j = 0; j < resultRowColMatrix[0].length; j++) {
                resultRowColMatrix[i][j] = Math.random();
            }
        }

        return resultRowColMatrix;
    }

    public double[][] ijkRowColMatrtixMultiplication(double[][] aRowColMatrix, double[][] bRowColMatrix) throws MatrixSizeThrowable {
        if (aRowColMatrix[0].length != bRowColMatrix.length) {
            throw new MatrixSizeThrowable("aMat colmunSize should be same bMat rowSize.\n"
                    + "aMat columnSize = " + aRowColMatrix[0].length + "\n"
                    + "bMat rowSize = " + bRowColMatrix.length);
        }
        int n = aRowColMatrix[0].length;

        double[][] resultRowColMatrix = new double[aRowColMatrix.length][bRowColMatrix[0].length];

        for (int i = 0; i < aRowColMatrix.length; i++) {
            for (int j = 0; j < bRowColMatrix[0].length; j++) {
                for (int k = 0; k < n; k++) {
                    resultRowColMatrix[i][j] += aRowColMatrix[i][k] * bRowColMatrix[k][j];
                }
            }
        }

        return resultRowColMatrix;
    }

    public double[][] ikjRowColMatrtixMultiplication(double[][] aRowColMatrix, double[][] bRowColMatrix) throws MatrixSizeThrowable {
        if (aRowColMatrix[0].length != bRowColMatrix.length) {
            throw new MatrixSizeThrowable("aMat colmunSize should be same bMat rowSize.\n"
                    + "aMat columnSize = " + aRowColMatrix[0].length + "\n"
                    + "bMat rowSize = " + bRowColMatrix.length);
        }
        int n = aRowColMatrix[0].length;

        double[][] resultRowColMatrix = new double[aRowColMatrix.length][bRowColMatrix[0].length];

        for (int i = 0; i < aRowColMatrix.length; i++) {
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < bRowColMatrix[0].length; j++) {
                    resultRowColMatrix[i][j] += aRowColMatrix[i][k] * bRowColMatrix[k][j];
                }
            }
        }

        return resultRowColMatrix;
    }
}
