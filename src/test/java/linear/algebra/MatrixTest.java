package linear.algebra;

import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StopWatch;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {
    private Matrix mat = new Matrix();
    private double[][] aMat = new double[][]{};
    private double[][] bMat = new double[][]{};
    private StopWatch st = new StopWatch("Matrix Multiplication");

    @Before
    public void setUp() throws MatrixSizeThrowable {
        aMat = mat.generateMat(1000);
        bMat = mat.generateMat(1000);
    }

    @Test
    public void matrixMul() throws Exception {
        st.start("ijk");
        double[][] cMat = mat.ijkMatMul(aMat, bMat);
        st.stop();

        st.start("ikj");
        double[][] dMat = mat.ikjMatMul(aMat, bMat);
        st.stop();

        assertThat("Compare Matrix", cMat, is(dMat));

        System.out.println(st.prettyPrint());
    }
}