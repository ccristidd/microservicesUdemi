package com.tutorial.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SiruriTest {
    Siruri sir=new Siruri();


    @Test
    void display() {
        assertEquals( "a",sir.display());
    }
}