package com.example.fileprocessor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FileTest {

    @Mock
    FileService fileService;

    @InjectMocks
    FileProcessor fileProcessor;

    @Test
    void testProcessFile_success() throws IOException {
        List<String> lines = Arrays.asList("Hello", "World");
        when(fileService.readLines("input.txt")).thenReturn(lines);

        fileProcessor.processFile("input.txt", "output.txt");

        verify(fileService).readLines("input.txt");
        verify(fileService).writeLines("output.txt", Arrays.asList("HELLO", "WORLD"));
    }

    @Test
    void testProcessFile_emptyFile() throws IOException {
        when(fileService.readLines("empty.txt")).thenReturn(Collections.emptyList());

        fileProcessor.processFile("empty.txt", "output.txt");

        verify(fileService).writeLines("output.txt", Collections.emptyList());
    }

    @Test
    void testReadLines_throwsException() throws IOException {
        when(fileService.readLines("bad.txt")).thenThrow(new IOException("File not found"));

        IOException exception = assertThrows(IOException.class,
                () -> fileProcessor.processFile("bad.txt", "output.txt"));

        assertEquals("File not found", exception.getMessage());
        verify(fileService).readLines("bad.txt");
        verify(fileService, never()).writeLines(anyString(), anyList());
    }
}
