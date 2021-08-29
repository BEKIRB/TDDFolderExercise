package com.sky.jloc;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.nio.file.InvalidPathException;

import static org.junit.Assert.assertEquals;

public class FileCounterAppTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

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

    @Test
    public void nonExistsFolder(){
        exceptionRule.expect(RuntimeException.class);
        exceptionRule.expectMessage("Folder does not exists");
        String path = "src/test/resources/filecount/dir2/dir21/dir211/nonexists";

        //then
        assertEquals(0, FileCounterApp.countFiles(path));
    }

    @Test
    public void  invalidPath(){
        exceptionRule.expect(InvalidPathException.class);
        String path = "http://fdf.comfsdfsdfsrc/test/resources/filecount/dir2/dir21/dir211/nonexists";

        //then
        assertEquals(0, FileCounterApp.countFiles(path));
    }
}
