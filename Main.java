import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(101, "Alice", "123 Wonderland St"));
        students.add(new Student(105, "Bob", "456 Marley St"));
        students.add(new Student(102, "Charlie", "789 Chaplin St"));
        students.add(new Student(104, "Diana", "321 Ross St"));
        students.add(new Student(103, "Eve", "654 Adam St"));
        students.add(new Student(110, "Frank", "987 Sinatra St"));
        students.add(new Student(108, "Grace", "111 Hopper St"));
        students.add(new Student(107, "Hank", "222 William St"));
        students.add(new Student(106, "Ivy", "333 Poison St"));
        students.add(new Student(109, "Jack", "444 Jane St"));

        System.out.println("Original List:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sort by name
        SelectionSorter.selectionSort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });

        System.out.println("\nSorted by Name:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sort by roll number
        SelectionSorter.selectionSort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.getRollno(), s2.getRollno());
            }
        });

        System.out.println("\nSorted by Roll Number:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}