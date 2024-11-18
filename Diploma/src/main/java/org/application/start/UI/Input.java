package org.application.start.UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private final BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));

    public String getUserInput() throws IOException {
        return reader.readLine();
    }

}
