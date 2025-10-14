package com.example.fileprocessor;
import java.io.IOException;
import java.util.List;

public interface FileService {
    List<String> readLines(String path) throws IOException;
    void writeLines(String path, List <String> lines) throws IOException;
}
