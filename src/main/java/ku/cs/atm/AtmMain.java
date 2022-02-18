package ku.cs.atm;

public class AtmMain {
    public static void main(String[] args) {
        Bank kuBank = new Bank("KU Bank");
        kuBank.addAllCustomers();
        
        System.out.println(  kuBank.validateCustomer(1, 1234)  );
        System.out.println(  kuBank.validateCustomer(5, 1234)  );
        System.out.println(  kuBank.findCustomerById(2).getName()  );
    }
}
