package empman;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DataStore {
    private String fileName;

    public DataStore(String fileName) {
        this.fileName = fileName;
        createFile();
    }

    public void writeEmployees(List<Employee> employees) {
        String text = employeesToLines(employees);
        writeFile(text);
    }

    public List<Employee> readEmployees() {
        String text = readFile();
        return linesToEmployees(text);
    }

    private String employeesToLines(List<Employee> employees) {
        String lines = "";
        for (Employee employee : employees) {
            String line = employeeToLine(employee);
            if (line != null) {
                lines += line;
            }
        }
        return lines;
    }

    private String employeeToLine(Employee employee) {
        if (employee instanceof SalaryEmployee) {
            SalaryEmployee sal = (SalaryEmployee) employee;
            return "s,%d,%s,%s,%.2f\n".formatted(
                    sal.getId(),
                    sal.getName(),
                    sal.getDepartment(),
                    sal.getSalary()
            );
        } else if (employee instanceof HourlyEmployee) {
            HourlyEmployee hrl = (HourlyEmployee) employee;
            return "h,%d,%s,%s,%.2f,%.2f\n".formatted(
                    hrl.getId(),
                    hrl.getName(),
                    hrl.getDepartment(),
                    hrl.getRate(),
                    hrl.getHours()
            );
        } else {
            return null;
        }
    }

    private List<Employee> linesToEmployees(String text) {
        List<Employee> employees = new ArrayList<Employee>();
        List<String> lines = text.lines().collect(Collectors.toList());
        for (String line : lines) {
            Employee employee = lineToEmployee(line);
            if (employee != null) {
                employees.add(employee);
            }
        }
        return employees;
    }

    private Employee lineToEmployee(String line) {
        if (line.startsWith("s")) {
            String[] values = line.split(",");
            int id = Integer.parseInt(values[1]);
            String name = values[2];
            String department = values[3];
            double salary = Double.parseDouble(values[4]);
            return new SalaryEmployee(id, name, department, salary);
        } else if (line.startsWith("h")) {
            String[] values = line.split(",");
            int id = Integer.parseInt(values[1]);
            String name = values[2];
            String department = values[3];
            double rate = Double.parseDouble(values[4]);
            double hours = Double.parseDouble(values[5]);
            return new HourlyEmployee(id, name, department, rate, hours);
        } else {
            return null;
        }
    }

    private void createFile() {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void writeFile(String text) {
        try {
            FileWriter fw = new FileWriter(fileName, false);
            fw.write(text);
            fw.close();
            System.out.println("Successfully write to file " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private String readFile() {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            String results = "";
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                results += data + "\n";
            }
            scanner.close();
            return results;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return "";
        }
    }
}
