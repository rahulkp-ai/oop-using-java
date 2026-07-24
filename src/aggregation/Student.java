package aggregation;

/**
 * Student - can exist independently of a Department.
 *
 * @author OOP-Using-Java
 */
public class Student {

    private final String studentId;
    private String name;
    private String program;
    private int semester;
    private double gpa;

    public Student(String studentId, String name, String program, int semester) {
        this.studentId = studentId;
        this.name = name;
        this.program = program;
        this.semester = semester;
        this.gpa = 0.0;
    }

    public void updateGPA(double gpa) {
        this.gpa = gpa;
        System.out.printf("GPA updated for %s: %.2f%n", name, gpa);
    }

    public void displayInfo() {
        System.out.printf("Student: %s | %s | Semester %d | GPA: %.2f%n",
                name, program, semester, gpa);
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getProgram() { return program; }
    public int getSemester() { return semester; }
    public double getGpa() { return gpa; }
}
