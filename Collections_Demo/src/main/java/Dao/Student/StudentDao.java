package Dao.Student;

import Model.Students;

import java.util.List;

public interface StudentDao {
    public List<Students> getAll();
    public boolean deleteStudent(int studentId);
    public Students getStudent(int studentId);
    public boolean updateStudent(Students students);
    public void insertStudent(Students students);
}
