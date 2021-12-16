package com.chords.chordsquare;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TestGeneral {
    @Test
    void testSystemEnv(){
        assertNotNull(System.getenv("CHORDSQUARE_MONGO_URI"));
    }
}
