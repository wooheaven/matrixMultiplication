package linearAlgebra;

import java.util.ArrayList;

public class Matrix {
    public double[][] generateMat(int size) {
        double[][] myMat = new double[size][size];

        for (int i = 0; i < myMat.length; i++) {
            for (int j = 0; j < myMat[0].length; j++) {
                myMat[i][j] = Math.random();
            }
        }

        return myMat;
    }

    public double[][] ijkMatMul(double[][] aMat, double[][] bMat) {
        int n = aMat.length;

        double[][] cMat = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    cMat[i][j] += aMat[i][k] * bMat[k][j];
                }
            }
        }

        return cMat;
    }

    public double[][] ikjMatMul(double[][] aMat, double[][] bMat) {
        int n = aMat.length;

        double[][] cMat = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n; j++) {
                    cMat[i][j] += aMat[i][k] * bMat[k][j];
                }
            }
        }

        return cMat;
    }

    public void printMat(int[][] myMat) {
        for (int i = 0; i < myMat.length; i++) {
            printRow(myMat[i]);
            System.out.println();
        }
    }

    private void printRow(int[] myRow) {
        for (int i = 0; i < myRow.length; i++) {
            System.out.print(myRow[i]+"\t");
        }
    }
}
