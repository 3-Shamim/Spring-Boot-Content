package ConnectionDB;

import Model.Course;

import java.util.List;

public interface CourseDao {

    public List<Course> getALL();
    public default Course getCourse(int id)
    {
        List<Course> list = getALL();
        Course getCourse = null;
        for (Course course: list) {
            if (id == course.getId())
            {
                getCourse = course;
            }
        }
        return getCourse;
    }

    public boolean deleteData(int id);

    public boolean updateData(Course course);


}
