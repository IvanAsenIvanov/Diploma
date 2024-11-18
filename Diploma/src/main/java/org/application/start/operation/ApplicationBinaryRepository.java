package org.application.start.operation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ApplicationBinaryRepository {
    private String storageDirectory;

    public ApplicationBinaryRepository(String storageDirectory) {
        this.storageDirectory = storageDirectory;
    }

    public void saveApplicationBinary(String appId, String sourceFilePath) throws IOException {
        Path sourcePath = Paths.get(sourceFilePath);
        Path targetPath = Paths.get(storageDirectory, appId);
        Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
    }

    public Path getApplicationBinaryPath(String appId) {
        return Paths.get(storageDirectory, appId);
    }
}

