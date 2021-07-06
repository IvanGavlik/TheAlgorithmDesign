package util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberService {

    public int nexRandomInt(int start, int end) {
        return ThreadLocalRandom.current().nextInt(start, end);
    };
}
