package fundamentals.programmingModel.binarySearch;

import java.util.Arrays;

/**
 * Search for the element in the sorted array
 */
public class BinarySearch {

    /**
     * Search for the element in the sorted array
     * @return element  if doest not exist return -1
     */
    public static int find(int[] sortedArray, int element) {
        if(sortedArray.length == 0) {
            return -1;
        }
        if(sortedArray.length == 1) {
            return element == sortedArray[0] ? sortedArray[0] : -1;
        }

        int middle = (sortedArray.length) / 2;
        int value = sortedArray[middle];

        if (element == value) {
            return value;
        }
        if (element < value) {
            return find(Arrays.copyOfRange(sortedArray,0, middle), element);
        } else {
            return find(Arrays.copyOfRange(sortedArray, middle, sortedArray.length), element);
        }
    }
}
