package ru.jevo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import ru.jevo.model.box.Box;
import ru.jevo.model.fruits.Apple;
import ru.jevo.model.fruits.Garnet;

/**
 * Unit test for simple App.
 */
public class AppTest {
    final Box appleFirstBox = new Box(new Apple(), 50);
    final Box garnetFirstBox = new Box(new Garnet(), 60);
    final Box appleSecondBox = new Box(new Apple(), 90);

    @Test
    public void testCompare() {
        assertTrue(appleSecondBox.isCompare(garnetFirstBox));
        assertFalse(appleSecondBox.isCompare(appleFirstBox));
    }

    @Test
    public void testWeight() {
        assertTrue(appleFirstBox.getWeight() == 50);
        assertTrue(garnetFirstBox.getWeight() == 90);
    }

    @Test
    public void testCharge() {
        appleFirstBox.charge(garnetFirstBox);
        appleFirstBox.charge(appleSecondBox);
        assertTrue(appleFirstBox.getBox().size() == 0);
        assertTrue(appleSecondBox.getBox().size() == 140);
    }
}
