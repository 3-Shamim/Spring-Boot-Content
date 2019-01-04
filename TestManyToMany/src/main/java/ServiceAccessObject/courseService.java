package ServiceAccessObject;

import Model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class courseService {
    private SessionFactory sessionFactory;
    private Session session;

    public courseService() {
        sessionFactory =  SessionFactoryProvider.getSessionFactory();
    }
    public void addCourse(Course course)
    {

        if (session == null)
        {
            session =  sessionFactory.openSession();
        }
        Transaction transaction = session.beginTransaction();
        session.save(course);
        transaction.commit();
    }

    public Course getCourse(String courseCode)
    {
        if (session == null)
        {
            session =  sessionFactory.openSession();
        }
        Course course = session.get(Course.class, courseCode);
        return course;
    }
}
