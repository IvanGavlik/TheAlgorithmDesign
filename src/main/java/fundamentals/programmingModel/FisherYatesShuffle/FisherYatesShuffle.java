package fundamentals.programmingModel.FisherYatesShuffle;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 The Fisher–Yates shuffle is an algorithm for generating a
 random permutation of a finite sequence—in plain terms,
 the algorithm shuffles the sequence.

 The algorithm effectively puts all the elements into a hat; it continually
 determines the next element by randomly drawing an element from the hat until
 no elements remain.

 @see: https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#Sattolo.27s_algorithm
 */
public class FisherYatesShuffle {

    /**
     * Fisher–Yates shuffle
     *     Write down the numbers from 1 through N.
     *     Pick a random number k between one and the number of unstruck numbers remaining (inclusive).
     *     Counting from the low end, strike out the kth number not yet struck out, and write it down at the end of a separate list.
     *     Repeat from step 2 until all the numbers have been struck out.
     *     The sequence of numbers written down in step 3 is now a random permutation of the original numbers.
     *
     * Example: have array length of 9
     *  From 1 - 9 Rolled 2 swap 9 and 3
     *  From 1 - 8 Rolled 8 skip
     *  From 1 - 7 Rolled 4 swap 7 and 4
     *  From 1 - 6 Rolled 6 skip
     *  From 1 - 5 Rolled 5 skip
     *  From 1 - 4 rolled 1 swap 4 and 1
     *  From 1 - 3 rolled 2 swap 2 and 3
     *  From 1 - 2 rolled 3 skip
     *
     * @param array
     * @return
     */
    // TODO write tests note MOCK
    public static <ELEMENT> ELEMENT[] shuffle(ELEMENT[] array) {
        int length = array.length;

        // start form the end
        for(int i = length -1; i >= 0; i--) {
            int random = ThreadLocalRandom.current().nextInt(0, i+1);
            if (random == i) {
                continue;
            }

            ELEMENT randomEL = array[random];
            ELEMENT lastNotShuffle = array[i];

            array[random] = lastNotShuffle;
            array[i] = randomEL;
        }

        return array;
    }
}
