package ku.cs.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankCustomerTest {
    Bank bank;
    Customer customer;

    @BeforeEach
    public void setup() {
        bank = new Bank("MyBank");
        customer = new Customer(1, 123, "Kwan");
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
        Customer anotherCust = new Customer(2, 456, "Noon");
        bank.addCustomer(anotherCust);

        Customer found = bank.findCustomerById(2);
        assertNotNull(found);
        assertSame(anotherCust, found);
    }

    @Test
    void testValidateCustomerValid() {
        assertTrue(bank.validateCustomer(1, 123));
    }

    @Test
    void testValidateCustomerNotValid() {
        assertFalse(bank.validateCustomer(1, 999));
    }
}
