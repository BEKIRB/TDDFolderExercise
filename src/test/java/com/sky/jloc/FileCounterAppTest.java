package com.sky.jloc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileCounterAppTest {

    @Test
    public void emptyFolder() {
        assertEquals(0, FileCounterApp.countFiles("src/test/resources/functional/nofiles"));
    }

}
