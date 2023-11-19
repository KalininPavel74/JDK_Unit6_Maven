package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void isTrue() {
        Main main = new Main();
        System.out.println(main);
        assertEquals(Boolean.TRUE, main.isTrue());
    }

    @Test
    void empty() {
        assertEquals(Boolean.TRUE, Main.empty());
    }

}