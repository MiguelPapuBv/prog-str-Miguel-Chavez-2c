package org.example.demolistviewfile.repositories;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PersonFileRepository {

    private final Path pathFile = Paths.get("demoListViewFile", "data", "persons.csv");

    private void ensureFile() throws IOException {
        if (pathFile.getParent() != null && Files.notExists(pathFile.getParent())) {
            Files.createDirectories(pathFile.getParent());
        }
        if (Files.notExists(pathFile)) {
            Files.createFile(pathFile);
        }
    }

    public List<String> readAllLines() throws IOException {
        if (Files.notExists(pathFile)) {
            ensureFile();
        }
        return Files.readAllLines(pathFile, StandardCharsets.UTF_8);
    }

    public void addNewLine(String line) throws IOException {
        ensureFile();
        Files.writeString(pathFile, line + System.lineSeparator(),
                StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }
}