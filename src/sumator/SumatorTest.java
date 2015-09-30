package sumator;

import org.junit.*;
import org.junit.Test;
import org.junit.Assert;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class SumatorTest {
  private Sumator sumator;

  @Before
  public void setUp() {
    sumator = new Sumator();
  }

  @Test
  public void sum() {
    int i = sumator.sum("1", "2");
    Assert.assertEquals(3, i);
  }

  @Test(expected = IllegalArgumentException.class)
  public void sumException() {
    sumator.sum("", "2");
  }

  @Test(expected = IllegalArgumentException.class)
  public void sumSymbolException() {
    sumator.sum("s", "4");

  }

  @After
  public void tearDown() {
    sumator = null;
  }
}
