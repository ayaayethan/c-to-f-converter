package edu.csumb.cst_338;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    double c_freezing = 0.0;
    double f_freezing = 32.0;
    double c_boiling = 100.0;
    double f_boiling = 212.0;
    double nForty = -40.0;

    @Test
    public void ctofTest() {
        assertEquals(f_freezing, Utils.ctof(c_freezing), 0.001);
        assertEquals(f_boiling, Utils.ctof(c_boiling), 0.001);
        assertEquals(nForty, Utils.ctof(nForty), 0.001);
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}