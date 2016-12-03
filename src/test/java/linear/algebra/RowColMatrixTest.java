package linear.algebra;

import linear.algebra.throwable.MatrixSizeThrowable;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StopWatch;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RowColMatrixTest {
    private StopWatch st;
    private RowColMatrix rowColMatrix;
    private double[][] aRowColMatrix;
    private double[][] bRowColMatrix;
    private double[][] cRowColMatrix;
    private double[][] dRowColMatrix;
    private double cMatValue;
    private double dMatValue;
    private double different;

    @Before
    public void setUp() throws MatrixSizeThrowable {
        st = new StopWatch("RowColMatrix Multiplication");
        rowColMatrix = new RowColMatrix();
        aRowColMatrix = rowColMatrix.generateRowColMatrtix(300, 200);
        bRowColMatrix = rowColMatrix.generateRowColMatrtix(200, 300);
    }

    @Test
    public void rowColMatrtixMul() throws MatrixSizeThrowable {
        st.start("ijk RowColMatrix Multiplication");
        cRowColMatrix = rowColMatrix.ijkRowColMatrtixMultiplication(aRowColMatrix, bRowColMatrix);
        st.stop();

        st.start("ikj RowColMatrix Multiplication");
        dRowColMatrix = rowColMatrix.ikjRowColMatrtixMultiplication(aRowColMatrix, bRowColMatrix);
        st.stop();

        for (int i = 0; i < cRowColMatrix.length; i++) {
            for (int j = 0; j < cRowColMatrix[i].length; j++) {
                cMatValue = cRowColMatrix[i][j];
                dMatValue = dRowColMatrix[i][j];
                different = Math.abs(cMatValue - dMatValue);
                assertThat("Compare RowColMatrix["+i+"]["+j+"] is different", different, is(0.0));
            }
        }

        System.out.println(st.prettyPrint());
    }
}