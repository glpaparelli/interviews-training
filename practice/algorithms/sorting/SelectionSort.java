package algorithms.sorting;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
/**
 * selectionSort: in-place sorting algorithm, one element at a time.
 * the idea is the naive one: for each element i find the minimum from 
 * i+1 to the end of the sequence. If that is bigger than swap and procede
 */
public class SelectionSort {
    public static void main(String[] args) {
        List<int[]> testCases = new ArrayList<>();
        testCases.add(new int[] {});                                //empty array
        testCases.add(new int[] {1});                               //array with one elem
        testCases.add(new int[] {3, 2});                            //array with 2 elems
        testCases.add(new int[] {3, 3, 3});                         //array of repeated elem
        testCases.add(new int[] {1, 2, 3, 4});                      //sorted array
        testCases.add(new int[] {4, 3, 2, 1});                      //reverse sorted array
        testCases.add(new int[] {2, 1, 4, 5, 9, 2, 3, 6, 7, 21});   //real case

        // //test of int insertion sort
        // for(int[] testCase : testCases){
        //     System.out.println("before sorting: " + Arrays.toString(testCase));
        //     sort(testCase);
        //     System.out.println("after sorting: " + Arrays.toString(testCase));
        // }

        //test of generic insertion sort
        for(int[] testCase : testCases){
            Integer[] objArray = Arrays.stream(testCase).boxed().toArray(Integer[] :: new);
            System.out.println("before sorting: " + Arrays.toString(objArray));
            genericSort(objArray);
            System.out.println("after sorting: " + Arrays.toString(objArray));
        }
    }

    /**
     * sort an array of integers using the selection sort algorithm
     * @param array is the array to be sorted in ascending order
     */
    public static void sort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            int min_index = i;
            for(int j = i + 1; j < array.length; j++)
                if(array[j] < array[min_index])
                    min_index = j;
            
            if(min_index != i)
                swap(array, i, min_index);
        }
    }

    public static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T extends Comparable<? super T>> void genericSort(T[] array){
        for(int i = 0; i < array.length - 1; i++){
            int min_index = i;
            for(int j = i + 1; j < array.length; j++)
                if(array[j].compareTo(array[min_index]) < 0)
                    min_index = j;
                
            if(min_index != i)
                genericSwap(array, i, min_index);
        }
    }

    public static <T> void genericSwap(T[] array, int i, int j){
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
