package aggregation;

import java.util.ArrayList;
import java.util.List;

/**
 * Department - demonstrates AGGREGATION with Professor and Student.
 *
 * AGGREGATION: Department contains Professors and Students, but they can
 * exist without the Department. If Department is dissolved, the professors
 * and students still exist (weak ownership / "HAS-A" with shared lifecycle).
 *
 * Compare with Composition (Engine-Car) where components cannot exist alone.
 *
 * @author OOP-Using-Java
 */
public class Department {

    private final String departmentId;
    private String name;
    private String headOfDepartment;
    private final List<Professor> professors;  // Aggregated - professors exist independently
    private final List<Student> students;      // Aggregated - students exist independently

    public Department(String departmentId, String name, String hod) {
        this.departmentId = departmentId;
        this.name = name;
        this.headOfDepartment = hod;
        this.professors = new ArrayList<>();
        this.students = new ArrayList<>();
        System.out.println("Department created: " + name + " (HOD: " + hod + ")");
    }

    /**
     * Adds a professor to this department.
     * Professor already exists before being added.
     *
     * @param professor an already-created Professor object
     */
    public void addProfessor(Professor professor) {
        if (!professors.contains(professor)) {
            professors.add(professor);
            System.out.printf("Prof. %s joined %s department.%n", professor.getName(), name);
        }
    }

    public void removeProfessor(Professor professor) {
        if (professors.remove(professor)) {
            System.out.printf("Prof. %s left %s department.%n", professor.getName(), name);
            // Professor still exists! They could join another department.
        }
    }

    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            System.out.printf("Student %s enrolled in %s.%n", student.getName(), name);
        }
    }

    public void displayDepartmentInfo() {
        System.out.println("\n=== Department: " + name + " ===");
        System.out.println("ID  : " + departmentId);
        System.out.println("HOD : " + headOfDepartment);
        System.out.println("--- Professors (" + professors.size() + ") ---");
        professors.forEach(Professor::displayProfile);
        System.out.println("--- Students (" + students.size() + ") ---");
        students.forEach(Student::displayInfo);
    }

    public String getDepartmentId() { return departmentId; }
    public String getName() { return name; }
    public int getProfessorCount() { return professors.size(); }
    public int getStudentCount() { return students.size(); }
    public List<Professor> getProfessors() { return List.copyOf(professors); }
    public List<Student> getStudents() { return List.copyOf(students); }

    public static void main(String[] args) {
        // Professors exist before the department
        Professor p1 = new Professor("PROF-001", "Dr. Ramesh Iyer",
                "Machine Learning", "PhD CS", 12);
        Professor p2 = new Professor("PROF-002", "Dr. Sunita Menon",
                "Data Structures", "PhD Math", 8);

        p1.addPublication("Deep Learning Optimization Strategies");

        Student s1 = new Student("STU-001", "Aryan Kapoor", "MCA", 3);
        Student s2 = new Student("STU-002", "Neha Sharma", "MSc CS", 1);
        s1.updateGPA(8.7);

        // Department aggregates existing objects
        Department csDept = new Department("CS", "Computer Science", "Dr. Ramesh Iyer");
        csDept.addProfessor(p1);
        csDept.addProfessor(p2);
        csDept.enrollStudent(s1);
        csDept.enrollStudent(s2);
        csDept.displayDepartmentInfo();

        // Professor moves to another department - still exists
        Department aiDept = new Department("AI", "Artificial Intelligence", "Dr. Sunita Menon");
        csDept.removeProfessor(p2);
        aiDept.addProfessor(p2);

        System.out.println("\n--- After Transfer ---");
        System.out.println("CS Department professors: " + csDept.getProfessorCount());
        System.out.println("AI Department professors: " + aiDept.getProfessorCount());
    }
}
