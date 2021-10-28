package empman;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataStore {
    private Gson gson = new Gson();
    private String employeesFileName;
    private String payslipsFileName;

    public DataStore(String employeesFileName, String payslipsFileName) {
        this.employeesFileName = employeesFileName;
        this.payslipsFileName = payslipsFileName;
    }

    public void writeEmployees(List<Employee> employees) {
        try (FileWriter writer = new FileWriter(employeesFileName)) {
            gson.toJson(employees, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Employee> readEmployees() {
        try (FileReader reader = new FileReader(employeesFileName)) {
            Employee[] array = gson.fromJson(reader, SalaryEmployee[].class);
            List<Employee> list = new ArrayList<Employee>();
            Collections.addAll(list, array);
            return list;
        } catch (IOException e) {
            return new ArrayList<Employee>();
        }
    }

    public void writePayslips(List<Payslip> payslips) {
        try (FileWriter writer = new FileWriter(payslipsFileName)) {
            gson.toJson(payslips, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Payslip> readPayslips() {
        try (FileReader reader = new FileReader(payslipsFileName)) {
            Payslip[] array = gson.fromJson(reader, Payslip[].class);
            List<Payslip> list = new ArrayList<Payslip>();
            Collections.addAll(list, array);
            return list;
        } catch (IOException e) {
            return new ArrayList<Payslip>();
        }
    }
}
