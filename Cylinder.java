// Cylinder.java
public class Cylinder extends Shape {
    private double radius;
    private double height;

    // Parameterized constructor
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    // Method to compute surface area
    @Override
    public double surfaceArea() {
        return 2 * Math.PI * radius * (radius + height);
    }

    // Method to compute volume
    @Override
    public double volume() {
        return Math.PI * Math.pow(radius, 2) * height;
    }

    // toString method
    @Override
    public String toString() {
        return "Cylinder - Surface Area: " + surfaceArea() + ", Volume: " + volume();
    }
}