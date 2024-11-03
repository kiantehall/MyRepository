// Cone.java
public class Cone extends Shape {
    private double radius;
    private double height;

    // Parameterized constructor
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Method to compute surface area
    @Override
    public double surfaceArea() {
        double slantHeight = Math.sqrt(Math.pow(radius, 2) + Math.pow(height, 2));
        return Math.PI * radius * (radius + slantHeight);
    }

    // Method to compute volume
    @Override
    public double volume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }

    // toString method
    @Override
    public String toString() {
        return "Cone - Surface Area: " + surfaceArea() + ", Volume: " + volume();
    }
}