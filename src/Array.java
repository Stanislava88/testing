/**
 * Created by clouway on 15-9-25.
 */
public class Array {
    /**
     * @param array
     * @return minimal element of the array
     */

    public int getMinimalElement(int[] array) {

        if (array==null || array.length == 0) {
            throw new IllegalArgumentException();
        }

        int minElement = array[0];
        for (int i = 1; i < array.length; i++) {

            if (array[i] < minElement) {
                minElement = array[i];
            }
        }
        return minElement;
    }

    /**
     * @param array
     * @return sum of all elements of the array
     */

    public int getSum(int[] array) {
        if (array==null || array.length == 0) {
            throw new IllegalArgumentException();
        }
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }

        return sum;
    }

    public void printArray(int[] array,ArrayOutput arrout) {
        for(int i=0;i<array.length;i++){
            arrout.saveArr(array[i]);
        }
    }

    public void add(int a, int b){
        int c=a+b;
    }

}

