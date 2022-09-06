package fundamentals.programmingModel.binarySearch;

import fundamentals.programmingModel.binarySearch.BinarySearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinarySearchTest {


    /**
     * On empty array should return -1
     */
    @Test()
    public void testEmptyArray() {
        int[] emptyArray = {};
        Assertions.assertEquals(-1, BinarySearch.find(emptyArray, 0));
    }

    /**
     * On array with one element return element
     */
    @Test
    public void onOneElementArrayReturn() {
        int[] array = {0};
        Assertions.assertEquals(0, BinarySearch.find(array, 0));
    }

    /**
     * On array with one element return -1 if when element is not found
     */
    @Test
    public void onOneElementArrayReturnNotFound() {
        int[] array = {0};
        Assertions.assertEquals(-1, BinarySearch.find(array, -1));
    }

    /**
     * On
     *  the item already exists in the array
     *  odd number of items
     *
     *  Should return index of element in array
     */
    @Test
    public void haveItemOddArray() {
        int[] array = {1, 2, 3};
        Assertions.assertEquals(3, BinarySearch.find(array, 3));
    }

    /**
     * On
     *  the item already exists in the array
     *  even number of items
     *
     *  Should return index of element in array
     */
    @Test
    public void haveItemEvenArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        Assertions.assertEquals(6, BinarySearch.find(array, 6));
    }

    /**
     * On
     *  item does not exist in the array
     *  odd number of items
     *
     *  Should return -1
     */
    @Test
    public void noItemOddArray() {
        int[] array = {1, 2, 3};
        Assertions.assertEquals(-1, BinarySearch.find(array, 4));
    }

    /**
     * On
     *  item does not exist in the array
     *  even number of items
     *
     *  Should return -1
     */
    @Test
    public void noItemEvenArray() {
        int[] array = {1, 2, 3, 4};
        Assertions.assertEquals(-1, BinarySearch.find(array, 5));
    }

    /**
     * On last element in array
     *  Should return last element
     */
    @Test
    public void lastElement() {
        int[] array = {1, 2, 3, 4, 5};
        Assertions.assertEquals(5, BinarySearch.find(array, 5));
    }

    /**
     * On first element in array
     *  Should return first element
     */
    @Test
    public void firstElement() {
        int[] array = {1, 2, 3, 4, 5};
        Assertions.assertEquals(1, BinarySearch.find(array, 1));
    }

}
