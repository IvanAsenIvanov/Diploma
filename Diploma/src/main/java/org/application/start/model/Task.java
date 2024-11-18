package org.application.start.model;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.*;
import com.vdurmont.semver4j.Semver;


public class Task {

    public String path;
    public UUID id;
    public Date dateCreated;
    public String status;
    public Semver version;

    @JsonCreator
    public Task(@JsonProperty(value = "path") String path, @JsonProperty(value = "status") String status,
                @JsonProperty(value = "version") Semver version) {
        this.id = UUID.randomUUID();
        this.path = path;
        this.dateCreated = new Date();
        this.status = status;
        this.version = version;
    }

    @Override
    public String toString() {
        return "Task{" +
                "path='" + path + '\'' +
                ", id=" + id +
                ", dateCreated=" + dateCreated +
                ", status='" + status + '\'' +
                ", version=" + version +
                '}';
    }

    @JsonGetter(value = "version")
    public String getVersion() {
        return version.toString();
    }

}
