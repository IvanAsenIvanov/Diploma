package org.application.start.operation;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JsonFileReader {

    public static ArrayList readJsonFile(String fileName) throws IOException {

        // Read the JSON from the file
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder json = new StringBuilder();
        String line = reader.readLine();
        while (line != null) {
            json.append(line);
            line = reader.readLine();
        }
        reader.close();

        // Create a Gson object
        Gson gson = new Gson();
        // Convert the JSON to an ArrayList of objects
        return gson.fromJson(json.toString(), ArrayList.class);
    }
}