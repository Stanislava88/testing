package com.clouway.test.tasks;

/**
 * Created by clouway on 8/18/15.
 */
public class Array {
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
    public int [] printAllElementsOfArray( int [] arr){
        return arr;
    }

}
