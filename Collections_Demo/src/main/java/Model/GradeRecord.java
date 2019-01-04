package Model;

public class GradeRecord {
    private int studentId;
    private String courseCode;
    private String facultyInitials;
    private String grade;
    private int semesterId;

    public GradeRecord() {
    }

    public GradeRecord(int studentId, String courseCode, String facultyInitials, String grade, int semesterId) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.facultyInitials = facultyInitials;
        this.grade = grade;
        this.semesterId = semesterId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    @Override
    public String toString() {
        return "GradeRecord{" +
                "studentId='" + studentId + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", facultyInitials='" + facultyInitials + '\'' +
                ", Grade='" + grade + '\'' +
                ", semesterId=" + semesterId +
                '}';
    }
}
