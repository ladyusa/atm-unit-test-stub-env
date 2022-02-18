package ku.cs.atm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private String bankName;
    private Map<Integer, Customer> customers;

    private DataService<Customer> dataService;

    public Bank(String name) {
        this(name, new CustomerFileDataService());
    }

    public Bank(String name, DataService dataService) {
        this.bankName = name;
        this.customers = new HashMap<>();
        this.dataService = dataService;
    }

    protected DataService<Customer> getDataService() {
        return dataService;
    }

    protected void setDataService(DataService<Customer> dataService) {
        this.dataService = dataService;
    }

    public void addAllCustomers() {
        List<Customer> customerList = dataService.getAllData();
        for (Customer customer : customerList) {
            addCustomer(customer);
        }
    }

    public void addCustomer(Customer c) {
        customers.put(c.getId(), c);
    }

    public Customer findCustomerById(int custId) {
        return customers.get(custId);
    }

    public boolean validateCustomer(int custId, int pin) {
        Customer customer = findCustomerById(custId);
        if (customer != null && customer.match(pin)) {
            return true;
        }
        return false;
    }
}