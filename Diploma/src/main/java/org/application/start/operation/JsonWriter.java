package org.application.start.operation;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.application.start.model.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter {

    public static void writeJsonFile(List<String> objectList, String fileName) throws IOException {

        // Create a Gson object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Convert the object list to JSON
        String json = gson.toJson(objectList);

        // Write the JSON to a file
            FileWriter writer = new FileWriter(fileName);
            writer.write(json);
            writer.close();
    }
}
