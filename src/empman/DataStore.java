package empman;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataStore {
    private Gson gson = new Gson();
    private String fileName;

    public DataStore(String fileName) {
        this.fileName = fileName;
    }

    public void writeEmployees(List<Employee> employees) {
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(employees, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> readEmployees() {
        try (FileReader reader = new FileReader(fileName)) {
            Employee[] array = gson.fromJson(reader, Employee[].class);
            return Arrays.asList(array);
        } catch (IOException e) {
            return new ArrayList<Employee>();
        }
    }
}
