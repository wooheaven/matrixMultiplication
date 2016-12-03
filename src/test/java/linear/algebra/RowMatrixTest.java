package linear.algebra;

import linear.algebra.throwable.MatrixSizeThrowable;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StopWatch;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RowMatrixTest {
    private StopWatch stopWatch;
    private RowMatrix matrix;
    private int aMatrixRowSize;
    private int aMatrixColSize;
    private int bMatrixColSize;
    private double[] aMatrix;
    private double[] bMatrix;
    private double[] cMatrix;
    private double[] dMatrix;
    private double cValue;
    private double dValue;
    private double different;

    @Before
    public void setUp() throws MatrixSizeThrowable {
        stopWatch = new StopWatch("RowMatrix Multiplication");
        matrix = new RowMatrix();
        aMatrixRowSize = 300;
        aMatrixColSize = 200;
        bMatrixColSize = 300;
        aMatrix = matrix.generateRowMatrix(aMatrixRowSize, aMatrixColSize);
        bMatrix = matrix.generateRowMatrix(aMatrixColSize, bMatrixColSize);
    }

    @Test
    public void rowMatrixMultiplicationTest(){
        stopWatch.start("ijk RowMatix Multiplication");
        cMatrix = matrix.ijkRowMatirxMultiplication(aMatrix, bMatrix, aMatrixColSize);
        stopWatch.stop();

        stopWatch.start("ikj RowMatix Multiplication");
        dMatrix = matrix.ikjRowMatirxMultiplication(aMatrix, bMatrix, aMatrixColSize);
        stopWatch.stop();

        for (int i = 0; i < aMatrixRowSize; i++) {
            for (int j = 0; j < aMatrixColSize; j++) {
                cValue = cMatrix[i* bMatrixColSize +j];
                dValue = dMatrix[i* bMatrixColSize +j];
                different = Math.abs(cValue - dValue);
                assertThat("Compare RowMatrix["+i+"]["+j+"] is different", different, is(0.0));
            }
        }

        System.out.println(stopWatch.prettyPrint());
    }
}