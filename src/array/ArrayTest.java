package array;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
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


  @Test
  public void GetMin() throws Exception {
    int[] ints = {3, 4, 1, 6, 5};
    int[] ints2 = {1, 2, 3, -5};
    assertThat("min element not found", 1, is(equalTo(arr.getMin(ints))));
    assertThat("min element not found correctly", -5, is(equalTo(arr.getMin(ints2))));
  }

  @Test
  public void GetSum() throws Exception {
    int[] ints = {3, 4, 1, 6, 5};
    int[] ints2 = {1, 1, 1};
    assertThat("sum not found", 19, is(equalTo(arr.getSum(ints))));
    assertThat("sumn not found correctly", 3, is(equalTo(arr.getSum(ints2))));
  }

  @Test
  public void PrintAll() throws Exception {
    PrintStream original = System.out;
    OutputStream os = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(os);
    System.setOut(ps);
    String newline = System.getProperty("line.separator");
    int[] ints = {1, 2, 3};
    int[] ints2 = {3, 4, 5};
    arr.printAll(ints);
    String message = os.toString();
    assertThat("print failed", "1, 2, 3, " + newline, is(equalTo(message)));
    os = new ByteArrayOutputStream();
    ps = new PrintStream(os);
    System.setOut(ps);
    arr.printAll(ints2);
    String message2 = os.toString();
    System.out.println(message2);
    assertThat("print incorrect", "3, 4, 5, " + newline, is(equalTo(message2)));
    System.setOut(original);
    System.out.println();
  }

  @Test
  public void ArrRevert() throws Exception {
    int[] ints = {1, 2, 3};
    int[] expected = {3, 2, 1};
    int[] ints2 = {9, 8, 0};
    int[] expected2 = {0, 8, 9};
    arr.arrRevert(ints);
    assertThat("revertion failed", expected, is(equalTo(ints)));
    arr.arrRevert(ints2);
    assertThat("revertion not correct", expected2, is(equalTo(ints2)));
  }
}