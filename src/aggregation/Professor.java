package aggregation;

import java.util.ArrayList;
import java.util.List;

/**
 * Professor - can exist independently of a Department.
 * Used in Aggregation with Department (weak ownership).
 *
 * @author OOP-Using-Java
 */
public class Professor {

    private final String professorId;
    private String name;
    private String specialization;
    private String degree;
    private int yearsOfExperience;
    private List<String> publications;

    public Professor(String professorId, String name, String specialization, String degree, int experience) {
        this.professorId = professorId;
        this.name = name;
        this.specialization = specialization;
        this.degree = degree;
        this.yearsOfExperience = experience;
        this.publications = new ArrayList<>();
    }

    public void addPublication(String title) {
        publications.add(title);
        System.out.println("Prof. " + name + " published: " + title);
    }

    public void teach(String course) {
        System.out.printf("Prof. %s is teaching: %s%n", name, course);
    }

    public void displayProfile() {
        System.out.printf("Professor: %s | %s | %s | %d years exp | %d publications%n",
                name, specialization, degree, yearsOfExperience, publications.size());
    }

    public String getProfessorId() { return professorId; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public List<String> getPublications() { return List.copyOf(publications); }
}
