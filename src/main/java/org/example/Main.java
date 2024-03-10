package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        int lengthArr = arr.length;
        if (lengthArr == 1) {
            return;
        }

        int mid = (lengthArr % 2 != 0) ? lengthArr / 2 + 1 : lengthArr / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int[lengthArr - mid];

        System.arraycopy(arr, 0, leftArr, 0, mid);

        if (lengthArr - mid >= 0) System.arraycopy(arr, 0 + mid, rightArr, 0, lengthArr - mid);

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(arr, leftArr, rightArr);
    }

    private static void merge(int[] arr, int[] leftArr, int[] rightArr) {
        int leftArrLength = leftArr.length;
        int rightArrLength = rightArr.length;
        int leftIndex = 0;
        int rightIndex = 0;
        int arrIndex = 0;

        while (leftIndex < leftArrLength && rightIndex < rightArrLength) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                arr[arrIndex] = rightArr[rightIndex];
                rightIndex++;
            } else {
                arr[arrIndex] = leftArr[leftIndex];
                leftIndex++;
            }
            arrIndex++;
        }

        while (leftIndex < leftArrLength) {
            arr[arrIndex] = leftArr[leftIndex];
            leftIndex++;
            arrIndex++;
        }

        while (rightIndex < rightArrLength) {
            arr[arrIndex] = rightArr[rightIndex];
            rightIndex++;
            arrIndex++;
        }
    }
}