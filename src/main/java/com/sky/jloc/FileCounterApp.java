package com.sky.jloc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileCounterApp {
    public static void main(String[] args) {
        System.out.println("Files: " + countFiles(args[0]));
    }

    public static int countFiles(String path) {
        try {
            Path mainFolder = Paths.get(path);
            if(!Files.exists(mainFolder)){
                throw new RuntimeException("folder does not exists");
            }
            List<File> files = Files.list(Paths.get(path)).map(Path::toFile).collect(Collectors.toList());

            return files.size();
        } catch (IOException e) {
            throw new RuntimeException("An Exception occured");
        }
    }



}
