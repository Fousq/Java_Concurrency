package kz.zhanbolat.concurrency.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class YamlFileLoader {
    private static final String FILE_EXTENSION = ".yml";

    public static List<File> loadYamlFiles(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            throw new IllegalArgumentException("The directory doesn't exist");
        }
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("To load files, the path of directory should be passed as input parameter.");
        }
        File[] files = directory.listFiles();
        if (Objects.isNull(files)) {
            return Collections.emptyList();
        }
        List<File> fileList = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory()) {
                fileList.addAll(loadYamlFiles(file.getPath()));
            }
            if (file.getName().endsWith(FILE_EXTENSION)) {
                fileList.add(file);
            }
        }
        return fileList;
    }
}
