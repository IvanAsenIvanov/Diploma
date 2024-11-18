package org.application.start.operation;

import org.application.start.model.Runtime;

import java.util.HashMap;
import java.util.Map;

public class RuntimeRepository {
    private Map<String, Runtime> runtimes = new HashMap<>();

    public void addRuntime(Runtime runtime) {
        runtimes.put(runtime.getId(), runtime);
    }

    public void updateRuntime(Runtime runtime) {
        runtimes.put(runtime.getId(), runtime);
    }

    public void deleteRuntime(Runtime runtime) {
        runtimes.remove(runtime.getId());
    }

    public Runtime getRuntime(String idUser) {
        return runtimes.get(idUser);
    }
}




