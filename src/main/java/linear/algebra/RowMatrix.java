package linear.algebra;

import linear.algebra.throwable.MatrixSizeThrowable;

public class RowMatrix {
    public double[] generateRowMatrix(int rowSize, int colSize) throws MatrixSizeThrowable {
        if (rowSize <= 0) {
            throw new MatrixSizeThrowable("RowMatrix rowSize should be more than 0. And the current size is " + rowSize);
        }
        if (colSize <= 0) {
            throw new MatrixSizeThrowable("RowColMatrix columnSise should be more than 0. And the current columnSise is " + colSize);
        }

        double[] resultRowMatrix = new double[rowSize * colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                resultRowMatrix[i * colSize + j] = Math.round(Math.random() * 10 );
            }
        }

        return resultRowMatrix;
    }

    public double[] ijkRowMatirxMultiplication(double[] aMatrix, double[] bMatrix, int aMatrixColSize) {
        int aMatrixRowSize = aMatrix.length / aMatrixColSize;
        int bMatirxColSize = bMatrix.length / aMatrixColSize;

        double[] resultRowMatrix = new double[aMatrixRowSize * bMatirxColSize];

        for (int i = 0; i < aMatrixRowSize; i++) {
            for (int j = 0; j < bMatirxColSize; j++) {
                for (int k = 0; k < aMatrixColSize; k++) {
                    resultRowMatrix[i * aMatrixColSize + j] += aMatrix[i*aMatrixColSize+k] * bMatrix[k*bMatirxColSize+j];
                }
            }
        }
        return resultRowMatrix;
    }

    public double[] ikjRowMatirxMultiplication(double[] aMatrix, double[] bMatrix, int aMatrixColSize) {
        int aMatrixRowSize = aMatrix.length / aMatrixColSize;
        int bMatirxColSize = bMatrix.length / aMatrixColSize;

        double[] resultRowMatrix = new double[aMatrixRowSize * bMatirxColSize];

        for (int i = 0; i < aMatrixRowSize; i++) {
            for (int k = 0; k < aMatrixColSize; k++) {
                for (int j = 0; j < bMatirxColSize; j++) {
                    resultRowMatrix[i * aMatrixColSize + j] += aMatrix[i*aMatrixColSize+k] * bMatrix[k*bMatirxColSize+j];
                }
            }
        }
        return resultRowMatrix;
    }
}
