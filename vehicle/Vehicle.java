public class Vehicle {
    private int numberOfWheels;
    private String color;

    public Vehicle() {
    }
    
    public Vehicle(String color) {
        this.color = color;
    }

    public Vehicle(String color, int num) {
        this.color = color;
        this.numberOfWheels = num;
    }
    
    // getter
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    // setter
    public void setNumberOfWheels(int number) {
        this.numberOfWheels = number;
    }

    // getter
    public String getColor() {
        return color;
    }

    // setter
    public void setColor(String color) {
        this.color = color;
    }
}