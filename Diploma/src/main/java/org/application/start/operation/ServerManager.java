package org.application.start.operation;

import java.io.IOException;

public class ServerManager {
    private String tomcatPath;
    private String tomeePath;

    public ServerManager(String tomcatPath, String tomeePath) {
        this.tomcatPath = tomeePath;
        this.tomeePath = tomeePath;
    }

    public void startTomcat() throws IOException {
        Runtime.getRuntime().exec(tomcatPath + "/bin/startup.sh");
    }

    public void stopTomcat() throws IOException {
        Runtime.getRuntime().exec(tomcatPath + "/bin/shutdown.sh");
    }

    public void startTomEE() throws IOException {
        Runtime.getRuntime().exec(tomeePath + "/bin/startup.sh");
    }

    public void stopTomEE() throws IOException {
        Runtime.getRuntime().exec(tomeePath + "/bin/shutdown.sh");
    }
}
