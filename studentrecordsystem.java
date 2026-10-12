import java.util.*;

class Student {
    private String id;
    private String name;
    private String department;
    private int totalClasses;
    private int attendedClasses;
    private Map<String, Double> subjectMarks;

    public Student(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.totalClasses = 0;
        this.attendedClasses = 0;
        this.subjectMarks = new LinkedHashMap<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    public void updateAttendance(int attended, int total) {
        this.attendedClasses += attended;
        this.totalClasses += total;
    }

    public void addOrUpdateMarks(String subject, double mark) {
        subjectMarks.put(subject, mark);
    }

    public double getAttendancePercentage() {
        if (totalClasses == 0) return 0.0;
        return ((double) attendedClasses / totalClasses) * 100.0;
    }

    public double getAverageMarks() {
        if (subjectMarks.isEmpty()) return 0.0;
        double sum = 0.0;
        for (double mark : subjectMarks.values()) {
            sum += mark;
        }
        return sum / subjectMarks.size();
    }

    public String calculateGrade(double score) {
        if (score >= 90) return "A+";
        if (score >= 80) return "A";
        if (score >= 70) return "B";
        if (score >= 60) return "C";
        if (score >= 50) return "D";
        return "F";
    }

    public void generateReportCard() {
        System.out.println("\n========================================");
        System.out.println("         SEMESTER REPORT CARD           ");
        System.out.println("========================================");
        System.out.println("Student ID  : " + id);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
        System.out.println("----------------------------------------");
        System.out.printf("Attendance  : %d/%d (%.1f%%)\n", attendedClasses, totalClasses, getAttendancePercentage());
        System.out.println("----------------------------------------");
        System.out.printf("%-20s %-10s %-5s\n", "Subject", "Marks", "Grade");
        System.out.println("----------------------------------------");

        if (subjectMarks.isEmpty()) {
            System.out.println("No marks recorded yet.");
        } else {
            for (Map.Entry<String, Double> entry : subjectMarks.entrySet()) {
                System.out.printf("%-20s %-10.2f %-5s\n", 
                    entry.getKey(), entry.getValue(), calculateGrade(entry.getValue()));
            }
            System.out.println("----------------------------------------");
            double avg = getAverageMarks();
            System.out.printf("Average Score: %.2f | Overall Grade: %s\n", avg, calculateGrade(avg));
        }
        System.out.println("========================================\n");
    }
}

class RecordManager {
    private Map<String, Student> students = new HashMap<>();

    public void registerStudent(String id, String name, String department) {
        if (students.containsKey(id)) {
            System.out.println("Error: Student with ID " + id + " already exists.");
            return;
        }
        students.put(id, new Student(id, name, department));
        System.out.println("Student registered successfully.");
    }

    public Student getStudent(String id) {
        return students.get(id);
    }

    public void listAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No registered students found.");
            return;
        }
        System.out.println("\n--- Registered Students ---");
        System.out.printf("%-10s %-20s %-15s\n", "ID", "Name", "Department");
        System.out.println("---------------------------------------------");
        for (Student s : students.values()) {
            System.out.printf("%-10s %-20s %-15s\n", s.getId(), s.getName(), s.getDepartment());
        }
    }
}

public class StudentRecordApp {
    public static void main(String[] args) {
        RecordManager manager = new RecordManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== UNIVERSITY STUDENT RECORD SYSTEM ===");
            System.out.println("1. Register New Student");
            System.out.println("2. Record Attendance");
            System.out.println("3. Record Subject Marks");
            System.out.println("4. Generate Student Report Card");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.print("Select an option (1-6): ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine().trim();
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("Enter Department: ");
                    String dept = scanner.nextLine().trim();
                    manager.registerStudent(id, name, dept);
                    break;

                case "2":
                    System.out.print("Enter Student ID: ");
                    String attId = scanner.nextLine().trim();
                    Student attStudent = manager.getStudent(attId);
                    if (attStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    try {
                        System.out.print("Enter classes attended: ");
                        int attended = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter total classes held: ");
                        int total = Integer.parseInt(scanner.nextLine().trim());
                        if (attended > total || attended < 0 || total <= 0) {
                            System.out.println("Invalid numbers. Attended classes cannot exceed total classes.");
                        } else {
                            attStudent.updateAttendance(attended, total);
                            System.out.println("Attendance updated successfully.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid numeric input.");
                    }
                    break;

                case "3":
                    System.out.print("Enter Student ID: ");
                    String marksId = scanner.nextLine().trim();
                    Student marksStudent = manager.getStudent(marksId);
                    if (marksStudent == null) {
                        System.out.println("Student not found.");
                        break;
                    }
                    System.out.print("Enter Subject Name: ");
                    String subject = scanner.nextLine().trim();
                    try {
                        System.out.print("Enter Marks (0 - 100): ");
                        double marks = Double.parseDouble(scanner.nextLine().trim());
                        if (marks < 0 || marks > 100) {
                            System.out.println("Marks must be between 0 and 100.");
                        } else {
                            marksStudent.addOrUpdateMarks(subject, marks);
                            System.out.println("Marks recorded successfully.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid numeric input.");
                    }
                    break;

                case "4":
                    System.out.print("Enter Student ID: ");
                    String repId = scanner.nextLine().trim();
                    Student repStudent = manager.getStudent(repId);
                    if (repStudent == null) {
                        System.out.println("Student not found.");
                    } else {
                        repStudent.generateReportCard();
                    }
                    break;

                case "5":
                    manager.listAllStudents();
                    break;

                case "6":
                    running = false;
                    System.out.println("Exiting system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 6.");
            }
        }
        scanner.close();
    }
}