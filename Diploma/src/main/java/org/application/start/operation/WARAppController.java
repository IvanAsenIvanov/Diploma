package org.application.start.operation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WARAppController {
    public String warFilePath;
    public String tomcatWebappsDirPath;
    public String tomeeWebappsDirPath;

    public void StartTomcatApp() {
        // The Tomcat server must already be running for this to work
        Path source = Paths.get(warFilePath);
        Path target = Paths.get(tomcatWebappsDirPath, source.getFileName().toString());
        try {
            Files.copy(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void StartTomEEApp() {
        // The Tomcat server must already be running for this to work
        Path source = Paths.get(warFilePath);
        Path target = Paths.get(tomeeWebappsDirPath, source.getFileName().toString());
        try {
            Files.copy(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void StopWAR() {
        try {
            String tomcatStopScript = warFilePath + "/shutdown.sh"; // replace with your path
            ProcessBuilder pb = new ProcessBuilder(tomcatStopScript);
            Process p = pb.start();
            p.waitFor();
            System.out.println("Tomcat stopped successfully.");
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}