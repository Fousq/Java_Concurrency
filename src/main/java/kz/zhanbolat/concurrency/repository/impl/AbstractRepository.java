package kz.zhanbolat.concurrency.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Objects;

public abstract class AbstractRepository {
    protected ObjectMapper objectMapper;

    protected AbstractRepository(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    protected void checkParameters(File file) {
        Objects.requireNonNull(file);
        if (file.isDirectory()) {
            throw new IllegalArgumentException("Cannot read values from the directory. " +
                    "The file should be passed as input parameter.");
        }
    }
}
