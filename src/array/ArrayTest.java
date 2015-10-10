package array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by krasimir94 on 10.10.15.
 */
public class ArrayTest {
    Array arr = null;

    @Before
    public void setUp() {
        arr = new Array();
    }

    @After
    public void tearDown() {
        arr = null;
    }

    @Test
    public void testGetMin() throws Exception {
        int[] ints = {3, 4, 1, 6, 5};
        assertEquals("min element not found", 1, arr.getMin(ints));
    }

    @Test
    public void testGetSum() throws Exception {
        int[] ints = {3, 4, 1, 6, 5};
        assertEquals("sum not found", 19, arr.getSum(ints));
    }

    @Test
    public void testPrintAll() throws Exception {
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        String newline = System.getProperty("line.separator");
        System.setOut(ps);
        int[] ints = {1, 2, 3};
        arr.printAll(ints);
        String message = os.toString();
        assertEquals("print failed", "1, 2, 3, " + newline, message);
    }

    @Test
    public void testArrRevert() throws Exception {
        int[] ints = {1, 2, 3};
        int[] expected = {3, 2, 1};
        arr.arrRevert(ints);
        assertArrayEquals("revertion failed", expected, ints);
    }
}