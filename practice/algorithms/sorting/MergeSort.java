package algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * mergeSirt: sorting algorithm using the divide and conquer schema.
 * the idea is to split the array recursevly, sort the halves and then merge
 */
public class MergeSort {
    public static void main(String[] args) {
        List<int[]> testCases = new ArrayList<>();
        testCases.add(new int[] {});                                //empty array
        testCases.add(new int[] {1});                               //array with one elem
        testCases.add(new int[] {3, 2});                            //array with 2 elems
        testCases.add(new int[] {3, 3, 3});                         //array of repeated elem
        testCases.add(new int[] {1, 2, 3, 4});                      //sorted array
        testCases.add(new int[] {4, 3, 2, 1});                      //reverse sorted array
        testCases.add(new int[] {2, 1, 4, 5, 9, 2, 3, 6, 7, 21});   //real case

        //test of int merge sort
        for(int[] testCase : testCases){
            System.out.println("before sorting: " + Arrays.toString(testCase));
            sort(testCase, 0, testCase.length - 1);
            System.out.println("after sorting: " + Arrays.toString(testCase));
        }
    }

    public static void sort(int[] array, int start, int end){
        if(start >= end)
            return;
        int middle = (start + end) / 2;
        sort(array, start, middle);
        sort(array, middle+1, end);
        merge(array, start, middle, end);
    }

    public static void merge(int[] array, int start, int middle, int end){
        int[] leftHalf = new int[middle - start + 1];
        int[] rightHalf = new int[end - middle];

        //fill the left half
        for(int i = 0; i < leftHalf.length; i++)
            leftHalf[i] = array[start + i];

        //fill the right half
        for(int i = 0; i < rightHalf.length; i++)
            rightHalf[i] = array[middle + i + 1];
        
        int leftIndex = 0, rightIndex = 0;
        int currentIndex = start;
    
        //merge the two arrays: confront the first (smallest) element of the 
        //left half with the first (smallest) element of the right half, the
        //smallest will be first on the merged sequence
        while(leftIndex < leftHalf.length && rightIndex < rightHalf.length)
            if(leftHalf[leftIndex] < rightHalf[rightIndex])
                array[currentIndex++] = leftHalf[leftIndex++];
            else
                array[currentIndex++] = rightHalf[rightIndex++];

        //copy the remaining elements of the left half if any 
        //this is the case where the smallest element of the left half
        //is bigger than any element of the right half
        while(leftIndex < leftHalf.length)
            array[currentIndex++] = leftHalf[leftIndex++];

        //the analgous of the previous while
        while(rightIndex < rightHalf.length)
            array[currentIndex++] = rightHalf[rightIndex++];
    }
}
