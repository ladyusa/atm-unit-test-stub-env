package ku.cs.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    Customer customer;

    @BeforeEach
    public void setup() {
        customer = new Customer(1, 123, "Kwan");
    }

    @Test
    void testGetId() {
        assertEquals(1, customer.getId());
    }

    @Test
    void testGetName() {
        assertEquals("Kwan", customer.getName());
    }

    @Test
    void testSetName() {
        customer.setName("Noon");
        assertEquals("Noon", customer.getName());
    }

    @Test
    void testPinMatch() {
        assertTrue(customer.match(123));
    }
    @Test
    void testPinNotMatch() {
        assertFalse(customer.match(999));
    }

}
