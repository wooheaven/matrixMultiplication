package linear.algebra;

import linear.algebra.throwable.MatrixSizeThrowable;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StopWatch;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RowColMatrixTest {
    private StopWatch stopWatch;
    private RowColMatrix matrix;
    private int aMatrixRowSize;
    private int aMatrixColSize;
    private int bMatrixColSize;
    private double[][] aMatrix;
    private double[][] bMatrix;
    private double[][] cMatrix;
    private double[][] dMatrix;
    private double cValue;
    private double dValue;
    private double different;

    @Before
    public void setUp() throws MatrixSizeThrowable {
        stopWatch = new StopWatch("RowColMatrix Multiplication");
        matrix = new RowColMatrix();
        aMatrixRowSize = 300;
        aMatrixColSize = 200;
        bMatrixColSize = 300;
        aMatrix = matrix.generateRowColMatrtix(aMatrixRowSize, aMatrixColSize);
        bMatrix = matrix.generateRowColMatrtix(aMatrixColSize, bMatrixColSize);
    }

    @Test
    public void rowColMatrtixMultiplication() throws MatrixSizeThrowable {
        stopWatch.start("ijk RowColMatrix Multiplication");
        cMatrix = matrix.ijkRowColMatrtixMultiplication(aMatrix, bMatrix);
        stopWatch.stop();

        stopWatch.start("ikj RowColMatrix Multiplication");
        dMatrix = matrix.ikjRowColMatrtixMultiplication(aMatrix, bMatrix);
        stopWatch.stop();

        for (int i = 0; i < cMatrix.length; i++) {
            for (int j = 0; j < cMatrix[i].length; j++) {
                cValue = cMatrix[i][j];
                dValue = dMatrix[i][j];
                different = Math.abs(cValue - dValue);
                assertThat("Compare RowColMatrix["+i+"]["+j+"] is different", different, is(0.0));
            }
        }

        System.out.println(stopWatch.prettyPrint());
    }
}