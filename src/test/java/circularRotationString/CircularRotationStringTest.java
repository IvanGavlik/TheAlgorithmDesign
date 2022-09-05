package circularRotationString;

import fundamentals.dataAbstraction.distancePoints.circularRotationString.CircularRotationString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CircularRotationStringTest {

    @Test
    public void onPassNull() {
        Assertions.assertFalse(CircularRotationString.isCircular(null, ""));
        Assertions.assertFalse(CircularRotationString.isCircular("", null));
        Assertions.assertFalse(CircularRotationString.isCircular(null, null));
    }

    @Test
    public void onPassStringUnequalLength() {
        Assertions.assertFalse(CircularRotationString.isCircular("A", "AB"));
        Assertions.assertFalse(CircularRotationString.isCircular("AB", "A"));
    }

    @Test
    public void onPassCircularString() {
        Assertions.assertTrue(CircularRotationString.isCircular("ACTGACG", "TGACGAC"));
        Assertions.assertTrue(CircularRotationString.isCircular("TGACGAC", "ACTGACG"));
    }

    @Test
    public void onPassNoCircularString() {
        Assertions.assertFalse(CircularRotationString.isCircular("ACTGACD", "TGACGAC"));
        Assertions.assertFalse(CircularRotationString.isCircular("TGACGAC", "ACTGACD"));
    }


}
