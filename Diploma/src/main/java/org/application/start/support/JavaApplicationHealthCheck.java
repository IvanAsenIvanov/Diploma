package org.application.start.support;

import java.net.HttpURLConnection;
import java.net.URL;

public class JavaApplicationHealthCheck implements HealthCheck {
    private String healthCheckUrl;

    public JavaApplicationHealthCheck(String healthCheckUrl) {
        this.healthCheckUrl = healthCheckUrl;
    }

    @Override
    public boolean isHealthy() {
        try {
            URL url = new URL(healthCheckUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                return true;
            }
        } catch (Exception e) {
            // Log or handle the exception as needed
        }
        return false;
    }
}

