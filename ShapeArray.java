// ShapeArray.java
public class ShapeArray {
    public static void main(String[] args) {
        // Instantiate one sphere, one cylinder, and one cone
        Sphere sphere = new Sphere(5);
        Cylinder cylinder = new Cylinder(3, 7);
        Cone cone = new Cone(4, 6);

        // Store instances in an array
        Shape[] shapeArray = { sphere, cylinder, cone };

        // Loop through array and print each object's data
        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
        }
    }
}