package com.clouway.test.tasks;

/**
 * @author Ivaylo Penev(ipenev91@gmail.com) on 9/18/15.
 */
public class Array {

    /**k
     *
     * @param arr an array in which wll look for minimal element
     * @return minimal element of array
     */
    public int getMinElement(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Can't handle zero-length array.");
        }
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    /**
     *
     * @param arr an array which reverse.
     * @return reversed array
     */
    public int[] reversedArray(int[] arr) {
        int[] reversedArray = new int[arr.length];

        if (reversedArray.length == 0) {
            throw new IllegalArgumentException("Can't handle zero-length array.");
        }
        for (int i = 0; i < arr.length; i++) {

            reversedArray[arr.length - i - 1] = arr[i];
        }

        return reversedArray;
    }

    /**
     *
     * @param arr an array in which will sum all elements
     * @return sum of all elements of array
     */
    public int sum(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Zero-length array");
        }
        int sum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /**
     *
     * @param arr an array with elements which will print.
     * @return all elements of given array.
     */
    public int [] printAllElementsOfArray( int [] arr){
        return arr;
    }

}
