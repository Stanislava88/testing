package array;

/**
 * Created by krasimir94 on 10.10.15.
 */
public class Array {

    /**
     * finds the minimal element from array
     *
     * @param array the array from which to search
     * @return int which is the Minimal element
     */
    public int getMin(int[] array) {
        int i = 0;
        int min = 100;
        while (i < array.length - 1) {
            if (array[i] < array[i + 1]) {
                if (array[i] < min) {
                    min = array[i];
                }
            } else if (array[i + 1] < min) {
                min = array[i + 1];
            }
            i++;
        }
        return min;
    }

    /**
     * calculates the sum of the array
     *
     * @param array the array on which the method operates
     * @return integer which represents the sum of the array
     */
    public int getSum(int[] array) {
        int i = 0;
        int sum = 0;
        while (i < array.length) {
            sum = sum + array[i];
            i++;
        }
        return sum;
    }

    /**
     * Prints all the members of an array
     *
     * @param array the array which is being printed
     */
    public void printAll(int[] array) {
        for (int anArray : array) {
            System.out.print(anArray + ", ");
        }
        System.out.println();
    }

    /**
     * reverts an array
     *
     * @param array the array to be reverted
     * @return the reverted array
     */
    public int[] arrRevert(int[] array) {
        int cup;
        for (int i = 0; i < array.length / 2; i++) {
            cup = array[(array.length - i) - 1];
            array[(array.length - i) - 1] = array[i];
            array[i] = cup;
        }
        return array;
    }
}

