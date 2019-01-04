package Model;

public class GradeEntry {
    private Course course;
    private Faculty faculty;
    private int studentId;
    private Grade grade;
    private int semesterId;

    public GradeEntry() {
    }

    public GradeEntry(Course course, Faculty faculty, int studentId, Grade grade, int semesterId) {
        this.course = course;
        this.faculty = faculty;
        this.studentId = studentId;
        this.grade = grade;
        this.semesterId = semesterId;
    }

    public Course getCourse() {
        return course;
    }

    public Faculty getFacult() {
        return faculty;
    }

    public int getStudentId() {
        return studentId;
    }

    public Grade getGrade() {
        return grade;
    }

    public int getSemesterId() {
        return semesterId;
    }

    @Override
    public String toString() {
        return "GradeEntry{" +
                "course=" + course +
                ", faculty=" + faculty +
                ", studentId=" + studentId +
                ", grade=" + grade +
                ", semesterId=" + semesterId +
                '}';
    }
}
