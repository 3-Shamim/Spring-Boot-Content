package Model;

public class Registration {
    private String studentId;
    private String courseCode;
    private String facultyInitials;
    private int semesterId;

    public Registration() {
    }

    public Registration(String studentId, String courseCode, String facultyInitials, int semesterId) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.facultyInitials = facultyInitials;
        this.semesterId = semesterId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getFacultyInitials() {
        return facultyInitials;
    }

    public void setFacultyInitials(String facultyInitials) {
        this.facultyInitials = facultyInitials;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "studentId='" + studentId + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", facultyInitials='" + facultyInitials + '\'' +
                ", semesterId=" + semesterId +
                '}';
    }
}
