package ku.cs.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankDataServiceStubTest {
    Bank bank;

    @BeforeEach
    void setup() {
        bank = new Bank("KU Bank", new DataServiceStub());
        bank.addAllCustomers();
    }

    @Test
    void testFindCustomerById() {
        Customer customer = bank.findCustomerById(1);
        assertEquals("Kwan", customer.getName());
    }

    private class DataServiceStub implements DataService<Customer> {
        @Override
        public List<Customer> getAllData() {
            ArrayList<Customer> customerList = new ArrayList<>();
            customerList.add(new Customer(1, 123, "Kwan"));
            customerList.add(new Customer(2, 456, "Noon"));
            return customerList;
        }
    }
}
