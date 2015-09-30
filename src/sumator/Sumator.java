package sumator;

/**
 * @author raikov.krasimir@gmail.com (Krasimir Raikov)
 */
public class Sumator {

  /**
   * Calculates the sum of two strings
   *
   * @param a the first string
   * @param b the second string
   * @return the sum of the strings
   */
  public int sum(String a, String b) {
    int s = Integer.parseInt(a);
    int t = Integer.parseInt(b);
    return s + t;
  }
}
