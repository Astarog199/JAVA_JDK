package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MapTest {
    Map map = new Map();

    @Test
    void testCheckWin() {
        map.initMap();

        map.field[0][0] = 1;
        map.field[1][1] = 1;
        map.field[2][2] = 1;

        Assertions.assertEquals(true, map.checkWin(1));

        map.field[0][2] = 2;
        map.field[1][1] = 2;
        map.field[2][0] = 2;

        Assertions.assertEquals(true, map.checkWin(2));
    }
}

