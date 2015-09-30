package sumator;

import junit.framework.TestCase;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class SumatorTest extends TestCase {
  private Sumator sumator;

  protected void setUp() throws Exception {
    sumator = new Sumator();
  }


  public void testSum() {
    int i = sumator.sum("1", "2");
    assertEquals(3, i);
  }

  public void testSumException() {
    try {
      sumator.sum("", "2");
      fail("expected exception to be thrown when '' and '2' parameters are given, but it didn't happen");
    } catch (IllegalArgumentException a) {
    }
  }

  public void testSumSymbolException() {
    try {
      sumator.sum("s", "4");
      fail();
    } catch (IllegalArgumentException a) {
    }
  }
}
