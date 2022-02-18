package ku.cs.atm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerFileDataService implements DataService<Customer> {

    private String filename = "customers.csv";

    @Override
    public List<Customer> getAllData() {
        List<Customer> customers = new ArrayList<>();
        try {
            FileReader file = new FileReader(filename);
            BufferedReader in = new BufferedReader(file);

            String line;
            while ((line = in.readLine()) != null) {
                String[] data = line.trim().split(",");
                int id = Integer.parseInt(data[0]);
                int pin = Integer.parseInt(data[1]);
                String name = data[2];
                Customer cust = new Customer(id, pin, name);
                customers.add(cust);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File " + filename + " cannot be found");
        } catch (IOException e) {
            System.err.println("Error reading file customers.csv");
            e.printStackTrace();
        }
        return customers;
    }
}
