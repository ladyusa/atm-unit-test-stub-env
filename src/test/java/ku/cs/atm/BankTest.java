package ku.cs.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    Bank bank;
    CustomerStub customer;

    @BeforeEach
    public void setup() {
        bank = new Bank("MyBank");
        customer = new CustomerStub(1, 123, "Kwan");
        bank.addCustomer(customer);
    }

    @Test
    void testFindCustomer() {
        Customer found = bank.findCustomerById(1);
        assertNotNull(found);
        assertSame(customer, found);
    }

    @Test
    void testAddAnotherCustomer() {
        CustomerStub anotherCust = new CustomerStub(2, 456, "Noon");
        bank.addCustomer(anotherCust);

        Customer found = bank.findCustomerById(2);
        assertNotNull(found);
        assertSame(anotherCust, found);
    }

    @Test
    void testValidateCustomerValid() {
        customer.hardCodeMatch = true;
        assertTrue(bank.validateCustomer(1, 123));
    }

    @Test
    void testValidateCustomerNotValid() {
        customer.hardCodeMatch = false;
        assertFalse(bank.validateCustomer(1, 999));
    }

    // ----- customer stub -----
    class CustomerStub extends Customer {

        boolean hardCodeMatch = false;

        public CustomerStub(int id, int pin, String name) {
            super(id, pin, name);
        }

        // override complex / slow method
        public boolean match(int pin) {
            // hard code
            return hardCodeMatch;
        }
    }
}
