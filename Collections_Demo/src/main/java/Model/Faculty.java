package Model;

public class Faculty {
    private String facultyInitials;

    public Faculty(String facultyInitials) {
        this.facultyInitials = facultyInitials;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "facultyInitials='" + facultyInitials + '\'' +
                '}';
    }
}
