package org.application.start.support;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MonitoringService {
    private Map<String, HealthCheck> monitoredApplications;
    private ScheduledExecutorService scheduler;

    public MonitoringService() {
        this.monitoredApplications = new HashMap<>();
        this.scheduler = Executors.newScheduledThreadPool(1);
    }

    public void startMonitoring(String appId, HealthCheck healthCheck) {
        monitoredApplications.put(appId, healthCheck);

        scheduler.scheduleAtFixedRate(() -> {
            boolean isHealthy = healthCheck.isHealthy();
            if (!isHealthy) {
                System.out.println("Application " + appId + " is not healthy!");
                // Perform necessary actions, e.g., logging, restarting the application, etc.
            }
        }, 0, 10, TimeUnit.SECONDS);
    }

    public void stopMonitoring(String appId) {
        monitoredApplications.remove(appId);
    }
}

