package ku.cs.atm;

public class Customer {
    private int id;
    private int pin;
    private String name;

    public Customer(int id, int pin, String name) {
        this.id = id;
        this.pin = pin;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public boolean match(int pin) {
        // complex or slow code
        // ex. hash / encrypt / decrypt pin
        return this.pin == pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}