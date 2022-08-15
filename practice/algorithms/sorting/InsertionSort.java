package algorithms.sorting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * insertionSort: in-place sorting of the array, one element at a time.
 * the idea is the same behind the card ordering: check element at
 * index i and i+1, if the element at index i+1 is smaller than swap
 */
public class InsertionSort {
    public static void main(String[] args) {
        List<int[]> testCases = new ArrayList<>();
        testCases.add(new int[] {});                                //empty array
        testCases.add(new int[] {1});                               //array with one elem
        testCases.add(new int[] {3, 2});                            //array with 2 elems
        testCases.add(new int[] {3, 3, 3});                         //array of repeated elem
        testCases.add(new int[] {1, 2, 3, 4});                      //sorted array
        testCases.add(new int[] {4, 3, 2, 1});                      //reverse sorted array
        testCases.add(new int[] {2, 1, 4, 5, 9, 2, 3, 6, 7, 21});   //real case

        // test of generic insertion sort
        for(int[] testCase : testCases){
            Integer[] objArray = Arrays.stream(testCase).boxed().toArray(Integer[] :: new);
            System.out.println("before sorting: " + Arrays.toString(objArray));
            genericSort(objArray);
            System.out.println("after sorting: " + Arrays.toString(objArray));
        }
    }

    /**
     * sort an array of integers using the insertion sort algorithm
     * @param array is the array to be sorted in ascending order
     */
    public static void sort(int[] array){
        for(int i = 0; i < array.length; i++){
            int j = i;
            while (j > 0 && array[j-1] > array[j]) {
                swap(array, j, j-1);
                j--;
            }
        }
    }

    /**
     * swap two elements in the array, we assume no overflow
     * @param array of which elements have to be swapped
     * @param i first index's element
     * @param j second index's element
     */
    private static void swap(int[] array, int i, int j){
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T extends Comparable<? super T>> void genericSort(T[] array){
        for(int i = 0; i < array.length; i++){
            int j = i;
            while(j > 0 && array[j-1].compareTo(array[j]) > 0){
                genericSwap(array, j, j-1);
                j--; 
            }
        }
    }

    private static <T> void genericSwap(T[] array, int i, int j){
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}