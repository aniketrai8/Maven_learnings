package com.example.fileprocessor;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileProcessor {
    private final FileService fileService ;

    public FileProcessor (FileService fileService){
        this.fileService = fileService;

    }
    public List<String> readLines(String filePath) throws IOException {
        return fileService.readLines(filePath);
    }
    public List<String> toUpperCase(List<String> lines){
        return lines.stream()
        .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
   public void writeLines(String filePath,List<String> lines) throws IOException {
        fileService.writeLines(filePath,lines);
   }
   public void processFile(String inputFilePath,String outputFile) throws IOException {
        List<String> lines= readLines(inputFilePath);
        List<String> upperLines = toUpperCase(lines);
        writeLines(outputFile,upperLines);
        
   }

}
