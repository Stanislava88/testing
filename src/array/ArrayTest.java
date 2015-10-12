package array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
@RunWith(Parameterized.class)
public class ArrayTest {
  Array arr;
  public final PrintStream original = System.out;

  @Before
  public void setUp() {
    arr = new Array();
  }

  @After
  public void tearDown() {
    System.setOut(original);
  }

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
  }

  private int firstDigit;
  private int secondDigit;
  private int thirdDigit;

  public ArrayTest(int firstDigit, int secondDigit, int thirdDigit) {
    this.firstDigit = firstDigit;
    this.secondDigit = secondDigit;
    this.thirdDigit = thirdDigit;
  }


  @Test
  public void getMin() throws Exception {
    int[] ints = {firstDigit, secondDigit, thirdDigit};
    assertThat("min element not found", firstDigit, is(equalTo(arr.getMin(ints))));
  }

  @Test
  public void getSum() throws Exception {
    int[] ints = {firstDigit, secondDigit, thirdDigit};
    int sum = firstDigit + secondDigit + thirdDigit;
    assertThat("sum not found", sum, is(equalTo(arr.getSum(ints))));
  }

  @Test
  public void printAll() {
    OutputStream os = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(os);
    System.setOut(ps);
    String newline = System.getProperty("line.separator");
    int[] ints = {firstDigit, secondDigit, thirdDigit};
    arr.printAll(ints);
    String message = os.toString();
    String expected = firstDigit + ", " + secondDigit + ", " + thirdDigit + ", " + newline;
    assertThat("print failed", expected, is(equalTo(message)));
  }

  @Test
  public void arrRevert() {
    int[] ints = {firstDigit, secondDigit, thirdDigit};
    int[] expected = {thirdDigit, secondDigit, firstDigit};
    arr.arrRevert(ints);
    assertThat("revertion failed", expected, is(equalTo(ints)));

  }
}