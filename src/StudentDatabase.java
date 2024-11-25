import java.util.*;
import java.io.*;

public class StudentDatabase {
    private List<Student> students = new ArrayList<>();

    public void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                int rollNumber = Integer.parseInt(fields[1].trim());
                double marks = Double.parseDouble(fields[2].trim());
                students.add(new Student(name, rollNumber, marks));
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) return student;
        }
        return null;
    }

    public boolean updateStudent(int rollNumber, double newMarks) {
        Student student = searchStudent(rollNumber);
        if (student != null) {
            student.setMarks(newMarks);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(int rollNumber) {
        return students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

