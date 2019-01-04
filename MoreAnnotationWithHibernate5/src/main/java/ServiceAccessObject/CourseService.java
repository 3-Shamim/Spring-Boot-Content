package ServiceAccessObject;

import Model.Course;
import SessionFactoryProvider.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CourseService {

    private SessionFactory sessionFactory;
    private Session session;

    public CourseService() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    // Insert Course
    public void addCourse(Course course) {
        if (session == null)
        {
            session = sessionFactory.openSession();
        }
        Transaction transaction = session.beginTransaction();
        session.save(course);
        transaction.commit();
    }

    // Get Course
    public Course getCourse(String courseCode)
    {
        if (session == null)
        {
            session = sessionFactory.openSession();
        }
        Course course =  session.get(Course.class, courseCode);
        return course;
    }
}
