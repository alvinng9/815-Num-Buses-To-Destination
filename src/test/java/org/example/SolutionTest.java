package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void numBusesToDestinationTest() {
        Solution solution = new Solution();
        Assert.assertEquals(2,
                solution.numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
        Assert.assertEquals(-1,
                solution.numBusesToDestination(new int[][]
                        {{7,12},{4,5,15},{6},{15,19},{9,12,13}}, 15, 12));
    }

}