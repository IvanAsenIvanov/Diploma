package org.application.start.model;

public class Runtime {
    private String id;
    private String version;
    private String installationPath;

    public Runtime(String id, String version, String installationPath) {
        this.id = id;
        this.version = version;
        this.installationPath = installationPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getInstallationPath() {
        return installationPath;
    }

    public void setInstallationPath(String installationPath) {
        this.installationPath = installationPath;
    }
}
