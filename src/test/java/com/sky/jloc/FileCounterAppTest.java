package com.sky.jloc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FileCounterAppTest {

    @Test
    public void emptyFolder() {
        assertEquals(0, FileCounterApp.countFiles("src/test/resources/functional/nofiles"));
    }

    @Test
    public void noNestedFolder() {
        //given
        String path = "src/test/resources/filecount/dir2/dir21/dir211";

        //then
        assertEquals(1, FileCounterApp.countFiles(path));
    }

}
